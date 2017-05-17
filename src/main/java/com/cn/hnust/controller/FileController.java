package com.cn.hnust.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileController {
	
//	@RequestMapping(value="/MP_verify_yPoDNEPUU1OwQ2kE.txt")
	public String file(HttpServletRequest request,HttpServletResponse resp){
		try {
            // path是指欲下载的文件的路径。
            File file = new File("d:/MP_verify_yPoDNEPUU1OwQ2kE.txt");
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            //String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            System.out.println(filename);
            
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            resp.reset();
            // 设置response的Header
            resp.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("utf-8"),"ISO-8859-1"));
            resp.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(resp.getOutputStream());
            resp.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return "index";
   }
}
