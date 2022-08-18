package com.HRA.helper;

public class StringPass {

	public static void main(String[] args) {
    String password = "Mindrops#123";
	String encryptQaPass	=StringEncrypt.encryptXOR(password, "Prod");
	System.out.println("The Encrypted Password is " + encryptQaPass);
//	String decryptQaPass= StringEncrypt.decryptXOR(password, "qa");
//	System.out.println("The decrypt Password is " + decryptQaPass);
	
	}

}
