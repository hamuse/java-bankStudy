package com.bitcamp3.domains;

public class AdminBean extends MemberBean {
	private String sabun;

	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	@Override
	public String toString() {
		return "사원정보 [사번=" + sabun +
				"아이디=" + getId() +
				", 비번=" + getPw() +
				", 이름=" + getName() +
				", 주민번호=" + getSsn() + "]";
	}


}
