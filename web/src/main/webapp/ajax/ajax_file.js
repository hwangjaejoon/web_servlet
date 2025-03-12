function ajax_file(){
	var mfile = document.getElementById("mfile");
	if(mfile.value==""){
		alert("파일을 첨부해 주세요");
	}else{
		this.ajax_post(mfile);
	}	
}

// Ajax I/O로 파일으 전송하는 방식
function ajax_post(mfile){
	var http,result;
	var formdata = new FormData();	//form 형태의 태그를 이용하는 방식과 동일
	formdata.append("mfile",mfile.files[0]);	//배열기준으로 파일을 처리
	
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status==200){
			console.log(this.response);
		}
	}
	//FIle 은 무조건 Post 전송
	http.open("POST","./ajax_fileok.do",true);
	//http.setRequestHeader("content-type","mutipart/form-data");
	http.send(formdata);	//Formdata 함수의 값을 send 함수에 인자값으로 적용하여 전송
	
}