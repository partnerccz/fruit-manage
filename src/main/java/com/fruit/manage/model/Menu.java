package com.fruit.manage.model;

import java.util.List;

import com.fruit.manage.model.base.BaseMenu;
import com.jfinal.plugin.activerecord.Db;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Menu extends BaseMenu<Menu> {
	public static final Menu dao = new Menu().dao();

	/**
	 * 根据角色id查询对应的菜单id列表
	 * @param roleId
	 * @return
	 */
	public List<Integer> getMenuIdsByRoleId(int roleId) {
		return Db.query("SELECT p.id FROM `a_role` r, `a_role_menu` rp, `a_menu` p WHERE r.`id` = rp.`role_id` AND p.`id` = rp.`menu_id` AND r.`id` = ?", roleId);
	}
	
	/**
	 * 获取菜单列表
	 * @param uid
	 * @return
	 */
	public List<Menu> getMenuListByUid(int uid) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT m.* FROM `a_user` u ");
		sql.append("INNER JOIN `a_user_role` ur ON u.`id` = ur.user_id ");
		sql.append("INNER JOIN `a_role` r ON ur.role_id = r.`id` ");
		sql.append("INNER JOIN `a_role_menu` rm ON rm.role_id = r.`id` ");
		sql.append("INNER JOIN `a_menu` m ON rm.menu_id = m.`id` ");
		sql.append("AND u.id = ? ");
		return find(sql.toString(), uid);
	}
}