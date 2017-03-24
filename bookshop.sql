DROP DATABASE IF EXISTS bookshop;		#存在数据库 bookshop 则删除
CREATE DATABASE IF NOT EXISTS bookshop;		#不存在数据库 bookshop 则创建

DROP TABLE IF EXISTS tb_Publisher		#若存在表则删除
DROP TABLE IF EXISTS tb_Categories;
DROP TABLE IF EXISTS tb_Books;
DROP TABLE IF EXISTS tb_UserRoles;
DROP TABLE IF EXISTS tb_Users;
DROP TABLE IF EXISTS tb_Orders;
DROP TABLE IF EXISTS tb_OrderBook;
DROP TABLE IF EXISTS tb_sysman;

USE bookshop;

#创建出版社表
CREATE TABLE tb_Publishers(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(200) NOT NULL
	);

#创建图书分类表
CREATE TABLE tb_Categories(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(200) NOT NULL,
	SortNum INT NULL
	);

#创建图书表
CREATE TABLE tb_Books(
  Id INT AUTO_INCREMENT PRIMARY KEY,
  Title VARCHAR(200) NOT NULL,
  Author VARCHAR(200) NOT NULL,
  PublisherId INT NOT NULL,
  PublishDate DATE NOT NULL,
  ISBN VARCHAR(50) NOT NULL,
  MarketPrice DECIMAL(12,4) NULL,
  UnitPrice DECIMAL(12,4) NOT NULL,
  ContentDescription VARCHAR(1000) NULL,
  TOC VARCHAR(1000) NULL,
  CategoryId INT NOT NULL,
  Clicks INT NOT NULL,
  FOREIGN KEY(PublisherId) REFERENCES tb_Publishers(ID),
  FOREIGN KEY(CategoryId) REFERENCES tb_Categories(ID)
	);

#创建会员等级表
CREATE TABLE tb_UserRoles(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(50) NOT NULL,
	minScore INT NULL,
	maxScore INT NULL
	);
	
#创建会员表
CREATE TABLE tb_Users(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	LoginId VARCHAR(50) NOT NULL,
	LoginPwd VARCHAR(50) NOT NULL,
	NAME VARCHAR(50) NULL,
	Address VARCHAR(200) NULL,
	Phone VARCHAR(100) NULL,
	Mail VARCHAR(100) NOT NULL,
	Birthday DATE NULL,
	UserRoleId INT NOT NULL,
	RegisterIp VARCHAR(50) NULL,
	RegisterTime DATE NULL,
	scoreTotal INT NULL,
	scoreCurrent INT NULL,
	HeadImg VARCHAR(50) NULL,
	FOREIGN KEY(UserRoleId) REFERENCES tb_UserRoles(ID)
	);
	
#创建订单表
CREATE TABLE tb_Orders(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	OrderDate DATE NOT NULL,
	UserId INT NOT NULL,
	TotalPrice DECIMAL(12,4) NOT NULL,
	flag INT NULL,
	personame VARCHAR(50) NULL,
	phone VARCHAR(50) NULL,
	address VARCHAR(50) NULL,
	sendCash DECIMAL(12,4) NULL,
	userCancelReason VARCHAR(500) NULL,
	OrderRemark VARCHAR(500) NULL,
	FOREIGN KEY(UserId) REFERENCES tb_Users(ID)
	);

#创建订单详情表
CREATE TABLE tb_OrderBook(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	OrderID INT NOT NULL,
	BookID INT NOT NULL,
	Quantity INT NOT NULL,
	UnitPrice DECIMAL(12,4) NOT NULL,
	FOREIGN KEY(orderid) REFERENCES tb_Orders(ID),
	FOREIGN KEY(bookid) REFERENCES tb_books(ID)
	);
	
#创建系统管理员表
CREATE TABLE tb_sysman(
	id INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(50) NOT NULL,
	pwd VARCHAR(50) NOT NULL
	);

