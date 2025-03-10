//게시물 등록 시 체크하는 함수
function writeck(){
	if(frm.subject.value==""){
		alert("제목을 입력 해 주세요.");
		frm.subject.focus();
	}
	else if(frm.writer.value==""){
		alert("글쓴이를 입력 해 주세요.");
		frm.writer.focus();
	}
	else if(frm.pw.value==""){
		alert("비밀번호를 입력 해 주세요.");
		frm.pw.focus();
	}
	else{
		//CKEDITOR.instances.에디터 쓴 id.getData();	==>  ckeditor를 로드하는 명령어
		var txt = CKEDITOR.instances.editor.getData();
		if(txt == ""){
			alert("내용을 입력 해 주세요.");
		}
		else if(txt.length <30){
			alert("최소 30자 이상 입력 해 주세요.");
		}
		else{
			frm.submit();
		}
	}
}