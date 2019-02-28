<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>陕西杰信商务综合管理平台</title>
	<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/login.css" media="all" />
</head>

<body>
<form id="login_main" method="post">
<div id="warpbox">
	<div class="main">
		 <div class="zck">
		  <div class="zc">
				<div class="zc_line">用户名：
				<input type="text" value="" name="userName" id="userName" 
				 onFocus="this.select();"
				 autocomplete="off" title="请您输入用户名"/><div id="ts" style="z-index:1;"></div></div>
			    <div class="zc_line">密　码：
				<input type="password" value="" name="password" id="password"
				 onfocus="$('#ts').css('display','none');this.select();"
				 onKeyDown="javascript:if(event.keyCode==13){ submitFind(); }"
				 title="请您输入密码"/></div>
		  </div>
			<div class="dl">
				<!-- 提交验证数据 -->
				<input  class="loginImgOut" id="login" value="" type="button" 
				  onmouseover="this.className='loginImgOver'" 
				  onmouseout="this.className='loginImgOut'"
				/>
				<input class="resetImgOut" value="" type="button"   
				  onmouseover="this.className='resetImgOver'" 
				  onmouseout="this.className='resetImgOut'"
				/>
			</div>
		</div>
		<div class="bqxx" style="text-align:right;margin-top:0px;">
		<a href="#">系统帮助</a> | <a href="#" onclick="bookmarkit();">加入收藏</a>
	    </div>
	    <div class="mirro"></div>
		<div class="erro" id="erro">
			<div class="erro_intro">
				
			</div>
		</div>
</div>
</form>
<script type="text/JavaScript">
	document.getElementById('login_main').userName.focus();
</script>

</body>
</html>


