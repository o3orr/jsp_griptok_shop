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

import com.pro.dto.QnAVO;
import com.pro.dto.ReviewVO;


public class QnADAO {

	private static QnADAO instance = new QnADAO();

	private QnADAO() {
	}

	public static QnADAO getInstance() {
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

	public List<QnAVO> selectAllQnAByPid(int pid) {
		String sql = "select * from QnA where pid = ?";
		List<QnAVO> list = new ArrayList<QnAVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnAVO vo = new QnAVO();

				vo.setQa_id(rs.getInt("qa_id"));
				vo.setId(rs.getString("id"));
				vo.setPid(rs.getInt("pid"));
				vo.setQuestion_title(rs.getString("question_title"));
				vo.setQuestion(rs.getString("question"));
				vo.setAnswer(rs.getString("answer"));
				vo.setState(rs.getString("state"));
				vo.setCreated_at(rs.getTimestamp("created_at"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}
	
	public List<QnAVO> selectAllQnAByUserid(String id) {
		String sql = "select * from QnA where id = ?";
		List<QnAVO> list = new ArrayList<QnAVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnAVO vo = new QnAVO();

				vo.setQa_id(rs.getInt("qa_id"));
				vo.setId(rs.getString("id"));
				vo.setPid(rs.getInt("pid"));
				vo.setQuestion_title(rs.getString("question_title"));
				vo.setQuestion(rs.getString("question"));
				vo.setAnswer(rs.getString("answer"));
				vo.setState(rs.getString("state"));
				vo.setCreated_at(rs.getTimestamp("created_at"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public void insertQnA(QnAVO vo) {
		String sql = "insert into QnA values(Review_SEQUENCE.nextval,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getPid());
			pstmt.setString(3, vo.getQuestion_title());
			pstmt.setString(4, vo.getQuestion());
			pstmt.setString(5, vo.getAnswer());
			pstmt.setString(6, vo.getState());
			pstmt.setTimestamp(7, vo.getCreated_at());
				

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	public QnAVO selectQnAByPid(int pid) {

		QnAVO vo = new QnAVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from QnA where pid=?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setQa_id(rs.getInt("QA_ID"));
				vo.setId(rs.getString("id"));
				vo.setPid(rs.getInt("pid"));
				vo.setQuestion_title(rs.getString("QUESTION_TITLE"));
				vo.setQuestion(rs.getString("QUESTION"));
				vo.setAnswer(rs.getString("ANSWER"));
				vo.setState(rs.getString("state"));
				vo.setCreated_at(rs.getTimestamp("CREATED_AT"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return vo;
	}
	
	
	public QnAVO selectQnAByPidQaId(int pid, int qa_id) {

		QnAVO vo = new QnAVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM QnA WHERE pid=? AND qa_id=?";


		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setInt(2, qa_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setQa_id(rs.getInt("QA_ID"));
				vo.setId(rs.getString("id"));
				vo.setPid(rs.getInt("pid"));
				vo.setQuestion_title(rs.getString("QUESTION_TITLE"));
				vo.setQuestion(rs.getString("QUESTION"));
				vo.setAnswer(rs.getString("ANSWER"));
				vo.setState(rs.getString("state"));
				vo.setCreated_at(rs.getTimestamp("CREATED_AT"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return vo;
	}
	
	
	public void updateQnA(QnAVO vo) {
	    String sql = "UPDATE QnA SET id=?, QUESTION_TITLE=?, QUESTION=?, CREATED_AT=? WHERE pid=? AND qa_id=?";
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = getConnection();
	        pstmt = con.prepareStatement(sql);

	        pstmt.setString(1, vo.getId());
	        pstmt.setString(2, vo.getQuestion_title());
	        pstmt.setString(3, vo.getQuestion());
	        pstmt.setTimestamp(4, vo.getCreated_at());
	        pstmt.setInt(5, vo.getPid());
	        pstmt.setInt(6, vo.getQa_id());
	        pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(con, pstmt);
	    }
	}

	public void deleteQnA(int pid, int qa_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from QnA where pid = ? and qa_id=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setInt(2, qa_id);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
	}

}

