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
	<div class="content">
		<div class="content-block-title">${sessionScope.userinfo.realname}&nbsp;${year_month}薪资信息</div>
		  <div class="list-block">
		    <ul>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">身份证号</div>
		          <div class="item-after">371522199408206522</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">转正以后工资</div>
		          <div class="item-after">10000.00</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">发全薪日期</div>
		          <div class="item-after">全薪</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">当月应发 工资金额</div>
		          <div class="item-after">10000.00</div>
		        </div>
		      </li>
		       <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">各项目计薪天数</div>
		          <div class="item-after">21.00</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">计薪天数</div>
		          <div class="item-after">11.00</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">加班费、补贴、扣款</div>
		          <div class="item-after">952.38</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">补贴说明</div>
		          <div class="item-after">2000/21*10=952.38元</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">报销费用</div>
		          <div class="item-after">null</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">代扣社保</div>
		          <div class="item-after">348.20</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">代扣公积金</div>
		          <div class="item-after">258.00</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">考勤应发工资（考勤工资+调整补贴）</div>
		          <div class="item-after">6190.48</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">个人所得税</div>
		          <div class="item-after">103.43</div>
		        </div>
		      </li>
		      <li class="item-content">
		        <div class="item-media"><i class="icon icon-f7"></i></div>
		        <div class="item-inner">
		          <div class="item-title">实发工资</div>
		          <div class="item-after">5480.85</div>
		        </div>
		      </li>
		    </ul>
		  </div>
	</div>

	<script type='text/javascript'
		src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
</body>
</html>