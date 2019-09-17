package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDao {
	
	// Select all
	public List<BookVO> getAllBookRec(){
		List<BookVO> list = new ArrayList<BookVO>();
		
		String sql = "SELECT * FROM book order by bookid";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();		// select 는 executeQuery
			
			while(rs.next()) {
				list.add(new BookVO(rs.getInt("bookid"), 
								  rs.getString("bookname"), 
								  rs.getString("publisher"), 
								  rs.getInt("price")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return list;
		
	}
	public List<BookVO> getAllBookRec(int page, int n){
		List<BookVO> list = new ArrayList<BookVO>();
		
		
		String sql = "select * from(select rownum row#, bookid, bookname, publisher, price from "
				+ "(select * from book order by bookid desc)) "
				+ "where row# between ? and ? ";
		
		int start = n*(page-1)+1;
		int end = start+(n-1);
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();		// select 는 executeQuery
			while(rs.next()) {
				list.add(new BookVO(rs.getInt("bookid"), 
						rs.getString("bookname"), 
						rs.getString("publisher"), 
						rs.getInt("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return list;
		
	}
	
	public int updateBook(BookVO book) {
		
		String sql = "UPDATE book SET price = ? WHERE bookid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);;
			ps.setInt(1, book.getPrice());
			ps.setInt(2, book.getBookid());
			result = ps.executeUpdate();	// update, Insert, delete 는 executeUpdate 사용
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		return result;
		
	}
	
	public int deleteBook(int bookid) {
		
		String sql = "DELETE FROM book WHERE bookid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookid);
			result = ps.executeUpdate();	// update, Insert, delete 는 executeUpdate 사용
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		return result;
	}
	public int insertBook(BookVO book) throws SQLException {
		
		String sql = "INSERT INTO book(bookid, bookname, publisher, price) VALUES((select nvl(max(bookid),0)+1 from book),?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getPublisher());
			ps.setInt(3, book.getPrice());
			result = ps.executeUpdate();	// update, Insert, delete 는 executeUpdate 사용
			
		} catch (SQLException e) {
//			e.printStackTrace();
			throw e;
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		return result;
	}
	
	public List<BookVO> selectBookName(String bookname){
		List<BookVO> list = new ArrayList<BookVO>();
		
		String sql = "SELECT * FROM book WHERE lower(bookname) = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bookname.toLowerCase());
			
			rs = ps.executeQuery();		// select 는 executeQuery
			
			while(rs.next()) {
				list.add(new BookVO(rs.getInt("bookid"), 
								  rs.getString("bookname"), 
								  rs.getString("publisher"), 
								  rs.getInt("price")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return list;
	}
	
	public List<BookVO> selectPublisher(String publisher){
		List<BookVO> list = new ArrayList<BookVO>();
		
		String sql = "SELECT * FROM book WHERE lower(publisher) = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, publisher.toLowerCase());
			
			rs = ps.executeQuery();		// select 는 executeQuery
			
			while(rs.next()) {
				list.add(new BookVO(rs.getInt("bookid"), 
								  rs.getString("bookname"), 
								  rs.getString("publisher"), 
								  rs.getInt("price")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return list;
	}
	
}
