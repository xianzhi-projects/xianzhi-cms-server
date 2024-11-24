package io.xianzhi.cms.bootstrap.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Max
 * @since 1.0.0
 */
@Data
public class AuthUser implements Serializable {

    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 真是姓名
     */
    private String realName;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 手机号码
     */
    private String mobileNumber;
    /**
     * 密码
     */
    private String password;
    /**
     * 工号
     */
    private String workNumber;
    /**
     * 域账号
     */
    private String domainAccount;

    /**
     * 是否启用
     */
    private Boolean enableFlag;

}
