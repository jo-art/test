/**
 * board2.js
 */


const table = new DataTable('#example', {
	ajax: 'replyListDatatable.do?bno=' + bno,
	columns: [
		{ data: 'REPLY_NO' },
		{ data: 'REPLY' },
		{ data: 'REPLYER' },
		{ data: 'REPLY_DATE' }
	],
	lengthMenu: [
		[5, 10, 25, 50, -1],
		[5, 10, 25, 50, 'All']
	],
	order: [[3, 'desc']]
});
function addNewRow() {
    let reply = document.querySelector('#addContent').value; // 댓글 내용

    // 댓글 추가 요청
    fetch('addReply.do?bno=' + bno + '&replyer=' +replyer + '&reply=' + reply)
        .then(result => result.json())
        .then(obj => {
            // 서버에서 반환된 댓글 정보를 사용하여 DataTable에 추가
			console.log(obj);
            table.row.add({
                REPLY_NO: obj.retVal.replyNo, // 서버에서 반환된 댓글 번호
                REPLY: obj.retVal.reply, // 클라이언트에서 가져온 댓글 내용
                REPLYER: obj.retVal.replyer, // 서버에서 반환된 댓글 작성자
                REPLY_DATE: obj.retVal.replyDate // 서버에서 반환된 댓글 작성일
            }).draw(false);

            console.log(obj); // 서버 응답을 콘솔에 출력
        })
        .catch(err => console.error(err)); // 오류 처리
}

// 버튼 클릭 이벤트 리스너 등록
document.querySelector('#addRow').addEventListener('click', addNewRow);


//삭제
let rno;
table.on('click', 'tbody tr', (e) => {
	rno=e.currentTarget.children[0].innerHTML;
	console.log(e);
	console.log(e.currentTarget.children[0].innerHTML);
	let classList = e.currentTarget.classList; //class목록()

	if (classList.contains('selected')) {//classList에 있는지 contains('클래스명'), 제거(remove('클래스명')) , 추가(add('클래스명'))
		classList.remove('selected'); //클래스 제거
	}
	else {
		table.rows('.selected').nodes().each((row) => row.classList.remove('selected')); //이전에 클릭된 클래서 제거
		classList.add('selected'); //방금 선택된 요소를 셀렉티드로 추가
	}
});

document.querySelector('#delRow').addEventListener('click', function() {
	//화면에서 삭제. fetch
	
	fetch('removeReply.do?rno=' + rno)
	.then(result => result.json())
	.then(result=>{
		
		console.log(result);
		if(result.retCode=='OK'){
			table.row('.selected').remove().draw(false);
		}else{
			console.error(err);
		}
		
	})		
	.catch(err => console.error(err)); // 오류 처리			
	
})
