-- member 테이블 생성
create table member(	
	userid varchar2(15) primary key,
	password varchar2(20) not null,
	name nvarchar2(10) not null,
	genger nvarchar2(2) not null,
	email varchar2(50) not null
);

insert into member values('hong123', 'hong123@', '홍길동', '남', 'hong@gmail.com');

select * from member;