CREATE TABLE EMPLOYEE
(
EMPLOYEE_ID         VARCHAR(10)                                            NOT NULL,
FIRST_NAME          VARCHAR(20)                                           NOT NULL,
LAST_NAME           VARCHAR(20)                                           NOT NULL,
ADDRESS              VARCHAR(150)                                          NOT NULL,
ACTIVE_IND           VARCHAR(1)               DEFAULT 'Y'                  NOT NULL,
LAST_UPDATED_USERID  VARCHAR(20)                                            NOT NULL,
LAST_UPDATED_TMSTMP      TIMESTAMP WITH TIME ZONE DEFAULT SYSDATE            NOT NULL
);