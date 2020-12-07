package com.yedam.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import com.yedam.common.DAO;
import com.yedam.db2.EmployeeVO;

public class StreamExample5 {
	public static void main(String[] args) {
		Connection conn = DAO.getConnection();
		List<EmployeeVO> list = new ArrayList<>();
		try {
			String sql = "select * from emp1";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		Stream<EmployeeVO> stream = list.stream();
		stream.forEach(s -> s.showEmpInfo());

		// 1. salary 10,000이상인 사원.
		System.out.println("salary가 10,000이상인 사원: ");
		list.stream().filter(new Predicate<EmployeeVO>() {

			@Override
			public boolean test(EmployeeVO t) {

				return t.getSalary() > 10000;
			}

		}).forEach(s -> s.showEmpInfo());

		// 40 부서 사원
		System.out.println("40 부서 사원");
		OptionalDouble avg = list.stream().filter( p -> p.getDepartmentId()==40)
		.mapToInt((e) -> e.getSalary())
		.average();
		System.out.println("평균: " + avg.orElse(0.0)); //Optional orElse
		
//		avg.ifPresent(new DoubleConsumer() {
//
//			@Override
//			public void accept(double value) {
//				System.out.println("급여평균: " + avg.getAsDouble());
//					
//			}
//			
//		});
	
		
	}
	
}
