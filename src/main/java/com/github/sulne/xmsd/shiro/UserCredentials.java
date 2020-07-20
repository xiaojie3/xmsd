package com.github.sulne.xmsd.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

public class UserCredentials extends SimpleCredentialsMatcher {
	private Cache<String, AtomicInteger> passwordRetryCache;

	public UserCredentials(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
		passwordRetryCache.size();
	}

	//private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
	/**
	 * 自定义的密码匹配器
	 * 如果验证通过,则进入自定义拦截器,进行登录后所需的操作
	 * */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		System.out.println("进入自定义Credentials类的密码匹配>>doCredentialsMatch方法");
		System.out.println("token的内容>>"+token.toString());
		System.out.println("info的内容>>"+info.toString());
		boolean result =  super.doCredentialsMatch(token, info);
		System.out.println("密码验证的结果为>>"+result);
		System.out.println("=============================================================================================");
		return result;
	}
}
