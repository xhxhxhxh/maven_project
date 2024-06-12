package com.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

@WebServlet("/demo5")
public class CookieDemo extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 获取cookie
    System.out.println("------");
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        System.out.println(cookie.getName() + ": " + URLDecoder.decode(cookie.getValue()));
      }
    }

    // 设置cookie
    Cookie cookie = new Cookie("username", URLEncoder.encode("aaa"));
    cookie.setMaxAge(-1); // 设置存活时间，负数表示浏览器关闭则失效，0表示删除cookie
    resp.addCookie(cookie);

    // 获取session,tomcat在服务器关闭后会将session写入硬盘,默认情况下30分钟自动销毁，可在web.xml配置
    HttpSession session = req.getSession();
    // session.invalidate(); // 销毁
    Object password = session.getAttribute("password");
    if (password == null) {
      session.setAttribute("password", "123456");

    } else {
      System.out.println("password: " + password);
    }
  }
}
