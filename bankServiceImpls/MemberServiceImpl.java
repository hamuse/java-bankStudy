package com.bitcamp3.bankServiceImpls;
import com.bitcamp3.domains.*;
import com.bitcamp3.bankServices.MemberService;

public class MemberServiceImpl implements MemberService {
	private CustomerBean[] customers;
	private  AdminBean[] admins;
  private int empCount, custCount;
   
   
	public MemberServiceImpl() { //컨트롤 시프트 누르면 자동으로 나온다.
		customers =new CustomerBean[10]; 
		admins =new AdminBean [10]; 
		custCount = 0;
		empCount = 0;
			}
	@Override
	public void join(CustomerBean param) {
	
		customers[custCount] = param;
		custCount++;
     
	}
	@Override
	public void register(AccountBean paran) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerBean[] findAllCustomers() {
        
		return customers;
	}

	@Override
	public AdminBean[] findAllAdmins() {
		return admins;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int count1 = 0, count2  =0 , count3 = 0;
			for(int i =0; i < custCount; i++) {
				if(name.equals(customers[i].getName())) {
					count1++;
					break;
				}
			}
			for(int i =0; i < empCount; i++) {
				if(name.equals(admins[i].getName())) {
					count2++;
					break;
				}
	}
			count3 = count1 + count2;
			int j = 0;
			MemberBean[] members = new MemberBean[count3];
			for(int i = 0; i < count3; i++) {
				if(name.equals(customers[i].getName())) {
					members[j] = customers[i];
					j++;
					if(j == count1) {
						
						break;
					}
				}
			}
			int k = 0;
			for(int i = 0; i < count3; i++) {
				if(name.equals(admins[i].getName())) {
					members[j] = admins[i];
					j++;
					k++;
				   if(k == count2) {
					   
					   break;
				   }
				}
			}
			return members;
	}
	@Override
	public MemberBean findById(String id) {
       MemberBean bean = new MemberBean();
       for(int i = 0; i < custCount; i++) {
    	   if(id.equals(customers[i].getId())) {
    		   bean = customers[i];
    		   break;
    	   }
       }
       for(int i = 0; i < empCount; i++) {
    	   if(id.equals(admins[i].getId())) {
    		   bean = admins[i];
    		   break;
    	   }
	}
       return bean;
	}
	@Override
	public boolean login(MemberBean param) {
//		for(int i = 0; i< custCount; i++) {
//			if(param.getId().equals(customers[i].getId()) && param.getPw().equals(customers[i].getPw())) {
//				
//			}
//		}
//		boolean flag = false;
//		MemberBean b = findById(param.getId());
		return findById(param.getId())
				.getPw()
				.equals(param.getPw());//(b.equals(param.getPw())) {
	}

	@Override
	public int countCustomers() {
		return custCount ;
	}

	@Override
	public int countAdmins() {
				return empCount;
	}

	@Override
	public boolean existId(String id) { //아이디 중복 문제 
	   boolean flag = false;
	   for(int i = 0; i < custCount; i++) {
    	   if(id.equals(customers[i].getId())) {
    		   flag = true;
    		   break;
    	   }
       }
       for(int i = 0; i < empCount; i++) {
    	   if(id.equals(admins[i].getId())) {
    		   flag = true;
    		   break;
    	   }
	}
	   
	   
		return flag;
	}

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String[] arr = param.getPw().split(",");
		String oldPw = arr[0];
		String newPw = arr[1];
		param.setPw(oldPw);
       if(login(param)) {
    	   for(int i = 0; i < custCount; i++) {
        	   if(id.equals(customers[i].getId())) {
        		 customers[i].setPw(newPw);
        		   break;
        	   }
           }
           for(int i = 0; i < empCount; i++) {
        	   if(id.equals(admins[i].getId())) {
        		  admins[i].setPw(newPw);
        		   break;
        	   }
    	   
           }
           }
	}

	@Override
	public void deleteMember(MemberBean param) {
		if(login(param)) {
			int i =0;
			for(; i < custCount; i++) {
				if(customers[i].getId().equals(param.getId())) {
					customers[i] = customers[custCount-1];
					custCount--;
					break;
				}
				customers[i] = customers[custCount-1];
			}
			i =0;
			for(;i<empCount; i++) {
				if(admins[i].getId().equals(param.getId())) {
					admins[i] = admins[empCount-1];
					empCount--;
					break;
				}
				admins[i] = admins[empCount-1];
			}
		}
		
	}


}
