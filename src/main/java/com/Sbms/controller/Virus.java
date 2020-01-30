package com.Sbms.controller;

import javax.swing.JOptionPane;

public class Virus {
	
	public static void main(String[] args) {
		int x=0;
		int y=4;
		while(x<y){
			JOptionPane.showConfirmDialog(null, "Do you want to close this virus?","Virus",JOptionPane.YES_NO_CANCEL_OPTION);
		}
	}

}
