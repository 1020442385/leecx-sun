<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="<%=request.getContextPath() %>/static/pages/js/spend.js?v=3.1415926" type="text/javascript"></script>

<form id="spendForm" action="" class="form-horizontal" method="post">
	<input id="spendId" name="id" type="hidden" value="${spend.id }" />

	<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	    <h4 class="modal-title">修改消费信息</h4>
	</div>
	<div class="modal-body">
	    <div class="row">
	        <div class="col-md-12">
							
                    <div class="form-body">
                    	<div class="form-group">
                        	<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>消费备注</label>
                            <div class="col-md-4">
                            	<div id="input-error">
                            		<input id="note" name="note" type="text" class="form-control" value="${spend.note}" />
                            	</div>
							</div>
						</div>
                        
                        <div class="form-group">
							<label class="col-md-3 control-label"><span class="required" aria-required="true"> * </span>消费金额</label>
							<div class="col-md-4">
                                   <div id="input-error">
                                       <input id="amount" name="amount" type="text" class="form-control" value="${spend.amount / 10}">
                                   </div>
							</div>
						</div>
						
						
					</div>
                                                       
				
	        </div>
	    </div>
	</div>
	<div class="modal-footer">
	    <button type="button" class="btn default" data-dismiss="modal">关  闭</button>
	    <button type="submit" class="btn blue">保  存</button>
	</div>

</form>