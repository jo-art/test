/**
 * json.js
 */
const jsonStr= `[{"id":1,"first_name":"Janeczka","last_name":"Bodechon","email":"jbodechon0@google.co.jp","gender":"Female","salary":6170},
{"id":2,"first_name":"Trista","last_name":"Cudiff","email":"tcudiff1@ocn.ne.jp","gender":"Female","salary":6934},
{"id":3,"first_name":"Paolo","last_name":"Crowth","email":"pcrowth2@usnews.com","gender":"Male","salary":7247},
{"id":4,"first_name":"Philippe","last_name":"Louis","email":"plouis3@mail.ru","gender":"Female","salary":9563},
{"id":5,"first_name":"Shantee","last_name":"Arcase","email":"sarcase4@sfgate.com","gender":"Female","salary":1726},
{"id":6,"first_name":"Mahalia","last_name":"Standring","email":"mstandring5@engadget.com","gender":"Female","salary":5298},
{"id":7,"first_name":"Alexis","last_name":"Luxen","email":"aluxen6@apache.org","gender":"Male","salary":6304},
{"id":8,"first_name":"Carolina","last_name":"Lebbon","email":"clebbon7@meetup.com","gender":"Female","salary":3096},
{"id":9,"first_name":"Rozalin","last_name":"Carney","email":"rcarney8@spotify.com","gender":"Female","salary":9572},
{"id":10,"first_name":"Howey","last_name":"Mowbury","email":"hmowbury9@freewebs.com","gender":"Male","salary":1426},
{"id":11,"first_name":"Nevile","last_name":"Eccleshare","email":"necclesharea@xrea.com","gender":"Male","salary":1005},
{"id":12,"first_name":"Abraham","last_name":"McGaugie","email":"amcgaugieb@themeforest.net","gender":"Male","salary":2416},
{"id":13,"first_name":"Darill","last_name":"Vasic","email":"dvasicc@hc360.com","gender":"Male","salary":4694},
{"id":14,"first_name":"Eliot","last_name":"Guillart","email":"eguillartd@admin.ch","gender":"Polygender","salary":6268},
{"id":15,"first_name":"Letizia","last_name":"Bernon","email":"lbernone@si.edu","gender":"Agender","salary":7447}]`;

let obj = JSON.parse(jsonStr); //json문자열 ->object 변경
let str= JSON.stringify(obj); //object->json문자열 변경
console.log(obj);

//데이터 한건을 tr로 묶는 함수 선언
function makeRow(emp = {id,first_name,last_name,email,gender,salary}){
	const fields  = ['id','first_name','last_name','email'];
	let tr = document.createElement('tr'); //<tr></tr>요소를 생성
	for(let i=0; i<fields.length;i++){  //필드배열의 길이만큼 반복
		let td = document.createElement('td');//<td></td>요소를 생성
		td.innerHTML = emp[fields[i]]; //td 사이 이너 값 생성 <td>1</td>
		tr.appendChild(td); //tr의 자식요소 를 넣어줌.<tr><td>1</td><td>Janeczka</td></tr>
		
	}
	return tr;
}
//화면 출력.
obj.forEach(function(item,idx,ary){
	let tr= makeRow(item);
	document.querySelector('tbody#target').appendChild(tr);
})






