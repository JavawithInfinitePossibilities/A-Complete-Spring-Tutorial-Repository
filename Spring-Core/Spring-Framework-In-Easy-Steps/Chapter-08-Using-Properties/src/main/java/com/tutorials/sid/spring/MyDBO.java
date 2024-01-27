/**
 * 
 */
package com.tutorials.sid.spring;

/**
 * @author Lenovo
 *
 */
public class MyDBO {
	private String dbUrl;
	private String user;
	private String pwd;

	/**
	 * @param dbUrl
	 * @param user
	 * @param pwd
	 */
	public MyDBO(String dbUrl, String user, String pwd) {
		super();
		this.dbUrl = dbUrl;
		this.user = user;
		this.pwd = pwd;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "MyDBO [dbUrl=" + dbUrl + ", user=" + user + ", pwd=" + pwd + "]";
	}

}
