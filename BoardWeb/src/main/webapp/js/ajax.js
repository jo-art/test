/**
 * ajax.js 
 */
let dataAry = [];
const xhtp = new XMLHttpRequest(); //비동기방식
xhtp.open('get', 'data/MOCK_DATA.json'); //경로지정
xhtp.send();
xhtp.onload = function() { //load 이벤트 발생.
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	dataAry = obj;//대입
	//화면출력
	obj.forEach(function(item, idx, ary) {
		let tr = makeRow(item);
		document.querySelector('tbody#target').appendChild(tr);
	})
}

//한건 데이터를 매개값으로 tr을 생성하는 함수.
function makeRow(emp = { id, first_name, last_name, email, gender, salary }) {
	const fields = ['id', 'first_name', 'last_name', 'gender'];
	let tr = document.createElement('tr'); //<tr></tr>요소를 생성
	//체크박스 생성	
	let tdd = document.createElement('td');
	let chb = document.createElement('input');
	chb.setAttribute('type', 'checkbox');

	tdd.appendChild(chb);
	tr.appendChild(tdd);
	//td생성
	for (let i = 0; i < fields.length; i++) {  //필드배열의 길이만큼 반복
		let td = document.createElement('td');//<td></td>요소를 생성
		td.innerHTML = emp[fields[i]]; //td 사이 이너 값 생성 <td>1</td>
		tr.appendChild(td); //tr의 자식요소 를 넣어줌.<tr><td>1</td><td>Janeczka</td></tr>

	}
	//button 생성
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('class', 'btn btn-danger');
	btn.innerText = '삭제';
	btn.addEventListener('click', deleteRow);
	//부모-자식
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;

}

//btn의 이벤트 핸들러 .
function deleteRow(e) {
	console.log(e.target);
	e.target.parentElement.parentElement.remove();
}

//thead의 checkbox에 이벤트 등록
document.querySelector('thead input[type="checkbox"]').addEventListener('change', function(e) {
	//tbody영역의 checkbox의 값 변경
	let checked = e.target.checked;
	document.querySelectorAll('tbody#target input[type="checkbox"]').forEach(function(item) {
		item.checked = checked;
	})
})

document.querySelector('select#searchGender').addEventListener('change', function(e) {
	let gender = e.target.value;
	//dataAry의 배열을 활용해서 출력
	//dataAry의 gender 속성을 비교해서 출력하기(출력전 목록 초기화.)
	document.querySelector('tbody#target').innerHTML="";
	dataAry.forEach(function(item) {
		if (gender=='all' || item.gender == gender) {
			let tr = makeRow(item);
			document.querySelector('tbody#target').appendChild(tr);
		}
	});

})



