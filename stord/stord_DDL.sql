CREATE SCHEMA stord DEFAULT CHARACTER SET utf8 ;

CREATE TABLE stord.URL (
  ID INT NOT NULL AUTO_INCREMENT,
  LONG_URL LONGTEXT NOT NULL,
  SHORT_URL VARCHAR(100) ,
  PRIMARY KEY (ID),
  UNIQUE INDEX ID_UNIQUE (ID ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

