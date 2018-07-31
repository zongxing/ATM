package com.mashensoft.atm;

import java.util.Scanner;

public class ATM {
	/**
	 * 已登录用户
	 */
	User user;
	public void login() {
		Helper.log("请输入账号");
		Scanner s = new Scanner(System.in);
		String username = s.nextLine();
		if(!Bank.checkUserIsExist(username)){
			login();
		}
		Helper.log("请输入密码");
		String password = s.nextLine();
		if(!Bank.checkUserPassword(username, password)) {
			login();
		}
		//把用户查询出来
		user = Bank.getUser(username, password);
		Helper.log("恭喜"+user.getName()+"：登录成功");
		showMainUI();
	}
	public void modifyPassword() {
		Helper.log("请输入原密码");
		Scanner s = new Scanner(System.in);
		String password = s.nextLine();
		if(!user.getPassword().equalsIgnoreCase(password)) {
			modifyPassword();
		}
		Helper.log("请输入新密码");
		String newPassword = s.nextLine();
		if(!Bank.modifyPassword(user, newPassword)) {
			modifyPassword();
		}
		Helper.log("密码修改成功");
		showMainUI();
	}
	public void tranfer() {
		Helper.log("请输入目标账号");
		Scanner s = new Scanner(System.in);
		String destAccount = s.nextLine();
		if(!Bank.checkUserIsExist(destAccount)) {
			tranfer();
		}
		Helper.log("请输入转账金额");
		String moneyStr = s.nextLine();
		double money = Double.parseDouble(moneyStr);
		if(user.getBanlance()<money) {
			Helper.log("您的余额不足");
			tranfer();
		}
		//TODO 需要转账
		if(!Bank.transfer(user, destAccount, money)) {
			Helper.log("转账不成功，请重试");
			tranfer();
		}
		Helper.log("转账成功");
		showMainUI();
	}
	public void queryBalance() {
		Helper.log("您的余额是："+user.getBanlance());
		showMainUI();
	}
	public void logout() {
		login();
		user = null;
	}
	public void showMainUI() {
		//获取用户名
		Helper.log("请输入以下数字，进入对应菜单进行操作");
		Helper.log("1：修改用户密码");
		Helper.log("2: 转账");
		Helper.log("3：查询余额");
		Helper.log("4：退出登录");
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
		Helper.log("欢迎进入码神ATM系统");
		new ATM().login();
	}
}
