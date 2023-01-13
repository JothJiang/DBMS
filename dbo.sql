/*
 Navicat Premium Data Transfer

 Source Server         : LWSQLSERVER
 Source Server Type    : SQL Server
 Source Server Version : 15002000
 Source Host           : DESKTOP-VCNOILB:1433
 Source Catalog        : Database_course_design
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 15002000
 File Encoding         : 65001

 Date: 11/01/2023 20:58:08
*/


-- ----------------------------
-- Table structure for achievement
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[achievement]') AND type IN ('U'))
	DROP TABLE [dbo].[achievement]
GO

CREATE TABLE [dbo].[achievement] (
  [id] int  NOT NULL,
  [type] varchar(30) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [detail_id] int  NOT NULL
)
GO

ALTER TABLE [dbo].[achievement] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [achievement]
-- ----------------------------
INSERT INTO [dbo].[achievement]  VALUES (N'1', N'Paper', N'7')
GO

INSERT INTO [dbo].[achievement]  VALUES (N'2', N'Reward', N'1')
GO

INSERT INTO [dbo].[achievement]  VALUES (N'3', N'Paper', N'1')
GO

INSERT INTO [dbo].[achievement]  VALUES (N'4', N'Paper', N'2')
GO

INSERT INTO [dbo].[achievement]  VALUES (N'5', N'Paper', N'3')
GO

INSERT INTO [dbo].[achievement]  VALUES (N'6', N'Paper', N'4')
GO

INSERT INTO [dbo].[achievement]  VALUES (N'7', N'Paper', N'5')
GO

INSERT INTO [dbo].[achievement]  VALUES (N'8', N'Paper', N'6')
GO

INSERT INTO [dbo].[achievement]  VALUES (N'9', N'Standard', N'1')
GO

INSERT INTO [dbo].[achievement]  VALUES (N'10', N'SoftwareHardwarePlatform', N'1')
GO


-- ----------------------------
-- Table structure for activity
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[activity]') AND type IN ('U'))
	DROP TABLE [dbo].[activity]
GO

CREATE TABLE [dbo].[activity] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [name] nvarchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [addr] nvarchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [adate] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [report] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [picture] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [note] nvarchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [grad_id] varchar(10) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [state] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[activity] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [activity]
-- ----------------------------
SET IDENTITY_INSERT [dbo].[activity] ON
GO

INSERT INTO [dbo].[activity] ([id], [name], [addr], [adate], [report], [picture], [note], [grad_id], [state]) VALUES (N'1', N'人工智能峰会', N'北京邮电大学', N'2022-8-9', N'报告', N'D:/', N'无', N'G001', N'已通过')
GO

INSERT INTO [dbo].[activity] ([id], [name], [addr], [adate], [report], [picture], [note], [grad_id], [state]) VALUES (N'2', N'大数据交流会', N'北京林业大学', N'2020-01-11', N'大数据', N'C:/User', N'很好', N'G001', N'导师审核通过')
GO

INSERT INTO [dbo].[activity] ([id], [name], [addr], [adate], [report], [picture], [note], [grad_id], [state]) VALUES (N'3', N'云计算研讨会', N'中科院计算所', N'2021-10-1', N'物联网', N'C:/picture', N'没问题', N'G001', N'待审核')
GO

SET IDENTITY_INSERT [dbo].[activity] OFF
GO


-- ----------------------------
-- Table structure for course
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[course]') AND type IN ('U'))
	DROP TABLE [dbo].[course]
GO

