package com.github.sulne.xmsd.config;

import com.github.sulne.xmsd.shiro.UserFilter;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sulne.xmsd.shiro.UserCredentials;
import com.github.sulne.xmsd.shiro.UserRealm;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

	@Bean
	public MemoryConstrainedCacheManager cacheManager() {
		return new MemoryConstrainedCacheManager();
	}

	@Bean
	public UserCredentials credentialsMatcher() {
		return new UserCredentials(cacheManager());
	}

	@Bean
	public UserRealm realm() {
		UserRealm realm = new UserRealm();
		realm.setCredentialsMatcher(credentialsMatcher());
		return realm;
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(realm());
		return securityManager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilter() {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager());
		Map<String,String> map = new HashMap<>();
		map.put("/kb/**","user");
		map.put("/kb/login","anon");
		Map<String, Filter> filters = shiroFilter.getFilters();
		filters.put("authc",new UserFilter());
		shiroFilter.setFilters(filters);
		shiroFilter.setFilterChainDefinitionMap(map);
		return shiroFilter;
	}
}
