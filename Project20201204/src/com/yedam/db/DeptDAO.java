package com.yedam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDAO {
	Connection conn = getConnection(); // 연결객체 생성

	public Department[] getDeptList() {
		String sql1 = "select*from departments";
		Department[] depts = new Department[100];
		try {

			PreparedStatement psmt = conn.prepareStatement(sql1);
			ResultSet rs1 = psmt.executeQuery();
			int i = 0;
			while (rs1.next()) {
				Department dept = new Department ();
				dept.setDepartmentId(rs1.getInt("department_id"));
				dept.setDepartmentName(rs1.getString("department_name"));
				dept.setManagerId(rs1.getInt("manager_id"));
				dept.setLocationId(rs1.getInt("location_id"));

				depts[i++] = dept;

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return depts;
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			String user = "hr";
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		return conn;
	}

}
