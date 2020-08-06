package com.example.controller;

import com.example.entity.ResultData;
import com.example.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private SmsService smsService;

    @GetMapping
    public ResultData<String> hello(){
        return ResultData.ok("成功", "hello security");
    }
//    @GetMapping
//    public ResultData<String> hello(@Value("${logging.type}") String type){
//        return ResultData.ok("成功", "hello security, "+type);
//    }

    @GetMapping("ssms/{phone}")
    public ResultData<String> sendSms(@PathVariable("phone") String phone){
        smsService.sendSms(phone);
        return ResultData.ok("发送成功", null);
    }

}
