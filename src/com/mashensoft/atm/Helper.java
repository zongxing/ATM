package com.mashensoft.atm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Helper {
	public static void log(String content) {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("logs.txt",true)));
			System.out.println(content);
			pw.write(content+"\r\n");
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
