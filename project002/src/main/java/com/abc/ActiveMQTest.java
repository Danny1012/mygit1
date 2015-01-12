package com.abc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ActiveMQTest
{

	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("localhost", 8080);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		pw.println("GET /project002/login.jsp HTTP/1.1");
		pw.println("Host: localhost");
		pw.println("Content-Type: text/html");
		pw.println();
		pw.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null)
		{
			System.out.println(line);
		}
		
		br.close();
		pw.close();
		s.close();
	}

}
