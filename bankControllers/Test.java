package com.bitcamp3.bankControllers;

import java.util.Random;
import com.bitcamp3.bankServiceImpls.*;
import com.bitcamp3.domains.AccountBean;
import javax.swing.JOptionPane;;
public class Test {

	public static void main(String[] args) {
		AccountServiceImpl a = new AccountServiceImpl();
		AccountBean bean = null;
		
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료1.계좌생성 2.예금확인")) {
			
			case "0" : JOptionPane.showMessageDialog(null, "종료"); 
						return;
			case "1" : String money = JOptionPane.showInputDialog("돈입력");
					bean = new AccountBean();
					bean.setMoney(money);
				    a.createAccount(Integer.parseInt(money));
				    break;
			case "2" : JOptionPane.showMessageDialog(null, a.findAll());
			break;
			}
		}
		
		
		
	}
		
}
