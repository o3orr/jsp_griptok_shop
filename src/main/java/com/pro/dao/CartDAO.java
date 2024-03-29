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

import com.pro.dto.CartVO;

public class CartDAO {
	private static CartDAO instance = new CartDAO();

	public CartDAO() {
	}

	public static CartDAO getInstance() {
		return instance;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
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
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//

	// 전체 데이터 DB에서 상품 가져오기

	public List<CartVO> selectAllCartList(String id) {
		List<CartVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from cart where id=?";

		try {

			con = getConnection();

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			System.out.println("rs>>" + rs);
			while (rs.next()) {

				CartVO vo = new CartVO();

				vo.setCart_id(rs.getInt("cart_id"));
				vo.setId(rs.getString("id"));
				vo.setPid(rs.getInt("pid"));
				vo.setCreateDate(rs.getTimestamp("createDate"));

				list.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return list;
	}

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 장바구니 삭제

	public void deleteSelectedOrders(List<String> cartList, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = getConnection();

			String sql = "DELETE FROM cart WHERE cart_id = ? AND id = ?";
			pstmt = con.prepareStatement(sql);

			for (String cart_id : cartList) {
				System.out.println(cart_id);
				pstmt.setString(1, cart_id);
				pstmt.setString(2, id);
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}
	
	
	public List<Integer> selectCartListPid(String id) {
		List<Integer> Ilist = new ArrayList<Integer>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select pid from cart where id=?";

		try {

			con = getConnection();

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			System.out.println("rs>>" + rs);
			while(rs.next()) {
				
				Ilist.add(rs.getInt("pid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return Ilist;
	}
	public void addCartItem(CartVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into cart(cart_id ,id, pid) values(Cart_SEQ.nextval,?,?)";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getPid());
			
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}


//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//	public UserVO selectOrderByNum(int num) {
//
//		UserVO vo = new UserVO();
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		String sql = "select * from users where num = ?";
//
//		try {
//			con = getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//
//				vo.setNum(rs.getInt("num"));
//				vo.setId(rs.getString("id"));
//				vo.setPass(rs.getString("pass"));
//				vo.setUsername(rs.getString("username"));
//				vo.setEmail(rs.getString("email"));
//				vo.setAddr(rs.getString("addr"));
//				vo.setAddr2(rs.getString("addr2"));
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(con, pstmt, rs);
//		}
//		return vo;
//	}

}