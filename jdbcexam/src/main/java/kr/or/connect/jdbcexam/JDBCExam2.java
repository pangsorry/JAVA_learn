package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.*;
import kr.or.connect.jdbcexam.dto.*;
public class JDBCExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int roleId=501;
		String description="CTO";
		
		Role role = new Role(roleId,description);
		
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);
		
		System.out.println(insertCount);
		
	}

}
