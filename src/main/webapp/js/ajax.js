$(function() { 
    $('#submit').bind('click', function() { 

        var formData = $('#registForm').serialize(); 
        //.serialize() 方法创建以标准 URL 编码表示的文本字符串 
      
        $.ajax({ 
            type : "POST", 
            url  : "http://1d6289976g.imwork.net/wx/fiveBookUser/regist",  
            cache : false, 
            data : formData, 
            success : onSuccess, 
            error : onError 
        }); 
        return false; 
    }); 
}); 
 
function onSuccess(data,status){ 
    data = $.trim(data); //去掉前后空格 
    $('#notification').text(data).append(); 
//    location.href ="http://1d6289976g.imwork.net/wx/fiveBookUser/registResult";
    if(data.indexOf("success") >0 ) {
    	location.href ="http://1d6289976g.imwork.net/wx/registResultaa.html";
    } else {
    	$('#notification').text("注册失败").append(); 
    }
    
} 
 
function onError(data,status){ 
    //进行错误处理 
}