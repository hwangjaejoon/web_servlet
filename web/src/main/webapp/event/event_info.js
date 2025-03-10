function wordck(){
	var w = "01012345678";
	
	//let ck = /[0-9]/;
	//let ck = /[0-9]/;
	
	//console.log(w.match(ck));
	let ck = /^(010|011)\d{3,4}\d{4}$/;		//true(010-1234-5678)     false(01012345678)
	console.log(ck.test(w)); 		
	
}


function eventok(){
	if(f.ename.value==""){
		alert("고객명을 입력하세요");
		f.ename.focus();
	}
	else if(f.etel.value==""){
		alert("연락처를 입력하세요");
		f.etel.focus();	
	}
	else if(f.email.value==""){
		alert("이메일을 입력하세요");
		f.email.focus();
	}
	else if(f.ememo.value==""){
		alert("이벤트를 참여한 이유를 입력하세요");
		f.ememo.focus();
	}
	else if(f.info1.checked==false){
		alert("개인정보 활용 여부에 동의해 주세요.");
	}
	else if(f.info2.checked==false){
		alert("제 3자 정보제공 여부에 동의해 주세요.");
	}
	else{
		//정규식 코드 사용 (연락처 확인)
		let ck = /^(010|011)\d{3,4}\d{4}$/;	//수샂 외의 다른 문자일 경우 false 발생...
		if(ck.test(f.etel.value)==false){
			alert("전화번호를 정상적으로 입력하세요");
		}
		else{
			f.submit();
		}
		
	}
	
}