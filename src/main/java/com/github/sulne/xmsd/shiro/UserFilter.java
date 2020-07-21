package com.github.sulne.xmsd.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserFilter extends AuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(UserFilter.class);

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        boolean loggedIn = false; //false by default or we wouldn't be in this method
        log.debug("111");
        return loggedIn;
    }
}
