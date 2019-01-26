package kr.or.connect.jdbcexam;

import java.util.*;

import kr.or.connect.jdbcexam.dao.*;
import kr.or.connect.jdbcexam.dto.*;

public class JDBCExam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RoleDao roledao = new RoleDao();
		List<Role> list = roledao.getRoles();
		
		for(Role role:list) {
			System.out.println(role);
		}
	}
}
