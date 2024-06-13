package com.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonDemo {
  public static void main(String[] args) {
    // java对象转json字符
    User user = new User();
    user.setAge(20);
    user.setName("张三");
    String jsonString = JSON.toJSONString(user);
    System.out.println(jsonString);

    // json字符转java对象
    User jsonObject = JSON.parseObject(jsonString, User.class);
    System.out.println(jsonObject.toString());
  }
}
