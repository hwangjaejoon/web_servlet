function gomovie(){
	
	if(frm.mname.value==""){
		alert("고객명을 입력해 주세요.");
		frm.mname.focus();
	}
	else if(frm.mno.value==""){
		alert("연락처를 입력해 주세요.");
		frm.mno.focus();
	}
	else if(isNaN(frm.mno.value)){
		alert("연락처는 숫자만 입력해 주세요.");
		frm.mno.focus();
	}		
	else if(frm.subject.value==""){
		alert("예매하실 영화를 선택해 주세요.");		
	}
	else if(frm.dt.value==""){
		alert("날짜를 선택해 주세요");
	}
	else if(frm.dt.value < "2025-02-20"){
		alert("날짜는 오늘 이전 날짜를 골라주세요.");
	}
	else{
		frm.submit();
	}
}
