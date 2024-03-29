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

import com.pro.dto.ReviewVO;


public class ReviewDAO {

	private static ReviewDAO instance = new ReviewDAO();

	private ReviewDAO() {
	}

	public static ReviewDAO getInstance() {
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

	public List<ReviewVO> selectAllReviewByPid(int pid) {
		String sql = "select * from Review where pid = ?";
		List<ReviewVO> list = new ArrayList<ReviewVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewVO vo = new ReviewVO();

				vo.setReview_id(rs.getInt("review_id"));
				vo.setId(rs.getString("id"));
				vo.setPid(rs.getInt("pid"));
				vo.setRating(rs.getInt("rating"));
				vo.setContent(rs.getString("content"));
				vo.setImg(rs.getString("img"));
				vo.setRegistration_date(rs.getTimestamp("registration_date"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}
	
	public List<ReviewVO> selectAllReviewByUserid(String id) {
		String sql = "select * from Review where id = ?";
		List<ReviewVO> list = new ArrayList<ReviewVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewVO vo = new ReviewVO();

				vo.setReview_id(rs.getInt("review_id"));
				vo.setId(rs.getString("id"));
				vo.setPid(rs.getInt("pid"));
				vo.setRating(rs.getInt("rating"));
				vo.setContent(rs.getString("content"));
				vo.setImg(rs.getString("img"));
				vo.setRegistration_date(rs.getTimestamp("registration_date"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public void insertReview(ReviewVO vo) {
		String sql = "insert into Review values(Review_SEQUENCE.nextval,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, vo.getReview_id());
			pstmt.setString(2, vo.getId());
			pstmt.setInt(3, vo.getPid());
			pstmt.setInt(4, vo.getRating());
			pstmt.setString(5, vo.getContent());
			pstmt.setString(6, vo.getImg());
			pstmt.setTimestamp(7, vo.getRegistration_date());
			

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	public ReviewVO selectReviewByPid(int pid) {

		ReviewVO vo = new ReviewVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from Review where pid=?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setReview_id(rs.getInt("review_id"));
				vo.setId(rs.getString("id"));
				vo.setPid(rs.getInt("pid"));
				vo.setRating(rs.getInt("rating"));
				vo.setContent(rs.getString("content"));
				vo.setImg(rs.getString("img"));
				vo.setRegistration_date(rs.getTimestamp("registration_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return vo;
	}
	
	
	
	
	public void updateReview(ReviewVO vo) {
		String sql = "update Review set rating=?, content=?, img=?, registration_date=? where pid=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, vo.getRating());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getImg());
			pstmt.setTimestamp(4, vo.getRegistration_date());
			pstmt.setInt(5, vo.getPid());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	
	}
	public void deleteReview(int pid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from Review where pid = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
	}

}