CREATE TABLE [dbo].[course] (
  [cno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [cname] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [ctype] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [cstu] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [cteacher] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [ctime] int  NULL,
  [cnum] int  NULL,
  [stunum] int  NULL
)
GO

ALTER TABLE [dbo].[course] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [course]
-- ----------------------------
INSERT INTO [dbo].[course]  VALUES (N'C001', N'英语', N'必修', N'本科', N'T001', N'64', N'1', N'160')
GO

INSERT INTO [dbo].[course]  VALUES (N'C002', N'数学', N'必修', N'研究生', N'T002', N'32', N'1', N'120')
GO

INSERT INTO [dbo].[course]  VALUES (N'C003', N'计算机', N'选修', N'本科', N'T002', N'70', N'1', N'65')
GO

INSERT INTO [dbo].[course]  VALUES (N'C004', N'离散数学', N'必修', N'本科生', N'T001', N'48', N'0', N'200')
GO

INSERT INTO [dbo].[course]  VALUES (N'C005', N'英语', N'必修', N'本科生', N'T001', N'24', N'1', N'60')
GO

INSERT INTO [dbo].[course]  VALUES (N'C006', N'数据库', N'必修', N'本科生', N'T001', N'36', N'0', N'100')
GO


-- ----------------------------
-- Table structure for depart
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[depart]') AND type IN ('U'))
	DROP TABLE [dbo].[depart]
GO

CREATE TABLE [dbo].[depart] (
  [dno] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [dname] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [dask] int  NULL
)
GO

ALTER TABLE [dbo].[depart] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for gc
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[gc]') AND type IN ('U'))
	DROP TABLE [dbo].[gc]
GO

CREATE TABLE [dbo].[gc] (
  [sno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [cno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [gstate] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [tevaluate] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[gc] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [gc]
-- ----------------------------
INSERT INTO [dbo].[gc]  VALUES (N'G001', N'C001', N'非常不错', NULL)
GO

INSERT INTO [dbo].[gc]  VALUES (N'G001', N'C002', N'很好', N'合格')
GO

INSERT INTO [dbo].[gc]  VALUES (N'G003', N'C003', N'不合格', N'不合格')
GO


-- ----------------------------
-- Table structure for manager
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[manager]') AND type IN ('U'))
	DROP TABLE [dbo].[manager]
GO

CREATE TABLE [dbo].[manager] (
  [mno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [pwd] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [mdepart] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[manager] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [manager]
-- ----------------------------
INSERT INTO [dbo].[manager]  VALUES (N'M001', N'001', N'D001')
GO

INSERT INTO [dbo].[manager]  VALUES (N'M002', N'002', N'D002')
GO


-- ----------------------------
-- Table structure for Other
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Other]') AND type IN ('U'))
	DROP TABLE [dbo].[Other]
GO

CREATE TABLE [dbo].[Other] (
  [other_id] int  NOT NULL,
  [other_name] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [other_type] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [other_time] date  NOT NULL,
  [other_contribution] int  NOT NULL,
  [other_proof] varchar(1000) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL
)
GO

ALTER TABLE [dbo].[Other] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Paper
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Paper]') AND type IN ('U'))
	DROP TABLE [dbo].[Paper]
GO

CREATE TABLE [dbo].[Paper] (
  [paper_id] int  NOT NULL,
  [paper_name] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [journal_name] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [paper_status] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [paper_time] date  NOT NULL,
  [index_type] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [paper_library] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [paper_proof] varchar(1000) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL
)
GO

ALTER TABLE [dbo].[Paper] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [Paper]
-- ----------------------------
INSERT INTO [dbo].[Paper]  VALUES (N'1', N'数据库技术', N'数据库期刊', N'录用未发表', N'2022-02-02', N'会议论文', N'学院高质量论文库', N'file')
GO

INSERT INTO [dbo].[Paper]  VALUES (N'2', N'数据库技术', N'数据库期刊', N'已发表', N'2022-02-02', N'学术会议', N'学院高质量论文库', N'file')
GO

INSERT INTO [dbo].[Paper]  VALUES (N'3', N'计算机论文', N'计算机期刊', N'录用未发表', N'2020-03-05', N'会议论文', N'学院核心论文库', N'file')
GO

INSERT INTO [dbo].[Paper]  VALUES (N'4', N'数据库', N'数据库期刊', N'已发表', N'2020-02-02', N'会议论文', N'学院核心论文库', N'file')
GO

INSERT INTO [dbo].[Paper]  VALUES (N'5', N'数据库理论', N'计算机期刊', N'录用未发表', N'2022-02-02', N'学术会议', N'学院高质量论文库', N'file')
GO

INSERT INTO [dbo].[Paper]  VALUES (N'6', N'数据库理论', N'计算机期刊', N'录用未发表', N'2022-01-01', N'会议论文', N'学院核心论文库', N'file')
GO

INSERT INTO [dbo].[Paper]  VALUES (N'7', N'计算机网络', N'计算机期刊', N'已发表', N'2022-02-02', N'学术会议', N'学院高质量论文库', N'file')
GO


-- ----------------------------
-- Table structure for Patent
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Patent]') AND type IN ('U'))
	DROP TABLE [dbo].[Patent]
GO

CREATE TABLE [dbo].[Patent] (
  [patent_id] int  NOT NULL,
  [patent_name] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [patent_type] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [patent_number] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [patent_deliverytime] date  NOT NULL,
  [patent_status] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [patent_contribution] int  NOT NULL,
  [patent_proof] varchar(1000) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL
)
GO

ALTER TABLE [dbo].[Patent] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Project_identification
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Project_identification]') AND type IN ('U'))
	DROP TABLE [dbo].[Project_identification]
GO

CREATE TABLE [dbo].[Project_identification] (
  [pid] int  IDENTITY(1,1) NOT NULL,
  [pnum] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [ptype] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [pname] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [ptime] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [pwork] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [pbudget] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [confirms] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [sno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [tno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[Project_identification] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'项目认定序号',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'pid'
GO

EXEC sp_addextendedproperty
'MS_Description', N'项目编号',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'pnum'
GO

EXEC sp_addextendedproperty
'MS_Description', N'项目类型',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'ptype'
GO

EXEC sp_addextendedproperty
'MS_Description', N'项目名称',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'pname'
GO

EXEC sp_addextendedproperty
'MS_Description', N'参与项目的时间',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'ptime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'承担工作',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'pwork'
GO

EXEC sp_addextendedproperty
'MS_Description', N'承担工作的折合经费（万元）',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'pbudget'
GO

EXEC sp_addextendedproperty
'MS_Description', N'项目负责人确认',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'confirms'
GO

EXEC sp_addextendedproperty
'MS_Description', N'学号',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'sno'
GO

EXEC sp_addextendedproperty
'MS_Description', N'导师编号',
'SCHEMA', N'dbo',
'TABLE', N'Project_identification',
'COLUMN', N'tno'
GO


-- ----------------------------
-- Records of [Project_identification]
-- ----------------------------
SET IDENTITY_INSERT [dbo].[Project_identification] ON
GO

INSERT INTO [dbo].[Project_identification] ([pid], [pnum], [ptype], [pname], [ptime], [pwork], [pbudget], [confirms], [sno], [tno]) VALUES (N'1', N'KC00001', N'国家自然科学基金项目', N'石漠化地区生态补偿机制建设研究', N'2020.6-2021.6', N'关键算法研究', N'6.20', N'已确认', N'G001', N'T001')
GO

INSERT INTO [dbo].[Project_identification] ([pid], [pnum], [ptype], [pname], [ptime], [pwork], [pbudget], [confirms], [sno], [tno]) VALUES (N'2', N'KC00002', N'国家软科学研究计划项目', N'jspm高校校园图书馆座位预约系统研究', N'2020.6-2021.6', N'关键算法研究', N'1.10', N'已确认', N'G002', N'T002')
GO

INSERT INTO [dbo].[Project_identification] ([pid], [pnum], [ptype], [pname], [ptime], [pwork], [pbudget], [confirms], [sno], [tno]) VALUES (N'3', N'KC00003', N'国家软科学研究计划项目', N'基于JSP的高校研招信息共享系统', N'2021.6-2022.6', N'数据分析', N'6.9', N'未确认', N'G003', N'T003')
GO

INSERT INTO [dbo].[Project_identification] ([pid], [pnum], [ptype], [pname], [ptime], [pwork], [pbudget], [confirms], [sno], [tno]) VALUES (N'5', N'KC00004', N'国家软科学研究计划项目', N'基于ssm-mysql新闻发布系统', N'2021.6-2022.6', N'数据分析', NULL, N'未确认', N'G003', N'T003')
GO

INSERT INTO [dbo].[Project_identification] ([pid], [pnum], [ptype], [pname], [ptime], [pwork], [pbudget], [confirms], [sno], [tno]) VALUES (N'8', N'KC00005', N'国家自然科学基金项目', N'绿色生态建设研究', N'2021.6-2022.6', N'数据探测', NULL, N'未确认', N'G004', N'T004')
GO

INSERT INTO [dbo].[Project_identification] ([pid], [pnum], [ptype], [pname], [ptime], [pwork], [pbudget], [confirms], [sno], [tno]) VALUES (N'9', N'KC00006', N'国家软科学研究计划项目', N'基于ssh智能CAI平台研发考试系统研究', N'2021.6-2022.6', N'代码整合', N'8', N'未确认', N'G001', N'T001')
GO

SET IDENTITY_INSERT [dbo].[Project_identification] OFF
GO


-- ----------------------------
-- Table structure for request
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[request]') AND type IN ('U'))
	DROP TABLE [dbo].[request]
GO

CREATE TABLE [dbo].[request] (
  [sno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [cno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [agree] varchar(1) COLLATE Chinese_PRC_90_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[request] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [request]
-- ----------------------------
INSERT INTO [dbo].[request]  VALUES (N'G001', N'C001', N'1')
GO

INSERT INTO [dbo].[request]  VALUES (N'G001', N'C002', N'1')
GO

INSERT INTO [dbo].[request]  VALUES (N'G002', N'C005', N'0')
GO

INSERT INTO [dbo].[request]  VALUES (N'G003', N'C003', N'1')
GO


-- ----------------------------
-- Table structure for reward
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[reward]') AND type IN ('U'))
	DROP TABLE [dbo].[reward]
GO

CREATE TABLE [dbo].[reward] (
  [reward_id] int  NOT NULL,
  [reward_name] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [reward_level] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [award_level] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [reward_rank] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [reward_time] date  NOT NULL,
  [reward_proof] varchar(1000) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL
)
GO

ALTER TABLE [dbo].[reward] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [reward]
-- ----------------------------
INSERT INTO [dbo].[reward]  VALUES (N'1', N'优秀学员', N'国家级', N'二等奖', N'3', N'2022-02-02', N'file')
GO


-- ----------------------------
-- Table structure for SoftwareHardwarePlatform
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[SoftwareHardwarePlatform]') AND type IN ('U'))
	DROP TABLE [dbo].[SoftwareHardwarePlatform]
GO

CREATE TABLE [dbo].[SoftwareHardwarePlatform] (
  [software_id] int  NOT NULL,
  [software_name] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [software_company] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [software_time] date  NOT NULL,
  [software_contribution] int  NOT NULL,
  [software_proof] varchar(1000) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL
)
GO

ALTER TABLE [dbo].[SoftwareHardwarePlatform] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [SoftwareHardwarePlatform]
-- ----------------------------
INSERT INTO [dbo].[SoftwareHardwarePlatform]  VALUES (N'1', N'管理平台', N'学校', N'2023-01-05', N'20', N'file')
GO


-- ----------------------------
-- Table structure for standard
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[standard]') AND type IN ('U'))
	DROP TABLE [dbo].[standard]
GO

CREATE TABLE [dbo].[standard] (
  [standard_id] int  NOT NULL,
  [standard_name] varchar(100) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [standard_level] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [standard_time] date  NOT NULL,
  [standard_proof] varchar(1000) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL
)
GO

ALTER TABLE [dbo].[standard] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [standard]
-- ----------------------------
INSERT INTO [dbo].[standard]  VALUES (N'1', N'标准', N'国家标准', N'2022-10-10', N'file')
GO


-- ----------------------------
-- Table structure for student
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[student]') AND type IN ('U'))
	DROP TABLE [dbo].[student]
GO

CREATE TABLE [dbo].[student] (
  [sno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [sname] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [sdepart] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [stype] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [pwd] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [mentor] varchar(255) COLLATE Chinese_PRC_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[student] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'导师',
'SCHEMA', N'dbo',
'TABLE', N'student',
'COLUMN', N'mentor'
GO


-- ----------------------------
-- Records of [student]
-- ----------------------------
INSERT INTO [dbo].[student]  VALUES (N'G001', N'轩轩', N'计算机', N'硕士研究生', N'001', N'张三')
GO

INSERT INTO [dbo].[student]  VALUES (N'G002', N'潇潇', N'艺术', N'博士研究生', N'002', N'李四')
GO

INSERT INTO [dbo].[student]  VALUES (N'G003', N'江江', N'考古', N'博士研究生', N'003', N'王五')
GO

INSERT INTO [dbo].[student]  VALUES (N'G004', N'欣欣', N'生态保护', N'硕士研究生', N'123', N'金达')
GO


-- ----------------------------
-- Table structure for student_achievement
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[student_achievement]') AND type IN ('U'))
	DROP TABLE [dbo].[student_achievement]
GO

CREATE TABLE [dbo].[student_achievement] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [sid] varchar(10) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [achievement_id] int  NOT NULL,
  [teacher_result] varchar(10) COLLATE Chinese_PRC_90_CS_AS_WS DEFAULT (N'待审核') NOT NULL,
  [manager_result] varchar(10) COLLATE Chinese_PRC_90_CS_AS_WS DEFAULT (N'待审核') NOT NULL
)
GO

ALTER TABLE [dbo].[student_achievement] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [student_achievement]
-- ----------------------------
SET IDENTITY_INSERT [dbo].[student_achievement] ON
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'2', N'G001', N'1', N'通过', N'不通过')
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'3', N'G001', N'2', N'不通过', N'待审核')
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'4', N'G002', N'3', N'不通过', N'待审核')
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'5', N'G002', N'4', N'通过', N'通过')
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'6', N'G003', N'5', N'不通过', N'待审核')
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'7', N'G003', N'6', N'通过', N'不通过')
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'8', N'G004', N'7', N'不通过', N'待审核')
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'9', N'G004', N'8', N'通过', N'通过')
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'10', N'G001', N'9', N'待审核', N'待审核')
GO

