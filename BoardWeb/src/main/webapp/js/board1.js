/**
 * board1.js
 * XMLHttpRequest, fetch => 실행 순서
 */



//함수 선언식. -함수표현식
let successCallback =function successCallback(result) { // result를 받아서 처리하는 경우 괄호 필요
	console.log(result);
	result.forEach(item => {
		makeRow2(item);
	});
}

//에러콜백
function errCallback(err) { // err를 받아서 처리하는 경우 괄호 필요
	console.error(err);
}
//삭제함수
function deleteFnc(rno = 21) {
	let deleteOk = confirm("삭제하시겠습니까?");
	if(!deleteOk){
		return;
	}
	svc.removeReply(rno//삭제댓글번호,
		,function(result){
			console.log(result);
			if(result.retCode='OK'){
				//id속성
				alert("삭제성공");
				document.querySelector('#rno_'+rno).remove();
			}
		}
		,errCallback)
}
//이벤트. 
//이벤트. 
document.querySelector('button.addReply').addEventListener('click',function(e){
	//등록
	
	if(replyer == ''){
		alert("로그인하세요");
		return;
	}
	//bno,replyer,reply:#reply.value속성
	let reply= document.querySelector('#reply').value;
	if(reply == ''){
			alert("댓글을 등록하세요");
			return;
		}
		console.log(bno,reply,replyer);
		svc.addReply({bno,reply,replyer}
		,function(result){
			if(result.retCode=='OK'){
				alert('등록성공');
				let item=result.retVal;
				makeRow2(item);
			}else{
				alert('등록실패');
			}
		},errCallback);
})
//목록보여주기
svc.replyList(bno,successCallback,errCallback);
//댓글정보 ->화면 출력
function makeRow2(item) {
	let html = `<li id="rno_${item.replyNo}">
              <span class="col-sm-2">${item.replyNo}</span>
              <span class="col-sm-5">${item.reply}</span>
              <span class="col-sm-2">${item.replyer}</span>
              <span class="col-sm-2"><button onclick="deleteFnc(${item.replyNo})">삭제</button></span>
            </li>`;
	let templ = document.querySelector('div.content>ul');
	templ.insertAdjacentHTML('beforeend', html);
}

// 동기, 비동기(ajax)
setTimeout(function() {
	console.log('1');

	setTimeout(function() {
		console.log('2');

		setTimeout(function() {
			console.log('3');
		}, 1000);

	}, 1000);

}, 1000);
