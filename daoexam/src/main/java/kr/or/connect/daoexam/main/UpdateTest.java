package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class UpdateTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao = ac.getBean(RoleDao.class);
		Role role = new Role();
		
		role.setRoleId(500);
		role.setDescription("CT0O");
		
		int updateCount = roleDao.update(role);
		System.out.println(updateCount + "건 수정되었습니다.");	
		
		Role role2 = roleDao.selectById(500);
		
		System.out.println(role2);

	}

}
