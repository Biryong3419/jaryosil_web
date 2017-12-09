package org.comstudy21.myapp.jaryo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myapp.service.Service;
import org.comstudy21.myapp.util.JdbcUtil;

public class JaryoServiceImpl extends Service {

	private JaryoDao dao = new JaryoDao();
	
	@Override
	public int insert(Object obj) {
		Connection conn = JdbcUtil.getConnection();
		dao.setConnection(conn);
		int cnt = dao.insert((JaryoDto)obj);
		if(cnt>0) {
			System.out.println("입력성공!");
		}
		JdbcUtil.close(conn);
		return 0;
	}

	@Override
	public ArrayList<String[]> selectAll() {
		Connection conn = JdbcUtil.getConnection();
		dao.setConnection(conn);
		ArrayList<String[]> list = dao.selectAll();
		JdbcUtil.close(conn);
		return list;
	}

	@Override
	public JaryoDto search(int id) {
		Connection conn = JdbcUtil.getConnection();
		dao.setConnection(conn);
		JaryoDto jaryodto=(JaryoDto)dao.search(id);
		JdbcUtil.close(conn);
		return jaryodto;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		Connection conn = JdbcUtil.getConnection();
		dao.setConnection(conn);
		dao.delete(id);
		JdbcUtil.close(conn);
	
	}



}
