-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2014 at 05:01 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `globus`
--

-- --------------------------------------------------------

--
-- Table structure for table `alertsdata`
--

CREATE TABLE IF NOT EXISTS `alertsdata` (
  `AlertID` int(10) NOT NULL AUTO_INCREMENT,
  `ResellerId` int(10) DEFAULT '0',
  `CustomerID` int(10) NOT NULL DEFAULT '0',
  `Campaign` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Url` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Keyword` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Engine` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `PreviousRank` int(10) NOT NULL DEFAULT '0',
  `CurrentRank` int(10) NOT NULL DEFAULT '0',
  `TrackDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`AlertID`),
  KEY `CustomerID` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `campaignkeywords`
--

CREATE TABLE IF NOT EXISTS `campaignkeywords` (
  `CampaignId` int(10) NOT NULL DEFAULT '0',
  `KeywordID` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`CampaignId`,`KeywordID`),
  KEY `CampaignId` (`CampaignId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `campaigns`
--

CREATE TABLE IF NOT EXISTS `campaigns` (
  `CampaignID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(11) NOT NULL DEFAULT '0',
  `Campaign` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `CampaignType` varchar(6) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'serp',
  `ResellerId` int(11) DEFAULT '0',
  `Visibility` int(2) DEFAULT '1',
  `ViewKey` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ReportEmailID` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ReportFrequency` int(10) DEFAULT NULL,
  `MailSentOn` timestamp NULL DEFAULT NULL,
  `RankRefresher` datetime DEFAULT NULL,
  `RankRefresherStatus` int(2) DEFAULT '0',
  `CompanyName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CompanyURLLink` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CompanyLogoLink` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CampaignID`),
  KEY `CustomerID` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `commonseo`
--

CREATE TABLE IF NOT EXISTS `commonseo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryRank` varchar(255) DEFAULT NULL,
  `description` text,
  `doctype` varchar(255) DEFAULT NULL,
  `domainCreated` varchar(255) DEFAULT NULL,
  `domainExpired` varchar(255) DEFAULT NULL,
  `domainUpdated` varchar(255) DEFAULT NULL,
  `encoding` varchar(255) DEFAULT NULL,
  `facebookAbout` varchar(255) DEFAULT NULL,
  `facebookAddress` varchar(255) DEFAULT NULL,
  `facebookImage` varchar(255) DEFAULT NULL,
  `facebookLikes` varchar(255) DEFAULT NULL,
  `facebook_mission` text,
  `facebookName` varchar(255) DEFAULT NULL,
  `facebookOverview` longtext,
  `facebook_phone` varchar(255) DEFAULT NULL,
  `facebookProduct` text,
  `facebookUrl` varchar(255) DEFAULT NULL,
  `flagCode` varchar(255) DEFAULT NULL,
  `flash` varchar(255) DEFAULT NULL,
  `frames` varchar(255) DEFAULT NULL,
  `globalRank` varchar(255) DEFAULT NULL,
  `googleImage` varchar(255) DEFAULT NULL,
  `googleIntroduction` text,
  `googleName` varchar(255) DEFAULT NULL,
  `googleOverview` text,
  `googlePublisher` varchar(255) DEFAULT NULL,
  `googleTagline` varchar(255) DEFAULT NULL,
  `googleUrl` varchar(255) DEFAULT NULL,
  `googleVerified` varchar(255) DEFAULT NULL,
  `htmlRatio` varchar(255) DEFAULT NULL,
  `ipCanonicalization` varchar(255) DEFAULT NULL,
  `ipadView` varchar(255) DEFAULT NULL,
  `ipaddress` varchar(255) DEFAULT NULL,
  `iphoneView` varchar(255) DEFAULT NULL,
  `keyword` text,
  `locat` varchar(255) DEFAULT NULL,
  `pageRank` varchar(255) DEFAULT NULL,
  `reviewGoogleDesc` varchar(255) DEFAULT NULL,
  `reviewGoogleTitle` varchar(255) DEFAULT NULL,
  `reviewGoogleUrl` varchar(255) DEFAULT NULL,
  `robots` varchar(255) DEFAULT NULL,
  `takingAbout` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `titleLength` varchar(255) DEFAULT NULL,
  `underscores` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `urlDomain` varchar(255) DEFAULT NULL,
  `w3cvalidity` varchar(255) DEFAULT NULL,
  `wwwResolve` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `crawlinfo`
