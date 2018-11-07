<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	    <h4 class="modal-title">消费信息详情</h4>
	</div>
	<div class="modal-body">
	
        <div class="modal-body">
        	<div class="portlet-body">
	            <div class="row">
	                <div class="col-md-12">
	                    <table id="spend" class="table table-bordered table-striped">
	                        <tbody>
	                            <tr>
	                                <td style="width:15%"> 消费编号 </td>
	                                <td style="width:50%">
	                                    ${spend.id }
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 消费备注 </td>
	                                <td>
	                                    ${spend.note}
	                                </td>
	                            </tr>
	                            <tr>
	                                <td> 消费金额 </td>
	                                <td>
	                                    <fmt:formatNumber value="${spend.amount / 10}" type="currency"></fmt:formatNumber>
	                                </td>
	                            </tr>
	                        </tbody>
	                    </table>
	                </div>
	            </div>
	        </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn default" data-dismiss="modal">关  闭</button>
        </div>
        
	</div>

