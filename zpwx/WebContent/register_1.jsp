<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>注册</title>
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
			<!-- 你的html代码 -->
<!-- 			<header class="bar bar-nav"> -->
<!-- 			<h1 class='title'>注册</h1> -->
<!-- 			</header> -->
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
									<div class="item-title label">真实姓名</div>
									<div class="item-input">
										<input type="hidden"  name="openid" id="openid" value="${sessionScope.userinfo.openid}">
										<input type="text" placeholder="真实姓名" name="realname" id="realname">
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-media">
									<i class="icon icon-form-email"></i>
								</div>
								<div class="item-inner">
									<div class="item-title label">邮箱</div>
									<div class="item-input">
										<input type="email" placeholder="邮箱" id="email">
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-media">
									<i class="icon icon-form-password"></i>
								</div>
								<div class="item-inner">
									<div class="item-title label">密码</div>
									<div class="item-input">
										<input type="password" placeholder="密码" name="password" id="password">
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-media">
									<i class="icon icon-form-gender"></i>
								</div>
								<div class="item-inner">
									<div class="item-title label">性别</div>
									<div class="item-input">
										<select id="sex_user" name="sex">
											<option <c:if test="${sessionScope.userinfo.sex eq 1 or sessionScope.userinfo.sex eq null}">selected="selected"</c:if> value="1">男</option>
											<option <c:if test="${sessionScope.userinfo.sex eq 2}">selected="selected"</c:if> value="2">女</option>
											<option <c:if test="${sessionScope.userinfo.sex eq 0}">selected="selected"</c:if> value="0">未知</option>
										</select>
									</div>
								</div>
							</div>
						</li>
						<!-- Date -->
						<li>
							<div class="item-content">
								<div class="item-media">
									<i class="icon icon-form-calendar"></i>
								</div>
								<div class="item-inner">
									<div class="item-title label">生日</div>
									<div class="item-input">
										<input type="date" placeholder="生日" value="1980-04-30" name="birthday" id="birthday">
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-media">
									<i class="icon icon-form-calendar"></i>
								</div>
								<div class="item-inner">
									<div class="item-title label">入职时间</div>
									<div class="item-input">
										<input type="date" placeholder="入职时间" value="2014-04-30" name="enterDay" id="enterDay">
									</div>
								</div>
							</div>
						</li>
						<li class="align-top">
							<div class="item-content">
								<div class="item-media">
									<i class="icon icon-form-comment"></i>
								</div>
								<div class="item-inner">
									<div class="item-title label">手机号</div>
									<div class="item-input">
										<input type="text" placeholder="手机号" name="mobile" id="mobile">
									</div>
								</div>
							</div>
						</li>
						<li class="align-top">
							<div class="item-content">
								<div class="item-media">
									<i class="icon icon-form-comment"></i>
								</div>
								<div class="item-inner">
									<div class="item-title label">身份证号</div>
									<div class="item-input">
										<input type="text" placeholder="身份证号码" id="ino" name="ino">
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="content-block">
					<div class="row">
						<div class="col-50">
							<a href="login_wx.jsp" class="button button-big button-fill button-danger">取消</a>
						</div>
						<div class="col-50">
							<a href="javascript:registerWxopenid();" class="button button-big button-fill button-success">提交</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
<script type="text/javascript">
function registerWxopenid(){
	var queryparam = "";
 	var openid= $("input[id='openid']").attr("value");
 	if(openid!=""){
 		queryparam=queryparam+"&&openid="+openid;
	}
	var realname = $("input[id='realname']").attr("value");
	if(realname==""){
		alert("请填写真实姓名");
		return;
	}else{
		queryparam=queryparam+"&&realname="+realname;
	}
	var email = $("input[id='email']").attr("value");
	if(email!=""){
 		queryparam=queryparam+"&&email="+email;
	}
	var password = $("input[id='password']").attr("value");
	if(password==""){
		alert("请填写密码");
		return;
	}
	else{
 		queryparam=queryparam+"&&password="+password;
	}
 	var  myselect=document.getElementById("sex_user");
 	var index = myselect.selectedIndex;//获取选中的index
 	var sex = myselect.options[index].value;//获取value值
 	if(sex!=""){
 		queryparam=queryparam+"&&sex="+sex;
	}
	var birthday = $("input[id='birthday']").attr("value");
	if(birthday!=""){
 		queryparam=queryparam+"&&birthday="+birthday;
	}
	var enterDay = $("input[id='enterDay']").attr("value");
	if(enterDay!=""){
 		queryparam=queryparam+"&&enterDay="+enterDay;
	}
	var mobile = $("input[id='mobile']").attr("value");
	if(mobile==""){
		alert("请输入注册微信所使用的手机号");
		return;
	}else{
		queryparam=queryparam+"&&mobile="+mobile;
	}
	var ino = $("input[id='ino']").attr("value");
	if(ino==""){
		alert("内部员工请输入身份证号实名制注册");
		return;
	}
	else{
		queryparam=queryparam+"&&idno="+ino;
	}
  window.location.href="${pageContext.request.contextPath}/wxAuthLogIn?type=register&&"+queryparam;
}
</script>
<script type='text/javascript'
		src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
</body>
</html>