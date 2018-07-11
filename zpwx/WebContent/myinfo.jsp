<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>个人中心</title>
</head>
<body>
<!-- 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 -->
	<div>登陆成功！</div>
	<div>用户昵称：${userinfo.nickname}</div><br>
	<div>用户昵称：
		<img style="vertical-align:top;" width="100" alt="" src="${userinfo.headimgurl}">
	</div>
	<div>省份：${userinfo.province}</div><br>
	<div>城市：${userinfo.province}</div><br>
	<div>
		<c:if test="${userinfo.sex eq 1}">男</c:if>
		<c:if test="${userinfo.sex eq 2}">女</c:if>
		<c:if test="${userinfo.sex eq 0}">未知</c:if>
	</div>
</body>
</html>