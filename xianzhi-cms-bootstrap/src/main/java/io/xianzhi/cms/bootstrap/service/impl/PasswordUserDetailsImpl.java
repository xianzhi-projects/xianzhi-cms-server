package io.xianzhi.cms.bootstrap.service.impl;

import io.xianzhi.boot.security.code.SecurityCode;
import io.xianzhi.cms.bootstrap.dao.mapper.UserMapper;
import io.xianzhi.cms.bootstrap.model.AuthUser;
import io.xianzhi.cms.bootstrap.model.XianZhiUserDetails;
import io.xianzhi.boot.security.enums.GrantTypeEnum;
import io.xianzhi.cms.bootstrap.service.XianZhiUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordUserDetailsImpl implements XianZhiUserDetailsService {

    /**
     * 用户信息持久层
     */
    private final UserMapper userMapper;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException(SecurityCode.USER_NAME_OR_PASSWORD_ERROR.getCode());
        }
        AuthUser authUser = userMapper.loadAuthUserByAccount(username);
        if (null == authUser) {
            throw new UsernameNotFoundException(SecurityCode.USER_NAME_OR_PASSWORD_ERROR.getCode());
        }
        XianZhiUserDetails userDetails = new XianZhiUserDetails();
        userDetails.setId(authUser.getId());
        userDetails.setNickName(authUser.getNickName());
        userDetails.setAvatar(authUser.getAvatar());
        userDetails.setRealName(authUser.getRealName());
        userDetails.setEmail(authUser.getEmail());
        userDetails.setMobileNumber(authUser.getMobileNumber());
        userDetails.setPassword(authUser.getPassword());
        userDetails.setWorkNumber(authUser.getWorkNumber());
        userDetails.setDomainAccount(authUser.getDomainAccount());
        userDetails.setEnableFla(authUser.getEnableFlag());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("/user"));
        userDetails.setAuthorities(authorities);
        return userDetails;
    }

    /**
     * 是否支持授权方式
     *
     * @param grantType 授权方式
     * @return 响应信息
     */
    @Override
    public boolean support(String grantType) {
        return GrantTypeEnum.PASSWORD.getCode().equals(grantType);
    }
}
