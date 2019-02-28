$(function(){
	$("#login").on("click",function(){
		CheckajaxSubmit("toLogin.action");
	});
})

function CheckajaxSubmit(url){
	var params = {
		"password":$.base64.btoa($("#password").val()),
		"userName":$.base64.btoa($("#userName").val())
	};
	$.post(url,params,function(result){
		if(result.state==1){
			window.location.href="fmain.action";
		}else{
			$("#erro").html(result.message);
		}
	});
}