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
import com.pro.dto.OrderVO;
import com.pro.dto.QnAVO;
import com.pro.dto.UserVO;

public class OrderDAO {
	private static OrderDAO instance = new OrderDAO();

	private OrderDAO() {
	}

	public static OrderDAO getInstance() {
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


//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	public UserVO selectOrderById(String id) {

		UserVO vo = new UserVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from users where id = ?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setUsername(rs.getString("username"));
				vo.setEmail(rs.getString("email"));
				vo.setAddr(rs.getString("addr"));
				vo.setAddr2(rs.getString("addr2"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return vo;
	}
	
	
	//주문 내역 생성 메서드
	public void getOrders(OrderVO vo) {
	    String sql = "insert into QnA values(Review_SEQUENCE.nextval,?,?,?,?,?)";
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getUserName());
			pstmt.setInt(3, vo.getPid());
			pstmt.setTimestamp(4, vo.getOrderDate());
			pstmt.setInt(5, vo.getPrice());
				

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}
	

}