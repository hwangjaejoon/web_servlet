function joinok(){
	if(frm.mid.value==""){
		alert("아이디를 입력해 주세요");
		frm.mid.focus();
	}
	else if(frm.mpass.value==""){
		alert("비밀번호를 입력해 주세요");
		frm.mpass.focus();
	}
	else if(frm.mname.value==""){
		alert("이름을 입력해 주세요");
		frm.mname.focus();
	}
	else if(frm.memail.value==""){
		alert("이메일을 입력해 주세요");
		frm.memail.focus();
	}
	else if(frm.mtel.value==""){
		alert("전화번호를 입력해 주세요");
		frm.mtel.focus();
	}
	else{
		var pw2 = document.getElementById("mpass2").value;
		if(pw2 != frm.mpass.value){
			alert("비밀번호를 확인해 주세요");
		}
		else{
			frm.submit();
		}
	}
}