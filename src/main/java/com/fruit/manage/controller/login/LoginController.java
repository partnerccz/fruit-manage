package com.fruit.manage.controller.login;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.fruit.manage.base.BaseController;
import com.fruit.manage.util.Constant;
import com.fruit.manage.util.DataResult;

public class LoginController extends BaseController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	/**
	 * 登录操作
	 */
	public void index(){
		Object uid = getSessionAttr(Constant.SESSION_UID);
		if(uid != null){
			renderJson(new DataResult<>(DataResult.CODE_SUCCESS, "登录成功"));
		}
		String userName = getPara("username");
		String password = getPara("password");
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(userName, password);
		try{
			subject.login(token);
			Session session = subject.getSession();
			session.setAttribute(Constant.SESSION_UID, userName);
			renderNull();
		}catch(Exception e){
			if(StringUtils.isAllBlank(userName, password)){
				renderLogin("身份认证失败");
			}else{
				renderErrorText("用户名或密码错误");
			}
		}
	}
	
	/**
	 * 退出登录操作
	 */
//	public void logout(){
//		Object uid = getSessionAttr(Constant.SESSION_UID);
//		if(null != uid){
//			logger.info("登出系统：uid="+uid.toString());
//		}
//		getSession().invalidate();
//		//TODO:shiro登出
//		SecurityUtils.getSubject().logout();
//		redirect(Constant.MANAGE_URL_HOME);
//	}

}