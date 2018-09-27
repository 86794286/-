package kohgylw.people_list_online.service;

import java.util.List;

import kohgylw.people_list_online.modal.Peoples;

/**
 * 
 * <h2>执行关于Peoples的业务逻辑</h2>
 * <p>如标题</p>
 * @author 青阳龙野(kohgylw)
 * @version 1.0
 */
public interface PeopleService {
	
	/**
	 * 
	 * <h2>新增人员信息</h2>
	 * <p>在数据库中添加一个人员记录，并返回添加结果。</p>
	 * @author 青阳龙野(kohgylw)
	 * @param iname 新增人员的姓名
	 * @param isex 性别
	 * @param iage 年龄
	 * @return “SUCCESS”代表成功，“ERROR”代表失败。
	 */
	String doInsertPeople(String iname,String isex,Integer iage);
	
	/**
	 * 
	 * <h2>插叙所有人员信息并以列表形式返回</h2>
	 * <p>从数据库得到全部的人员信息并返回为列表形式，如果没有信息则返回一个空列表。</p>
	 * @author 青阳龙野(kohgylw)
	 * @return List<Peoples> 人员信息列表
	 */
	List<Peoples> getAllPeoples();
	
	/**
	 * 
	 * <h2>执行删除某一条人员记录</h2>
	 * <p>从数据库中删除指定的ID对应的人员记录。</p>
	 * @author 青阳龙野(kohgylw)
	 * @param peoplesId String 要删除的人员记录的ID
	 * @return “SUCCESS”代表删除成功，“ERROR”代表删除失败。
	 */
	String doRemovePeople(String peoplesId);
	
	String getAllPeopleByJson();

}
