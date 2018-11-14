/*
Navicat SQL Server Data Transfer

Source Server         : localSQLServer
Source Server Version : 110000
Source Host           : 127.0.0.1:1433
Source Database       : testSS
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 110000
File Encoding         : 65001

Date: 2018-11-13 17:23:52
*/


-- ----------------------------
-- Table structure for efiles
-- ----------------------------
DROP TABLE [dbo].[efiles]
GO
CREATE TABLE [dbo].[efiles] (
[id] varchar(50) NOT NULL ,
[savePath] varchar(255) NULL 
)


GO

-- ----------------------------
-- Records of efiles
-- ----------------------------
INSERT INTO [dbo].[efiles] ([id], [savePath]) VALUES (N'1', N'E:\\files\\heros.xlsx')
GO
GO
INSERT INTO [dbo].[efiles] ([id], [savePath]) VALUES (N'2', N'E:\\files\\hxgc.xlsx')
GO
GO
INSERT INTO [dbo].[efiles] ([id], [savePath]) VALUES (N'3', N'E:\\files\\hxgc2.xlsx')
GO
GO
INSERT INTO [dbo].[efiles] ([id], [savePath]) VALUES (N'4', N'E:\\files\\关键件表 CN180C_河西工厂_201809.xlsx')
GO
GO

-- ----------------------------
-- Table structure for hero
-- ----------------------------
DROP TABLE [dbo].[hero]
GO
CREATE TABLE [dbo].[hero] (
[hid] varchar(50) NOT NULL ,
[hname] varchar(255) NULL ,
[hability] varchar(255) NULL 
)


GO

-- ----------------------------
-- Records of hero
-- ----------------------------
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'21bcd42377fb43f8b20830b6ac8a5ed6', N'EGR(排气再循环)', N'是')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'6a07b8d39dff44c1be46a148c8273c1e', N'EGR(排气再循环)', N'●')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'6f8f147498da471bb5dcd5fa16d56a1b', N'McRee', N'否')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'717941b5d7594d0eba69081fc1d1793a', N'Bob', N'是')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'72e01abe7bcb4a1a8c335e09c90f1459', N'Bob', N'●')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'9434659652c54b1fa5b1e8bd06c92aad', N'McRee', null)
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'b9c63aab7df04569b98778773bf39442', N'www', N'●')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'c3320ca316724a6d821769d1d753e50c', N'123.0', N'是')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'c7a3c2203a194c17977de60c8a147413', N'123.0', N'是')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'cb4f68de280247a1bd0137ee9ee83a51', N'www', N'●')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'cf736dad87a74a9bae9ac7600411bffc', N'McRee', null)
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'dbdd8b36051a4bf3b642f112f5c73ca0', N'EGR(排气再循环)', N'●')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'e1ddff863bac4ee0ac2927fa326e424e', N'www', N'是')
GO
GO
INSERT INTO [dbo].[hero] ([hid], [hname], [hability]) VALUES (N'fd55560839f448fc92b999007924badc', N'Bob', N'●')
GO
GO

-- ----------------------------
-- Table structure for newkeypart
-- ----------------------------
DROP TABLE [dbo].[newkeypart]
GO
CREATE TABLE [dbo].[newkeypart] (
[id] varchar(50) NOT NULL ,
[partName] varchar(255) NULL ,
[isNoticed] varchar(255) NULL ,
[isccc] varchar(255) NULL ,
[isEnvironmentalProtection] varchar(255) NULL ,
[iscccCertificate] varchar(255) NULL ,
[specification] varchar(255) NULL ,
[trademark] varchar(255) NULL ,
[productionEnterprise] varchar(255) NULL ,
[cccCertificateNumber] varchar(255) NULL ,
[applicableCarType] varchar(255) NULL ,
[responsibilityDepartment] varchar(255) NULL ,
[isSigned] varchar(255) NULL ,
[isAddModel] varchar(255) NULL ,
[cccApplyingWay] varchar(255) NULL ,
[positionDescription] varchar(255) NULL ,
[RecordApplyingWay] varchar(255) NULL ,
[zhPartName] varchar(255) NULL ,
[partNumber] varchar(255) NULL ,
[euPartName] varchar(255) NULL ,
[vpps] varchar(255) NULL ,
[upc] varchar(255) NULL ,
[fna] varchar(255) NULL ,
[engineerSign] varchar(255) NULL ,
[directorSign] varchar(255) NULL 
)


GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'newkeypart', 
'COLUMN', N'id')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'主键'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'newkeypart'
, @level2type = 'COLUMN', @level2name = N'id'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'主键'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'newkeypart'
, @level2type = 'COLUMN', @level2name = N'id'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'newkeypart', 
'COLUMN', N'partName')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'零件名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'newkeypart'
, @level2type = 'COLUMN', @level2name = N'partName'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'零件名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'newkeypart'
, @level2type = 'COLUMN', @level2name = N'partName'
GO

-- ----------------------------
-- Records of newkeypart
-- ----------------------------
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'06998818400d498588fd7ab3a5e6c5eb', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-FYBB-ST-01', N'', N'柳州双英科技有限公司', N'2014011111671417', N'ALL', N'EI', N'', N'Y', N'模压', N'零件内表面', N'模压', N'副仪表板总成', N'23964935', N'CONSOLE ASM-F/FLR', N'40.01.03.01', N'1C1J', N'3951C', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'0c304efefcf044cbb5c1ff6f549278d5', N'仪表板（型号/材料/生产企业）', N'是', N'是', N'否', N'否', N'CN180C-YBB-UT-01', N'', N'佛吉亚（柳州）汽车内饰系统有限公司', N'2016091111005256', N'All', N'EI', N'', N'', N'模刻', N'仪表板本体背面', N'模压', N'仪表板组件', N'23908242', N'PANEL-INST', N'40.01.02.25', N'1A2B', N'0050A', N'', N'18026')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'0c55c537721f42b7aa5410b692eb5be8', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-ZYB-UT-01', N'', N'柳州市风华汽车装饰件厂', N'2015011111768574', N'ALL', N'EI', N'Y', N'Y', N'模压', N'轴座表面', N'粘贴', N'遮阳板总成', N'23909513
23909519', N'SUNSHADE ASM-.', N'40.03.03.04.01', N'1C3J', N'3300A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'15c1ee1fe5aa4d91a8fb0da8a6a21fe8', N'座椅蒙皮的材料', N'是', N'是', N'否', N'否', N'CN180C-ZYMT-S-01', N'', N'旷达汽车饰件有限公司', N'', N'LZW7123CAYA', N'EI', N'', N'N/A', N'', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'19d8b3f4f7c34c5eba155db03110152f', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-ZYB-BS-01', N'', N'柳州市风华汽车装饰件厂', N'2015011111768574', N'ALL', N'EI', N'Y', N'Y', N'模压', N'轴座表面', N'粘贴', N'遮阳板总成', N'23980489
23919079
23980491', N'SUNSHADE ASM-.', N'40.03.03.04.01', N'1C3J', N'3300A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'25e91add6dc14c0fa207a9e6da23275f', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-ZCH-BS-01', N'', N'柳州福瑞特汽车零部件有限公司', N'2016011111841483', N'All', N'EI', N'Y', N'Y', N'粘贴', N'零件背面', N'粘贴', N'后备箱左/右支撑盒', N'23983084/23983086', N'SUPPORT-R/COMPT FLR PNL TR', N'40.03.05.98', N'1C1M', N'1000K', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'26d0b4c261b349ad9a682e6ac15fe776', N'天线', N'是', N'是', N'否', N'否', N'QT-1300', N'', N'柳州盛泰汽车部件有限公司', N'', N'LZW7123CAYA', N'HVAC', N'', N'Y', N'', N'底座上', N'模具上', N'天线总成', N'24510001', N'ANTENNA ASM-RDO ECCN = 5A991', N'70.04.01.01', N'12L', N'0900A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'2a4e455c73f04d108aeb207dedc7d9d8', N'车轴（第2轴）', N'是', N'是', N'否', N'否', N'AXL300', N'', N'柳州五菱汽车工业有限公司', N'', N'All', N'CH', N'N/A', N'N', N'', N'贴在扭梁上', N'条形码', N'后悬架总成（带制动器）', N'23528690', N'SUSPENSION ASM-RR(W/BRK)', N'20.02.02.98', N'4D', N'8900B', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'30da578ee43c4895b70213cd0f7c9590', N'转向锁总成（防盗装置）', N'是', N'否', N'否', N'否', N'ESCL0001', N'', N'苏州瑞延电子科技有限公司', N'', N'LZW7123CAYA', N'CE', N'', N'Y', N'', N'锁体上', N'模压', N'转向锁总成', N'24565702', N'LOCK ASM-STRGCOLELEK', N'20.01.04.98', N'9A', N'2675A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'3455663745bd47c5a7355eaaa243dae1', N'宝骏商标牌（后标）', N'否', N'否', N'否', N'否', N'CN180C-SBP-RT-01', N'', N'慈溪市斌晨塑料制品有限公司', N'', N'All', N'EI', N'', N'Y', N'', N'在标牌本体的后侧', N'将字体刻到模具上，通过注塑的方式施加', N'后部商标牌', N'23914070', N'EMBLEM ASM-L/GATE', N'60.09.06.01', N'1C6N', N'0840A', N'', N'18025')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'39def9a2393144eca67aab4ee959af74', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-HDT-BS-01', N'', N'柳州市富英华工贸有限公司洛满生产基地', N'2016011111855748', N'All', N'EI', N'Y', N'Y', N'粘贴', N'零件背面', N'粘贴', N'后备箱地毯', N'23983081', N'CARPET ASM-R/CMPT FLR PNL<SEE GUIDE/CONTACT BFO>', N'40.03.05.01', N'1C1M', N'1000A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'458be4e2930740c38879d10ad2d0127c', N'轮胎', N'是', N'是', N'是', N'是', N'165/70R14', N'', N'广西玲珑轮胎有限公司', N'2015061201000037', N'ALL', N'CH', N'Y', N'Y', N'模压', N'轮胎胎侧', N'模压', N'165/70R14轮胎总成', N'23890616', N'TIRE-165/70R14 N HWY TL BW', N'20.03.01.01', N'10B', N'2885K', N'', N'18010，')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'57881c6c73a7469d818f09c28d3dfa15', N'座椅蒙皮的材料', N'是', N'是', N'否', N'否', N'CN180C-ZYMT-F-06', N'', N'瑞安市李尔汽车面料有限公司上海分公司', N'', N'LZW7123CAYA', N'EI', N'', N'N/A', N'', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'60422241d36c45d3a92a60d83400f587', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-HDT-UT-01', N'', N'柳州市富英华工贸有限公司洛满生产基地', N'2016011111853705', N'All', N'EI', N'Y', N'Y', N'粘贴', N'零件背面', N'粘贴', N'后备箱地毯', N'23983083', N'CARPET ASM-R/CMPT FLR PNL<SEE GUIDE/CONTACT BFO>', N'40.03.05.01', N'1C1M', N'1000A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'6b2a9888b7d847cb87a5cff0c6a2d7a0', N'中文厂标牌', N'否', N'否', N'否', N'否', N'CN180C-CBP-01', N'', N'慈溪市斌晨塑料制品有限公司', N'', N'All', N'EI', N'', N'N', N'', N'N/A', N'N/A', N'中文厂标牌', N'23868026', N'PLATE ASM-L/GATE VEH NA', N'60.09.06.07', N'1C6N', N'0830A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'73d2f94271824dbeba55ffc8dff0f141', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'MFSM-UT-02', N'', N'武汉凯利塑料有限责任公司 ', N'2016011111852856', N'All', N'EI', N'', N'Y', N'粘贴', N'包装袋', N'粘贴', N'前门防水薄膜组件，后侧门防水薄膜组件', N'23909322/23928973/23908118/23956398/23917687', N'DEFLECTOR ASM-FRT S/D WAT', N'55.01.01.06.05', N'1C5K', N'0200A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'77ab639d6eab4f76a7731d48defa7055', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-ZYB-BS-01', N'', N'宁波市阳光汽车配件有限公司', N'2015091111003298', N'ALL', N'EI', N'Y', N'Y', N'模压', N'轴座表面', N'粘贴', N'遮阳板总成', N'23980489
23919079
23980491', N'SUNSHADE ASM-.', N'40.03.03.04.01', N'1C3J', N'3300A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'7c8e099785384a5a8ab3bf587bc1828c', N'座椅蒙皮的材料', N'是', N'是', N'否', N'否', N'CN180C-ZYMT-F-02', N'', N'广东天安新材料股份有限公司', N'', N'LZW7123CAYA', N'EI', N'', N'N/A', N'', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'8b677c73316b48bc86c211f8770a1780', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-WGY-UT-01', N'', N'柳州环球汽车内饰件有限公司', N'2016091111005471', N'All', N'EI', N'Y', N'Y', N'粘贴', N'零件背面', N'粘贴', N'前围外隔音垫', N'23909546', N'INSULATOR-DA PNL OTR', N'40.05.01.07', N'1C2K', N'1010B', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'9027cbbd42074a4387cb17a5be04e073', N'EGR(排气再循环)', N'是', N'是', N'是', N'否', N'BE', N'', N'无锡隆盛科技股份有限公司', N'', N'LZW7123CAYA', N'EH', N'', N'Y', N'', N'外壳', N'打刻', N'EGR阀总成', N'23863628', N'VALVE ASM-EGR', N'10.01.01.16.01', N'6L3', N'0050A', N'刘超', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'93d6546530154acba2bb5a0cabce98cd', N'OBD', N'否', N'是', N'是', N'否', N'C18C05AC1', N'', N'大陆汽车电子(长春)有限公司', N'', N'LZW7123CAYA', N'PCI', N'', N'Y', N'', N'ECU壳体及标签', N'粘贴', N'发动机控制模块总成', N'23574569/23585097/23585098', N'MODULE ASM-ENG CONT', N'N/A', N'N/A', N'N/A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'b0eb4d0addea4979b74644662a06dd2e', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-YMJ-BS-01', N'', N'柳州市富英华工贸有限公司洛满生产基地', N'2016011111846721', N'All', N'EI', N'Y', N'Y', N'粘贴', N'零件背面', N'粘贴', N'衣帽架饰板', N'23983091', N'COVER-COAT HOOK ACC HOLE', N'40.03.03.01.01', N'1C4J', N'5915B', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'b2e6397b2a174f4588d8a43610d49ea0', N'变速器', N'是', N'是', N'是', N'否', N'SH12MS5B5', N'', N'柳州上汽汽车变速器有限公司', N'', N'LZW7123CAYA', N'TA', N'', N'Y', N'', N'壳体', N'打刻', N'AMT变速箱总成', N'23574296', N'TRANSMISSION ASM-AUTO', N'10.02.02.11', N'7', N'0100A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'b7ebe87b99a745749cca8f154f7ca3a0', N'座椅蒙皮的材料', N'是', N'是', N'否', N'否', N'CN180C-ZYMT-F-03', N'', N'旷达汽车饰件有限公司', N'', N'LZW7123CAYA', N'EI', N'', N'N/A', N'', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'N/A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'b8d4161065974a79807ee89b4ab326c2', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-FYBB-BS-01', N'', N'柳州双英科技有限公司', N'2014011111671417', N'ALL', N'EI', N'', N'Y', N'模压', N'零件内表面', N'模压', N'副仪表板总成', N'23914195', N'CONSOLE ASM-F/FLR', N'40.01.03.01', N'1C1J', N'3951C', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'ca37f55ff44e488196953de7144dec96', N'宝骏商标牌', N'否', N'否', N'否', N'否', N'CN180C-SBP-FT-01', N'', N'慈溪市斌晨塑料制品有限公司', N'', N'All', N'EI', N'', N'Y', N'', N'在标牌本体的后侧', N'将字体刻到模具上，通过注塑的方式施加', N'前部商标牌-散热器格栅', N'23914069', N'EMBLEM ASM-FRT BPR FASCIA', N'60.09.06.01', N'11G', N'6125A', N'', N'18025')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'e7c56cc5c6ed4febbca7557d575f82db', N'昼间行驶灯', N'是', N'否', N'否', N'否', N'707-411601/707-411602', N'', N'常州市佳乐车辆配件制造有限公司', N'', N'LZW7159CQY、LZW7123CAYA', N'HVAC', N'', N'N', N'模印', N'灯壳/灯玻', N'模压', N'左/右后回复反射器总成', N'', N'REFLECTOR ASM-RR BPR', N'60.06.06.98', N'12E', N'4150A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'efbf7ef3cdd74e58ba95fdbb4ff9307a', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-FZG-UT-01', N'', N'柳州环球汽车内饰件有限公司', N'2016091111005471', N'All', N'EI', N'Y', N'Y', N'粘贴', N'零件背面', N'粘贴', N'发动机罩隔热板', N'23909548', N'INSULATOR-HOOD', N'40.05.01.07', N'11D', N'0400A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'f0562d9980e8403996522758ff24b2f3', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'MFSM-UT-02', N'', N'柳州市风华汽车装饰件厂', N'2016011111846243', N'All', N'EI', N'', N'Y', N'粘贴', N'包装袋', N'粘贴', N'前门防水薄膜组件，后侧门防水薄膜组件', N'23909322/23928973/23908118/23956398/23917687', N'DEFLECTOR ASM-RR S/D WAT', N'55.01.01.06.05', N'1C5K', N'0860A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'f31c734d098640e2b1ac202274ef7d88', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-ZYB-UT-01', N'', N'宁波市阳光汽车配件有限公司', N'2015091111003298', N'ALL', N'EI', N'Y', N'Y', N'模压', N'轴座表面', N'粘贴', N'遮阳板总成', N'23909513
23909519
23980489
23919079
23980491
', N'SUNSHADE ASM-.', N'40.03.03.04.01', N'1C3J', N'3300A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'fa3763a16f494e51bd33dae0b01292c0', N'组合仪表', N'是', N'是', N'否', N'否', N'IC0158', N'', N'黑龙江天有为电子有限责任公司', N'', N'LZW7123CAYA', N'HVAC', N'Y', N'Y', N'', N'后盖上', N'标签上', N'组合仪表总成', N'23519092/23519093/23529890', N'CLUSTER ASM-INST', N'70.01.01.05', N'12J', N'0050A', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'fa72f249d7e24bbdbc0f5b23739e2a3e', N'车轴（第2轴）', N'是', N'是', N'否', N'否', N'AXL300', N'', N'四川建安工业有限责任公司', N'', N'All', N'CH', N'N/A', N'N', N'', N'贴在扭梁上', N'条形码', N'后悬架总成（带制动器）', N'23528690', N'SUSPENSION ASM-RR(W/BRK)', N'20.02.02.98', N'4D', N'8900B', N'', N'')
GO
GO
INSERT INTO [dbo].[newkeypart] ([id], [partName], [isNoticed], [isccc], [isEnvironmentalProtection], [iscccCertificate], [specification], [trademark], [productionEnterprise], [cccCertificateNumber], [applicableCarType], [responsibilityDepartment], [isSigned], [isAddModel], [cccApplyingWay], [positionDescription], [RecordApplyingWay], [zhPartName], [partNumber], [euPartName], [vpps], [upc], [fna], [engineerSign], [directorSign]) VALUES (N'fc00e9f03cca426e8ff2f28cd7eb59cf', N'用于其它方面的材料', N'是', N'是', N'否', N'是', N'CN180C-GJH-UT-01', N'', N'柳州福瑞特汽车零部件有限公司', N'2016011111841483', N'All', N'EI', N'Y', N'Y', N'粘贴', N'零件背面', N'粘贴', N'工具盒总成', N'23942463', N'CONTAINER ASM-JK STOW', N'20.07.01.98', N'14E', N'1175A', N'', N'')
GO
GO

-- ----------------------------
-- Indexes structure for table efiles
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table efiles
-- ----------------------------
ALTER TABLE [dbo].[efiles] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table hero
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table hero
-- ----------------------------
ALTER TABLE [dbo].[hero] ADD PRIMARY KEY ([hid])
GO

-- ----------------------------
-- Indexes structure for table newkeypart
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table newkeypart
-- ----------------------------
ALTER TABLE [dbo].[newkeypart] ADD PRIMARY KEY ([id])
GO
