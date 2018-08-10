<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0" />
        
        <!-- Jquery  -->
        <script src="/WeChatDemo/jquery-weui/dist/lib/jquery-2.1.4.js"></script>
        <!--weui css-->
        <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.0/style/weui.min.css" />
        <!--jQuery weui-->
        <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/0.8.0/css/jquery-weui.min.css">
        <!--切换样式-->
        <style type="text/css">
            .weui_navbar_item.weui_bar_item_on {
                color: #2196F3;
                cursor: pointer;
            }
        </style>
        <title>售后测试	</title>
    </head>
<body ontouchstart style="height: 32rem;">
<header class="ui-header">
			<h1>**电气售后服务公众号</h1></header>
<div class="weui-cells weui-cells_form">
<!-- 车型 -->
  <div class="weui-cell">
    <div class="weui-cell__hd"><label class="weui-label ">车型</label></div>
    <div class="weui-cell__bd">
    <!-- 这个地方的pattern 需要进行修改 -->
    <!-- 此处输入车型信息 添加 车型class  -->
      <input class="weui-input chexing" type="text"   placeholder="点击选择车型">
    </div>
  </div>
<!-- 车型 -->
<!-- 车号 -->
  <div class="weui-cell weui-cell_vcode">
    <div class="weui-cell__hd">
      <label class="weui-label">车号</label>
    </div>
    <div class="weui-cell__bd">
    <!-- 此处添加车号信息  添加车号 class -->
      <input class="weui-input chehao" type="text" placeholder="请手动输入机车号">
    </div>
  </div>
<!-- 车号 -->
<!-- 日期 -->
  <div class="weui-cell">
    <div class="weui-cell__hd"><label for="" class="weui-label">日期</label></div>
    <div class="weui-cell__bd">
    <!-- 此处添加 日期信息 添加日期 class -->
      <!-- <input class="weui-input faultdate" type="date" value=""/> -->
      <input class="weui-input faultdate" type="text" data-toggle='date'/>
    </div>
  </div>
<!-- 日期 -->
<!-- 故障发生地点 -->
<!-- 暂时有些问题 先去掉 -->
 <!--  <div class="weui-cell">
    <div class="weui-cell__hd"><label for="" class="weui-label">地点</label></div>
    <div class="weui-cell__bd">
      <input class="weui-input faultarea" type="text"  data-toggle="city-picker" value="浙江 杭州 拱墅区" />
    </div>
  </div> -->
 
<!-- 故障发生地点 -->
<!-- 时间 -->
<!-- 这个部分暂时省略,等待后期需求需要在改回去 -->
  <!-- <div class="weui-cell">
    <div class="weui-cell__hd"><label for="" class="weui-label">时间</label></div>
    <div class="weui-cell__bd">
    此处添加 时间信息 添加时间 class
      <input class="weui-input faulttime" type="datetime-local" value="" placeholder="">
    </div>
  </div> -->
<!-- 时间 -->
<!-- 机车故障信息 -->
<div class="weui-cells__title">机车故障填报区</div>
<div class="weui-cells weui-cells_form">
  <div class="weui-cell">
    <div class="weui-cell__bd">
    <!-- 故障信息 添加故障class faultinfo -->
      <textarea class="weui-textarea faultinfo" placeholder="请在此处填写机车故障信息!" rows="3"></textarea>
      <div class="weui-textarea-counter"><span>0</span>/200</div>
    </div>
  </div>
</div>
<!-- 机车故障信息 -->
</div>
 
<!-- 提交成功提示界面 -->
<a  class="weui-btn weui-btn_primary">提交</a>
<a  class="weui-btn weui-btn_warn">取消</a>
<!-- 提交成功提示界面 -->
<!-- 底部foot -->
<div class="weui-footer weui-footer_fixed-bottom">
  <p class="weui-footer__links">
    <a href="javascript:void(0);" class="weui-footer__link ">**电气售后</a>
  </p>
  <p class="weui-footer__text ">Copyright © 2010-2018 **dq.com</p>
