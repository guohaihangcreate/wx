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
	<header class="bar bar-nav">
<!-- 	<h1 class='title'>栅格</h1> -->
	</header>
	<div class="content" style="background:url('../img/timg.jpg');">
		<div class="content-padded grid-demo">
			 <div class="row no-gutter">
				<div class="col-33" style="height: 6rem;text-align: center;vertical-align: middle;"><a href="www.baidu.com">工资条查询</a>
				</div>
				<div class="col-33" style="height: 6rem;text-align: center;vertical-align: middle;"><a href="www.baidu.com">考勤查询</a></div>
				<div class="col-33" style="height: 6rem;text-align: center;vertical-align: middle;"><a href="www.baidu.com">项目通知</a></div>
			</div>
			<div class="row no-gutter">
				<div class="col-33" style="height: 6rem;text-align: center;vertical-align: middle;"><a href="www.baidu.com">放假通知</a></div>
				<div class="col-33" style="height: 6rem;text-align: center;vertical-align: middle;" >
					<a href="www.baidu.com">集团动态</a></div>
				<div class="col-33" style="height: 6rem;text-align: center;vertical-align: middle;" >
					<a href="www.baidu.com">......</a></div>
			</div>
			 <div class="row no-gutter">
				<div class="col-33" style="height: 6rem;text-align: center;vertical-align: middle;" >
					<a href="www.baidu.com">工作机会</a></div>
				<div class="col-33" style="height: 6rem;text-align: center;vertical-align: middle;" >
					<a href="www.baidu.com">推荐有礼</a></div>
				<div class="col-33" style="height: 6rem;text-align: center;vertical-align: middle;" >
					<a href="www.baidu.com">......</a></div>
			</div>
		</div>
	</div>
	<nav class="bar bar-tab"> <a class="tab-item external active"
		href="#"> <span class="icon icon-home"></span> <span
		class="tab-label">常用</span>
	</a> <a class="tab-item external" href="#"> <span class="icon icon-me"></span>
		<span class="tab-label">项目情况</span> <span class="badge">2</span>
	</a> <a class="tab-item external" href="#"> <span
		class="icon icon-star"></span> <span class="tab-label">蜗牛在行动</span>
	</a> <a class="tab-item external" href="#"> <span
		class="icon icon-cart"></span> <span class="tab-label">蜗牛历史</span>
	</a> <a class="tab-item external" href="#"> <span
		class="icon icon-settings"></span> <span class="tab-label">我</span>
	</a> </nav>

	<script type='text/javascript'
		src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>

</body>
<script type="text/javascript">
	$(function() {

	});

	function changeImg() {
		var imgSrc = $("#imgObj");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}

	// 时间戳
	// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		url = url.substring(0, 20);
		if ((url.indexOf("&") >= 0)) {
			url = url + "×tamp=" + timestamp;
		} else {
			url = url + "?timestamp=" + timestamp;
		}
		return url;
	}
</script>
</html>