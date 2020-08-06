package com.example.social;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class QQApiAdapter implements ApiAdapter {

    @Override
    public boolean test(Object o) {
        return false;
    }

    @Override
    public void setConnectionValues(Object o, ConnectionValues connectionValues) {
        
    }

    @Override
    public UserProfile fetchUserProfile(Object o) {
        return null;
    }

    @Override
    public void updateStatus(Object o, String s) {

    }

}
