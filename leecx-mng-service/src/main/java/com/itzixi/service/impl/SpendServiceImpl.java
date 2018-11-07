package com.itzixi.service.impl;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.mapper.SpendMapper;
import com.itzixi.pojo.Spend;
import com.itzixi.pojo.SpendExample;
import com.itzixi.service.SpendService;

@Service
public class SpendServiceImpl implements SpendService {

	@Autowired
	private SpendMapper spendMapper;

	@Autowired
	private Sid sid;

	@Override
	public void saveSpend(Spend spend) {

		String spId = sid.nextShort();
		spend.setId(spId);
		spend.setAmount(spend.getAmount() * 10);

		spendMapper.insert(spend);
	}

	@Override
	public JqGridResult querySpendList(Integer page, Integer pageSize) {

		PageHelper.startPage(page, pageSize);

		SpendExample spendExample = new SpendExample();
		//带参查询
//		Criteria demoItemCriteria = demoItemExample.createCriteria();
		List<Spend> result = spendMapper.selectByExample(spendExample);

		PageInfo<Spend> pageList = new PageInfo<Spend>(result);

		JqGridResult grid = new JqGridResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(result);
		grid.setPage(pageList.getPageNum());
		grid.setRecords(pageList.getTotal());

		return grid;
	}

	@Override
	public Spend querySpendById(String spendId) {
		
		Spend spend = spendMapper.selectByPrimaryKey(spendId);
		
		return spend;
	}

	@Override
	public void updateSpend(Spend spend) {
		spendMapper.updateByPrimaryKeySelective(spend);
		
	}

	@Override
	public void deleteSpend(String spendId) {
		spendMapper.deleteByPrimaryKey(spendId);
		
	}
}
