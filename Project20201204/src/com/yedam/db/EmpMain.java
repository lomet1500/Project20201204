package com.yedam.db;

import java.util.Scanner;

public class EmpMain {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// 사원정보, 부서정보
		while (true) {
			System.out.println("===============================");
			System.out.println("1.사원정보 2.부서정보 3.종료 4.사원입력)");
			System.out.println("===============================");
			System.out.println("선택> ");
			int selectNo = scn.nextInt(); scn.nextLine();
 			if (selectNo == 1) {
				EmpDAO dao = new EmpDAO();
				EmployeeVO[] employees = dao.getEmpList();
				for (EmployeeVO emp : employees) {
					if (emp != null) {
						emp.showEmpInfo();
					}

				}

			} else if (selectNo == 2) {
				DeptDAO dao = new DeptDAO();
				Department[] department = dao.getDeptList();
				for (Department dept : department) {
					if (dept != null) {
						dept.showDeptInfo();
					}
				}

			} else if (selectNo == 3) {
				break;
				
			} else if (selectNo == 4) {
				addEmployee();
				
			}
			System.out.println("end of prog");
		}

	} // end of main()

	public static void addEmployee() {
		System.out.println("이름 입력하세요.");
		String name = scn.nextLine();
		System.out.println("이메일을 입력하세요.");
		String email = scn.nextLine();
		System.out.println("직무를 입력하세요.");
		String jobId = scn.nextLine();
		System.out.println("입사일자를 입력하세요.");
		String hireDate = scn.nextLine();
		
		EmployeeVO emp = new EmployeeVO(name, email, hireDate, jobId);
		EmpDAO dao = new EmpDAO();
		dao.insertEmployee(emp);
	}
}// end of class
