function login(){
	if(frm.adm_id.value==""){
		alert("아이디를 입력하세요.");	
	}
	else if(frm.adm_pw.value==""){
		alert("비밀번호를 입력하세요.");	
	}
	else if(frm.adm_no.value==""){
		alert("사원번호를 입력하세요.");	
	}
	
	else{
		//frm.method = "get";
		//frm.action = "./adminok.do";
		//frm.submit();
		
		//btoa : base64 암호화
		var id = btoa(frm.adm_id.value);
		var pw = btoa(frm.adm_pw.value);
		var no = btoa(frm.adm_no.value);

		location.href="./adminok.do?adm_id="+id+"&adm_pw="+pw+"&adm_no="+no;		//  <<-- html에서 name 을 id값으로 써도 되나봄 (Get 방식)
	}
}