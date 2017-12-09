package org.comstudy21.myapp.jaryo;

import org.comstudy21.myapp.command.Command;

public class JaryoCommandFactory {

	private static JaryoCommandFactory instance = new JaryoCommandFactory();

	private JaryoCommandFactory() {
	}

	public static JaryoCommandFactory getInstance() {
		if (instance == null) {
			synchronized (instance) {
				instance = new JaryoCommandFactory();
			}
		}
		return instance;
	}

	public Object getCommand(String cmd) {

		Command command = null;
		if ("/moveList".equals(cmd)) {
			command = new JaryoMoveListCommand();
		} else if ("/moveUpload".equals(cmd)) {
			command = new JaryoMoveUploadCommand();
		} else if ("/upload".equals(cmd)) {
			command = new JaryoUploadCommand();
		} else if ("/moveDelete".equals(cmd)) {
			command = new JaryoMoveDeleteCommand();
		} else if ("/delete".equals(cmd)) {
			command = new JaryoDeleteCommand();
		}

		return command;
	}
}
