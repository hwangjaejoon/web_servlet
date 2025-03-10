// ECMAScript : touchstart, touchend, touchmove, touchcancel, click, change, submit, keypress, 등등등.......
// touchstart == click
document.getElementById("btn").addEventListener("touchstart",function(){
	reviews();
});



function reviews(){
	if(frm.mname.value==""){
		alert("고객명을 입력해 주세요");
		frm.mname.focus();		
	}
	else if(frm.pname.value==""){
		alert("상품명을 입력해 주세요");
		frm.pname.focus();
	}
	else if(frm.mtext.value==""){
		alert("리뷰 내용을 입력해 주세요..");
	}	
	else{
		frm.submit();
	}
}