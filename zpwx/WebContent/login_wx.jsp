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
<body onload="opener.location.reload(true);">
	<div class="page-group">
		<div class="page page-current">
			<!-- 你的html代码 -->
<!-- 			<header class="bar bar-nav"> -->
<!-- 			<h1 class='title'>登陆</h1> -->
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
									<div class="item-input">
										<input type="text" placeholder="输入已经注册的手机号或者邮箱">
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
									<div class="item-input">
										<input type="password" placeholder="请输入密码">&nbsp;<a href="javascript:register();">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="forgetPassWord.jsp">找回密码</a>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="item-content">
								<div class="item-media">
									<i class="icon icon-form-name"></i>
								</div>
								<div class="item-inner">
									<div class="item-input">
										<input type="text" name="code" placeholder="请输入验证码" /> <img id="imgObj" alt="验证码"
            								src="${pageContext.request.contextPath}/getCode"><a href="#" onclick="changeImg()">&nbsp;换一张</a><br/>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="content-block">
					<div class="row">
						<div class="col-50">
							<a href="#" class="button button-big button-fill button-success">提交</a>
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
$(document).ready(function(){
})
function register() {        
  window.location.href="${pageContext.request.contextPath}/register.jsp?v=<%=Math.random()%>";
}
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
    					alert(1);
    					// 		            	  window.location.href="login.do?method=2"; //如果返回的IsOK的值为true,也就是用户名密码都正确，则执行该跳转
    				} else {
    					alert(2);
    					// 		            	 window.location.href="http://www.baidu.com";
    				}
    			}, "json");
    		})
    	})
    
</script>
</html>