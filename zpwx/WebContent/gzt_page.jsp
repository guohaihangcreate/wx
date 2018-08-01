<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>登陆</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<link rel="stylesheet"
	href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
<link rel="stylesheet"
	href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">

</head>
<body>
	<div class="page-group">
		<div class="page page-current">
			<div class="content">
				<div class="list-block">
					<ul>
						<!-- Text inputs -->
						<li>
							<div class="item-content">
								<div class="item-media">
									<i class="icon icon-form-name"></i>
								</div>
								<div class="item-inner">
									<div class="item-input">
										<input type="text" placeholder="选择查询月份" id='datetime-picker'/>
										<input type="hidden"  value="610424198510254338" id="ino"/>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="content-block">
					<div class="row">
						<div class="col-50">
						
							<a href="javascript:getSailaryByMonth('${sessionScope.userinfo.nickname}');" class="button button-big button-fill button-success;class=alert-text;">提交</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<script type='text/javascript'
		src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>

</body>
<script type="text/javascript">
function getSailaryByMonth(openid){
	var year_month = $("input[id='datetime-picker']").attr("value");
	var ino = $("#ino").val();
	if(ino==""){
		alert("实名制登陆以后才能使用本功能");
		return;
	}
	if(year_month==""){
		alert("请输入年份和查询的月份");
		return;
	}
 	window.location.href="${pageContext.request.contextPath}/salaryQuery?openid="+openid+"&year_month="+year_month+"&ino="+ino;
}
</script>
<script type="text/javascript">
	$("#datetime-picker").picker({
		  toolbarTemplate: '<header class="bar bar-nav">\
		  <button class="button button-link pull-left">按钮</button>\
		  <button class="button button-link pull-right close-picker">确定</button>\
		  <h1 class="title">查询月份选择</h1>\
		  </header>',
		  cols: [
			    {
			      textAlign: 'center',
			      values: ['2011年','2012年','2013年','2014年','2015年', '2016年', '2017年', '2018年', '2019年', '2020年', '2021年', '2022年']
			      //如果你希望显示文案和实际值不同，可以在这里加一个displayValues: [.....]
			    },
			    {
			      textAlign: 'center',
			      values: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月','9月','10月','11月','12月']
			    }
			  ]
	});
</script>
</html>