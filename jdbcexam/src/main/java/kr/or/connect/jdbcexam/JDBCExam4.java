package kr.or.connect.jdbcexam;
import kr.or.connect.jdbcexam.dao.*;

public class JDBCExam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int roleid = 501;
		int deleteCount;
		
		RoleDao roledao = new RoleDao();
		
		deleteCount = roledao.delRole(roleid);
		
		System.out.println(deleteCount);
	}

}
