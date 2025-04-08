/**
 *  boardService.js
 */

const svc = {
	name: "홍길동",
	replyList: function(search = { bno, page }, successCallback, errorCall) {
		//메소드
		fetch('replyList.do?bno=' + search.bno + '&page=' + search.page)
			.then(result => result.json())//가지고온 데이터를 파싱
			.then(successCallback)
			.catch(errorCall)
	},
	removeReply(rno, successCallback, errorCall) {
		//메소드
		fetch('removeReply.do?rno=' + rno)
			.then(result => result.json())//가지고온 데이터를 파싱
			.then(successCallback)
			.catch(errorCall)
	},
	//추가
	addReply(rvo = { bno, reply, replyer }, successCallback, errorCall) {
		//메소드
		fetch('addReply.do?bno=' + rvo.bno + '&reply=' + rvo.reply + '&replyer=' + rvo.replyer)
			.then(result => result.json())//가지고온 데이터를 파싱
			.then(successCallback)
			.catch(errorCall)
	},
	//페이지 계산
	pagingList(bno = 103, successCallback, errorCall) {
		//메소드
		fetch('replyCount.do?bno='  + bno)
			.then(result => result.json())//가지고온 데이터를 파싱
			.then(successCallback)
			.catch(errorCall)
	}

}
