package com.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;

@WebServlet("/demo4")
public class ResponseDemo extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    resp.setHeader("content-type", "text/html;charset=utf-8");
//
//   resp.setStatus(302); // 设置状态码
//    resp.setHeader("Location", "/tomcat-demo/demo2?a=张三");
     //resp.sendRedirect("/tomcat-demo/demo2?a=" + URLEncoder.encode("张三")); // 重定向
//    PrintWriter writer = resp.getWriter(); // 该流不需要关闭
//    writer.write("<h1>aaa你好</h1>");

    FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\下载.png");
    ServletOutputStream outputStream = resp.getOutputStream();
//    byte[] bytes = new byte[1024];
//    int len = 0;
//    while ((len = fis.read(bytes)) != -1) {
//      outputStream.write(bytes, 0, len);
//    }

    // 流的拷贝工具
    IOUtils.copy(fis, outputStream);

    fis.close();
  }
}
