/**
 * array.js
 * 배열 추가 push,unshift
 * 배열 제거 pop,shift
 * splice 추가, 수정, 삭제
 * forEach()
 */
const ary=[];
//배열 추가 push,unshift
ary.push('홍길동'); //배열 제일 마지막 위치에 추가
ary.push('김길동'); 
ary.unshift('최길동'); // 배열 제일 앞 위치에 추가


//ary.pop();// 삭제
//ary.shift();//삭제
//ary.splice(0,0,'박길동','황길동'); // splice(몇번째 , 크기, 대체값)

ary.forEach(function(item,index,ary){
	console.log(`item => ${item},index=${index},ary=${ary}`);
}); 
//함수
function addElement(elem = "noElem"){
	ary.push(elem);
}
//삭제함수
function deleteElement(e){
	//alert('삭제버튼클릭됨');
	e.target.parentElement.remove();
}
document.querySelector('button#addBtn').addEventListener('click',function(){
	 let val= document.querySelector('input#userInput').value;
	 addElement(val); // ary배열에 추가.
	 //화면 출력
	 let html='';
	 ary.forEach(function(item,idx,ary){
		html+='<li>'+item+'<button onclick="deleteElement(event)" >삭제</button></li>';
	 });
	 //ul 태그 영역에다 넣기
	 document.querySelector('ul#list').innerHTML =html;
	 
});
