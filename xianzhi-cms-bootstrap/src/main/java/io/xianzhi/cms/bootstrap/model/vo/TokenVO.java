package io.xianzhi.cms.bootstrap.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * token出参
 *
 * @author Max
 * @since 1.0.0
 */
@Data
public class TokenVO implements Serializable {


    /**
     * 用户ID
     */
    private String id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 真是姓名
     */
    private String realName;

    /**
     * 工号
     */
    private String workNumber;

    /**
     * 头像
     */
    private String avatar;
    /**
     * 域账号
     */
    private String domainAccount;
    /**
     * 认证token
     */
    private String accessToken;

    /**
     * 刷新token
     */
    private String refreshToken;
}
