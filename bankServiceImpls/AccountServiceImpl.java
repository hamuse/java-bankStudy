package com.bitcamp3.bankServiceImpls;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.bitcamp3.bankServices.AccountService;
import com.bitcamp3.domains.AccountBean;

public   class AccountServiceImpl implements AccountService {
	
	private AccountBean[] accounts; //저장소
	private int count; //저장소 
	 
	
	 public AccountServiceImpl() {
		 accounts = new AccountBean[10];
		 count = 0;
	}
		 
	@Override
	public void createAccount(int money) {
		AccountBean acc = new AccountBean();
		acc.setAccountNum(createAccountNum() );
		acc.setMoney(money+"");
		acc.setToday(findDate());
		accounts[count] = acc;
		count++;		
	}
	@Override
	public String createAccountNum() {
		 String accountNum = "";
	      Random ran = new Random();
	      for(int i = 0 ; i < 9 ; i++) {
	    	accountNum += (i==4) ? "-" : ran.nextInt(10);
	      }
		return accountNum;
		
	}

	@Override
	public AccountBean[] findAll() {
		AccountBean[] accountBeans = new AccountBean[count];
		for(int i = 0; i < count; i++) {
			accountBeans[i] = accounts[i];
			
		}
		return accountBeans;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean accountBean = new AccountBean();
		for(int i =0 ; i <count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				accountBean = accounts[i];
				break;
			}
		}
		
		return accountBean;
	}

	@Override
	public int countAccounts() {

		return count;
	}

	@Override
	public boolean existAccountNum(String accountNum) { //계좌번호 중복 확인
        boolean num = false;
    	for(int i =0 ; i <count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				num =true;
				break;
			}
	}
    	return num;
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) { //예금?
		int money =0;
		for(int i = 0; i< count; i++) {
			if(param.getAccountNum().equals(accounts[i].getAccountNum())) {
				int a = Integer.parseInt(accounts[i].getMoney());
				int b = Integer.parseInt(param.getMoney());
				money = a + b ;
				accounts[i].setMoney(String.valueOf(money));
				accounts[i].setToday(findDate());
				break;
			}
		}
	}

	@Override
	public void withdrawMoney(AccountBean param) { //인출
		int money = 0;
		
	  for(int i = 0; i<count; i++) {
		  if(param.getAccountNum().equals(accounts[i].getAccountNum())) {
			int a = Integer.parseInt(accounts[i].getMoney());
			int b = Integer.parseInt(param.getMoney());
			money = a - b ;
			accounts[i].setMoney(String.valueOf(money));
			accounts[i].setToday(findDate());
			  break;
		  }
	  }
		
		
	}

	@Override
	public void deleteAccountNum(String accountNum) { //계좌삭제
		for(int i = 0; i <count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				accounts[i] = accounts[count-1];
				count--;
				break;
			}
		}
	}

}