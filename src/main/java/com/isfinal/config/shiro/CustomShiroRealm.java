package com.isfinal.config.shiro;

import com.isfinal.config.jwt.JwtToken;
import com.isfinal.config.jwt.JwtUtil;
import com.isfinal.module.model.Role;
import com.isfinal.module.model.User;
import com.isfinal.module.service.RoleService;
import com.isfinal.module.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomShiroRealm extends AuthorizingRealm {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JwtUtil.getUsername(principalCollection.toString());
        User User = userService.getUserByUsername(username);
        List<Role> roleList = roleService.getRoles(User.getId());
        Set<String> permissions = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        for (Role role : roleList) {
            roles.add(role.getRole());
            permissions.add(role.getPermission());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getCredentials().toString();
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }
        User User = userService.getUserByUsername(username);
        if (User == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JwtUtil.verify(token, username, User.getPassWord())) {
            throw new AuthenticationException("Username or password error");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token, token, getName());
        return info;
    }

    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        SimplePrincipalCollection spc = new SimplePrincipalCollection(user.getUserName(), getName());
        super.clearCachedAuthenticationInfo(spc);
    }

}
