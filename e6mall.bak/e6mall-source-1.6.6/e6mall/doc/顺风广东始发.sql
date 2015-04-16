-- phpMyAdmin SQL Dump
-- version 3.2.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2010 年 12 月 28 日 06:09
-- 服务器版本: 5.1.33
-- PHP 版本: 5.2.11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `shop`
--

-- --------------------------------------------------------

--
-- 表的结构 `ladlink`
--

CREATE TABLE IF NOT EXISTS `ladlink` (
  `lsarea` varchar(32) NOT NULL COMMENT '第三方物流分区',
  `district` int(11) NOT NULL COMMENT '城市地区',
  PRIMARY KEY (`lsarea`,`district`),
  KEY `district` (`district`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='第三方物流分区表与城市地区多对多链接表';

--
-- 转存表中的数据 `ladlink`
--

INSERT INTO `ladlink` (`lsarea`, `district`) VALUES
('7ea96dcc288b4df5a35ff709be8d5320', 35),
('7ea96dcc288b4df5a35ff709be8d5320', 36),
('7ea96dcc288b4df5a35ff709be8d5320', 37),
('7ea96dcc288b4df5a35ff709be8d5320', 38),
('7ea96dcc288b4df5a35ff709be8d5320', 39),
('7ea96dcc288b4df5a35ff709be8d5320', 40),
('7ea96dcc288b4df5a35ff709be8d5320', 41),
('7ea96dcc288b4df5a35ff709be8d5320', 42),
('7ea96dcc288b4df5a35ff709be8d5320', 43),
('7ea96dcc288b4df5a35ff709be8d5320', 44),
('7ea96dcc288b4df5a35ff709be8d5320', 45),
('7ea96dcc288b4df5a35ff709be8d5320', 46),
('7ea96dcc288b4df5a35ff709be8d5320', 47),
('7ea96dcc288b4df5a35ff709be8d5320', 48),
('7ea96dcc288b4df5a35ff709be8d5320', 49),
('d7d091845fe940ebbad6cae897c1c1dd', 50),
('d7d091845fe940ebbad6cae897c1c1dd', 51),
('d7d091845fe940ebbad6cae897c1c1dd', 52),
('d7d091845fe940ebbad6cae897c1c1dd', 53),
('d7d091845fe940ebbad6cae897c1c1dd', 54),
('d7d091845fe940ebbad6cae897c1c1dd', 55),
('d7d091845fe940ebbad6cae897c1c1dd', 56),
('d7d091845fe940ebbad6cae897c1c1dd', 57),
('d7d091845fe940ebbad6cae897c1c1dd', 58),
('d7d091845fe940ebbad6cae897c1c1dd', 59),
('d7d091845fe940ebbad6cae897c1c1dd', 60),
('7ea96dcc288b4df5a35ff709be8d5320', 61),
('7ea96dcc288b4df5a35ff709be8d5320', 73),
('7ea96dcc288b4df5a35ff709be8d5320', 74),
('7ea96dcc288b4df5a35ff709be8d5320', 75),
('7ea96dcc288b4df5a35ff709be8d5320', 76),
('7ea96dcc288b4df5a35ff709be8d5320', 77),
('7ea96dcc288b4df5a35ff709be8d5320', 78),
('7ea96dcc288b4df5a35ff709be8d5320', 79),
('7ea96dcc288b4df5a35ff709be8d5320', 80),
('7ea96dcc288b4df5a35ff709be8d5320', 81),
('7ea96dcc288b4df5a35ff709be8d5320', 82),
('7ea96dcc288b4df5a35ff709be8d5320', 83),
('7ea96dcc288b4df5a35ff709be8d5320', 84),
('7ea96dcc288b4df5a35ff709be8d5320', 85),
('7ea96dcc288b4df5a35ff709be8d5320', 86),
('151b74d2a12f4dbdbd97fda76f670f88', 87),
('151b74d2a12f4dbdbd97fda76f670f88', 88),
('151b74d2a12f4dbdbd97fda76f670f88', 89),
('151b74d2a12f4dbdbd97fda76f670f88', 90),
('151b74d2a12f4dbdbd97fda76f670f88', 91),
('151b74d2a12f4dbdbd97fda76f670f88', 92),
('151b74d2a12f4dbdbd97fda76f670f88', 93),
('151b74d2a12f4dbdbd97fda76f670f88', 94),
('151b74d2a12f4dbdbd97fda76f670f88', 95),
('151b74d2a12f4dbdbd97fda76f670f88', 96),
('151b74d2a12f4dbdbd97fda76f670f88', 97),
('151b74d2a12f4dbdbd97fda76f670f88', 98),
('151b74d2a12f4dbdbd97fda76f670f88', 99),
('151b74d2a12f4dbdbd97fda76f670f88', 100),
('151b74d2a12f4dbdbd97fda76f670f88', 101),
('151b74d2a12f4dbdbd97fda76f670f88', 102),
('151b74d2a12f4dbdbd97fda76f670f88', 103),
('151b74d2a12f4dbdbd97fda76f670f88', 104),
('151b74d2a12f4dbdbd97fda76f670f88', 105),
('151b74d2a12f4dbdbd97fda76f670f88', 106),
('151b74d2a12f4dbdbd97fda76f670f88', 107),
('151b74d2a12f4dbdbd97fda76f670f88', 108),
('5272de3aca1c40dda51e4229fc7ae1ce', 109),
('5272de3aca1c40dda51e4229fc7ae1ce', 110),
('5272de3aca1c40dda51e4229fc7ae1ce', 111),
('5272de3aca1c40dda51e4229fc7ae1ce', 112),
('5272de3aca1c40dda51e4229fc7ae1ce', 113),
('5272de3aca1c40dda51e4229fc7ae1ce', 114),
('5272de3aca1c40dda51e4229fc7ae1ce', 115),
('5272de3aca1c40dda51e4229fc7ae1ce', 116),
('5272de3aca1c40dda51e4229fc7ae1ce', 117),
('5272de3aca1c40dda51e4229fc7ae1ce', 118),
('5272de3aca1c40dda51e4229fc7ae1ce', 119),
('5272de3aca1c40dda51e4229fc7ae1ce', 120),
('5272de3aca1c40dda51e4229fc7ae1ce', 121),
('5272de3aca1c40dda51e4229fc7ae1ce', 122),
('5272de3aca1c40dda51e4229fc7ae1ce', 123),
('5272de3aca1c40dda51e4229fc7ae1ce', 124),
('5272de3aca1c40dda51e4229fc7ae1ce', 125),
('5272de3aca1c40dda51e4229fc7ae1ce', 126),
('5272de3aca1c40dda51e4229fc7ae1ce', 127),
('5272de3aca1c40dda51e4229fc7ae1ce', 128),
('5272de3aca1c40dda51e4229fc7ae1ce', 129),
('5272de3aca1c40dda51e4229fc7ae1ce', 130),
('5272de3aca1c40dda51e4229fc7ae1ce', 131),
('5272de3aca1c40dda51e4229fc7ae1ce', 132),
('5272de3aca1c40dda51e4229fc7ae1ce', 133),
('5272de3aca1c40dda51e4229fc7ae1ce', 134),
('d7d091845fe940ebbad6cae897c1c1dd', 135),
('d7d091845fe940ebbad6cae897c1c1dd', 136),
('d7d091845fe940ebbad6cae897c1c1dd', 137),
('d7d091845fe940ebbad6cae897c1c1dd', 138),
('d7d091845fe940ebbad6cae897c1c1dd', 139),
('d7d091845fe940ebbad6cae897c1c1dd', 140),
('d7d091845fe940ebbad6cae897c1c1dd', 141),
('d7d091845fe940ebbad6cae897c1c1dd', 142),
('d7d091845fe940ebbad6cae897c1c1dd', 143),
('d7d091845fe940ebbad6cae897c1c1dd', 144),
('d7d091845fe940ebbad6cae897c1c1dd', 145),
('d7d091845fe940ebbad6cae897c1c1dd', 146),
('d7d091845fe940ebbad6cae897c1c1dd', 147),
('d7d091845fe940ebbad6cae897c1c1dd', 148),
('d7d091845fe940ebbad6cae897c1c1dd', 149),
('d7d091845fe940ebbad6cae897c1c1dd', 150),
('d7d091845fe940ebbad6cae897c1c1dd', 151),
('a1056a33003949c498345c291ba8bab7', 152),
('a1056a33003949c498345c291ba8bab7', 153),
('a1056a33003949c498345c291ba8bab7', 154),
('a1056a33003949c498345c291ba8bab7', 155),
('a1056a33003949c498345c291ba8bab7', 156),
('a1056a33003949c498345c291ba8bab7', 157),
('a1056a33003949c498345c291ba8bab7', 158),
('a1056a33003949c498345c291ba8bab7', 159),
('a1056a33003949c498345c291ba8bab7', 160),
('d7d091845fe940ebbad6cae897c1c1dd', 161),
('d7d091845fe940ebbad6cae897c1c1dd', 162),
('d7d091845fe940ebbad6cae897c1c1dd', 163),
('d7d091845fe940ebbad6cae897c1c1dd', 164),
('d7d091845fe940ebbad6cae897c1c1dd', 165),
('d7d091845fe940ebbad6cae897c1c1dd', 166),
('d7d091845fe940ebbad6cae897c1c1dd', 167),
('d7d091845fe940ebbad6cae897c1c1dd', 168),
('d7d091845fe940ebbad6cae897c1c1dd', 169),
('d7d091845fe940ebbad6cae897c1c1dd', 170),
('d7d091845fe940ebbad6cae897c1c1dd', 171),
('7ea96dcc288b4df5a35ff709be8d5320', 172),
('7ea96dcc288b4df5a35ff709be8d5320', 173),
('7ea96dcc288b4df5a35ff709be8d5320', 174),
('7ea96dcc288b4df5a35ff709be8d5320', 175),
('7ea96dcc288b4df5a35ff709be8d5320', 176),
('7ea96dcc288b4df5a35ff709be8d5320', 177),
('7ea96dcc288b4df5a35ff709be8d5320', 178),
('7ea96dcc288b4df5a35ff709be8d5320', 179),
('7ea96dcc288b4df5a35ff709be8d5320', 180),
('7ea96dcc288b4df5a35ff709be8d5320', 181),
('7ea96dcc288b4df5a35ff709be8d5320', 182),
('7ea96dcc288b4df5a35ff709be8d5320', 183),
('7ea96dcc288b4df5a35ff709be8d5320', 184),
('7ea96dcc288b4df5a35ff709be8d5320', 185),
('7ea96dcc288b4df5a35ff709be8d5320', 186),
('7ea96dcc288b4df5a35ff709be8d5320', 187),
('7ea96dcc288b4df5a35ff709be8d5320', 188),
('d7d091845fe940ebbad6cae897c1c1dd', 189),
('d7d091845fe940ebbad6cae897c1c1dd', 190),
('d7d091845fe940ebbad6cae897c1c1dd', 191),
('d7d091845fe940ebbad6cae897c1c1dd', 192),
('d7d091845fe940ebbad6cae897c1c1dd', 193),
('d7d091845fe940ebbad6cae897c1c1dd', 194),
('d7d091845fe940ebbad6cae897c1c1dd', 195),
('d7d091845fe940ebbad6cae897c1c1dd', 196),
('d7d091845fe940ebbad6cae897c1c1dd', 197),
('d7d091845fe940ebbad6cae897c1c1dd', 198),
('d7d091845fe940ebbad6cae897c1c1dd', 199),
('d7d091845fe940ebbad6cae897c1c1dd', 200),
('d7d091845fe940ebbad6cae897c1c1dd', 201),
('d7d091845fe940ebbad6cae897c1c1dd', 202),
('d7d091845fe940ebbad6cae897c1c1dd', 203),
('d7d091845fe940ebbad6cae897c1c1dd', 204),
('d7d091845fe940ebbad6cae897c1c1dd', 205),
('d7d091845fe940ebbad6cae897c1c1dd', 206),
('d7d091845fe940ebbad6cae897c1c1dd', 207),
('d7d091845fe940ebbad6cae897c1c1dd', 208),
('d7d091845fe940ebbad6cae897c1c1dd', 209),
('d7d091845fe940ebbad6cae897c1c1dd', 210),
('d7d091845fe940ebbad6cae897c1c1dd', 211),
('d7d091845fe940ebbad6cae897c1c1dd', 212),
('d7d091845fe940ebbad6cae897c1c1dd', 213),
('d7d091845fe940ebbad6cae897c1c1dd', 214),
('d7d091845fe940ebbad6cae897c1c1dd', 215),
('d7d091845fe940ebbad6cae897c1c1dd', 216),
('d7d091845fe940ebbad6cae897c1c1dd', 217),
('d7d091845fe940ebbad6cae897c1c1dd', 218),
('d7d091845fe940ebbad6cae897c1c1dd', 219),
('0d8d74e9f3f342b8a7c499936b7a162e', 220),
('0d8d74e9f3f342b8a7c499936b7a162e', 221),
('0d8d74e9f3f342b8a7c499936b7a162e', 222),
('0d8d74e9f3f342b8a7c499936b7a162e', 223),
('0d8d74e9f3f342b8a7c499936b7a162e', 224),
('0d8d74e9f3f342b8a7c499936b7a162e', 225),
('0d8d74e9f3f342b8a7c499936b7a162e', 226),
('0d8d74e9f3f342b8a7c499936b7a162e', 227),
('0d8d74e9f3f342b8a7c499936b7a162e', 228),
('0d8d74e9f3f342b8a7c499936b7a162e', 229),
('0d8d74e9f3f342b8a7c499936b7a162e', 230),
('0d8d74e9f3f342b8a7c499936b7a162e', 231),
('0d8d74e9f3f342b8a7c499936b7a162e', 232),
('0d8d74e9f3f342b8a7c499936b7a162e', 233),
('e4c9634dc7514a7890042af95b60c855', 234),
('e4c9634dc7514a7890042af95b60c855', 235),
('e4c9634dc7514a7890042af95b60c855', 236),
('e4c9634dc7514a7890042af95b60c855', 237),
('e4c9634dc7514a7890042af95b60c855', 238),
('e4c9634dc7514a7890042af95b60c855', 239),
('e4c9634dc7514a7890042af95b60c855', 240),
('e4c9634dc7514a7890042af95b60c855', 241),
('e4c9634dc7514a7890042af95b60c855', 242),
('e4c9634dc7514a7890042af95b60c855', 243),
('e4c9634dc7514a7890042af95b60c855', 244),
('e4c9634dc7514a7890042af95b60c855', 245),
('e4c9634dc7514a7890042af95b60c855', 246),
('e4c9634dc7514a7890042af95b60c855', 247),
('e4c9634dc7514a7890042af95b60c855', 248),
('e4c9634dc7514a7890042af95b60c855', 249),
('e4c9634dc7514a7890042af95b60c855', 250),
('e4c9634dc7514a7890042af95b60c855', 251),
('e4c9634dc7514a7890042af95b60c855', 252),
('e4c9634dc7514a7890042af95b60c855', 253),
('e4c9634dc7514a7890042af95b60c855', 254),
('0d8d74e9f3f342b8a7c499936b7a162e', 255),
('0d8d74e9f3f342b8a7c499936b7a162e', 256),
('0d8d74e9f3f342b8a7c499936b7a162e', 257),
('48561c854cbb4a5892521361888c7c96', 258),
('0d8d74e9f3f342b8a7c499936b7a162e', 259),
('0d8d74e9f3f342b8a7c499936b7a162e', 260),
('0d8d74e9f3f342b8a7c499936b7a162e', 261),
('0d8d74e9f3f342b8a7c499936b7a162e', 262),
('0d8d74e9f3f342b8a7c499936b7a162e', 263),
('0d8d74e9f3f342b8a7c499936b7a162e', 264),
('0d8d74e9f3f342b8a7c499936b7a162e', 265),
('0d8d74e9f3f342b8a7c499936b7a162e', 266),
('0d8d74e9f3f342b8a7c499936b7a162e', 267),
('0d8d74e9f3f342b8a7c499936b7a162e', 268),
('0d8d74e9f3f342b8a7c499936b7a162e', 269),
('0d8d74e9f3f342b8a7c499936b7a162e', 270),
('0d8d74e9f3f342b8a7c499936b7a162e', 271),
('d7d091845fe940ebbad6cae897c1c1dd', 272),
('d7d091845fe940ebbad6cae897c1c1dd', 273),
('d7d091845fe940ebbad6cae897c1c1dd', 274),
('d7d091845fe940ebbad6cae897c1c1dd', 275),
('d7d091845fe940ebbad6cae897c1c1dd', 276),
('d7d091845fe940ebbad6cae897c1c1dd', 277),
('d7d091845fe940ebbad6cae897c1c1dd', 278),
('d7d091845fe940ebbad6cae897c1c1dd', 279),
('d7d091845fe940ebbad6cae897c1c1dd', 280),
('d7d091845fe940ebbad6cae897c1c1dd', 281),
('d7d091845fe940ebbad6cae897c1c1dd', 282),
('d7d091845fe940ebbad6cae897c1c1dd', 283),
('d7d091845fe940ebbad6cae897c1c1dd', 284),
('d7d091845fe940ebbad6cae897c1c1dd', 285),
('d7d091845fe940ebbad6cae897c1c1dd', 286),
('d7d091845fe940ebbad6cae897c1c1dd', 287),
('d7d091845fe940ebbad6cae897c1c1dd', 288),
('d7d091845fe940ebbad6cae897c1c1dd', 289),
('d7d091845fe940ebbad6cae897c1c1dd', 290),
('d7d091845fe940ebbad6cae897c1c1dd', 291),
('d7d091845fe940ebbad6cae897c1c1dd', 292),
('d7d091845fe940ebbad6cae897c1c1dd', 293),
('d7d091845fe940ebbad6cae897c1c1dd', 294),
('d7d091845fe940ebbad6cae897c1c1dd', 295),
('d7d091845fe940ebbad6cae897c1c1dd', 304),
('d7d091845fe940ebbad6cae897c1c1dd', 327),
('d7d091845fe940ebbad6cae897c1c1dd', 328),
('d7d091845fe940ebbad6cae897c1c1dd', 329),
('d7d091845fe940ebbad6cae897c1c1dd', 330),
('d7d091845fe940ebbad6cae897c1c1dd', 331),
('d7d091845fe940ebbad6cae897c1c1dd', 332),
('d7d091845fe940ebbad6cae897c1c1dd', 333),
('d7d091845fe940ebbad6cae897c1c1dd', 334),
('d7d091845fe940ebbad6cae897c1c1dd', 335),
('d7d091845fe940ebbad6cae897c1c1dd', 336),
('d7d091845fe940ebbad6cae897c1c1dd', 337),
('7ea96dcc288b4df5a35ff709be8d5320', 359),
('151b74d2a12f4dbdbd97fda76f670f88', 364);

-- --------------------------------------------------------

--
-- 表的结构 `logistics`
--

CREATE TABLE IF NOT EXISTS `logistics` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '物流公司名称',
  `image` varchar(32) DEFAULT NULL COMMENT 'LOGO',
  `intro` text COMMENT '物流公司简介',
  `url` varchar(255) DEFAULT NULL COMMENT '物流公司网址',
  `pourl` varchar(255) DEFAULT NULL COMMENT '在线下单网址',
  `csort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `image` (`image`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流公司表';

--
-- 转存表中的数据 `logistics`
--

INSERT INTO `logistics` (`id`, `name`, `image`, `intro`, `url`, `pourl`, `csort`) VALUES
('b7df8e5f506d4c7bad1b4857e4ad1a46', '顺风快递', NULL, '顺丰速运（集团）有限公司于1993年成立，总部设在深圳，是一家主要经营国内、国际快递及相关业务的服务性企业。', 'http://www.sf-express.com', 'http://www.sf-express.com', 10);

-- --------------------------------------------------------

--
-- 表的结构 `lsarea`
--

CREATE TABLE IF NOT EXISTS `lsarea` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '分区名称',
  `intro` text COMMENT '分区描述',
  `wfirst` int(11) NOT NULL COMMENT '首重单位',
  `wfcost` decimal(11,2) NOT NULL COMMENT '首重价格',
  `wappend` int(11) NOT NULL COMMENT '续重单位',
  `wacost` decimal(11,2) NOT NULL COMMENT '续重价格',
  `cod` varchar(255) NOT NULL COMMENT '货到付款',
  `logistics` varchar(32) NOT NULL COMMENT '第三方物流公司',
  `premiumrate` decimal(11,2) NOT NULL COMMENT '保险费率',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `logistics` (`logistics`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='第三方物流分区表';

--
-- 转存表中的数据 `lsarea`
--

INSERT INTO `lsarea` (`id`, `name`, `intro`, `wfirst`, `wfcost`, `wappend`, `wacost`, `cod`, `logistics`, `premiumrate`, `status`) VALUES
('0d8d74e9f3f342b8a7c499936b7a162e', '7区广西_不含梧州分部_海南_湖南', NULL, 1000, 20.00, 50000, 8.00, 'no', 'b7df8e5f506d4c7bad1b4857e4ad1a46', 0.00, NULL),
('151b74d2a12f4dbdbd97fda76f670f88', '15区黑龙江吉林乌鲁木齐', NULL, 1000, 20.00, 50000, 18.00, 'no', 'b7df8e5f506d4c7bad1b4857e4ad1a46', 0.00, NULL),
('48561c854cbb4a5892521361888c7c96', '5区广西梧州分部', NULL, 1000, 15.00, 50000, 6.00, 'no', 'b7df8e5f506d4c7bad1b4857e4ad1a46', 0.00, NULL),
('5272de3aca1c40dda51e4229fc7ae1ce', '11区江浙沪', NULL, 1000, 20.00, 50000, 13.00, 'no', 'b7df8e5f506d4c7bad1b4857e4ad1a46', 0.00, NULL),
('7ea96dcc288b4df5a35ff709be8d5320', '12区京津冀辽宁山东呼和浩特银川', NULL, 1000, 20.00, 50000, 14.00, 'no', 'b7df8e5f506d4c7bad1b4857e4ad1a46', 0.00, NULL),
('a1056a33003949c498345c291ba8bab7', '6区福建', NULL, 1000, 20.00, 50000, 6.00, 'no', 'b7df8e5f506d4c7bad1b4857e4ad1a46', 0.00, NULL),
('d7d091845fe940ebbad6cae897c1c1dd', '10区湖北陕西四川重庆河南安徽江西山西昆明贵阳兰州', NULL, 1000, 20.00, 50000, 12.00, 'no', 'b7df8e5f506d4c7bad1b4857e4ad1a46', 0.00, NULL),
('e4c9634dc7514a7890042af95b60c855', '2区广东非即日', NULL, 1000, 12.00, 50000, 2.00, 'no', 'b7df8e5f506d4c7bad1b4857e4ad1a46', 0.00, NULL);

--
-- 限制导出的表
--

--
-- 限制表 `ladlink`
--
ALTER TABLE `ladlink`
  ADD CONSTRAINT `ladlink_ibfk_1` FOREIGN KEY (`lsarea`) REFERENCES `lsarea` (`id`),
  ADD CONSTRAINT `ladlink_ibfk_2` FOREIGN KEY (`district`) REFERENCES `district` (`id`);

--
-- 限制表 `logistics`
--
ALTER TABLE `logistics`
  ADD CONSTRAINT `logistics_ibfk_1` FOREIGN KEY (`image`) REFERENCES `attachment` (`id`);

--
-- 限制表 `lsarea`
--
ALTER TABLE `lsarea`
  ADD CONSTRAINT `lsarea_ibfk_1` FOREIGN KEY (`logistics`) REFERENCES `logistics` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