</div>
<!-- 底部foot -->
<script type="text/javascript">
$(document).ready(function(){
	$("a.weui-btn.weui-btn_primary").click(function(){
	 alert("已经获取点击事件"); 
	 		
	 	var chexing = $(".weui-input.chexing").val();
	 	var chehao = $(".weui-input.chehao").val();
	 	var faultdate = $(".weui-input.faultdate").val();
	 	var faulttime = $(".weui-input.faulttime").val();
	 	var faultinfo = $(".weui-textarea.faultinfo").val();
	 	alert("车型是:" + chexing + "车号是:" + chehao + "故障填报时间是:" + faultdate
	 			+"故障时间是:" + faulttime + "故障信息是:" + faultinfo); 
	 	
	/*  	 $.ajax({
	        //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
	        type : "post",      
	        //servlet文件名为Calculator，需要提前在web.xml里面注册
	        url : "FaultServlet", 
	       dataType :  "json",  //数据类型，可以为json，xml等等，
	        data :
	        {
	             "chexing" : chexing,//车型
	             "chehao":chehao,//车号
	             "faultdate":faultdate,//故障时间
	             "faultinfo":faultinfo //故障信息
	        },
	        success : function(response)
	        {
	               //处理后端传递过来的 JSON 数据.
	               var success = response.success;
	               alert("后端处理完毕");
	               if(success == "SUCCESS"){
	            	   //使用jquery 代码进行跳转.
	               $(location).attr('href', 'http://inut5w.natappfree.cc//WeChatDemo/submitsuccess.html');
	               }
	        },
	        error : function(xhr, status, errMsg,response)
	        {	
	        	//服务器错误处理
	        	var v1 = xhr;
	        	var v2 = status;
	        	var v3 = errMsg;
	            alert("数据传输失败!");
	        }
	    });  */
	 	
//	 	 $(location).attr('href', 'http://inut5w.natappfree.cc//WeChatDemo/submitsuccess.html');
	 	 $(location).attr('href', 'http://localhost:20000//WeChatDemo/submitsuccess.html');
	  });
	  <!--这个是机车车型的Picker-->
	  $(".weui-input.chexing").picker({
		 // input: '.weui-input.chexing',//这两个属性加上之后没有效果.有待测试.
		 // container: '#container',
		  title: "选择您的故障车型",
		  cols: [
		    {
		      textAlign: 'center',
		      values: ['HXD1', 'HXD3', 'HXN5', 'HXN5B', 'HXN3', 'HXN3B', 'HXD3D']
		    }
		  ]
		});
	  <!--这个是机车车型的Picker-->
	  <!--这个是机车型号的Picker-->
	 /*  $(".weui-input.chehao").picker({
		 // input: '.weui-input.chexing',//这两个属性加上之后没有效果.有待测试.
		 // container: '#container',
		  title: "选择您的故障车号",
		  cols: [
		    {
		      textAlign: 'center',
		      values: ['0001', '0002', '0003', '0004', '0005', '0006', '0007']
		    }
		  ]
		}); */
		//车号的picker 暂时禁用 由于车号估计数量比较多 
		//所以 为了便于用户的使用 决定使用 手动输入的方式.
	  <!--这个是机车型号的Picker-->
	  <!--这个是日期的Picker-->
	/*   $(".weui-input.faultdate").calendar(); */ //这个只是日期的简单的日期 不包括时间的格式.
	//下面的这个是包括的日期还有时间
	  $(".weui-input.faultdate").calendar();
	  <!--这个是日期的Picker-->
	  <!--故障填报区这写字体增加样式-->
	  $(".weui-cells__title").css({"color":"red","font-size":"12px"});
	  /* #18b4ed  蓝色的背景    不正常的绿色  #33cc00 */
	  $(".ui-header").css({"color":"#fff","font-size":"15px","background-color":"#1AAD19","text-align": "center"});
	  /*  $(".ui-header h1").css({"color":"#fff","font-size":"20px",}); */
	  
	  <!--故障填报区这写字体增加样式-->
	  <!--故障地点-->
	  //$(".weui-input.faultarea").cityPicker();//目前有问题 暂时先去掉
	  <!--故障地点-->
	  
	});
</script>
 
 
        <!--页面切换-->
        <script src="https://res.wx.qq.com/open/libs/zepto/1.1.6/zepto.js"></script>
        <script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/jquery-weui/0.8.2/js/jquery-weui.min.js"></script>
    </body>
</html>
