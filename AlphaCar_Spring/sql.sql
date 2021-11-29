insert into web_notice(notice_id, customer_email , notice_title, notice_content, notice_attribute)
values (SEQ_WEB_NOTICE.nextval, 'a', '테스트로 작성한 공지사항 입니다', '작성한 글','A');
insert into web_notice(notice_id, customer_email , notice_title, notice_content, notice_attribute)
values (SEQ_WEB_NOTICE.nextval, 'a', '운영자가 작성한 공지사항 입니다', '본문','A');

commit;

select c.*, (select customer_name from customer where customer_email = c.customer_email) customer_name
		from web_notice_coment c
		where notice_id = 238
		order by COMENT_WRITEDATE;
    
ALTER TABLE store_file
ADD CONSTRAINT store_delete_cascade
  FOREIGN KEY (store_number)
  REFERENCES store(store_number)
  ON DELETE CASCADE;    
    
delete 
from store
where store_number = 131;



