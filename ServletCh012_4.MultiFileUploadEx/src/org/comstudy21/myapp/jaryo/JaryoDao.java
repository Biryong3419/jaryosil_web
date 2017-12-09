package org.comstudy21.myapp.jaryo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class JaryoDao {
	String selectAll = "SELECT * FROM jaryo";
	String getFileName="SELECT * FROM jaryo WHERE id=?";
	String insert = "INSERT INTO jaryo(password,filename)VALUES(?,?)";
	String delete = "delete from jaryo where id=?";
	private Connection conn;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public JaryoDto search(int id) {
		String filename="";
		PreparedStatement pstmt=null;
		ResultSet rs = null;JaryoDto jaryodto=null;
		try {
			pstmt=conn.prepareStatement(getFileName);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				jaryodto = new JaryoDto(rs.getString(2),rs.getString(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(null,pstmt);
		}
		return jaryodto; 
	}

	public int insert(JaryoDto dto) {
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getFilename());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt);
		}
		
		return cnt;
	}
	public ArrayList<String[]> selectAll() {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String[]> list = new ArrayList<String[]>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectAll);
			while(rs.next()) {
				int index = rs.getInt(1);
				String password = rs.getString(2);
				String filename = rs.getString(3);
				list.add(new String[] {String.valueOf(index),password,filename});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt);
		}
		
		return list;
	}
	public void delete(int id) {
		int cnt=0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, id);
		cnt=pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("삭제완료");
			}else {
				System.out.println("삭제실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(null,pstmt);
		}
	}
	private void close(ResultSet rs, Statement stmt) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
