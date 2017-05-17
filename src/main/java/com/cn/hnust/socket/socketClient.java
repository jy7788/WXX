package com.cn.hnust.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;   
import java.io.DataOutputStream;   
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class socketClient
{
	private DataOutputStream output;
	private DataInputStream input;
	private String clientName;
	
	public static void main(String[] args)
	{
		//��main�����У�������������socket
		new socketClient().ConnectServer();
	}
	
	public void ConnectServer()
	{
		try
		{
			Socket socket = new Socket("127.0.0.1",10001);
			clientName = socket.getInetAddress().toString();
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
			
			new readServer().start();
			new writeServer().start();
		}
		catch(Exception e)	{System.out.println(e.toString());}
	}
	
	public class readServer extends Thread
	{
		private Socket client;

		public void run()
		{
			String msg;
			try
			{
				while(true)
				{
					msg = input.readUTF();
					if(msg!=null)
						System.out.println("�յ���Ϣ����"+clientName+"�� "+msg);	
				}
			}
			catch(Exception e) {System.out.println(e.toString());}
		}	
	}
	
	public class writeServer extends Thread
	{
		private Socket client;

		
		public void run()
		{
			try
			{
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				String userInput;
				while(true)
				{
					if(stdIn.ready())
					{
						userInput = stdIn.readLine();
						if(userInput!="exit")
						{
							output.writeUTF(userInput);
							System.out.println(clientName+" AAA "+userInput);
						}
					}
				}
			}
			catch(Exception e) {System.out.println(e.toString());}
		}
	}
	
}