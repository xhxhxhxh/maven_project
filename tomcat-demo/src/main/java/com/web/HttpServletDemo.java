package com.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/demo2")
//@WebServlet(urlPatterns = {"/demo2", "/demo3"}) // 多个匹配
//@WebServlet(urlPatterns = "/user/*") //目录匹配
//@WebServlet(urlPatterns = "*.do") //扩展名匹配
@WebServlet(urlPatterns = "/") //任意匹配
public class HttpServletDemo extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("doGet");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("doPost");
  }
}
