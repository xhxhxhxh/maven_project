package com.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@WebServlet("/demo3")
public class RequestDemo  extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("doGet");
    String method = req.getMethod();
    System.out.println(method);
    String contextPath = req.getContextPath(); // 虚拟目录
    System.out.println(contextPath);
    StringBuffer requestURL = req.getRequestURL();
    System.out.println(requestURL);
    String requestURI = req.getRequestURI();
    System.out.println(requestURI);
    // 中文乱码解决
    req.setCharacterEncoding("UTF-8"); // post提交
    // 获取参数
    String queryString = req.getQueryString();
    System.out.println(queryString);
    req.getParameterMap().forEach((k,v) -> System.out.println(k + "=" + Arrays.toString(v)));
    String[] bs = req.getParameterValues("b"); // 根据key获取参数值
    System.out.println(Arrays.toString(bs));
    String a = req.getParameter("a");
    System.out.println(a);// 根据key获取参数单个值
    System.out.println(toZHcn(a)); // 解决get乱码
    // 获取请求头
    String header = req.getHeader("user-agent");
    System.out.println(header);

    System.out.println("额外参数-----");
    System.out.println(req.getAttribute("msg"));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("doPost");
    // post获取请求体
    BufferedReader reader = req.getReader();
    reader.readLine();
  }

  protected String toZHcn(String s) {
    byte[] bytes = s.getBytes(StandardCharsets.ISO_8859_1);
    return new String(bytes, StandardCharsets.UTF_8);
  }
}
