/////////////////ajax 사용법//////////////////// 

function ajaxs(){	//전송 버튼 클릭 시 발동되는 이벤틓 ㅏㅁ수
	var mid = document.getElementById("mid");
	var memail = document.getElementById("memail");
	if(mid.value==""){
		alert("아이디를 입력하세요.");
		mid.focus();
	}
	else if(memail.value==""){
		alert("이메일을 입력하세요.");
		memail.focus();
	}
	else{
		//ajax Post 통신을 위한 함수
		this.ajax_post(mid.value,memail.value);
	}
}

//Ajax POST 로 전송하는 함수
function ajax_post(mid,memail){
	var http, result;	//http: Back-end 통신 , result : Back-end 에서 제공한 데이터
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status==200){
			console.log(this.response);
		}
		else if(http.status==404){
			console.log("경로 오류 발생");
		}
		else if(http.status==405){
			console.log("통신 규격 오류 발생");
		}
	}
	//Get통신
	//http.open("get","./ajax_getok.do?userid=",true); 
	//http.send();
	
	//Post 통신
	http.open("post","./ajax_postok.do",true);
	//Ajax Post 전송 시 content-type을 적용하여, application/x-www-form-urlencoded 을 적용해야 만 정상적으로 back-end에게 값을 전송
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	//http.send("userid="+mid);	//한 개의 데이터 값을 전송할 때
	http.send("userid="+mid+"&usermail="+memail);	//한 개 이상 부터는 & 사용
	
}