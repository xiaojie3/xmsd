package com.github.sulne.xmsd.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sulne.xmsd.shiro.UserCredentials;
import com.github.sulne.xmsd.shiro.UserFilter;
import com.github.sulne.xmsd.shiro.UserRealm;

@Configuration
public class ShiroConfig {
	private static final Logger log = LoggerFactory.getLogger(ShiroConfig.class);

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
		shiroFilter.setLoginUrl("/login");
		Map<String,String> map = new HashMap<>();
		map.put("/kb/**","user");
		map.put("/login","anon");
		LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();
		filters.put("rest",new UserFilter());
		shiroFilter.setFilters(filters);
		shiroFilter.setFilterChainDefinitionMap(map);

		log.info(filters.toString());
		return shiroFilter;
	}
}
