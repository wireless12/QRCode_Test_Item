package com.example.demo.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.utils.TokenUtil;


@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

  @RequestMapping("/login")
  @ResponseBody
  public String login(String name, String password){
      // 这个需要查数据库判断用户名和密码是否正确
      if(Objects.equals(name, "one") && Objects.equals(password, "123456"))
      {
          String res = TokenUtil.sign(name,6L);
          return res + "%and%6";
      }
      return "error";
  }

  @RequestMapping("/qr/login")
  @ResponseBody
  public String qrLogin(String name, String userId){
      // 这个需要查数据库判断用户名和密码是否正确
      if(Objects.equals(name, "one") && Objects.equals(userId, "6"))
      {
          String res = TokenUtil.sign(name,6L);
          return res + "%and%6";
      }
      return "error";
  }

  @RequestMapping("/check")
  @ResponseBody
  public String tokenCheck(HttpServletRequest request,String userId){
    System.out.println(request.getHeader("userToken"));
    String token = request.getHeader("userToken");
    TokenUtil.verify(token);
    return null;
  }
}