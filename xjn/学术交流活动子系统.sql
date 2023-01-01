use education
go

create table activity
(
    id      int identity
        constraint activity_pk
            primary key,
    name    nvarchar(100),
    addr    nvarchar(100),
    adate   varchar(50),
    report  varchar(100),
    picture varchar(100),
    note    nvarchar(100),
    grad_id varchar(10),
    state   varchar(50)
)
go

INSERT INTO education.dbo.activity (name, addr, adate, report, picture, note, grad_id, state) VALUES (N'人工智能峰会', N'北京邮电大学', N'2022-8-9', N'报告', N'D:/', N'无', N'G001', N'已通过');
INSERT INTO education.dbo.activity (name, addr, adate, report, picture, note, grad_id, state) VALUES (N'大数据交流会', N'北京林业大学', N'2020-01-11', N'大数据', N'C:/User', N'很好', N'G001', N'导师审核通过');
INSERT INTO education.dbo.activity (name, addr, adate, report, picture, note, grad_id, state) VALUES (N'云计算研讨会', N'中科院计算所', N'2021-10-1', N'物联网', N'C:/picture', N'没问题', N'G001', N'待审核');

