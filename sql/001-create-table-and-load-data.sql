DROP TABLE IF EXISTS members;

CREATE TABLE members (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  birth_date DATE NOT NULL,
  enrollment_date DATE NOT NULL,
  school_name VARCHAR(20) NOT NULL,
  grade int unsigned NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT grade_check CHECK (grade>=1 and grade<=6)
);

INSERT INTO members (name, birth_date, enrollment_date, school_name, grade) VALUES
 ("青木青太郎", "2012-01-01", "2022-04-01", "青林小学校", 6),
 ("緑沼みどり", "2011-10-10", "2021-09-15", "緑池中学校", 1),
 ("水山水樹", "2016-04-01", "2023-11-28", "青林小学校", 3),
 ("赤谷赤子", "2011-07-04", "2023-07-20", "赤滝中学校", 1);
