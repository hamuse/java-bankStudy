package com.bitcamp3.bankControllers;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		String createAccountNum = "";
		Random ran = new Random();

		for(int i = 0; i <9; i++) {
			createAccountNum += (i == 4)? "-" : ran.nextInt(10);
			
		}
		System.out.println( createAccountNum);
	}
		
}