--

CREATE TABLE IF NOT EXISTS `crawlinfo` (
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `message` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `ResellerId` int(11) DEFAULT '0',
  `FirstName` varchar(20) COLLATE utf8_unicode_ci DEFAULT '0',
  `LastName` varchar(20) COLLATE utf8_unicode_ci DEFAULT '0',
  `Phone` varchar(30) COLLATE utf8_unicode_ci DEFAULT '0',
  `Address` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0',
  `City` varchar(20) COLLATE utf8_unicode_ci DEFAULT '0',
  `State` varchar(20) COLLATE utf8_unicode_ci DEFAULT '0',
  `Country` varchar(20) COLLATE utf8_unicode_ci DEFAULT '0',
  `ZipCode` int(10) NOT NULL DEFAULT '0',
  `AllowedUserCount` int(10) NOT NULL DEFAULT '1',
  `ActiveUserCount` int(10) NOT NULL DEFAULT '0',
  `AllowedCampaignsCount` int(10) NOT NULL DEFAULT '0',
  `ActiveSerpCampaignsCount` int(10) NOT NULL DEFAULT '0',
  `ActiveVideoCampaignCount` int(10) NOT NULL DEFAULT '0',
  `AllowedKeywordCount` int(10) NOT NULL DEFAULT '0',
  `ActiveKeywordCount` int(10) NOT NULL DEFAULT '0',
  `ActiveVideoKeywordCount` int(10) NOT NULL DEFAULT '0',
  `TimezoneID` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0',
  `TimezoneValue` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0',
  `AlertEmailID` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0',
  `AlertNotificationCount` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0',
  `CompanyName` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CompanyURLLink` varchar(200) COLLATE utf8_unicode_ci DEFAULT '0',
  `CompanyLogoLink` varchar(200) COLLATE utf8_unicode_ci DEFAULT '0',
  `CompanyDescription` varchar(500) COLLATE utf8_unicode_ci DEFAULT '0',
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `displaysettings`
--

CREATE TABLE IF NOT EXISTS `displaysettings` (
  `DisplaysettingsID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerId` int(11) NOT NULL,
  `Googletab` tinyint(4) NOT NULL DEFAULT '1',
  `Yahootab` tinyint(4) NOT NULL DEFAULT '1',
  `Bingtab` tinyint(4) NOT NULL DEFAULT '1',
  `Daychangetab` tinyint(4) NOT NULL DEFAULT '1',
  `Weekchangetab` tinyint(4) NOT NULL DEFAULT '1',
  `Monthchangetab` tinyint(4) NOT NULL DEFAULT '1',
  `Alexatab` tinyint(4) NOT NULL DEFAULT '1',
  `Backlinkstab` tinyint(4) NOT NULL DEFAULT '1',
  `Monthlysearchstab` tinyint(4) NOT NULL DEFAULT '1',
  `Serpcampaigntab` tinyint(4) NOT NULL DEFAULT '1',
  `Videocampaigntab` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`DisplaysettingsID`),
  KEY `FK_displaysettings_customers` (`CustomerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `globustrackerevents`
--

CREATE TABLE IF NOT EXISTS `globustrackerevents` (
  `GlobustrackereventId` int(11) NOT NULL AUTO_INCREMENT,
  `EventName` varchar(255) NOT NULL DEFAULT '0',
  `EventDescription` varchar(255) NOT NULL DEFAULT '0',
  `EventDate` datetime NOT NULL,
  `AddedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`GlobustrackereventId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `headingcount`
--

CREATE TABLE IF NOT EXISTS `headingcount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `heading1` varchar(255) DEFAULT NULL,
  `heading2` varchar(255) DEFAULT NULL,
  `heading3` varchar(255) DEFAULT NULL,
  `heading4` varchar(255) DEFAULT NULL,
  `heading5` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `headingelements`
--

CREATE TABLE IF NOT EXISTS `headingelements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `h1elements` text,
  `h2elements` text,
  `h3elements` text,
  `h4elements` text,
  `h5elements` text,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE IF NOT EXISTS `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `src` text,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `mailhistory`
--

CREATE TABLE IF NOT EXISTS `mailhistory` (
  `MailHistoryId` int(10) NOT NULL AUTO_INCREMENT,
  `CustomerId` int(10) NOT NULL,
  `EmailId` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `MailSentOn` date NOT NULL,
  PRIMARY KEY (`MailHistoryId`),
  KEY `MailHistoryId` (`MailHistoryId`),
  KEY `FK_mailhistory_customers` (`CustomerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `monitor`
--

CREATE TABLE IF NOT EXISTS `monitor` (
  `CrawlID` int(10) NOT NULL AUTO_INCREMENT,
  `StartKeywordID` int(10) DEFAULT NULL,
  `EndKeywordID` int(10) DEFAULT NULL,
  `CrawlInitTime` timestamp NULL DEFAULT NULL,
  `CrawlStartTime` timestamp NULL DEFAULT NULL,
  `CrawlEndTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`CrawlID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pagelinks`
--

CREATE TABLE IF NOT EXISTS `pagelinks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `links` text,
  `title` text,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE IF NOT EXISTS `payments` (
  `PaymentID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(11) NOT NULL DEFAULT '0',
  `PlanID` int(11) DEFAULT '0',
  `ResellerId` int(11) DEFAULT '0',
  `Amount` float(11,0) NOT NULL DEFAULT '0',
  `BeginDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `PaymentDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `PayerID` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `EbayTransactionID` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Plan` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`PaymentID`),
  KEY `PlanID` (`PlanID`),
  KEY `CustomerID` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `plans`
--

CREATE TABLE IF NOT EXISTS `plans` (
  `PlanID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL DEFAULT '0',
  `Amount` int(5) NOT NULL DEFAULT '0',
  `Currency` varchar(5) NOT NULL DEFAULT 'USD',
  `Campaigns` int(11) NOT NULL,
  `Keywords` int(11) NOT NULL,
  `Users` int(11) NOT NULL,
  PRIMARY KEY (`PlanID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `plans`
--

INSERT INTO `plans` (`PlanID`, `Name`, `Amount`, `Currency`, `Campaigns`, `Keywords`, `Users`) VALUES
(1, 'FreeBeta', 0, 'USD', 1, 20, 1),
(2, 'Newbie', 10, 'USD', 5, 100, 1),
(3, 'Individual', 20, 'USD', 10, 200, 1),
(4, 'Master', 35, 'USD', 30, 500, 3),
(5, 'Professional', 60, 'USD', 50, 1000, 5),
(6, 'Agency', 150, 'USD', 250, 5000, 10),
(7, 'Reseller', 300, 'USD', 500, 10000, 10000),
(8, 'Enterprise', 800, 'USD', 1500, 30000, 10000),
(9, 'Add50Keywords', 5, 'USD', 0, 50, 0);

-- --------------------------------------------------------

--
-- Table structure for table `proxydata`
--

CREATE TABLE IF NOT EXISTS `proxydata` (
  `ProxyID` int(11) NOT NULL AUTO_INCREMENT,
  `DateAdded` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `IPAddress` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PortNo` int(6) NOT NULL,
  `ProxyUser` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ProxyPassword` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Blocked` int(1) DEFAULT '0',
  `UseCount` int(10) DEFAULT '0',
  `HttpStatusCode` int(10) DEFAULT '0',
  `Exception` varchar(100) COLLATE utf8_unicode_ci DEFAULT '',
  `PageSource` varchar(5000) COLLATE utf8_unicode_ci DEFAULT '',
  `Url` varchar(200) COLLATE utf8_unicode_ci DEFAULT '',
  `GoogleBlocked` int(1) DEFAULT '0',
  `ResponseTime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ProxyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `relatedwebsite`
--

CREATE TABLE IF NOT EXISTS `relatedwebsite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `relatedLinks` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reportfrequency`
--

CREATE TABLE IF NOT EXISTS `reportfrequency` (
  `FrequencyId` int(10) NOT NULL AUTO_INCREMENT,
  `FrequencyDetail` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`FrequencyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reseller`
--

CREATE TABLE IF NOT EXISTS `reseller` (
  `ResellerId` bigint(32) NOT NULL AUTO_INCREMENT,
  `PaymentID` bigint(32) NOT NULL DEFAULT '0',
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `Phone` varchar(30) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `City` varchar(20) NOT NULL,
  `State` varchar(20) NOT NULL,
  `Country` varchar(20) NOT NULL,
  `ZipCode` int(10) NOT NULL,
  `AllowedUserCount` int(10) NOT NULL,
  `ActiveUserCount` int(10) NOT NULL,
  `AllowedCampaignsCount` int(10) NOT NULL,
  `ActiveCampaignsCount` int(10) NOT NULL,
  `AllowedKeywordCount` int(10) NOT NULL,
  `ActiveKeywordCount` int(10) NOT NULL,
  `TimezoneID` varchar(50) NOT NULL,
  `TimezoneValue` varchar(50) NOT NULL,
  `AlertEmailID` varchar(50) NOT NULL,
  `AlertNotificationCount` varchar(50) NOT NULL,
  `CompanyURLLink` varchar(200) NOT NULL,
  `CompanyLogoLink` varchar(200) NOT NULL,
  `CompanyDescription` varchar(200) NOT NULL,
  PRIMARY KEY (`ResellerId`),
  KEY `ResellerId` (`ResellerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reviewsite`
--

CREATE TABLE IF NOT EXISTS `reviewsite` (
  `ReviewSiteId` int(11) NOT NULL AUTO_INCREMENT,
  `AddedDate` datetime NOT NULL,
  `ReviewSiteURL` varchar(255) NOT NULL,
  `Visibility` smallint(6) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  PRIMARY KEY (`ReviewSiteId`),
  KEY `CustomerId` (`CustomerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `seokeyworddetails`
--

CREATE TABLE IF NOT EXISTS `seokeyworddetails` (
  `SEOKeywordId` int(11) NOT NULL AUTO_INCREMENT,
  `CampaignID` int(11) NOT NULL DEFAULT '0',
  `KeywordID` int(11) NOT NULL DEFAULT '0',
  `Url` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Keyword` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `SearchVolume` int(11) NOT NULL DEFAULT '0',
  `GoogleCPC` float NOT NULL DEFAULT '0',
  `KeywordCompetition` float NOT NULL DEFAULT '0',
  `NumberofResult` bigint(20) unsigned NOT NULL DEFAULT '0',
  `GooglePA` int(11) NOT NULL DEFAULT '0',
  `GoogleDA` int(11) NOT NULL DEFAULT '0',
  `SiteIndexing` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `AddedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `RankPage` int(11) NOT NULL DEFAULT '0',
  `RankAlexa` int(11) NOT NULL DEFAULT '0',
  `CountBackLinks` int(11) NOT NULL DEFAULT '0',
  `CountMonthlySearches` int(11) NOT NULL DEFAULT '0',
  `Visibility` int(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`SEOKeywordId`),
  KEY `CampaignID` (`CampaignID`),
  KEY `KeywordID` (`KeywordID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `serpkeywordgoal`
--

CREATE TABLE IF NOT EXISTS `serpkeywordgoal` (
  `SerpKeywordGoalId` int(11) NOT NULL AUTO_INCREMENT,
  `SerpKeywordId` int(11) NOT NULL DEFAULT '0',
  `GoalRank` smallint(6) NOT NULL DEFAULT '0',
  `GoalDate` datetime NOT NULL,
  `AddedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`SerpKeywordGoalId`),
  KEY `SerpKeywordId` (`SerpKeywordId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `serpkeywords`
--

CREATE TABLE IF NOT EXISTS `serpkeywords` (
  `KeywordID` int(11) NOT NULL AUTO_INCREMENT,
  `CampaignID` int(11) NOT NULL,
  `Url` varchar(200) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Keyword` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `LinkGoogle` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT 'Google URL',
  `Region` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT 'Google URL',
  `RankGoogle` int(11) NOT NULL DEFAULT '0',
  `BestMatchRankGoogle` int(11) NOT NULL DEFAULT '0',
  `BestMatchLinkGoogle` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GooglePageRank` int(2) NOT NULL DEFAULT '0',
  `RankBing` int(11) NOT NULL DEFAULT '0',
  `BestMatchRankBing` int(11) NOT NULL DEFAULT '0',
  `BestMatchLinkBing` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RankYahoo` int(11) NOT NULL DEFAULT '0',
  `BestMatchRankYahoo` int(11) NOT NULL DEFAULT '0',
  `BestMatchLinkYahoo` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RankGoogleDayChange` int(11) NOT NULL DEFAULT '0',
  `RankGoogleWeekChange` int(11) NOT NULL DEFAULT '0',
  `RankGoogleMonthChange` int(11) NOT NULL DEFAULT '0',
  `RankBingDayChange` int(11) NOT NULL DEFAULT '0',
  `RankBingWeekChange` int(11) NOT NULL DEFAULT '0',
  `RankBingMonthChange` int(11) NOT NULL DEFAULT '0',
  `RankYahooDayChange` int(11) NOT NULL DEFAULT '0',
  `RankYahooWeekChange` int(11) NOT NULL DEFAULT '0',
  `RankYahooMonthChange` int(11) NOT NULL DEFAULT '0',
  `GoogleUpdatedDate` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `YahooUpdateDate` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BingUpdateDate` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Visibility` int(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`KeywordID`),
  KEY `CampaignID` (`CampaignID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `serpstrackhistory`
--

CREATE TABLE IF NOT EXISTS `serpstrackhistory` (
  `TrackId` int(10) NOT NULL AUTO_INCREMENT,
  `TrackDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `KeywordId` int(10) NOT NULL,
  `SearchEngine` varchar(10) NOT NULL,
  `Rank` int(4) DEFAULT NULL,
  `BestMatchRank` int(4) DEFAULT NULL,
  `BestMatchLink` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`TrackId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `site`
--

CREATE TABLE IF NOT EXISTS `site` (
  `SiteId` bigint(44) NOT NULL AUTO_INCREMENT,
  `ResellerId` bigint(44) NOT NULL DEFAULT '0',
  `Ip` varchar(60) NOT NULL,
  `Domain` varchar(200) NOT NULL,
  `Logo` varchar(200) DEFAULT NULL,
  `Css` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `socialreview`
--

CREATE TABLE IF NOT EXISTS `socialreview` (
  `SocialreviewId` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerId` int(11) NOT NULL,
  `FacebookURL` int(11) NOT NULL,
  `Facebookabout` int(11) NOT NULL,
  `Facebookcoverphoto` longblob NOT NULL,
  `Facebooklikes` int(11) NOT NULL,
  `Facebookname` int(11) NOT NULL,
  `Facebooktalkingabout` int(11) NOT NULL,
  `Visibility` int(11) NOT NULL,
  `ReviewSiteId` int(11) NOT NULL,
  PRIMARY KEY (`SocialreviewId`),
  KEY `ReviewSiteId` (`ReviewSiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `socialsignalurls`
--

CREATE TABLE IF NOT EXISTS `socialsignalurls` (
  `SocialSignalUrlID` int(11) NOT NULL AUTO_INCREMENT,
  `CampaignID` int(11) NOT NULL,
  `SocialSignalUrl` varchar(255) NOT NULL,
  `FacebookLike` int(11) NOT NULL,
  `FacebookShare` int(11) NOT NULL,
  `TweetCount` int(11) NOT NULL,
  `PinterestPins` int(11) NOT NULL,
  `GooglePlusLikes` int(11) NOT NULL,
  `LinkedInShares` int(11) NOT NULL,
  `RedittVotes` int(11) NOT NULL,
  `StumbleUponLikes` int(11) NOT NULL,
  `Visibility` int(2) NOT NULL,
  PRIMARY KEY (`SocialSignalUrlID`),
  KEY `CampaignID` (`CampaignID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `socialtrackhistory`
--

CREATE TABLE IF NOT EXISTS `socialtrackhistory` (
  `TrackId` int(10) NOT NULL AUTO_INCREMENT,
  `TrackDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SocialSignalUrlID` int(10) DEFAULT NULL,
  `FaceBookLike` int(11) DEFAULT NULL,
  `FaceBookShare` int(11) DEFAULT NULL,
  `TweetCount` int(11) DEFAULT NULL,
  `PinterestPin` int(11) DEFAULT NULL,
  `GooglePlus` int(11) DEFAULT NULL,
  `LinkedInShare` int(11) DEFAULT NULL,
  `RedittVote` int(11) DEFAULT NULL,
  `StumbleUponStumble` int(11) DEFAULT NULL,
  PRIMARY KEY (`TrackId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `technology`
--

CREATE TABLE IF NOT EXISTS `technology` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `analytics` varchar(255) DEFAULT NULL,
  `tech_used` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `trackhistory`
--

CREATE TABLE IF NOT EXISTS `trackhistory` (
  `TrackID` int(11) NOT NULL AUTO_INCREMENT,
  `TrackDate` date NOT NULL,
  `KeywordID` int(11) NOT NULL,
  `RankGoogle` int(11) NOT NULL DEFAULT '0',
  `BestMatchRankGoogle` int(11) NOT NULL DEFAULT '0',
  `BestMatchLinkGoogle` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `RankBing` int(11) NOT NULL DEFAULT '0',
  `BestMatchRankBing` int(11) NOT NULL DEFAULT '0',
  `BestMatchLinkBing` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `RankYahoo` int(11) NOT NULL DEFAULT '0',
  `BestMatchRankYahoo` int(11) NOT NULL DEFAULT '0',
  `BestMatchLinkYahoo` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `RankPage` int(11) NOT NULL DEFAULT '0',
  `RankAlexa` int(11) NOT NULL DEFAULT '0',
  `CountBackLinks` int(11) NOT NULL DEFAULT '0',
  `CountMonthlySearches` int(11) NOT NULL DEFAULT '0',
  `FacebookLike` int(11) NOT NULL DEFAULT '0',
  `FacebookShare` int(11) NOT NULL DEFAULT '0',
  `TweetCount` int(11) NOT NULL DEFAULT '0',
  `PinterestPins` int(11) NOT NULL DEFAULT '0',
  `GooglePlusLikes` int(11) NOT NULL DEFAULT '0',
  `LinkedInShares` int(11) NOT NULL DEFAULT '0',
  `RedittVotes` int(11) NOT NULL DEFAULT '0',
  `StumbleUponLikes` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`TrackID`),
  KEY `KeywordID` (`KeywordID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `UserID` int(10) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(10) NOT NULL DEFAULT '0',
  `ResellerId` int(10) DEFAULT '0',
  `LoginID` varchar(60) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `Password` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0',
  `UserType` int(11) DEFAULT '0',
  `active` int(2) NOT NULL,
  `Addeddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  KEY `FK__customers` (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `videokeywords`
--

CREATE TABLE IF NOT EXISTS `videokeywords` (
  `VideokeywordID` int(11) NOT NULL AUTO_INCREMENT,
  `CampaignID` int(11) NOT NULL DEFAULT '0',
  `VideoKeyword` varchar(200) NOT NULL DEFAULT '0',
  `YoutubeURL` varchar(255) NOT NULL DEFAULT '0',
  `RankYoutube` smallint(6) NOT NULL DEFAULT '0',
  `VimeoURL` varchar(255) DEFAULT '0',
  `RankVimeo` smallint(6) NOT NULL DEFAULT '0',
  `DailymotionURL` varchar(255) DEFAULT '0',
  `RankDailyMotion` smallint(6) NOT NULL DEFAULT '0',
  `MetacafeURL` varchar(255) DEFAULT '0',
  `RankMetacafe` smallint(6) NOT NULL DEFAULT '0',
  `Youtubeviewcoint` int(11) NOT NULL DEFAULT '0',
  `YoutubeLikeCount` int(11) NOT NULL DEFAULT '0',
  `YoutubeDislikeCount` int(11) NOT NULL DEFAULT '0',
  `YoutubeCommentCount` int(11) NOT NULL DEFAULT '0',
  `YoutubeDailyViewcount` smallint(5) unsigned NOT NULL DEFAULT '0',
  `Visibility` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`VideokeywordID`),
  KEY `CampaignID` (`CampaignID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `videotrackhistory`
--

CREATE TABLE IF NOT EXISTS `videotrackhistory` (
  `VideoTrackId` int(10) NOT NULL AUTO_INCREMENT,
  `TrackDate` date NOT NULL,
  `VideoKeywordID` int(11) NOT NULL,
  `VideoKeyword` varchar(100) NOT NULL,
  `VideoEngine` varchar(100) NOT NULL,
  `VideoRank` int(11) NOT NULL,
  `VideoURL` varchar(255) NOT NULL,
  PRIMARY KEY (`VideoTrackId`),
  KEY `VideoKeywordID` (`VideoKeywordID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `visitorarray`
--

CREATE TABLE IF NOT EXISTS `visitorarray` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `percent` varchar(255) DEFAULT NULL,
  `rank` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `xmldata`
--

CREATE TABLE IF NOT EXISTS `xmldata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `xmlfiles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alertsdata`
--
ALTER TABLE `alertsdata`
  ADD CONSTRAINT `alertsdata_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`);

--
-- Constraints for table `campaignkeywords`
--
ALTER TABLE `campaignkeywords`
  ADD CONSTRAINT `campaignkeywords_ibfk_1` FOREIGN KEY (`CampaignId`) REFERENCES `campaigns` (`CampaignID`);

--
-- Constraints for table `campaigns`
--
ALTER TABLE `campaigns`
  ADD CONSTRAINT `FK_campaigns_customers` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`);

--
-- Constraints for table `displaysettings`
--
ALTER TABLE `displaysettings`
  ADD CONSTRAINT `FK_displaysettings_customers` FOREIGN KEY (`CustomerId`) REFERENCES `customers` (`CustomerID`);

--
-- Constraints for table `mailhistory`
--
ALTER TABLE `mailhistory`
  ADD CONSTRAINT `FK_mailhistory_customers` FOREIGN KEY (`CustomerId`) REFERENCES `customers` (`CustomerID`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`PlanID`) REFERENCES `plans` (`PlanID`),
  ADD CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`);

--
-- Constraints for table `reviewsite`
--
ALTER TABLE `reviewsite`
  ADD CONSTRAINT `reviewsite_ibfk_1` FOREIGN KEY (`CustomerId`) REFERENCES `customers` (`CustomerID`);

--
-- Constraints for table `seokeyworddetails`
--
ALTER TABLE `seokeyworddetails`
  ADD CONSTRAINT `seokeyworddetails_ibfk_1` FOREIGN KEY (`CampaignID`) REFERENCES `campaigns` (`CampaignID`),
  ADD CONSTRAINT `seokeyworddetails_ibfk_2` FOREIGN KEY (`KeywordID`) REFERENCES `serpkeywords` (`KeywordID`);

--
-- Constraints for table `serpkeywords`
--
ALTER TABLE `serpkeywords`
  ADD CONSTRAINT `FK_CampaignID` FOREIGN KEY (`CampaignID`) REFERENCES `campaigns` (`CampaignID`);

--
-- Constraints for table `socialreview`
--
ALTER TABLE `socialreview`
  ADD CONSTRAINT `socialreview_ibfk_1` FOREIGN KEY (`ReviewSiteId`) REFERENCES `reviewsite` (`ReviewSiteId`);

--
-- Constraints for table `socialsignalurls`
--
ALTER TABLE `socialsignalurls`
  ADD CONSTRAINT `socialsignalurls_ibfk_1` FOREIGN KEY (`CampaignID`) REFERENCES `campaigns` (`CampaignID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK__customers` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`);

--
-- Constraints for table `videokeywords`
--
ALTER TABLE `videokeywords`
  ADD CONSTRAINT `CampaignID` FOREIGN KEY (`CampaignID`) REFERENCES `campaigns` (`CampaignID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
