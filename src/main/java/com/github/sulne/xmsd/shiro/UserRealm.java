package com.github.sulne.xmsd.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {

	/**
	 * 授权
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		System.out.println("进入自定义realm类的授权>>doGetAuthorizationInfo方法");
		SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
		/**
		 * 从数据库提取角色,权限数据
		 * 然后交给shiro验证
		 * */
		Set<String> roles = new HashSet<>();
		authorizationInfo.setRoles(roles);
		Set<String> perms = new HashSet<>();
		perms.add("add");
		authorizationInfo.setStringPermissions(perms);
		System.out.println("=============================================================================================");
		return authorizationInfo;
	}

	/**
	 * 登录验证
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("进入自定义realm类的登录验证>>doGetAuthenticationInfo方法");
		String username = (String)token.getPrincipal();
		System.out.println("用户输入的用户名是>>"+username);
		/**
		 * 这里进行从数据库提取数据做数据来源,例如:
		 * User user = userService.getUserByUserName(userName);
		 * 然后验证查找的user是否为空,为空就抛出异常,例如
		 * if(null = user) {
		 * 	throw new UnknownAccountException();
		 * }
		 * 
		 * 数据这里我先写死
		 * */
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("admin","123",getName());
		//加密的
		//AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,"9c456b271a7b81e313ee4bf461d803cd",ByteSource.Util.bytes(username+"f1d63637e5f22e3f375114453759c8b8"),getName());
		System.out.println("=============================================================================================");
		return authenticationInfo;
	}
}