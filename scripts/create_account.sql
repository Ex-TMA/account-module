CREATE TABLE `Account` (
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `accountId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `passWord` varchar(64) DEFAULT NULL,
  `state` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `timeToLiveInMinutes` int(11) DEFAULT NULL,
  PRIMARY KEY (`accountId`),
  UNIQUE KEY `passWord` (`passWord`),
  UNIQUE KEY `userName` (`userName`),
  KEY `state` (`state`),
  KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=601 DEFAULT CHARSET=latin1

CREATE TABLE `AccountAccess` (
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `accountId` int(11) NOT NULL,
  `access` varchar(50) NOT NULL,
  PRIMARY KEY (`accountId`,`access`),
  KEY `access` (`access`),
  CONSTRAINT `AccountAccess_ibfk_1` FOREIGN KEY (`accountId`) REFERENCES `Account` (`accountId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `AccountToken` (
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `counter` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `token` varchar(64) NOT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`counter`),
  UNIQUE KEY `token` (`token`),
  KEY `accountId` (`accountId`),
  KEY `createdAt` (`createdAt`),
  CONSTRAINT `AccountToken_ibfk_1` FOREIGN KEY (`accountId`) REFERENCES `Account` (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=latin1