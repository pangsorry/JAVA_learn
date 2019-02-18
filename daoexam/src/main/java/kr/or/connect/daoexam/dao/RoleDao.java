package kr.or.connect.daoexam.dao;

import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;

@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;  // '?' 대신 '이름'을 이용하여 바인딩해서 결과값을 가져오는것에 사용
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	private SimpleJdbcInsert insertAction;
	
	public RoleDao(DataSource dataSource) { //DataSource를 받아들여 namedparameterjdbctemplate를 생성한다.
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
	}
	
	public List<Role> selectAll(){
		//jdbc.query(sql문, 비어있는 맵객체, RowMapper객체
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role); //role객체를 Map으로 바꿔줌
		int insertCount = insertAction.execute(params);
		
		return insertCount;
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role); //role객체를 Map으로 바꿔줌
		return jdbc.update(UPDATE, params);
	}
	
	public int deleteById(int id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectById(int id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
/*
 * java에선 카멜표기법으로 단어구분 ex) roleId
 * sql에선 대소문자와 _ 로 구분      ex) role_id
 * BeanPropertyRowMapper는 이러한 표기법을 알아서 맞춰주는 편의기능이 있다.
 */
