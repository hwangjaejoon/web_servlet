//일반 or 사업자 회원 체크
function partcheck(part){
	var snoview = document.getElementById("snoview");
	if(part=="P"){
		snoview.style.display = "none";
	}else{
		snoview.style.display = "block";
	}
}



function loginck(){
	if(frm.sid.value==""){
		alert("아이디를 입력하세요");
		frm.sid.focus();
		return false;
	}
	else if(frm.spw.value==""){
		alert("비밀번호를 입력하세요");
		frm.spw.focus();
		return false;
	}
	else{
		if(frm.spart[0].checked==true){		//일반회원 체크
			//frm.submit(); 	//이거 아니면
			return true;
		}
		else if(frm.spart[1].checked==true){	//사업자 회원 체크
			if(frm.sno.value==""){
				alert("사업자 번호를 입력하세요");
				frm.sno.focus();
				return false;
			}	
			else if(frm.sno.value.length < 10){
				alert("올바른 사업자 번호를 입력해 주세요");
				return false;
			}
			else{
				return true;
		}
	}
}
	
}