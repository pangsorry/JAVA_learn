package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.*;

@Configuration
@Import({DBConfig.class})
@EnableTransactionManagement
@ComponentScan(basePackages = {"kr.or.connect.daoexam.dao"})  //Component나 repository 등을 자동스캔하여 Bean으로 등록함
public class ApplicationConfig {
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	private String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul";
	private String dbuser = "connectuser";
	private String dbpasswd = "connect123!@#";
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dburl);
		dataSource.setUsername(dbuser);
		dataSource.setPassword(dbpasswd);
		
		return dataSource;
	}
}
