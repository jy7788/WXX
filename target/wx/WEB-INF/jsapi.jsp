<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,07.initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js">
	
</script>

<script
	src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
</head>
<body>
	<!--标题行-->
	<h2
		style="color: white; background-color: green; text-align: center; background-position: center;">蓝牙设备</h2>
	<div class="page">
		<div class="bd spacing">
			<div class="weui_cells weui_cells_form">

				<div class="weui_cell">
					<div class="weui_cell_hd">
						<label class="weui_label" style="width: auto;">当前设备: </label>
					</div>
					<div class="weui_cell_bd weui_cell_primary">
						<label id="lbdeviceid" class="weui_label" style="width: auto;"></label>
					</div>
				</div>
				<div class="weui_cell">
					<div class="weui_cell_hd">
						<label class="weui_label" style="width: auto;">状态信息: </label>
					</div>
					<div class="weui_cell_bd weui_cell_primary">
						<label id="lbInfo" class="weui_label" style="width: auto;"></label>
					</div>
				</div>
				<div class="weui_cell">
					<div class="weui_cell_hd">
						<label class="weui_label">日志: </label>
					</div>
					<div class="weui_cell_bd weui_cell_primary">
						<textarea id="logtext" class="weui_textarea" placeholder="日志"
							rows="5"></textarea>
					</div>
				</div>

			</div>

			<div class="weui_btn_area weui">

				<button class="weui_btn weui_btn weui_btn_warn"
					id="CallGetWXrefresh">获取设备</button>
				<br>

			</div>

		</div>

		<div class="weui_dialog_alert" id="Mydialog" style="display: none;">
			<div class="weui_mask"></div>
			<div class="weui_dialog">
				<div class="weui_dialog_hd" id="dialogTitle">
					<strong class="weui_dialog_title">着急啦</strong>
				</div>
				<div class="weui_dialog_bd" id="dialogContent">亲,使用本功能,请先打开手机蓝牙！</div>
				<div class="weui_dialog_ft">
					<a href="#" class="weui_btn_dialog primary">确定</a>
				</div>
			</div>
		</div>


		<!--BEGIN toast-->
		<div id="toast" style="display: none;">
			<div class="weui_mask_transparent"></div>
			<div class="weui_toast">
				<i class="weui_icon_toast"></i>
				<p class="weui_toast_content" id="toast_msg">已完成</p>
			</div>
		</div>
		<!--end toast-->

		<!-- loading toast -->
		<div id="loadingToast" class="weui_loading_toast"
			style="display: none;">
			<div class="weui_mask_transparent"></div>
			<div class="weui_toast">
				<div class="weui_loading">
					<div class="weui_loading_leaf weui_loading_leaf_0"></div>
					<div class="weui_loading_leaf weui_loading_leaf_1"></div>
					<div class="weui_loading_leaf weui_loading_leaf_2"></div>
					<div class="weui_loading_leaf weui_loading_leaf_3"></div>
					<div class="weui_loading_leaf weui_loading_leaf_4"></div>
					<div class="weui_loading_leaf weui_loading_leaf_5"></div>
					<div class="weui_loading_leaf weui_loading_leaf_6"></div>
					<div class="weui_loading_leaf weui_loading_leaf_7"></div>
					<div class="weui_loading_leaf weui_loading_leaf_8"></div>
					<div class="weui_loading_leaf weui_loading_leaf_9"></div>
					<div class="weui_loading_leaf weui_loading_leaf_10"></div>
					<div class="weui_loading_leaf weui_loading_leaf_11"></div>
				</div>
				<p class="weui_toast_content" id="loading_toast_msg">数据加载中</p>
			</div>
		</div>
		<!-- End loading toast -->

		<!--BEGIN dialog1-->
		<div class="weui_dialog_confirm" id="dialog1" style="display: none;">
			<div class="weui_mask"></div>
			<div class="weui_dialog">
				<div class="weui_dialog_hd">
					<strong class="weui_dialog_title">弹窗标题</strong>
				</div>
				<div class="weui_dialog_bd">自定义弹窗内容，居左对齐显示，告知需要确认的信息等</div>
				<div class="weui_dialog_ft">
					<a href="javascript:;" class="weui_btn_dialog default" id="qxBtn">取消</a>
					<a href="javascript:;" class="weui_btn_dialog primary" id="okBtn">确定</a>
				</div>
			</div>
		</div>
		<!--END dialog1-->
		<!--BEGIN dialog2-->
		<div class="weui_dialog_alert" id="dialog2" style="display: none;">
			<div class="weui_mask"></div>
			<div class="weui_dialog">
				<div class="weui_dialog_hd">
					<strong class="weui_dialog_title">弹窗标题</strong>
				</div>
				<div class="weui_dialog_bd">弹窗内容，告知当前页面信息等</div>
				<div class="weui_dialog_ft">
					<a href="javascript:;" class="weui_btn_dialog primary">确定</a>
				</div>
			</div>
		</div>
		<!--END dialog2-->
	</div>

	<div id="myparams" style="display: none">
		<span id="timestamp">${timestamp }</span> <span id="nonceStr">${nonceStr }</span>
		<span id="signature">${signature }</span> <span id="appId">${appId }</span>

	</div>
</body>
</html>
