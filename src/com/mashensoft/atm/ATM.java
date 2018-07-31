package com.mashensoft.atm;

import java.util.Scanner;

public class ATM {
	/**
	 * �ѵ�¼�û�
	 */
	User user;
	public void login() {
		Helper.log("�������˺�");
		Scanner s = new Scanner(System.in);
		String username = s.nextLine();
		if(!Bank.checkUserIsExist(username)){
			login();
		}
		Helper.log("����������");
		String password = s.nextLine();
		if(!Bank.checkUserPassword(username, password)) {
			login();
		}
		//���û���ѯ����
		user = Bank.getUser(username, password);
		Helper.log("��ϲ"+user.getName()+"����¼�ɹ�");
		showMainUI();
	}
	public void modifyPassword() {
		Helper.log("������ԭ����");
		Scanner s = new Scanner(System.in);
		String password = s.nextLine();
		if(!user.getPassword().equalsIgnoreCase(password)) {
			modifyPassword();
		}
		Helper.log("������������");
		String newPassword = s.nextLine();
		if(!Bank.modifyPassword(user, newPassword)) {
			modifyPassword();
		}
		Helper.log("�����޸ĳɹ�");
		showMainUI();
	}
	public void tranfer() {
		Helper.log("������Ŀ���˺�");
		Scanner s = new Scanner(System.in);
		String destAccount = s.nextLine();
		if(!Bank.checkUserIsExist(destAccount)) {
			tranfer();
		}
		Helper.log("������ת�˽��");
		String moneyStr = s.nextLine();
		double money = Double.parseDouble(moneyStr);
		if(user.getBanlance()<money) {
			Helper.log("��������");
			tranfer();
		}
		//TODO ��Ҫת��
		if(!Bank.transfer(user, destAccount, money)) {
			Helper.log("ת�˲��ɹ���������");
			tranfer();
		}
		Helper.log("ת�˳ɹ�");
		showMainUI();
	}
	public void queryBalance() {
		Helper.log("��������ǣ�"+user.getBanlance());
		showMainUI();
	}
	public void logout() {
		login();
		user = null;
	}
	public void showMainUI() {
		//��ȡ�û���
		Helper.log("�������������֣������Ӧ�˵����в���");
		Helper.log("1���޸��û�����");
		Helper.log("2: ת��");
		Helper.log("3����ѯ���");
		Helper.log("4���˳���¼");
		Scanner s = new Scanner(System.in);
		String content = s.nextLine();
		switch (content) {
		case "1":
			modifyPassword();
			break;
		case "2":
			tranfer();
			break;
			
		case "3":
			queryBalance();
			break;
			
		case "4":
			logout() ;
			break;
			
		default:
			break;
		}
	}
	public static void main(String[] args) {
		Helper.log("��ӭ��������ATMϵͳ");
		new ATM().login();
	}
}
