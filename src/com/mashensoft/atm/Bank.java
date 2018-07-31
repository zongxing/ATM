package com.mashensoft.atm;

public class Bank {
	private static User[] userArray;
	
	static {
		userArray = new User[100];
		User user1 = new User("zongxing", "123456", "�Ǹ�", 666666.66);
		User user2 = new User("xiaoxing", "667788", "С��", 8888.88);
		userArray[0] = user1;
		userArray[1] = user2;
	}
	
	
	
	/**
	 * ����û��˺��Ƿ�����
	 * @param useranme
	 * @return
	 */
	public static boolean checkUserIsExist(String useranme) {
		boolean sign = false;
		for(int i=0;i<userArray.length;i++) {
			if(userArray[i]!=null) {
				if(userArray[i].getUsername().equalsIgnoreCase(useranme)) {
					return true;
				}
			}
		}
		return sign;
	}
	/**
	 * ����û������Ƿ���ȷ
	 * @param useranme
	 * @param password
	 * @return
	 */
	public static boolean checkUserPassword(String useranme,String password) {
		boolean sign = false;
		for(int i=0;i<userArray.length;i++) {
			if(userArray[i]!=null) {
				if(userArray[i].getUsername().equalsIgnoreCase(useranme)&&userArray[i].getPassword().equalsIgnoreCase(password)) {
					return true;
				}
			}
		}
		return sign;
	}
	/**
	 * �����û����������ȡһ���û�����
	 * @param useranme
	 * @param password
	 * @return
	 */
	public static User getUser(String useranme,String password) {
		for(int i=0;i<userArray.length;i++) {
			if(userArray[i]!=null) {
				if(userArray[i].getUsername().equalsIgnoreCase(useranme)&&userArray[i].getPassword().equalsIgnoreCase(password)) {
					return userArray[i];
				}
			}
		}
		return null;
	}
	/**
	 * �����û����������ȡһ���û�����
	 * @param useranme
	 * @return
	 */
	public static User getUser(String useranme) {
		for(int i=0;i<userArray.length;i++) {
			if(userArray[i]!=null) {
				if(userArray[i].getUsername().equalsIgnoreCase(useranme)) {
					return userArray[i];
				}
			}
		}
		return null;
	}
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username,String password) {
		return checkUserPassword(username,password);
	}
	public static boolean transfer(User user,String destAccount,double money) {
		boolean sign = false;
		User destUser = getUser(destAccount);
		//���Լ���Ǯ
		user.setBanlance(user.getBanlance()-money);
		//��Ŀ���û���Ǯ
		destUser.setBanlance(destUser.getBanlance()+money);
		sign = true;
		return sign;
	}
	/**
	 * 
	 * @return
	 */
	public static boolean modifyPassword(User user,String newPasword) {
		boolean sign = false;
		user.setPassword(newPasword);
		sign = true;
		return sign;
	}
	
}
