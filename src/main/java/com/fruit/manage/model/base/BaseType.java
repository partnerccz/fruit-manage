package com.fruit.manage.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseType<M extends BaseType<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return getLong("id");
	}

	public void setGroupId(java.lang.Integer groupId) {
		set("group_id", groupId);
	}

	public java.lang.Integer getGroupId() {
		return getInt("group_id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return getStr("name");
	}

	public void setSort(java.lang.Long sort) {
		set("sort", sort);
	}

	public java.lang.Long getSort() {
		return getLong("sort");
	}

	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}

	public java.lang.Integer getStatus() {
		return getInt("status");
	}
	
	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}

	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

}
