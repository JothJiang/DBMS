/*
 Navicat Premium Data Transfer

 Source Server         : text
 Source Server Type    : SQL Server
 Source Server Version : 15004249
 Source Host           : localhost:1433
 Source Catalog        : assistant
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 15004249
 File Encoding         : 65001

 Date: 31/12/2022 18:26:18
*/


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
-- Records of course
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[course] VALUES (N'C001', N'英语', N'必修', N'本科', N'T001', N'64', N'1', N'160')
GO

INSERT INTO [dbo].[course] VALUES (N'C002', N'数学', N'必修', N'研究生', N'T002', N'32', N'1', N'120')
GO

INSERT INTO [dbo].[course] VALUES (N'C003', N'计算机', N'选修', N'本科', N'T002', N'70', N'1', N'65')
GO

INSERT INTO [dbo].[course] VALUES (N'C004', N'离散数学', N'必修', N'本科生', N'T001', N'48', N'0', N'200')
GO

INSERT INTO [dbo].[course] VALUES (N'C005', N'英语', N'必修', N'本科生', N'T001', N'24', N'1', N'60')
GO

INSERT INTO [dbo].[course] VALUES (N'C006', N'数据库', N'必修', N'本科生', N'T001', N'36', N'0', N'100')
GO

COMMIT
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
-- Records of depart
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[depart] VALUES (N'D001', N'计算机', N'0')
GO

INSERT INTO [dbo].[depart] VALUES (N'D002', N'艺术', N'0')
GO

COMMIT
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
-- Records of gc
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[gc] VALUES (N'G001', N'C001', N'非常不错', NULL)
GO

INSERT INTO [dbo].[gc] VALUES (N'G001', N'C002', N'很好', N'合格')
GO

INSERT INTO [dbo].[gc] VALUES (N'G003', N'C003', N'不合格', N'不合格')
GO

COMMIT
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
-- Records of manager
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[manager] VALUES (N'M001', N'001', N'D001')
GO

INSERT INTO [dbo].[manager] VALUES (N'M002', N'002', N'D002')
GO

COMMIT
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
-- Records of request
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[request] VALUES (N'G001', N'C001', N'1')
GO

INSERT INTO [dbo].[request] VALUES (N'G001', N'C002', N'1')
GO

INSERT INTO [dbo].[request] VALUES (N'G002', N'C005', N'0')
GO

INSERT INTO [dbo].[request] VALUES (N'G003', N'C003', N'1')
GO

COMMIT
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
  [pwd] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[student] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[student] VALUES (N'G001', N'轩轩', N'D001', N'硕士研究生', N'001')
GO

INSERT INTO [dbo].[student] VALUES (N'G002', N'潇潇', N'D002', N'博士研究生', N'002')
GO

INSERT INTO [dbo].[student] VALUES (N'G003', N'江江', N'D001', N'博士研究生', N'003')
GO

COMMIT
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
  [tname] varchar(20) COLLATE Chinese_PRC_90_CS_AS_WS  NULL,
  [tdeaprt] varchar(255) COLLATE Chinese_PRC_90_CS_AS_WS  NULL
)
GO

ALTER TABLE [dbo].[teacher] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[teacher] VALUES (N'T001', N'001', N'张三', N'D001')
GO

INSERT INTO [dbo].[teacher] VALUES (N'T002', N'002', N'李四', N'D002')
GO

COMMIT
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
-- Primary Key structure for table request
-- ----------------------------
ALTER TABLE [dbo].[request] ADD CONSTRAINT [PK__request__905C0533F61F2168] PRIMARY KEY CLUSTERED ([sno], [cno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table student
-- ----------------------------
ALTER TABLE [dbo].[student] ADD CONSTRAINT [PK__student__DDDF6446FEBD20BC] PRIMARY KEY CLUSTERED ([sno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table teacher
-- ----------------------------
ALTER TABLE [dbo].[teacher] ADD CONSTRAINT [PK__teacher__DC10824FA5070047] PRIMARY KEY CLUSTERED ([tno])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table gc
-- ----------------------------
ALTER TABLE [dbo].[gc] ADD CONSTRAINT [FK__gc__sno__0C85DE4D] FOREIGN KEY ([sno]) REFERENCES [dbo].[student] ([sno]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

