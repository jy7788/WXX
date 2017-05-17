package com.cn.hnust.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class ReceiveClient {
//    private final String IP=Setting.RECEIVE_IP;
    private final String IP="192.168.1.121";
    private final int PORT=9090;
    /**
     * @throws Exception 
     * 发送报文
     * @Title: send 
     * @Description: TODO 
     * @param @param reqMessage   
     * @return void   
     * @throws
     */
   public void send(String reqMessage) throws Exception{
       Socket sock=null;
       BufferedOutputStream out=null;
       try {
        sock=new Socket();

                  SocketAddress sockAdd=new InetSocketAddress(IP, PORT);
             sock.connect(sockAdd, 2000); //客户端设置连接建立超时时间

             out=new BufferedOutputStream(sock.getOutputStream());
        out.write(reqMessage.getBytes());
        out.flush();

    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }finally{
        if(out!=null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();            }
        }
        if(sock!=null){
            try {
                sock.close();
            } catch (IOException e) {
                    e.printStackTrace();
        }
        }
    } 
   }

    //接收
    public String  reiceve() throws Exception{
        Socket sock=null;
        BufferedInputStream in=null;

            try {
                sock=new Socket(IP,PORT);
                in = new BufferedInputStream(sock.getInputStream());
                 if ((sock == null) || (in == null)) {
                        throw new Exception("套接口无效，无法读取数据");
                  }

            } catch (UnknownHostException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

             byte[] bts = new byte[10000];
             int totalLen = 0, len = 0;
             while ((len = in.read(bts, totalLen, 1000)) != -1) {
                    totalLen += len;
                }
             String result = new String(bts);  //注意字符编码
             return result.trim();
    } 

    public static void main(String[] args){
        //发送
        String str="我是客户端！";      
        try {
                new ReceiveClient().send(str);
                while(true) {
                	String recStr=new ReceiveClient().reiceve();
                	System.out.println("客户端接收到的结果=="+recStr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        //接收报文
        /*try {
            String recStr=new Receiver().reiceve();
            System.out.println("客户端接收到的结果=="+recStr);
                    } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}