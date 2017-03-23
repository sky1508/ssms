CREATE USER 'ssms_admin'@'localhost' IDENTIFIED BY 'ssms@123';
GRANT ALL ON `ssms`.* TO 'ssms_admin'@'localhost';

CREATE TABLE `ssms`.`student` (
  `student_id` INT NOT NULL,
  `student_name` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`student_id`));

CREATE TABLE `ssms`.`subject` (
  `subject_id` INT NOT NULL,
  `subject_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`subject_id`));
  
CREATE TABLE `ssms`.`result` (
  `id` INT NOT NULL,
  `student_id` INT NULL,
  `subject_id` INT NULL,
  `marks` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `student_id_idx` (`student_id` ASC),
  INDEX `subject_id_idx` (`subject_id` ASC),
  CONSTRAINT `student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `ssms`.`student` (`student_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `subject_id`
    FOREIGN KEY (`subject_id`)
    REFERENCES `ssms`.`subject` (`subject_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);