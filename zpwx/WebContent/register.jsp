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
<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="shortcut icon" href="/favicon.ico">
<link rel="stylesheet"
	href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
<link rel="stylesheet"
	href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
<link rel="stylesheet" href="js/jquery-3.3.1.min.js">
</head>
<body>
	<div class="page-group">
		<div class="page page-current">
			<!-- 			<header class="bar bar-nav"> -->
			<!-- 			<h1 class='title'>Ã¦Â³Â¨Ã¥ÂÂ</h1> -->
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
									<div class="item-title label">注册</div>
									<div class="item-input">
										<input type="hidden" name="openid" id="openid"
											value="${sessionScope.userinfo.openid}"> <input
											type="text" placeholder="真实姓名" name="realname" id="realname">
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
									<div class="item-title label">邮件</div>
									<div class="item-input">
										<input type="email" placeholder="邮件" id="email">
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
										<input type="password" placeholder="密码" id="password">
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
											<option selected="selected" value="1">男</option>
											<option value="2">女</option>
											<option value="0">未知</option>
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
										<input type="date" placeholder="生日" value="1980-04-30"
											name="birthday" id="birthday">
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
									<div class="item-title label">入职日期</div>
									<div class="item-input">
										<input type="date" placeholder="入职日期" value="2014-04-30"
											name="enterDay" id="enterDay">
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
									<div class="item-title label">手机号码</div>
									<div class="item-input">
										<input type="text" placeholder="手机号码" name="mobile"
											id="mobile">
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
										<input type="text" placeholder="身份证号" name="ino"
											id="ino">
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="content-block">
					<div class="row">
						<div class="col-50">
							<a href="${pageContext.request.contextPath}/login_wx.jsp?v=<%=Math.random()%>" class="button button-big button-fill button-danger">取消</a>
						</div>
						<div class="col-50">
							<a id="btn" class="button button-big button-fill button-success">注册</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
<script type='text/javascript'
	src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript'
	src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript'
	src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<script type="text/javascript">

$(document).ready(function(){
	$("#btn").click(function(){
	   var openid = $("#openid").val();
	   var realname = $("#realname").val()
	    if(realname==''){
    		alert("请输入真实姓名");
    		return;
    	}
    	var email = $("#email").val();
      	var password = $("#password").val();
      	if(password==''){
      		alert("请输入密码");
      		return;
      	}
     	var  myselect=document.getElementById("sex_user");
     	var index = myselect.selectedIndex;//获取选中的index
     	var sex = myselect.options[index].value;//获取value值
    	var birthday = $("#birthday").val();
        var enterDay = $("#enterDay").val();
    	var mobile = $("#mobile").val();
    	if(mobile==''){
    		alert("请输入注册微信所使用的手机号");
    		return;
    	}
		var ino = $("#ino").val();
    	if(ino==''){
    		alert("内部员工请输入身份证号实名制注册");
    		return;
    	}
	   $.post("wxAuthLogIn?type=register&v=<%=Math.random()%>", //利用ajax发起请求，这里写servlet的路径
			{
				"openid" : openid,
				"realname" : realname,
				"email" : email,
				"password" : password,
				"sex" : sex,
				"birthday" : birthday,
				"enterDay" : enterDay,
				"mobile" : mobile,
				"ino" : ino
			}, //传参
			function(data) { //请求成功时的回调函数
				if (data.IsOK == true) {
					alert("注册失败");
					window.location.href="${pageContext.request.contextPath}/register.jsp?v=<%=Math.random()%>";
					 //如果返回的IsOK的值为true,也就是用户名密码都正确，则执行该跳转
				} else {
					alert("注册成功");
					window.location.href="${pageContext.request.contextPath}/callback?optiontype=registered&v=<%=Math.random()%>&openid="+data.openid;
				}
			}, "json");
		})
	})
	
</script>
</html>