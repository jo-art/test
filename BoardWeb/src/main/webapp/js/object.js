/**
 *object.js 
 */
console.log("start");

//DOM 제어.
let li= document.createElement('li'); //새로운 요소 생성
li.innerText ='cherry'; //<li>cherry</li>
document.querySelector('ul#list').appendChild(li); //하위요소 추가
console.log(document.querySelector('ul#list'));
document.querySelector('ul#list').style.display = 'none';
let name="Hong"; //같이 할당되는 시점에 type 정해짐
name=100;
console.log(typeof name);

const obj={
	name:"홍길동",
	age:20,
	friends:['김길동','박길동'],
	pets:[{name:'웅이',age:3},{name:'멍멍잉',age:3}]
}

obj.height=159;
console.log(typeof obj);
console.log(obj.name,obj["age"]); //속성 출력
console.log('첫번째 친구',obj['friends'][0]); 
console.log('첫번째 반려동물 이름',obj.pets[0].name);
//최길동 추가
obj.friends[2]='최길동';




//친구목록
for(let i=0; i<obj.friends.length;i++){
	console.log('친구이름 :',obj.friends[i] );
}

//name:짹짹이,age: 1
obj.pets.push({name:'짹짹이',age:1});

//애완동물 목록,확장 for문 
for(let pet of obj.pets){
	console.log(`애완동물의 이름은 ${pet.name},나이는 ${pet.age}`);	
}

//애완동물 목록,확장 for문  화면출력.
// <table><thead> <tr><th/></thead><tbody>...</tbody></table>
let tblHtml='<table class="table">';
tblHtml +='<thead><tr><th>이름</th><th>나이</th></thead>';
tblHtml += '<tbody>';
for(let pet of obj.pets){
	console.log(`애완동물의 이름은 ${pet.name},나이는 ${pet.age}`);
	tblHtml +='<tr><td>'+pet.name+'</td><td>'+pet.age+'</td></tr>';
}
tblHtml +='</tbody></table>';
document.querySelector('nav+div.container-fluid').innerHTML +=tblHtml; //nav 다음 div class가 container-fluid 안 html에 출력

