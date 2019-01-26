package kr.or.connect.jdbcexam;
import kr.or.connect.jdbcexam.dao.*;
import kr.or.connect.jdbcexam.dto.*;

public class JDBCExam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int updatecount=0;
		Role role = new Role(501, "CEO");
		RoleDao roledao = new RoleDao();
		
		updatecount = roledao.updateRole(role);
		
		System.out.println(updatecount);
		
	}

}
