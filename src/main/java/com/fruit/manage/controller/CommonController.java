package com.fruit.manage.controller;

import java.util.ArrayList;
import java.util.List;

import com.fruit.manage.base.BaseController;
import com.fruit.manage.constant.OrderConstant;
import com.fruit.manage.model.Menu;
import com.fruit.manage.model.Permission;
import com.fruit.manage.util.Constant;
import com.fruit.manage.util.ImgUtil;
import com.jfinal.upload.UploadFile;

public class CommonController extends BaseController {
	
	/**
	 * 上传图片公共方法
	 */
	public void upload(){
		List<UploadFile> fileList = null;
		try{
			fileList = getFiles("file");
		}catch(Exception e) {
			renderNull();
			return;
		}
		if(fileList.size() == 1){
			String picUrl=ImgUtil.upImg(fileList.get(0), getRequest());
			renderText(picUrl);
			return;
		}
		List<String> uploadText = new ArrayList<String>();
		for(UploadFile f:fileList){
			String upImg = ImgUtil.upImg(f, getRequest());
			uploadText.add(upImg);
		}
		renderJson(uploadText);
	}
	
	/**
	 * 获取所有权限列表
	 */
	public void getPermissionList(){
		List<Permission> list = Permission.dao.find("select * from a_permission");
		renderJson(list);
	}
	
	/**
	 * 获取所有菜单列表
	 */
	public void getMenuList(){
		List<Menu> list = Menu.dao.find("select * from a_menu");
		renderJson(list);
	}
	
	/**
	 * 根据uid，获取菜单列表
	 */
	public void getMenuListByUid(){
		renderJson(Menu.dao.getMenuListByUid(getSessionAttr(Constant.SESSION_UID)));
	}
	
	/**
	 * 获取所有订单状态
	 */
	public void getAllOrderStatus(){
		renderJson(OrderConstant.ORDER_STATUS_MAP);
	}
}



