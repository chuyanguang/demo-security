package com.example.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    public static final String ACCESS_KEYID = "";
    public static final String ACCESS_SECRET = "";

    @Override
    public void sendSms(String phone) {
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEYID, ACCESS_SECRET);
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        request.setSysMethod(MethodType.POST);
//        request.setSysDomain("dysmsapi.aliyuncs.com");
//        request.setSysVersion("2017-05-25");
//        request.setSysAction("SendSms");
//        request.putQueryParameter("RegionId", "cn-hangzhou");
//        request.putQueryParameter("PhoneNumbers", phone);
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            log.info(response.getData());
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }

    }

}
