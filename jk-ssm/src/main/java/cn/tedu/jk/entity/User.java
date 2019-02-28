package cn.tedu.jk.entity;

public class User {
	private String admin;
	private String passworld;
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPassworld() {
		return passworld;
	}
	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}
	@Override
	public String toString() {
		return "User [admin=" + admin + ", passworld=" + passworld + "]";
	}
}
