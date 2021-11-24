INSERT INTO web_notice (notice_id, customer_email, notice_title, notice_content, notice_attribute) 
VALUES (SEQ_WEB_NOTICE.nextval, 'admin@naver.com', 'test 제목', 'test 내용', 'N');
INSERT INTO web_notice (notice_id, customer_email, notice_title, notice_content, notice_attribute) 
VALUES (SEQ_WEB_NOTICE.nextval, 'admin@naver.com', 'test 제목2', 'test 내용2', 'N');
INSERT INTO web_notice (notice_id, customer_email, notice_title, notice_content, notice_attribute) 
VALUES (SEQ_WEB_NOTICE.nextval, 'admin@naver.com', 'test 제목3', 'test 내용3', 'N');
INSERT INTO web_notice (notice_id, customer_email, notice_title, notice_content, notice_attribute) 
VALUES (SEQ_WEB_NOTICE.nextval, 'admin@naver.com', 'test 제목4', 'test 내용4', 'N');
INSERT INTO web_notice (notice_id, customer_email, notice_title, notice_content, notice_attribute) 
VALUES (SEQ_WEB_NOTICE.nextval, 'admin@naver.com', 'test 제목5', 'test 내용5', 'N');
INSERT INTO web_notice (notice_id, customer_email, notice_title, notice_content, notice_attribute) 
VALUES (SEQ_WEB_NOTICE.nextval, 'admin@naver.com', 'test 제목5test 제목5test 제목5test 제목5test 제목5test 제목5test 제목5test 제목5test 제목5test 제목5test 제목5test 제목5test 제목5test 제목5', 
  'test 내용5', 'A');
  
INSERT INTO web_notice (notice_id, customer_email, notice_title, notice_content, notice_attribute) 
VALUES (SEQ_WEB_NOTICE.nextval, 'admin@naver.com', '아 내가 해냈다', 
  'test 내용5', 'M');
  
commit;

select w.*,  c.customer_name customer_name, to_char(w.notice_writedate, 'YYYY-MM-DD HH24:MI:SS') notice_writetime
		from web_notice w, customer c
		where w.customer_email = c.customer_email;
    
select w.*,  c.customer_name customer_name
		from web_notice w, customer c
		where w.customer_email = c.customer_email;