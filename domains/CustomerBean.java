package com.bitcamp3.domains;

public class CustomerBean extends MemberBean {
   private String credit;
   
   public void setCredit(String credit) {
	   this.credit = credit;
   }
   public String getCredit() {
	   return credit;
   }
   @Override
	public String toString() {
		return String.format("회원정보"
				+ "아이디 : %s \n"
				+ "비번: %s \n"
				+ "이름: %s \n"
				+ "주민번호: %s \n"
				+ "신용도 : %s \n",super.getId() , super.getPw(), super.getName(), super.getSsn(), credit);
	}
}
