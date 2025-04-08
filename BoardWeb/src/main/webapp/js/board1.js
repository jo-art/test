/**
 * board1.js
 * XMLHttpRequest, fetch => 실행 순서
 */


let page = 1;

//함수 선언식. -함수표현식


//목록출력
let successCallback = function successCallback(result) { // result를 받아서 처리하는 경우 괄호 필요
	console.log(result);
	//기존 목록 지우기
	document.querySelectorAll('div.reply  div.content>ul>li').forEach(function(item, idx) {
		if (idx) { //truthy, falsy (0,null, '',undefined)
			item.remove();
		}
	});
	//새로운 목록 출력.
	result.forEach(item => {
		makeRow2(item);
	});
}

//에러콜백
function errCallback(err) { // err를 받아서 처리하는 경우 괄호 필요
	console.error(err);
}

//페이징 콜백
function pagingCallback(result) {

	//페이지목록 지우기.
	document.querySelector('nav>ul.pagination').innerHTML = "";
	console.log(result.totalCnt); //totalCnt :258
	let totalCnt = result.totalCnt;

	//첫페이지, 마지막페이지 => 현재페이지로 계산
	let startPage, endPage;
	//이전 페이지, 이후 페이지 변수 선언
	let prev, next;
	endPage = Math.ceil(page / 10) * 10;
	startPage = endPage - 9;
	let realEnd = Math.ceil(totalCnt / 5);
	endPage = endPage > realEnd ? realEnd : endPage;
	//이전페이지 여부
	prev = startPage == 1 ? false : true;
	//이후 페이지 여부
	next = endPage < realEnd ? true : false;
	let html = "";
	let target;
	//이전페이지
	if (!prev) {
		html = `<li class="page-item disabled">
					<span class="page-link">Previous</span>
					</li>`;


	} else {
		html = `<li class="page-item">
						<a class="page-link" data-page="${startPage - 1}" href="#">Previous</a>
					</li>`;

	} target = document.querySelector('nav>ul.pagination');
	target.insertAdjacentHTML('beforeend', html);



	//페이지 갯수

	for (let p = startPage; p <= endPage; p++) {
		if (p == page) {
			html = `<li class="page-item active" aria-current="page"><a
							class="page-link" data-page="${p}" href="#">${p}</a></li>`;
		} else {

			html = `<li class="page-item"><a class="page-link" data-page="${p}" href="#" >${p}</a></li>`;

		}
		target = document.querySelector('nav>ul.pagination');
		target.insertAdjacentHTML('beforeend', html);

	}

	//이후페이지
	if (!next) {
		html = `<li class="page-item disabled">
						<span class="page-link">Next</span>
						</li>`;

	} else {
		html = `<li class="page-item">
							<a class="page-link" data-page="${endPage + 1}" href="#">Next</a>
						</li>`;
	}
	target = document.querySelector('nav>ul.pagination');
	target.insertAdjacentHTML('beforeend', html);
	//링크이벤트
	pageLink();
}
//삭제함수
function deleteFnc(rno = 21) {
	let deleteOk = confirm("삭제하시겠습니까?");
	if (!deleteOk) {
		return;
	}
	svc.removeReply(rno//삭제댓글번호,
		, function(result) {
			console.log(result);
			if (result.retCode = 'OK') {
				//id속성
				alert("삭제성공");
				// 댓글 삭제 후 DOM에서 해당 댓글 제거
				document.querySelector('#rno_' + rno).remove();
				// 댓글 목록을 다시 로드하여 항상 5개가 보이도록 함
				svc.replyList({ bno, page }, successCallback, errCallback);

			}
		}
		, errCallback)
}

// 댓글 목록을 다시 로드하는 함수

//이벤트. 
//이벤트. 
document.querySelector('button.addReply').addEventListener('click', function(e) {
	//등록

	if (replyer == '') {
		alert("로그인하세요");
		return;
	}
	//bno,replyer,reply:#reply.value속성
	let reply = document.querySelector('#reply').value;
	if (reply == '') {
		alert("댓글을 등록하세요");
		return;
	}
	console.log(bno, reply, replyer);
	svc.addReply({ bno, reply, replyer }
		, function(result) {
			if (result.retCode == 'OK') {
				alert('등록성공');
				let item = result.retVal;
					alert('등록 성공');
					svc.replyList({ bno, page }, successCallback, errCallback);
					svc.pagingList(bno, pagingCallback, errCallback);
				//makeRow2(item);

			} else {
				alert('등록실패');
			}
		}, errCallback);
})

//이벤트 페이지링크
function pageLink() {
	document.querySelectorAll('div.reply ul a').forEach(function(atag) {
		atag.addEventListener('click', function(e) {
			e.preventDefault(); //이벤트의 기본기능 차단.
			page = atag.dataset.page; // <a data-page="3"></a>
			//댓글목록
			svc.replyList({ bno, page }, successCallback, errCallback);
			//페이징목록
			svc.pagingList(bno, pagingCallback, errCallback);
		})

	});
}

//목록보여주기
svc.replyList({ bno, page }, successCallback, errCallback);
//페이징목록
svc.pagingList(bno, pagingCallback, errCallback);
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





//동기, 비동기 설명

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
