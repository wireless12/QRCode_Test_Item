package com.example.demo.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.utils.QRCodeUtils;


@Controller
@CrossOrigin
@RequestMapping("/qr")
public class QRCodeController {
  @GetMapping("/login/qr")
  public void getLoginQr(HttpServletRequest req, HttpServletResponse resp, String address,String loginId) {
    String qrText = address+ "," + loginId;
    try {
      OutputStream outputStream = resp.getOutputStream();
      QRCodeUtils.encode(qrText,outputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
