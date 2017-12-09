package org.comstudy21.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myapp.jaryo.JaryoDto;

public abstract class Service {
	//�Է�, ���, �˻�, ����, ����
	public abstract int insert(Object obj);
	public abstract ArrayList<String[]> selectAll();
	public abstract JaryoDto search(int id);
	public abstract int update(Object obj);
	public abstract void delete(int id);
}
