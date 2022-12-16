--���̺� �ʱ�ȭ(����)
drop table "SCOTT"."CONTENT_TABLE";
drop table "SCOTT"."USER_TABLE";
drop table "SCOTT"."BOARD_INFO_TABLE";

DROP SEQUENCE user_seq;
DROP SEQUENCE content_seq;

COMMIT;

-- ���̺� ����
create sequence user_seq
start with 1
increment by 1
minvalue 1;

create sequence content_seq
start with 1
increment by 1
minvalue 1;

create table board_info_table(
	board_info_idx number constraint BOARD_INFO_PK primary key,
	board_info_name varchar2(500) not null
);

insert into board_info_table(board_info_idx, board_info_name) values (1, '�����Խ���');
insert into board_info_table(board_info_idx, board_info_name) values (2, '���ӰԽ���');
insert into board_info_table(board_info_idx, board_info_name) values (3, '��ġ�Խ���');
insert into board_info_table(board_info_idx, board_info_name) values (4, '�������Խ���');

commit;

create table user_table(
	user_idx number constraint USER_PK primary key,
	user_name varchar2(50) not null,
	user_id varchar2(100) not null,
	user_pw varchar2(100) not null
);

create table content_table(
	content_idx number constraint CONTENT_PK primary key,
	content_subject varchar2(500) not null,
	content_text long not null,
	content_file varchar2(500),
	content_writer_idx number not null
	                   constraint CONTENT_FK1 references user_table(user_idx),
	content_board_idx number not null
	                  constraint CONTENT_FK2 references board_info_table(board_info_idx),
	content_date date not null
);

commit;
--select  t1.content_idx, t1.content_subject, t2.user_name as content_writer_name, 
--        to_char(t1.content_date, 'YYYY-MM-DD') as content_date 
--        from content_table t1
--        JOIN user_table t2 
--        ON t1.content_writer_idx = t2.user_idx
--        and t1.content_board_idx = 1 order by 1 desc;

