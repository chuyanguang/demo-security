package com.example.social;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.example.social.entity.QQUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.util.Map;

@Slf4j
public class QQApi extends AbstractOAuth2ApiBinding {

    private String appId;
    private String openId;
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    private static final String URL_GET_TOKEN = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    protected QQApi(String accessToken, String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String result = super.getRestTemplate().getForObject(String.format(URL_GET_OPENID, accessToken), String.class);
        log.info(result);
//        callback( {"client_id":"YOUR_APPID","openid":"YOUR_OPENID"} );
        this.openId = StrUtil.subBetween(result, "openid\":\"", "\"}");
    }


    public QQUserInfo getUserInfo() {
        Map resultMap = super.getRestTemplate().getForObject(String.format(URL_GET_TOKEN, appId, openId), Map.class);
        log.info(resultMap.toString());
        QQUserInfo userInfo = new QQUserInfo();
        BeanUtil.copyProperties(resultMap, userInfo);
        return userInfo;
    }

}
