function notice_writer(){
	if(frm.subject.value==""){
		alert("제목을 입력하세요");
		frm.subject.focus();
	}
	else if(frm.writer.value==""){
		alert("글쓴이를 입력하세요");
		frm.writer.focus();
	}
	else if(frm.wtext.value==""){
		alert("내용을 입력하세요");
		frm.wtext.focus();
	}
	else{
		frm.submit();
	}
}