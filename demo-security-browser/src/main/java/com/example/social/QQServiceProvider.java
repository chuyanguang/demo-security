package com.example.social;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;

public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQApi> {

    private String appId;
    public static final String AUTH_URL = "https://graph.qq.com/oauth2.0/authorize";
    public static final String TOKEN_URL = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId, String secret) {
        super(new QQOAuth2Template(appId, secret, AUTH_URL, TOKEN_URL));
    }

    @Override
    public QQApi getApi(String accessToken) {
        return new QQApi(accessToken, appId);
    }
}
