package kr.or.connect.daoexam.dao;


//여기에 사용할 쿼리를 상수형태로 저장해놓고 사용한다.
/*-----------------------------
 * connectdb
 * ----------------------------
 * field		type		key
 * role_id		int(11)		pri
 * description	varchar(100)
 */
public class RoleDaoSqls {
	public static final String SELECT_ALL = "SELECT role_id, description FROM role order by role_id";
	public static final String UPDATE = "UPDATE role SET description = :description where role_id = :roleId";
	// 기존 구문                        String sql = "UPDATE role SET description = ? where role_id=?";  //  TABLE 'role'안에 'role_id'가 '?'인 객체의 'description'을 수정한다. 
										// '?' 대신 ':이름' 이 들어간 것을 확인할 수 있다. 이름은 자바기준
	
	public static final String SELECT_BY_ROLE_ID = "SELECT role_id, description FROM role where role_id=:roleId";
	public static final String DELETE_BY_ROLE_ID = "DELETE FROM role WHERE role_id=:roleId";
}
