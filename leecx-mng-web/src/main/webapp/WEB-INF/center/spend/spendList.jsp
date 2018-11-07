<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="<%=request.getContextPath() %>/static/pages/js/spendList.js?v=1.10.3" type="text/javascript"></script>

	<!-- BEGIN PAGE HEADER-->
	<!-- BEGIN PAGE BAR -->
	<div class="page-bar">
	    <ul class="page-breadcrumb">
	        <li>
	            <span>首页</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>消费信息</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>消费列表</span>
	        </li>
	    </ul>
	</div>
	<!-- END PAGE BAR -->
	<!-- END PAGE HEADER-->
        
    <!-- 用户信息列表 jqgrid start -->                
	<div class="row">
    	<div class="col-md-12">
			<br/>
			
			<div class="jqGridSpendList_wrapper">  
			    <table id="jqGridSpendList"></table>  
			    <div id="jqGridSpendPager"></div>  
			</div>  
			
		</div>
	</div>
	<!-- 用户信息列表 jqgrid end -->

	<!-- ajax 动态 读取model -->	
	<!-- 查看消费信息详情的model -->
	<div id="ajax-detailSpendInfo-modal" class="modal container fade" tabindex="-1"></div>
	<!-- 展现修改消费信息的model -->
	<div id="ajax-modifySpend-modal" class="modal container fade" tabindex="-1"></div>
