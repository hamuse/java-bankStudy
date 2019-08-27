package com.bitcamp3.bankControllers;
import javax.swing.JOptionPane;
import com.bitcamp3.domains.MemberBean;
import com.bitcamp3.bankServiceImpls.MemberServiceImpl;
import com.bitcamp3.domains.CustomerBean;
public class BankController {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		MemberBean memberBean = null;
		CustomerBean customerBean = null;
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		
		 while(true) {
			 switch(JOptionPane.showInputDialog("0.종료 1.등록 2.")) {
			 case "0" : JOptionPane.showMessageDialog(null, "종료"); 
				 return;
			case "1" :String[] arr = JOptionPane.showInputDialog("아이디,비번,이름,주민번호,신용도").split(",");
			 			customerBean = new CustomerBean();
			              customerBean.setId(arr[0]);
				          customerBean.setPw(arr[1]);
				           customerBean.setName(arr[2]);
				          customerBean.setSsn(arr[3]);
				           customerBean.setCredit(arr[4]);
				
				    	break;
				 
			 case "2" : 
				 break;
			 
			 }
			 
		 }
	}

}
