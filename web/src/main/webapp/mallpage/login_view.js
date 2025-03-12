function loginck(){
	if(frm.mid.value==""){
		alert("아이디를 입력해 주세요.");
		frm.mid.focus();
		return false;
	}
	else if(frm.mpass.value==""){
		alert("비밀번호를 입력해 주세요.");
		frm.mpass.focus();
		return false;
	}
	else{
		frm.submit();
	}
}