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

import com.pro.dto.ProVO;
import com.pro.dto.UserVO;

public class ProDAO {

	private static ProDAO instance = new ProDAO();

	private ProDAO() {
	}

	public static ProDAO getInstance() {
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

	public List<ProVO> selectAllPro() {
		String sql = "select * from products order by pid desc";
		List<ProVO> list = new ArrayList<ProVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProVO vo = new ProVO();

				vo.setPid(rs.getInt("pid"));
				vo.setPname(rs.getString("pname"));
				vo.setContent(rs.getString("content"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setCategory_id(rs.getInt("category_id"));
				vo.setImg(rs.getString("img"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public void insertPro(ProVO vo) {
		String sql = "insert into products values(product_seq.nextval,?,?,?,?,category_seq.nextval,?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getPname());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setInt(4, vo.getStock());
			pstmt.setString(5, vo.getImg());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	public ProVO selectProByPid(int pid) {

		ProVO vo = new ProVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from products where pid=?";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setPid(rs.getInt("pid"));
				vo.setPname(rs.getString("pname"));
				vo.setContent(rs.getString("content"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock(rs.getInt("stock"));
				vo.setCategory_id(rs.getInt("category_id"));
				vo.setImg(rs.getString("img"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return vo;
	}
	
	public void updatePro(ProVO vo) {
		String sql = "update products set pname=?, content=?, price=?, stock=?, img=? where pid=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getPname());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setInt(4, vo.getStock());
			pstmt.setString(5, vo.getImg());
			pstmt.setInt(6, vo.getPid());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	
	}
	public void deletePro(int pid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from products where pid = ?";
		
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

	public UserVO login(UserVO vo) {
		UserVO uvo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select is_admin from users where id=? and pass=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				uvo = new UserVO();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
			
		}
		return uvo;
	}
	
	// 수량 줄이는 메서드
	public void decreaseStock(int pid, int stock) {
	    String sql = "UPDATE products SET stock = stock - ? WHERE product_id = ?";
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = getConnection();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, stock);
	        pstmt.setInt(2, pid);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(con, pstmt);
	    }
	}
	
	public List<ProVO> selectProName(List<Integer>Ilist) {


		List<ProVO>plist = new ArrayList<ProVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select pname, price, pid from products where pid=?";

		try {
			con = getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			for(int i = 0; i < Ilist.size(); i ++ ) {
				
				
				pstmt.setInt(1, Ilist.get(i));	
				
				rs = pstmt.executeQuery();	
				
							

			if (rs.next()) {
				ProVO vo = new ProVO();
				
				vo.setPid(rs.getInt("pid"));
				vo.setPname(rs.getString("pname"));
				vo.setPrice(rs.getInt("price"));
				
				plist.add(vo);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return plist;
	}

	
	
}
