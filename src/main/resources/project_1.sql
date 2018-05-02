CREATE TABLE EMPLOYEE (
    e_email VARCHAR2(300) PRIMARY KEY,
    e_username VARCHAR2(100) UNIQUE NOT NULL,
    e_password VARCHAR2(100) NOT NULL,
    e_first_name VARCHAR2(100) NOT NULL,
    e_last_name VARCHAR2(100) NOT NULL
);

CREATE TABLE MANAGER (
    m_email VARCHAR2(300) PRIMARY KEY,
    m_username VARCHAR2(100) UNIQUE NOT NULL,
    m_password VARCHAR2(100) NOT NULL,
    m_first_name VARCHAR2(100) NOT NULL,
    m_last_name VARCHAR2(100) NOT NULL
);

CREATE TABLE REQUEST (
    r_id INTEGER PRIMARY KEY,
    r_amount NUMBER(7,2) CHECK (r_amount < 10000 AND r_amount > 0) NOT NULL,
    r_requester VARCHAR2(300) NOT NULL,
    r_reviewed_by VARCHAR2(300),
    r_status VARCHAR2(100) DEFAULT 'Pending Approval',
    r_image VARCHAR2(300),
    r_purpose NCLOB,
    r_request_date DATE DEFAULT sysdate,
    r_review_date DATE,
    CONSTRAINT fk_r_requester FOREIGN KEY (r_requester) REFERENCES EMPLOYEE(e_email),
    CONSTRAINT fk_r_reviewed_by FOREIGN KEY (r_reviewed_by) REFERENCES MANAGER(m_email)
);

CREATE OR REPLACE PROCEDURE insert_employee(email IN VARCHAR2, username IN VARCHAR2, password IN VARCHAR2, first IN VARCHAR2, last IN VARCHAR2)
AS 
BEGIN
    INSERT INTO EMPLOYEE VALUES(email,username,password,first,last);
END;
/

CREATE OR REPLACE PROCEDURE insert_manager(email IN VARCHAR2, username IN VARCHAR2, password IN VARCHAR2, first IN VARCHAR2, last IN VARCHAR2)
AS 
BEGIN
    INSERT INTO MANAGER VALUES(email,username,password,first,last);
END;
/

CREATE SEQUENCE requestIDSequence
    MINVALUE 0
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE OR REPLACE TRIGGER generate_id
BEFORE INSERT ON REQUEST
FOR EACH ROW
BEGIN
  SELECT requestIDSequence.NEXTVAL
  INTO   :new.r_id
  FROM   dual;
END;
/

CREATE OR REPLACE PROCEDURE insert_request(amount IN NUMBER, requester IN VARCHAR2)
AS 
BEGIN
    INSERT INTO REQUEST(r_amount,r_requester,r_reviewed_by,r_status) VALUES(amount,requester,reviewer,status);
END;
/

exec insert_employee('test requester','test requester','password','first','last');
exec insert_manager('test reviewer','test reviewer','password','first','last');
exec insert_request(1000,'test requester');

CREATE OR REPLACE PROCEDURE resolve_request(id IN VARCHAR2, status IN VARCHAR2)
AS 
BEGIN
    UPDATE REQUEST SET r_status = status WHERE r_id = id;
END;
/

create or replace PROCEDURE update_employee(email in VARCHAR2, username IN VARCHAR2, first IN VARCHAR2, last IN VARCHAR2)
AS 
BEGIN
    UPDATE EMPLOYEE SET e_email = email, e_username = username, e_first_name = first, e_last_name = last WHERE e_email=email;
END;


