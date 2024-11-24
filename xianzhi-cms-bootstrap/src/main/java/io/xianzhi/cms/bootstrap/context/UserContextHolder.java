package io.xianzhi.cms.bootstrap.context;

import io.xianzhi.cms.bootstrap.model.XianZhiUserDetails;
import io.xianzhi.core.context.ContextHolder;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户上下文处理
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
public class UserContextHolder extends ContextHolder {


    public static XianZhiUserDetails getCurrentUserDetails() {
        return (XianZhiUserDetails) getContextOrThrow();
    }


    /**
     * 是否超级管理员
     *
     * @return 是否是超级管理员
     */
    public static boolean superAdmin() {
        return getCurrentUserDetails().getWorkNumber().equals("001");
    }

}