#出版社表插入数据
INSERT INTO tb_Publishers (NAME) VALUES ( '21世纪出版社kkk');
INSERT INTO tb_Publishers (NAME) VALUES ( 'AAAA');
INSERT INTO tb_Publishers (NAME) VALUES ( 'AABBCCDDEE');
INSERT INTO tb_Publishers (NAME) VALUES ( 'abcde');
INSERT INTO tb_Publishers (NAME) VALUES ( 'ACCPACCP出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( 'BBBB');
INSERT INTO tb_Publishers (NAME) VALUES ( '北方');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京北京北京');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京航空航天大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京航天航空大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京科海出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京科海电子出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京科海集团公司');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京理工大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京师范大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京伟地电子出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京希望电子出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '北京邮电学院出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '兵器工业出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '大连理工大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '电子工业出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '东北财经大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '东方出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '东南大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '复旦大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '高等教育出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '贵州民族出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '国防工业出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '海洋出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '航空工业出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '华东理工大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '华东师范大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '华南理工大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '华夏出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '华中科技大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '化学工业出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '黄河水利出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '机械工业出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '九州出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '科学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '科学普及出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '辽宁科学技术出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '内蒙古大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '南开大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '农村读物出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '浦东电子');
INSERT INTO tb_Publishers (NAME) VALUES ( '青慧出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '清华大学');
INSERT INTO tb_Publishers (NAME) VALUES ( '清华大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '清华大学出版社；北京交通大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '人民大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '人民交通出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '人民文学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '人民邮电出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( 'dsfdsfsdfsdf');
INSERT INTO tb_Publishers (NAME) VALUES ( '陕西科学技术出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '上海北大青鸟');
INSERT INTO tb_Publishers (NAME) VALUES ( '上海交通大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '上海科学普及出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '世界图书出版公司');
INSERT INTO tb_Publishers (NAME) VALUES ( '水利电力出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '水利水电出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '天津人民出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '未来出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '武汉理工大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '西安电子科技大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '西安交通大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '西北工业大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '西南师范大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '希望电脑');
INSERT INTO tb_Publishers (NAME) VALUES ( '新时代出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '冶金工业出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '浙江大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中国电力出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中国建筑工业出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中国青年出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中国时代经济出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中国水利水电出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中国铁道出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中国宇航出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中华工商联合出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中山大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '中央广播电视大学出版社');
INSERT INTO tb_Publishers (NAME) VALUES ( '重庆大学出版社');

#图书分类表添加数据
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( '11223344', 9);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'newnew', 9);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'J2EE', 1000);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'CSS Div', 90);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'C C++ VC VC++', 20);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'Basic VB VB Script', 6000);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( '计算机等级考试', 40);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( '计算机理论', 100);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'Java Script Java', 120);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'HTML XML', 110);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( '.ET', 20);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'Perl', 50);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( '网站开发', 15);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( '其dsf', 180);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'ASP.ET', 160);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'JSP', 170);
INSERT INTO tb_Categories ( NAME, SortNum) VALUES ( 'WIDOWS', 220);


#会员等级添加数据
INSERT INTO tb_UserRoles ( NAME, minScore, maxScore) VALUES ( '白银会员', 0, 2000);
INSERT INTO tb_UserRoles ( NAME, minScore, maxScore) VALUES ( '黄金会员 ', 2001, 10000);
INSERT INTO tb_UserRoles ( NAME, minScore, maxScore) VALUES ( '钻石会员', 10001, 50000);
INSERT INTO tb_UserRoles ( NAME, minScore, maxScore) VALUES ( '金钻会员', 50001, 1000000);

#会员表添加数据
INSERT INTO tb_Users(LoginId,LoginPwd,NAME,Address,Phone,Mail,Birthday,UserRoleId,RegisterIp,RegisterTime,scoreTotal,scoreCurrent,HeadImg) VALUES('gongtao','1995','龚涛','安徽巢湖','13262629465','330556994@qq.com',STR_TO_DATE('06.04.1995', '%m.%d.%Y'),1,'127.0.0.1',NOW(),100,100,'gongtao');

