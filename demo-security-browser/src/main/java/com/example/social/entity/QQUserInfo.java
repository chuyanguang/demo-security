package com.example.social.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QQUserInfo implements Serializable {

    private static final long serialVersionUID = -751339187065230432L;

    // QQ空间的昵称
    private String nickName;

    // QQ空间头像URL
    private String figurerUrl;

    // 性别
    private String gender;
}
