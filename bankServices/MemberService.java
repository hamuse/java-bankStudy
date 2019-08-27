package com.bitcamp3.bankServices;

import com.bitcamp3.domains.*;

public interface MemberService {
	public void join(CustomerBean param);
	public void register(AccountBean paran);
	public CustomerBean[] findAllCustomers();
	public AdminBean[] findAllAdmins();
	public MemberBean[] findByName(String name);
	public MemberBean findById(String id); 
	public boolean login(MemberBean param);
	public int countCustomers();
	public int countAdmins();
	public boolean existId(String id);
	public void updatePass(MemberBean param);
	public void deleteMember(MemberBean param);
         
}
