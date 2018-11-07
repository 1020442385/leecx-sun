var reloadSpendGrid = function() {
	var jqGrid = $("#jqGridSpendList");  
	var hdnContextPath = $("#hdnContextPath").val();
	jqGrid.jqGrid('setGridParam',{datatype:'json'}).setGridParam({ 
		page: 1,
        url: hdnContextPath + "/spend/getSpendInfoList.action",
    }).trigger("reloadGrid");
}

// 商品对象信息
var SpendInfo = function() {

	// 商品对象的操作函数
	var handleSpendInfo = function() {

		$('#spendForm')
				.validate(
						{
							errorElement : 'span', // default input error message container
							errorClass : 'help-block', // default input error message class
							focusInvalid : false, // do not focus the last invalid input
							ignore : "", // validate all fields including form hidden input
							//validate验证规则
							rules : {
								note : {
									required : true
								},
								amount : {
									required : true,
									digits : true
								}
							},

							messages : {
								note : {
									required : "消费备注不能为空."
								},
								amount : {
									required : "消费金额不能为空.",
									digits : "请输入一个数字作为价格."
								}
							},

							invalidHandler : function(event, validator) { // display error alert on form submit
								$('.alert-danger', $('#spendForm')).show();
							},

							highlight : function(element) { // hightlight error inputs 高亮显示
								$(element).closest('.form-group').addClass('has-error'); // set error class to the control group
							},
							//成功把错误的东西拿掉
							success : function(label) {
								label.closest('.form-group').removeClass('has-error');
								label.remove();
							},

							errorPlacement : function(error, element) {
								error.insertAfter(element.closest('#input-error'));
							},
							
							//所有验证通过后所触发的事件
							submitHandler : function(form) {

								App.blockUI();

								var spendForm = $('#spendForm'); //获取jsp中的form表单
								var hdnContextPath = $("#hdnContextPath").val();//获取根目录
								spendForm.ajaxSubmit({
									dataType : "json",
									type : "post", // 提交方式 get/post
									url : hdnContextPath+ '/spend/saveOrUpdate.action', // 需要提交的 url
									data : spendForm.serialize(), //Form表单元素序列化为json
									success : function(data) {
										debugger;
										// 登录成功或者失败的提示信息
										if (data.status == 200 && data.msg == "OK") {
											SweetAlert.success("保存成功！");
											App.unblockUI();

											// 修改操作需要刷新grid以及关闭窗口
											var spendId = $("#spendId").val();
											if (spendId != "" && spendId != null && spendId != undefined) {
												reloadSpendGrid();
												$("#ajax-modifySpend-modal").modal('hide');
											}
										} else {
											SweetAlert.error(data.msg);
											App.unblockUI();
										}
									},
									error : function(response, ajaxOptions,thrownError) {
										Error.displayError(response,ajaxOptions, thrownError);
										App.unblockUI();
									}
								});

							}
						});

		$('#spendForm input').keypress(function(e) {
			if (e.which == 13) {
				if ($('#spendForm').validate().form()) {
					$('#spendForm').submit(); // form validation success, call ajax form submit
				}
				return false;
			}
		});

	}

	return {
		// 初始化各个函数及对象
		init : function() {
			handleSpendInfo();
		}

	};

}();

jQuery(document).ready(function() {
	SpendInfo.init();
});