INSERT INTO [dbo].[student_achievement] ([id], [sid], [achievement_id], [teacher_result], [manager_result]) VALUES (N'11', N'G001', N'10', N'待审核', N'待审核')
GO

SET IDENTITY_INSERT [dbo].[student_achievement] OFF
GO


-- ----------------------------
-- Table structure for teacher
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[teacher]') AND type IN ('U'))
	DROP TABLE [dbo].[teacher]
GO

CREATE TABLE [dbo].[teacher] (
  [tno] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [pwd] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [tname] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[teacher] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [teacher]
-- ----------------------------
INSERT INTO [dbo].[teacher]  VALUES (N'T001', N'001', N'张三')
GO

INSERT INTO [dbo].[teacher]  VALUES (N'T002', N'002', N'李四')
GO

INSERT INTO [dbo].[teacher]  VALUES (N'T003', N'003', N'王五')
GO

INSERT INTO [dbo].[teacher]  VALUES (N'T004', N'004', N'金达')
GO


-- ----------------------------
-- Table structure for TeachingBooks
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[TeachingBooks]') AND type IN ('U'))
	DROP TABLE [dbo].[TeachingBooks]
GO

CREATE TABLE [dbo].[TeachingBooks] (
  [tb_id] int  NOT NULL,
  [tb_name] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [tb_publisher] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [tb_publicationtime] date  NOT NULL,
  [tb_contribution] int  NOT NULL,
  [tb_proof] varchar(1000) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL
)
GO

ALTER TABLE [dbo].[TeachingBooks] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Train_administrator
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Train_administrator]') AND type IN ('U'))
	DROP TABLE [dbo].[Train_administrator]
