<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=320,maximum-scale=1.3,user-scalable=no">
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
	<!--禁止ios设备将数字作为拨号连接，邮箱自动发送，点击地图跳转-->
	<meta name="format-detection" content="telephone=no,email=no,adress=no">
	<!--强制全屏显示-->
	<meta name="full-screen" content="yes">
	<!--开启对webapp的支持-->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<!--web app应用下状态条(屏幕顶部条)的颜色,默认值为default(白色)-->
	<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
	<!--禁止浏览器从缓存中访问页面内容-->
	<meta http-equiv="Pragma" content="no-cache">
	<meta name="format-detection" content="telephone=no"/>
	<meta name="format-detection" content="email=no"/>
	<title>SAT</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/weui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/jquery-weui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/demos.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/mobile/css/style.css">
</head>
<body>
	<form id="satUserDetailForm" action="<%=request.getContextPath()%>/satuser/update" method="post" enctype="multipart/form-data">
		<input class="weui_input" type="text" name="openid" value="${satUser.openid}" hidden="true">
		<div class="sat_content">
			<div class="head_png weui_cell">
				<div class="weui_cell_hd"><img src="${satUser.imgUrl}" width="42" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p>修改头像</p>
				</div>
				<div class="weui_cell_ft"><img src="<%=request.getContextPath()%>/sat/mobile/img/baisejiantou-icon.png" width="6" alt=""></div>
			</div>
			<div class="sat_data">
				<div class="weui_cell">
					<div class="weui_cell_hd"><label class="weui_label">姓名</label></div>
					<div class="weui_cell_bd weui_cell_primary">
						<input class="weui_input" type="tel" name="username" placeholder="姓名" value="${satUser.username}">
					</div>
				</div>
				<div class="weui_cell ">
					<div class="weui_cell_hd"><label for="name" class="weui_label">性别</label></div>
					<div class="weui_cell_bd weui_cell_primary">
						<c:choose>
							<c:when test="${ satUser.sex == 1 }">
								<input class="weui_input" id="sex" type="text" value="男" readonly="" data-values="1">
								<input class="weui_input" id="sexChoose" name="sex" type="text" value="1" hidden="true" readonly="">
							</c:when>
							<c:otherwise>
								<input class="weui_input" id="sex" name="sex" type="text" value="女" readonly="" data-values="0">
								<input class="weui_input" id="sexChoose" name="sex" type="text" value="0" hidden="true" readonly="">
							</c:otherwise>
						</c:choose>	
					
					</div>
				</div>
				<div class="weui_cell">
					<div class="weui_cell_hd"><label for="time3" class="weui_label">生日</label></div>
					<div class="weui_cell_bd weui_cell_primary">
						<input class="weui_input" id="time3" name="birthday" type="text" readonly="" value="${satUser.birthday}">
					</div>
				</div>
				<div class="weui_cell">
					<div class="weui_cell_hd"><label class="weui_label">手机号</label></div>
					<div class="weui_cell_bd weui_cell_primary">
						<input class="weui_input" type="tel" name="phoneNum"  placeholder="手机号" value="${satUser.phoneNum}">
					</div>
				</div>
	
				<div class="weui_cell ">
					<div class="weui_cell_hd"><label for="name" class="weui_label">行业</label></div>
					<div class="weui_cell_bd weui_cell_primary">
						<input class="weui_input" id="job" name="trade" type="text" value="${satUser.trade}" readonly="" data-values="保险">
					</div>
				</div>
				<div class="weui_cell">
					<div class="weui_cell_hd"><label class="weui_label">公司名称</label></div>
					<div class="weui_cell_bd weui_cell_primary">
						<input class="weui_input" type="tel" name="organization" placeholder="" value="${satUser.organization}">
					</div>
				</div>
				<div class="weui_cell afters">
					<div class="weui_cell_hd"><label class="weui_label">个人签名</label></div>
					<div class="weui_cell_bd weui_cell_primary">
						<input class="weui_input" type="tel" name="signature" placeholder="" value="${satUser.signature}">
					</div>
				</div>
			</div>
			<div class="foot_btn">
				<ul class="sat_footbtn_ul">
					<li class="sat_footer_li"><a class="clicked"><b class="sat_footer_b zixun"></b>修改</a></li>
					<li class="sat_footer_li" id="saveButton"><!-- <a href ="" class=""> --><b class="sat_footer_b chanpin"></b>保存</a></li>
				</ul>
			</div>
		</div>
	</form>
</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/mobile/js/rem.js'></script>
	<script>
	  $(function() {
	    FastClick.attach(document.body);
	    
	    $("#saveButton").click(function () {
	    	$("#satUserDetailForm").submit();
    	}); 
	    
	  });
	 //性别插件
	$("#sex").select({
        title: "选择性别",
        items: ["男", "女"],
        onChange: function(d) {
          console.log(this, d);
          if(d.values == "女") {
	          $("#sexChoose").attr("value", "0");
          } 
          if(d.values == "男") {
	          $("#sexChoose").attr("value", "1");
          } 
        },
        onClose: function() {
          console.log("close");
        },
        onOpen: function() {
          console.log("open");
        },
      });
	//职业插件
      $("#job").select({
        title: "选择职业",
        items: ["金融/投资/证券", "保险", "银行", "互联网/电子商务", "房地产/建筑","微商/自营", "其他"],
        onChange: function(d) {
          console.log(this, d);
        },
        onClose: function() {
          console.log("close");
        },
        onOpen: function() {
          console.log("open");
        },
      });



     //日期插件
      $("#time").datetimePicker({
        title: '出发时间',
        min: "1990-12-12",
        max: "2022-12-12 12:12",
        onChange: function (picker, values, displayValues) {
          console.log(values);
        }
      });
      $("#time2").datetimePicker({
        times: function () {
          return [
            {
              values: (function () {
                var hours = [];
                for (var i=0; i<24; i++) hours.push(i > 9 ? i : '0'+i);
                return hours;
              })()
            },
            {
              divider: true,  // 这是一个分隔符
              content: '时'
            }
          ];
        },
        onChange: function (picker, values, displayValues) {
          console.log(values);
        },
      });
      $("#time3").datetimePicker({
        times: function () {
          return [
            {
              values: ['上午', '下午']
            }
          ];
        },
        value: '2012-12-12 上午',
        onChange: function (picker, values, displayValues) {
          console.log(values);
        }
      });
      $("#time4").datetimePicker({
        times: function () {
          return [
            {
              values: ['上午8点', '下午2点', '晚上8点']
            }
          ];
        },
        max: '2013-12-12',
        onChange: function (picker, values, displayValues) {
          console.log(values);
        }
      });
      $("#time-format").datetimePicker({
        title: '自定义格式',
        yearSplit: '年',
        monthSplit: '月',
        dateSplit: '日',
        times: function () {
          return [  // 自定义的时间
            {
              values: (function () {
                var hours = [];
                for (var i=0; i<24; i++) hours.push(i > 9 ? i : '0'+i);
                return hours;
              })()
            },
            {
              divider: true,  // 这是一个分隔符
              content: '时'
            },
            {
              values: (function () {
                var minutes = [];
                for (var i=0; i<59; i++) minutes.push(i > 9 ? i : '0'+i);
                return minutes;
              })()
            },
            {
              divider: true,  // 这是一个分隔符
              content: '分'
            }
          ];
        },
        onChange: function (picker, values, displayValues) {
          console.log(values);
        }
      });
      $("#time-inline").datetimePicker({
        container: '#time-container',
        onChange: function (picker, values, displayValues) {
          console.log(values);
        }
      })
    
	</script>



</html>