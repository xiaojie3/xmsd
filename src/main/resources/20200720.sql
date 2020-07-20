create table WEBLOG
(
  id         VARCHAR2(32),
  url        VARCHAR2(200),
  method     VARCHAR2(100),
  ip         VARCHAR2(30),
  type       VARCHAR2(10),
  parameters VARCHAR2(200),
  ret        VARCHAR2(1000),
  time       VARCHAR2(10),
  userid     VARCHAR2(32)
);

-- Add/modify columns 
alter table WEBLOG modify time VARCHAR2(20);
alter table WEBLOG add cost VARCHAR2(10);