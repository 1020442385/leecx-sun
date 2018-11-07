package com.itzixi.service;

import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.pojo.Spend;

public interface SpendService {
	
	/**
	 * 保存消费信息
	 * @param spend
	 */
	public void saveSpend(Spend spend);
	
	/**
	 * 分页查询消费信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public JqGridResult querySpendList(Integer page, Integer pageSize);
	
	/**
	 * 根据ID查询消费信息
	 * @param spendId
	 * @return
	 */
	public Spend querySpendById(String spendId);
	
	/**
	 * 修改消费信息
	 * @param spend
	 */
	public void updateSpend(Spend spend);
	
	/**
	 * 删除消费信息
	 * @param spendId
	 */
	public void deleteSpend(String spendId);

}
