function send(){
	if(frm.to_name.value==""){
		alert("성함을 입력해 주세요");
		frm.to_name.focus();
	}
	else if(frm.to_mail.value==""){
		alert("이메일을 입력해 주세요");
		frm.to_mail.focus();
	}
	else if(frm.subject.value==""){
		alert("제목을 입력해 주세요");
		frm.subject.focus();
	}
	else if(frm.context.value==""){	
		alert("내용을 입력해 주세요");
		frm.context.focus();
	}
	else{
		// 정규식 코드에 \를 사용하는 이유 : 특정 문자를 기준으로 삼는다는 뜻
		var reg = /^[a-z0-9] + \@[a-z0-9ㄱ-힇 + \.[a-z0-9ㄱ-힇]{2,}]/i;
		console.log(reg.test(frm.to_mail).value);
		frm.submit();
	}
}