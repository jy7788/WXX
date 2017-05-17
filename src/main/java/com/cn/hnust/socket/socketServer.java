package com.cn.hnust.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.DataInputStream;   
import java.io.DataOutputStream;   
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class socketServer
{
	ArrayList clientList = new ArrayList();
	//private DataOutputStream output;
	//private DataInputStream input;
	//private String clientName;
	//private Socket socket;
	
	public static void main(String[] args)
	{
		//��main�����У�������������socket
		new socketServer().OpenServer();
		
	}
	
	public void OpenServer()
	{
		try
		{
			ServerSocket server = new ServerSocket(10001);
			
			Socket socket;
			while((socket = server.accept())!=null)
			{
					clientList.add(socket);
					//clientName = socket.getInetAddress().toString();
					//output = new DataOutputStream(socket.getOutputStream());
					//input = new DataInputStream(socket.getInputStream());
					new readClient(socket).start();
					new writeClient(socket).start();
			}
		}
		catch(Exception e) {System.out.println(e.toString());}
	}
	
	public class readClient extends Thread
	{
		private Socket socket;
		
		public readClient(Socket client)
		{socket = client;}
		
		public void run()
		{
			String msg;
			try
			{
				String clientName = socket.getInetAddress().toString();
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				DataInputStream input = new DataInputStream(socket.getInputStream());
				while((msg = input.readUTF())!=null)
				{
					System.out.println("�յ���Ϣ����"+clientName+"�� "+msg);	
				}
			}
			catch(Exception e){System.out.println(e.toString());}
		}	
	}
	
	public class writeClient extends Thread
	{
		private Socket socket;
		
		public writeClient(Socket client)
		{socket = client;}
	
		public void run()
		{
			try{
				
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				String userInput;
				String clientName = socket.getInetAddress().toString();
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				DataInputStream input = new DataInputStream(socket.getInputStream());
				while(true)
				{
					if(stdIn.ready())
					{
						userInput = stdIn.readLine();
						if(userInput!="exit")
						{
							output.writeUTF(userInput);
							System.out.println("�ѷ�����Ϣ����"+clientName+"��"+userInput);
						}
					}
				}
			}
			catch(Exception e) {System.out.println(e.toString());}
		}
	}
	
}