GO

CREATE TABLE [dbo].[Train_administrator] (
  [tano] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NOT NULL,
  [pwd] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [taname] varchar(50) COLLATE Chinese_PRC_90_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[Train_administrator] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'研究生培养管理员编号',
'SCHEMA', N'dbo',
'TABLE', N'Train_administrator',
'COLUMN', N'tano'
GO

EXEC sp_addextendedproperty
'MS_Description', N'密码',
'SCHEMA', N'dbo',
'TABLE', N'Train_administrator',
'COLUMN', N'pwd'
GO

EXEC sp_addextendedproperty
'MS_Description', N'姓名',
'SCHEMA', N'dbo',
'TABLE', N'Train_administrator',
'COLUMN', N'taname'
GO


-- ----------------------------
-- Records of [Train_administrator]
-- ----------------------------
INSERT INTO [dbo].[Train_administrator]  VALUES (N'TA001', N'123', N'王丽')
GO

INSERT INTO [dbo].[Train_administrator]  VALUES (N'TA002', N'123', N'金华')
GO


-- ----------------------------
-- Checks structure for table achievement
-- ----------------------------
ALTER TABLE [dbo].[achievement] ADD CONSTRAINT [CK_Achievement_type] CHECK ([type]='Paper' OR [type]='Patent' OR [type]='Report' OR [type]='Reward' OR [type]='SoftwareHardwarePlatform' OR [type]='Standard' OR [type]='Other' OR [type]='TeachingBooks')
GO


-- ----------------------------
-- Primary Key structure for table activity
-- ----------------------------
ALTER TABLE [dbo].[activity] ADD CONSTRAINT [activity_pk] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table course
-- ----------------------------
ALTER TABLE [dbo].[course] ADD CONSTRAINT [PK__course__D83617553C775213] PRIMARY KEY CLUSTERED ([cno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table depart
-- ----------------------------
ALTER TABLE [dbo].[depart] ADD CONSTRAINT [PK__depart__D876095CEB8B3A2F] PRIMARY KEY CLUSTERED ([dno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table gc
-- ----------------------------
ALTER TABLE [dbo].[gc] ADD CONSTRAINT [PK__gc__905C053340D74CFE] PRIMARY KEY CLUSTERED ([sno], [cno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table manager
-- ----------------------------
ALTER TABLE [dbo].[manager] ADD CONSTRAINT [PK__manager__DF50C617D9826679] PRIMARY KEY CLUSTERED ([mno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Other
-- ----------------------------
ALTER TABLE [dbo].[Other] ADD CONSTRAINT [PK_Other] PRIMARY KEY CLUSTERED ([other_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Checks structure for table Paper
-- ----------------------------
ALTER TABLE [dbo].[Paper] ADD CONSTRAINT [CK_paper_library] CHECK ([paper_library]='学院高质量论文库' OR [paper_library]='学院核心论文库')
GO

ALTER TABLE [dbo].[Paper] ADD CONSTRAINT [CK_paper_status] CHECK ([paper_status]='录用未发表' OR [paper_status]='已发表')
GO


-- ----------------------------
-- Primary Key structure for table Paper
-- ----------------------------
ALTER TABLE [dbo].[Paper] ADD CONSTRAINT [PK_论文] PRIMARY KEY CLUSTERED ([paper_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Checks structure for table Patent
-- ----------------------------
ALTER TABLE [dbo].[Patent] ADD CONSTRAINT [CK_patent_type] CHECK ([patent_type]='发明专利' OR [patent_type]='实用新型专利')
GO


-- ----------------------------
-- Primary Key structure for table Patent
-- ----------------------------
ALTER TABLE [dbo].[Patent] ADD CONSTRAINT [PK_Patent] PRIMARY KEY CLUSTERED ([patent_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Project_identification
-- ----------------------------
ALTER TABLE [dbo].[Project_identification] ADD CONSTRAINT [PK__Project___DD37D91AC534C376] PRIMARY KEY CLUSTERED ([pid])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table request
-- ----------------------------
ALTER TABLE [dbo].[request] ADD CONSTRAINT [PK__request__905C0533F61F2168] PRIMARY KEY CLUSTERED ([sno], [cno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Checks structure for table reward
-- ----------------------------
ALTER TABLE [dbo].[reward] ADD CONSTRAINT [CK_award_level] CHECK ([award_level]='特等奖' OR [award_level]='一等奖' OR [award_level]='二等奖' OR [award_level]='三等奖')
GO

ALTER TABLE [dbo].[reward] ADD CONSTRAINT [CK_reward_level] CHECK ([reward_level]='国家级' OR [reward_level]='省部级' OR [reward_level]='市级' OR [reward_level]='其他')
GO


-- ----------------------------
-- Primary Key structure for table reward
-- ----------------------------
ALTER TABLE [dbo].[reward] ADD CONSTRAINT [PK_奖励] PRIMARY KEY CLUSTERED ([reward_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table SoftwareHardwarePlatform
-- ----------------------------
ALTER TABLE [dbo].[SoftwareHardwarePlatform] ADD CONSTRAINT [PK_SoftwareHardwarePlatform_1] PRIMARY KEY CLUSTERED ([software_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Checks structure for table standard
-- ----------------------------
ALTER TABLE [dbo].[standard] ADD CONSTRAINT [CK_standard_level] CHECK ([standard_level]='国家标准' OR [standard_level]='省部级地方标准' OR [standard_level]='行业标准' OR [standard_level]='团队标准')
GO


-- ----------------------------
-- Primary Key structure for table standard
-- ----------------------------
ALTER TABLE [dbo].[standard] ADD CONSTRAINT [PK_标准] PRIMARY KEY CLUSTERED ([standard_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table student
-- ----------------------------
ALTER TABLE [dbo].[student] ADD CONSTRAINT [PK__student__DDDF6446F7CE25F3] PRIMARY KEY CLUSTERED ([sno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Checks structure for table student_achievement
-- ----------------------------
ALTER TABLE [dbo].[student_achievement] ADD CONSTRAINT [CK_manager_result] CHECK ([manager_result]='通过' OR [manager_result]='不通过' OR [manager_result]='待审核')
GO

ALTER TABLE [dbo].[student_achievement] ADD CONSTRAINT [CK_teacher_result] CHECK ([teacher_result]='通过' OR [teacher_result]='不通过' OR [teacher_result]='待审核')
GO


-- ----------------------------
-- Primary Key structure for table student_achievement
-- ----------------------------
ALTER TABLE [dbo].[student_achievement] ADD CONSTRAINT [PK_student_achievement] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table teacher
-- ----------------------------
ALTER TABLE [dbo].[teacher] ADD CONSTRAINT [PK__teacher__DC10824F70C6E918] PRIMARY KEY CLUSTERED ([tno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table TeachingBooks
-- ----------------------------
ALTER TABLE [dbo].[TeachingBooks] ADD CONSTRAINT [PK_TeachingBooks_1] PRIMARY KEY CLUSTERED ([tb_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Train_administrator
-- ----------------------------
ALTER TABLE [dbo].[Train_administrator] ADD CONSTRAINT [PK__Train_ad__E5F942861B4F7659] PRIMARY KEY CLUSTERED ([tano])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table gc
-- ----------------------------
ALTER TABLE [dbo].[gc] ADD CONSTRAINT [FK__gc__sno__0C85DE4D] FOREIGN KEY ([sno]) REFERENCES [student] ([sno]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO


-- ----------------------------
-- Foreign Keys structure for table Project_identification
-- ----------------------------
ALTER TABLE [dbo].[Project_identification] ADD CONSTRAINT [sno] FOREIGN KEY ([sno]) REFERENCES [student] ([sno]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[Project_identification] ADD CONSTRAINT [tno] FOREIGN KEY ([tno]) REFERENCES [teacher] ([tno]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

