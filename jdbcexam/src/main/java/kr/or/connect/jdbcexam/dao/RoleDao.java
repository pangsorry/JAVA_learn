package kr.or.connect.jdbcexam.dao;
import java.sql.*;
import java.util.*;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul";
	private static String dbuser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public Role getRole(Integer roleId) {
		
		Role role = null;
		
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
			String sql = "SELECT role_id, description FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);  //SQL 명령어의 첫번째 ? 를 roleId로 바꿔주세요.
			rs = ps.executeQuery();
			
			if(rs.next()) {
				role = new Role(); 
				role.setRoleId(rs.getInt(1));
				role.setDescription(rs.getString("description"));
				
			}
		}catch (Exception e ) {
			e.printStackTrace();
		}finally {
			if(rs !=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps !=null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn !=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return role;
		
	}


	public int addRole(Role role) {
		int insertCount=0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO role (role_id, description) VALUES (?,?)";
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			
			insertCount = ps.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		}
		return insertCount;
	}


	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT description, role_id FROM role order by role_id desc";
		
		try {
			conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
			ps = conn.prepareStatement(sql);
			try {
				rs = ps.executeQuery();
				while (rs.next()) {
					String description = rs.getString(1);
					Integer roleId = rs.getInt(2);
					
					Role role = new Role(roleId, description);
					list.add(role);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

	public int delRole(int role_id) {
		int deleteCount = 0;
		
		Connection conn=null;
		PreparedStatement ps =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM role WHERE role_id=?";
		
		try {
			conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, role_id);
			
			deleteCount = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return deleteCount;
	}

	public int updateRole(Role role) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "UPDATE role SET description = ? where role_id=?";  //TABLE 'role'안에 'role_id'가 '?'인 놈의 'description'을 수정한다. 
		
		try (Connection conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());
			
			updateCount = ps.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return updateCount;
	}
}