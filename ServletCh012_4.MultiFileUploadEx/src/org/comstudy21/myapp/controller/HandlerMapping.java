package org.comstudy21.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.comstudy21.myapp.jaryo.JaryoController;

public class HandlerMapping {
	private Map<String, Controller> mapping;
	
	public HandlerMapping() {
		mapping = new HashMap<>();
		mapping.put("/jaryosil", new JaryoController());
	}
	
	public Controller getController(String path) {
		return mapping.get(path);
	}
}
