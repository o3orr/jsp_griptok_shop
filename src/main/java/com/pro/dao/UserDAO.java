package com.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.pro.dto.UserVO;

public class UserDAO {

	private static UserDAO instance = new UserDAO();

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		return instance;
	}

	private Connection getConnection() {
		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close(Connection con, Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<UserVO> listUser() {
		String sql = "select * from users";
		List<UserVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserVO vo = new UserVO();

				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setUsername(rs.getString("username"));
				vo.setEmail(rs.getString("email"));
				vo.setPass(rs.getString("pass"));
				vo.setRegistration_date(rs.getTimestamp("registration_date"));
				vo.setIs_admin(rs.getString("is_admin"));
				vo.setAddr(rs.getString("addr"));
				vo.setPhone(rs.getString("phone"));

				list.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public void insertUser(UserVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO users (NUM, ID, USERNAME, EMAIL, PASS, REGISTRATION_DATE, IS_ADMIN, ADDR, addr2, phone) "
				+ "VALUES (users_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getUsername());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPass());
			pstmt.setTimestamp(5, vo.getRegistration_date());
			pstmt.setString(6, vo.getIs_admin());
			pstmt.setString(7, vo.getAddr()); // 주소 정보 추가
			pstmt.setString(8, vo.getAddr2());
			pstmt.setString(9, vo.getPhone());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	public UserVO selectUser(int num) {

		UserVO vo = new UserVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from users where num = ?";

		try {
			System.out.println("num>>>>" + num);
			con = getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setEmail(rs.getString("email"));
				vo.setId(rs.getString("id"));
				vo.setIs_admin(rs.getString("is_admin"));
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setRegistration_date(rs.getTimestamp("REGISTRATION_DATE"));
				vo.setUsername(rs.getString("username"));
				vo.setAddr(rs.getString("addr"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setPhone(rs.getString("phone"));
			}

			System.out.println("vo>>" + vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return vo;
	}
	
	public UserVO selectOnUser(String id) {

		UserVO vo = new UserVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from users where id = ?";

		try {
			System.out.println("num>>>>" + id);
			con = getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setNum(rs.getInt("num"));
				vo.setEmail(rs.getString("email"));
				vo.setId(rs.getString("id"));
				vo.setIs_admin(rs.getString("is_admin"));
				vo.setPass(rs.getString("pass"));
				vo.setRegistration_date(rs.getTimestamp("REGISTRATION_DATE"));
				vo.setUsername(rs.getString("username"));
				vo.setAddr(rs.getString("addr"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setPhone(rs.getString("phone"));
			}

			System.out.println("vo>>" + vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return vo;
	}

	public void updateUser(UserVO vo) {

		String sql = "update users set username=?, email=?, pass=?, addr=?, addr2=?, phone=? where num=?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getUsername());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPass());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getAddr2());
			pstmt.setString(6, vo.getPhone());
			pstmt.setInt(7, vo.getNum());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}

	public void deleteUser(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "delete from users where num = ?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	public int userCheck(String id, String pass, String is_admin) {
	    int result = -1; // 기본적으로 -1로 초기화

	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    String sql = "SELECT pass, is_admin FROM users WHERE id = ?";

	    try {
	        con = getConnection();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            // 데이터베이스에서 조회된 비밀번호와 관리자 여부
	            String dbPwd = rs.getString("pass");
	            String dbAdmin = rs.getString("is_admin");

	            // 입력된 비밀번호와 조회된 비밀번호를 비교하여 결과 설정
	            if (dbPwd.equals(pass)) {
	                result = 1; // 로그인 성공

	                // 관리자 여부에 따라 결과 설정
	                if ("Y".equals(dbAdmin)) {
	                    result = 2; // 관리자 로그인
	                }
	            } else {
	                result = -1; // 비밀번호 불일치
	            }
	        } else {
	            result = 0; // 해당 아이디가 존재하지 않음
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(con, pstmt, rs);
	    }

	    return result;
	}

	public UserVO getUser(String id) {
		UserVO member = null;
		String sql = "SELECT * FROM users WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					member = new UserVO();
					member.setId(rs.getString("id"));
					member.setUsername(rs.getString("username"));
					// 나머지 필요한 사용자 정보를 설정
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}

}
