//회원분류
function frm_view(part){
	console.log(part);
	var sp = document.getElementById("corp");
	// style.display : 해당 오브젝트를 웹에 출력 또는 미출력
	if(part=="C"){
		sp.style.display = "block";
	}
	else{
		sp.style.display = "none";
	}
}
//아이디 중복체크
function idcheck(){
	if(frm.sid.value==""){
		alert("아이디를 입력하세요");
		frm.sid.focus();
	}
	else{
		//Ajax 역할..? (Back-end 통신)
		ajaxpost(frm.sid.value);
	}	
}

//Ajax 함수를 이용하여 중복체크
var ok = "";	//Back-end에게 통신을 보내는 역할을 하는 변수
function ajaxpost(data){
	//console.log(data);
	function wck(){
		//window.XMLHttpRequest : 현재 웹페이지에서 XHR 통신을 사용함
		if(window.XMLHttpRequest){		//(XHR 통신)
			return new XMLHttpRequest();	//신규 XHR 
		}
	}
	function getdata(){
		// XMLHttpRequest.UNSENT(0) = 객체를 생성
		// XMLHttpRequest.OPENED(1) = XHR 통신 연결( open() )
		// XMLHttpRequest.HEADERS_RECEIVED(2) = Back-end URL 및 통신규격 (POST or GET)
		// XMLHttpRequest.LOADING(3) = Back-end 경로 응답 대기 시간
		// XMLHttpRequest.DONE(4) = Back-end가 요청 된 데이터를 처리 한 결과 값을 보낸 경우
		
		//status : 통신에 대한 결과 코드 번호 (200:성공, 405:Back-end쪽 문제 , 404:URL 경로 오류 등등) 
		if(ok.readyState==4 && ok.status==200){
			//console.log(this.response);	//Back-end 결과값을 받음
			if(this.response == "ok"){
				alert("사용가능한 아이디입니다.");
				document.getElementById("idck").value="ok";
				frm.sid.readOnly = true;	//아이디 읽기 전용 (수정 불가) //대,소문자 구별 확실하게
			}
			else if(this.response == "no"){
				alert("이미 사용중인 아이디입니다.");
				frm.sid.value="";
				frm.sid.focus();
			}
		}
	}
	
	//순서에 맞게 통신을 실행하는 역할
	ok = wck();		//신규 XHR 생성
	ok.onreadystatechange = getdata; 	//해당 함수 결과를 받는 설정
	//Ajax 통신규약 : POST, GET, PUT, DELETE
	//ok.open("통신규약","Back-end의 경로","true:비동기통신, false:동기통신")
	//async : 비동기통신, sync : 동기통신
	//비동기통신 : 여러 데이터를 지속적으로 전송할 수 있으며, 결과값을 따로 받을 수 있음
	//동기통신 : 순차적으로 처리하는 방식, 1:1 => FORM 통신
	ok.open("GET","./idcheck.do?sid="+data,"true");	  //값을 이관(Back-end 한테)
	ok.send();	//Ajax 통신 실행
}

//회원가입 버튼
function memberok(){
	if(frm.sid.value==""){
		alert("아이디를 입력 후 중복체크를 해 주세요.");
		frm.sid.focus();
	}
	else if(frm.spw.value==""){
		alert("비밀번호를 입력 해 주세요.");
		frm.spw.focus();
	}
	else if(frm.snm.value==""){
		alert("이릅 및 회사명을 입력 해 주세요.");
		frm.snm.focus();
	}
	else if(frm.stel.value==""){
		alert("연락처를 입력 해 주세요.");
		frm.stel.focus();
	}
	else if(frm.semail.value==""){
		alert("이메일을 입력 해 주세요.");
		frm.semail.focus();
	}
	else{
		if(frm.spart[0].checked==true){	//일반회원
			if(document.getElementById("idck").value==""){
				alert("아이디 중복체크를 진행 해 주세요");
				frm.sid.focus();
			}else{
				frm.submit();
			}
		}
		else{						//사업자
			if(frm.sno.value==""){
				alert("사업자 번호를 입력 해 주세요.");
			}
			else if(frm.sno.value.length < 10){
				alert("사업자 번호를 제대로 입력 해 주세요.");
			}
			else{
				frm.submit();
			}
		}
	}
	
}