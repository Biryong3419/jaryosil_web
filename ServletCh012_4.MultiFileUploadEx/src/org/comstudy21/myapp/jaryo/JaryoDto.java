package org.comstudy21.myapp.jaryo;

public class JaryoDto {
	private String password;
	private String filename;
	public JaryoDto() {}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public JaryoDto(String password, String filename) {
		super();
		this.password = password;
		this.filename = filename;
	}

}
