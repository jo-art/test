/**
 *  boardService.js
 */

const svc = {
	name: "홍길동",
	replyList : function(bno,successCallback,errorCall){
		//메소드
		fetch('replyList.do?bno='+bno)
		.then(result =>result.json())//가지고온 데이터를 파싱
		.then(successCallback)
		.catch(errorCall)
	},
	removeReply(rno,successCallback,errorCall){
		//메소드
				fetch('removeReply.do?rno='+rno)
				.then(result =>result.json())//가지고온 데이터를 파싱
				.then(successCallback)
				.catch(errorCall)
	},
	//추가
	addReply(rvo ={bno,reply,replyer},successCallback,errorCall){
			//메소드
					fetch('addReply.do?bno='+rvo.bno+'&reply='+rvo.reply+'&replyer='+rvo.replyer)
					.then(result =>result.json())//가지고온 데이터를 파싱
					.then(successCallback)
					.catch(errorCall)
		}
}
