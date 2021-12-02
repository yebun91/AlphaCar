<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅하기</title>
<style type="text/css">

#chatList{
background:gray;
overflow-y:scroll; width:500px; height:300px; padding:4px; border:1 solid #000000;
}

.chatuserdiv{
	text-align:right;
}
.chatuserdiv .span1{
display:block; color:white; margin-bottom:3px; font-size: 12px;
}
.chatuserdiv  .span2{
background-color:#f8fc00; display:inline-block; max-width: 200px; min-width:50px; border-radius: 10px; margin: 5px 0px; font-size:20px; padding: 10px; color:black;
}
.chatuserdiv .span3{
display: block;  color:white; margin-bottom:3px; font-size: 12px;
}

.chatrevdiv{
	text-align:left;
}
.chatrevdiv .span1{
display: block;  color:white; margin-bottom:3px; font-size: 12px;
}
.chatrevdiv .span2{
background-color:#ffffff; display:inline-block; max-width: 200px; min-width:50px; border-radius: 10px; margin: 5px 0px; font-size:20px; padding: 10px; color:black;
}
.chatrevdiv .span3{
display: block;  color:white; margin-bottom:3px; font-size: 12px;
}
</style>
<script type="text/javascript"src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.10/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.10/firebase-analytics.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.10/firebase-auth.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.10/firebase-database.js"></script>

</head>
<body>
	<input type="hidden" id="userAdmin" value="${loginInfo.admin}" />
	<input type="hidden" id="userid" value="${loginInfo.customer_email}" />
	<input type="hidden" id="username" value="${loginInfo.customer_name}" />
	<input type="hidden" id="revid" value="${revid}" />
	<!-- revid 라는 아이디로 초기값 부여 -->
	<div>
		<a onclick="changeRevId('강동원')">강동원</a>
		<a onclick="changeRevId('아이유')">아이유</a>
	</div>
	<div id="chatList" class="chatList">
	
	</div>
	<div class="textContent">
		<form onsubmit="return send_msg();" id="subSend">
			<input type="text" id="usermsg" autocomplete="off" class="chk"
				onkeypress="if(event.keyCode==13){return emptyCheck();}" /> 
			<input
				type="button" value="보내기" class="send"
				onclick=" if(emptyCheck()){ $('#subSend').submit();}" />
		</form>
	</div>
</body>
<!-- 파이어 베이스 초기화 하기 fireBase Web플랫폼 추가시 나옴.  -->
<script type="text/javascript">
	const firebaseConfig = {
	    apiKey: "AIzaSyC3zt_SyO9CGSpVpYgPZeJZQNRb9lhrQLE",
	    authDomain: "alphacar-45c64.firebaseapp.com",
	    databaseURL: "https://alphacar-45c64-default-rtdb.asia-southeast1.firebasedatabase.app",
	    projectId: "alphacar-45c64",
	    storageBucket: "alphacar-45c64-default-rtdb.asia-southeast1.firebasedatabase.app",
	    messagingSenderId: "127615935781",
	    appId: "1:127615935781:web:242e910e902edc20bbe6cc",
	    measurementId: "G-D4CC7TYRNP"
	  };
	const app = firebase.initializeApp(firebaseConfig);
	/* 초기화 완료  */
	
</script>


<script type="text/javascript">
	//전역변수 선언.
	const userAdmin = document.getElementById("userAdmin").value;
	const userid = document.getElementById("username").value;
	let revid = document.getElementById("revid").value;
	let user_ref = 'users/' + userid + "/" + revid;
	let rev_ref = 'users/' + revid + "/" + userid;
	
	if(userAdmin == 'A'){
		if(revid != null){
			/* 관리자모드로 들어가 메세지를 보낼 사람을 고른 경우 */
			initChat();
		}else{
			/* 관리자모드로 들어가 메세지를 보낼 사람을 고르지 않은 경우 */
			
		}
		
	}else{
		/* 관리자가 아닐 경우 보내는 사람이 관리자 이기 때문에 관리자와의 채팅 내용을 보여줌 */
		initChat();
	}
	
	function sessionChange(reciveId) {
		$.ajax ({
			//경로 형태로 url 지정
			url : "chat/list/change",
			data : { revid:reciveId } 	
		});	
	}

	
	function changeRevId(reciveId) {
		user_ref = 'users/' + userid + "/" + reciveId;
		rev_ref = 'users/' + reciveId + "/" + userid;
		document.getElementById('revid').value = reciveId;
		sessionChange(reciveId);
		initChat();
	}

	function initChat() {
		firebase.database().ref(user_ref).once('value',
				 function(snapshot) { 
			 });
		firebase.database().ref(user_ref).on('child_added', function(snapshot){
			
			
				var childKey = snapshot.key;
				var childData = snapshot.val();
				
				console.log(childData.nickname);

				var html = '';
				if(childData.nickname == userid){
					html = rtnHtmlDiv(childData.nickname , childData.msg ,childData.date , 'chatuserdiv')
				}else{
					html = rtnHtmlDiv(childData.nickname , childData.msg ,childData.date, 'chatrevdiv');
				}
			
		
				$('#chatList').append(html);
				scrollBottom();
		}, callback());
		
	}
	function callback(){
		//alert('callback');
	}
	function rtnHtmlDiv(nickname,msg,date ,className){
		
			var temp_html = '<div class=' + className +'>'
				+ '<span class="span1">' 
				+ nickname 
				+ '</span>'
				+ '<span class="span2">' 
				+ msg
				+ '</span>'
				+ '<span class="span3">' 
				+ date
				+ '</span>'
				+'</div>';
		return temp_html;
	}
	//메세지 보내기
	function send_msg() {
		send_fb(userid, user_ref);
		send_fb(userid, rev_ref);
		//alert('전송 완료!');
	}

	function send_fb(userid, ref) {
		var date = rtnDate();
		var msg = document.getElementById('usermsg').value;
		var key = firebase.database().ref().child(ref).push().key;
		var data = {
			nickname : userid,
			msg : msg,
			date : date,
			selected : ''
		}
		var updates = {};
		updates['/' + ref + '/'+ key] = data;
		firebase.database().ref().update(updates);

	};

	//채팅창에 아무것도 입력하지 않은 경우 전송을 막는다.
	function emptyCheck(){
		var val = $('#usermsg').val().trim().length;
		console.log(val);
		if( val == 0 ){
			$('#usermsg').focus();
	
			return false;
		}
		return true;
	};

	function rtnDate(){
		var date = new Date();
		var hours = date.getHours();
		var minutes = date.getMinutes();
		var ampm = hours >= 12 ? '오후' : '오전';
		hours = hours % 12;
		hours = hours ? hours : 12; // the hour '0' should be '12'
		minutes = minutes < 10 ? "0" + minutes : minutes;
		var strTime = ampm + " " + hours + ":" + minutes;
		return strTime;
	}
	function scrollBottom(){
		$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
	}
	
	
</script>
</html>