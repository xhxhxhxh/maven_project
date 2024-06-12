package com.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns="/demo1", loadOnStartup = 1)
public class ServletDemo1 implements Servlet {
  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    System.out.println("init");
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    System.out.println("hello servlet");
  }

  @Override
  public String getServletInfo() {
    return "";
  }

  @Override
  public void destroy() {
    System.out.println("destroy");
  }
}