#图书表添加数据
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, TOC, CategoryId, Clicks) VALUES ( 'Effective C# 中文版改善C#程序的50种方法', '（美）瓦格纳  著，李建忠  译', 1, NOW(), '978711515888', 57.6471, 49.0000, 'd','d', 1, 208);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'abcde', '（美）克尼汉，（美）里奇 著，徐宝文，李志 译', 1, NOW(), '9787111128069', 35.2941, 30.0000, '', 1, 5);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( '框架设计（第2版）：CLR Via C#', '（美）瑞奇特（Richter,J.）  著，周靖，张杰良  译', 1, NOW(), '9787302140160', 80.0000, 68.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Expert C# 2005 Business Objects中文版（第二版）', '（美）霍特卡  著，王鑫  译', 1, NOW(), '9787121038181', 93.8824, 79.8000, '', 1, 1);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Visual C# 2005从入门到精通', '（英）夏普  著，周靖  译', 1, NOW(), '9787302131007', 57.6471, 49.0000, '', 1, 2173);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Beginning C# Objects中文版——概念到代码', '（美）芭可，（美）帕尔默  著，韩磊，戴飞  译', 1, NOW(), '9787121024931', 80.0000, 68.0000, '', 1, 21);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( '数据结构题集(C语言版)', '严蔚敏 吴伟民 编著', 1, NOW(), '9787302033141', 18.8235, 16.0000, '', 1, 3);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C#设计模式——开发大师系列', '（美）麦斯科 著，颜炯 译', 1,NOW(), '9787508334929', 49.4118, 42.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( '超越C++标准库Boost库导论', '（美）卡尔森（Kalsson，B.）　著，张杰良　译', 1, NOW(), '9787302149118', 47.0000, 39.8000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( '数据结构与算法分析C++描述（第三版）', '（美）维斯  著，张怀勇  等译', 1, NOW(), '9787115139238', 58.0000, 49.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C++编程思想（第2版）第1卷：标准C++导引（附光盘）', '（美）埃克尔 著，刘宗田等 译', 1,NOW(), '9787111108078', 99.0000, 59.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C程序设计语言（第2版·新版）习题解答', '美汤朵，美吉米拜尔 著，杨涛等 译', 1, NOW(), '9787111129431', 17.6471, 100.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C++编程规范:101条规则、准则与最佳实践（图灵程序设计丛书）', '萨特，亚历山德雷斯库  著，刘基诚  译', 1, NOW(), '9787115142054', 99.0000, 35.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C++设计新思维(泛型编程与设计模式之应用)', '美.Andrei Alexandrescu 著；候捷，於春景 译', 1, NOW(), '9787560929064', 70.3529, 59.8000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Visual C#2005程序开发与界面设计秘诀(附盘)', '章立民研究室  著', 1, NOW(), '9787111199472', 91.7647, 78.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( '单元测试之道C#版：使用Unit——程序员修炼三部曲第二部', '（美）托马斯  等著，陈伟桩，陶文  译', 1, NOW(), '9787121006661', 29.4118, 25.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C++ Primer中文版（第三版）', '美.利普曼 加.劳乔 著 潘爱民 张丽 译', 1, NOW(), '9787508309897', 150.5882, 128.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Essential C++ 中文版', '美Stanley B. Lippman著侯捷译', 1, NOW(), '9787560925110', 46.8235, 39.8000, '', 1, 3);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Visual C++6.0 程序设计从入门到精通（附CD-ROM光盘一张）', '求是科技  编著', 1, NOW(), '9787115141378', 45.8824, 39.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Effective C++ Third Edition ：改善程序技术与设计思维的55个有效做法（英文版）', '（美）玛雅尔斯（Meyers,S.)  著', 1, NOW(), '7121008270', 52.9412, 45.0000, '', 1, 2);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C程序设计（第二版）', '谭浩强', 1, NOW(), '9787302038061', 30.5882, 26.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Visual C++网络通信编程实用案例精选：第二版（附光盘）', '曹衍龙，刘海英  编著', 1, NOW(), '9787115147042', 65.8824, 56.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C++网络编程，卷1——运用ACE和模式消除复杂性', '（美）施密特，（美）霍斯顿  著，於春景  译', 1, NOW(), '9787121041518', 41.1765, 35.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C++标准程序库自修教程与参考手册', '德.icolai M.Josuttis 著，侯捷，孟岩 译', 1, NOW(), '9787560927824', 127.0588, 108.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Visual C#2005编程技巧大全', '罗斌 等编', 1, NOW(), '9787508442556', 115.2941, 98.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Visual C#2005技术内幕', '（美）马歇尔  著，许华杰，刘光惠  译', 1, NOW(), '9787302144175', 69.4118, 59.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C语言解惑', '（美）福伊尔  著，杨涛  等译', 1, NOW(), '9787115159731', 29.4118, 25.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Visual C#2005入门经典', '（美）福克塞尔　著，陈秋萍　译', 1, NOW(), '9787115155504', 45.8824, 39.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Visral C++程序开发范例宝典（附光盘）', '明日科技　编著', 1, NOW(), '9787115159700', 104.7059, 89.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'Visual C#2005文件IO与数据存取秘诀（附赠DVD）', '章立民研究室  著', 1, NOW(), '9787111199724', 92.9412, 79.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C#2005数据库编程经典教程', '（美）沃顿（Karli watton）  著，陈秋萍  译', 1, NOW(), '9787115158949', 68.2353, 58.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C#数据库系统开发案例精选(附光盘)', '明日科技　编著', 1, NOW(), '9787115159243', 57.6471, 49.0000, '', 1, 0);
INSERT INTO tb_Books ( Title, Author, PublisherId, PublishDate, ISBN, MarketPrice, UnitPrice, ContentDescription, CategoryId, Clicks) VALUES ( 'C语言编程：一本全面的C语言入门教程（第三版）', '（美）科汉　著，张小潘　译', 1, NOW(), '9787121007354', 69.4118, 59.0000, '', 1, 0);

SELECT * FROM tb_books;
