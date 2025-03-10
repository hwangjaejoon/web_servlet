<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  
//Controller에서 난수를 생성한 배열을 jsp로 전달받
ArrayList<String> ab = (ArrayList)request.getAttribute("seno");
String code = ""; 	//난수 4자리를 문자열로 변환시켜서 Javascript 변수에 이관
%>
     
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="imagetoolbar" content="no">
    <link rel="stylesheet" type="text/css" href="./new_member.css?v=1">
   <title>신규회원가입</title>
</head>
<body>
<form id="frm">
<main class="shop_main">
  <section class="subpage">
        <div class="newmemdiv">
            <span class="newmem1">
                <p>MEMEBER-SHIP</p>
                <span>
                    <ul class="fcolors">
                        <li>01 약관동의</li>
                        <li><img src="./images/step_off.png"></li>
                        <li>02 정보입력</li>
                        <li><img src="./images/step_on.png"></li>
                        <li>03 가입완료</li>
                    </ul>
                </span>
            </span>
            <span class="newmem2">
                <p>기본정보</p>
            </span>
            <span class="new_join">
                <ul>
                    <li>
                        <span>아이디</span>
                        <input type="text">&nbsp;&nbsp;* 아이디는 최소 5자 이상 입력하십시오.
                    </li>
                    <li>
                        <span>비밀번호</span>
                        <input type="password">&nbsp;&nbsp;* 패스워드는 최소 6자 이상 입력하셔야 합니다.
                    </li>
                    <li>
                        <span>비밀번호 확인</span>
                        <input type="password">&nbsp;&nbsp;* 동일한 패스워드를 입력하세요.
                    </li>
                    <li>
                        <span>고객명</span>
                        <input type="text">
                    </li>
                    <li>
                        <span>이메일</span>
                        <input type="text" id="myemail">
                        <select id="semail" onchange="mail_select(this.value)">
                            <option value="">직접입력</option>
                            <option value="naver.com">naver.com</option>
                            <option value="nate.com">nate.com</option>
                            <option value="hanmail.net">hanmail.net</option>
                            <option value="google.com">google.com</option>
                            <option value="hotmail.com">hotmail.com</option>
                        </select>
                        <label>
                            <input type="checkbox">&nbsp;정보/이벤트 메일 수신에 동의합니다.
                        </label>
                    </li>
                    <li>
                        <span>휴대폰 번호</span>
                        <input type="text" placeholder="- 없이 입력하세요.">
                        <label>
                            <input type="checkbox"> 정보/이벤트 SMS 수신에 동의합니다.
                        </label>
                    </li>
                    <li class="address">
                        <span>주소</span>
                        <span>
                            <div>
                            	<!-- 우편번호 -->
                                <input type="text" id="add_post" readonly><button type="button" onclick="sample4_execDaumPostcode()">우편번호 검색</button>
                            </div>
                            <!-- 도로명 주소 -->
                            <input type="text" id="add_ress" readonly>
                            <input type="text">
                        </span>
                    </li>
                    <li>
                        <span>별명</span>
                        <input type="text">
                    </li>
                    <li>
                        <span>개인정보 공개</span>
                        <label>
                            <input type="checkbox"> 개인정보 공개시 회원등급 및 회원 별명만 출력됩니다.
                        </label>
                    </li>
                    <li>
                        <span>자동등록방지</span>
                        <div style="box-sizing: border-box">
                        <%
                        int w = 0;
                        while(w < ab.size()){
                        	code += ab.get(w);		//난수 4자리 값 누적
                        %>	                      
                            <img src="./no/no<%=ab.get(w)%>.png" style="width:25px; height:60px;">
                        <%
                        w++;
                        }
                        %>                        	                      
                        </div>
                        <em><img src="./images/refresh.svg"></em>
                        <input type="text" id="autono">&nbsp;&nbsp;&nbsp;* 자동등록방지 이미지 문자를 입력해 주십시오.
                    </li>
                </ul>
            </span>
            <!--  button태그 : HTML5 전용태그 type을 이용하여 submit, button, reset으로 구분 -->
            <span class="newmembtn">
                <button type="button" onclick="joinok()">회원가입</button>
                <button type="reset">가입취소</button>
            </span>
        </div>
  </section>
</main>
</form>
<script>
var n = "<%=ab%>";
function joinok(){
var user = document.getElementById("autono");
var(n == user){
	alert("동일한 문자 확인 완료");
}
else{
	alret(정확하게 입력하세요);
}
}




//이메일 선택에 따른 interface 적용
function mail_select(mail){
		var user = document.getElementById("myemail");
		if(mail == ""){	//직접선택 시
			user.value = "";	//사용자가 입력한 값을 초기화
		}
		else{	//사용자가 입력한 내용 + email 도메인명 추가
			
			//정규식 코드 형태 추가
			if(user.value.indexOf("@") == -1){	//@없을 경우
				var modify = user.value + "@" + mail;		//@와 사용자가 선택한 옵션값을 적용		
			}
			else{	
				//@를 입력시 split을 이용하여 
				//이메일 아이디만 추출 후 사용자가 선택한 값을 적용
				var check = user.value.split("@");
				var modify = check[0] + "@" + mail;	
			}
			user.value = modify;		//해당 입력값에 새롭게 데이터 정보를 입력
			
		}
}

</script>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('add_post').value = data.zonecode;
            document.getElementById('add_ress').value = roadAddr;
      
        }
    }).open();
}
</script>
</body>
</html>