CREATE TABLE `authorities`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `authority` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `persistent_logins`
(
    `series`    varchar(100) NOT NULL,
    `username`  varchar(255) DEFAULT NULL,
    `token`     varchar(255) DEFAULT NULL,
    `last_used` datetime     DEFAULT NULL,
    PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `users`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;