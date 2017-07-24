package com.cn.hnust.htmlparser;


import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;


public class Test {  
    
	public static String path = "file:///D:/PerformanceTest/copy/5.html";
    public static String path1 = "http://mp.weixin.qq.com/s/65-cV4S0A0pXV5XTQmYmLQ";

    public static void main(String[] args) throws IOException, ParserException {
        Parser parser = new Parser((URLConnection) (new URL(path1)).openConnection());
        
        for(NodeIterator i=parser.elements();i.hasMoreNodes();){
            Node node=i.nextNode();
            System.out.println(node.toHtml());
            System.err.println("mhj------------------>");
        }
    }
}  