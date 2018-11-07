package com.itzixi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itzixi.common.pojo.JqGridResult;
import com.itzixi.common.utils.LeeJSONResult;
import com.itzixi.pojo.Spend;
import com.itzixi.service.SpendService;

@Controller
@RequestMapping("/spend")
public class SpendController extends BaseController {
	// slf4j
	final static Logger log = LoggerFactory.getLogger(DemoItemController.class);

	@Autowired
	private SpendService spendService;

	/**
	 * 打开新增消费的界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showCreateSpendPage")
	public String showCreateSpendPage(HttpServletRequest request) {

		return "spend/createSpend";
	}
	
	/**
	 * 创建一个消费或修改它
	 * @param spend
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public LeeJSONResult saveOrUpdate(Spend spend) {

		// 消费id不为空，则修改消费；消费id为空，则新建一个消费
		String spid = spend.getId();
		if (StringUtils.isEmpty(spid)) {
			// 保存消费的操作
			spendService.saveSpend(spend);
		} else {
			
			spend.setAmount(spend.getAmount() * 10);
			spendService.updateSpend(spend);
		}
		
		return LeeJSONResult.ok();
	}
	
	/**
	 * 打开查询消费信息页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/showQuerySpendPage")
	public String showQueryItemPage(HttpServletRequest request){
		
		return "spend/spendList";
	}
	
	/**
	 * 分页查询消费列表
	 * @param page
	 * @return
	 */
	@RequestMapping("/getSpendInfoList")
	@ResponseBody
	public JqGridResult getItemInfoList(Integer page){
		
		if (page == null) {
			page = 1;
		}
		
		JqGridResult jqgridResult = spendService.querySpendList(page, pageSize);
		
		return jqgridResult;
	}
	
	/**
	 * 展示消费信息详情
	 * @param spendId
	 * @param request
	 * @return
	 */
	@RequestMapping("/showSpendInfoPage")
	public ModelAndView showSpendInfoPage(String spendId, HttpServletRequest request){
		
		Spend spend = spendService.querySpendById(spendId);
		
		ModelAndView mv = new ModelAndView("spend/spendInfo");
		mv.addObject("spend", spend);
		
		return mv;
	}
	
	/**
	 * 展示修改消费信息的界面
	 * @param spendId
	 * @param request
	 * @return
	 */
	@RequestMapping("/showModifySpendPage")
	public ModelAndView showModifySpendPage(String spendId, HttpServletRequest request){
		
		Spend spend = spendService.querySpendById(spendId);
		
		ModelAndView mv = new ModelAndView("spend/modifySpend");
		mv.addObject("spend", spend);
		
		return mv;
	}
	
	/**
	 * 删除消费信息
	 * @param spendId
	 * @return
	 */
	@RequestMapping("/deleteSpend")
	@ResponseBody
	public LeeJSONResult deleteSpend(String spendId){
		
		if (StringUtils.isEmpty(spendId)) {
			return LeeJSONResult.errorMsg("消费id为空或者不存在...");
		}
		
		spendService.deleteSpend(spendId);
		
		return LeeJSONResult.ok();
	}
}
