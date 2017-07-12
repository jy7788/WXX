package org.zsl.testmybatis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.junit.Test;

public class TestSend {

	@Test
	public void test() {
		Socket socket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			socket  = new Socket("192.168.1.121", 9090);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			out.write("daaa".getBytes("utf-8"));
			out.flush();
			byte[] buf = new byte[1024];
			StringBuffer result = null;
			if(in.read(buf, 0, buf.length) != -1) {
				result.append(buf);
			}
			System.out.println(new String(buf));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
