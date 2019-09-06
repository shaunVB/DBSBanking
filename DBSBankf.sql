create database DBSBankf;
CREATE TABLE `DBSBankf`.`Aadhar_Details` ( `Aadhar_No` INT(12) UNSIGNED NOT NULL , `Name` VARCHAR(40) NOT NULL , `Address` VARCHAR(100) NOT NULL , `DOB` DATE NOT NULL , `Mobile_No` INT(10) NOT NULL , PRIMARY KEY (`Aadhar_No`)) ENGINE = InnoDB;

CREATE TABLE `DBSBankf`.`Customer_Registration_Table` ( `Aadhar_No` INT(12) UNSIGNED NOT NULL , `Name` VARCHAR(40) NOT NULL , `Customer_Id` INT(20) NOT NULL , `Account_No` INT(20) NOT NULL , `Address` VARCHAR(100) NOT NULL , PRIMARY KEY (`Customer_Id`, `Account_No`)) ENGINE = InnoDB;

CREATE TABLE `DBSBankf`.`Customer_Name` ( `Name` VARCHAR(40) NOT NULL , `First_Name` VARCHAR(40) NOT NULL , `Middle_Name` VARCHAR(40) NOT NULL , `Last_Name` VARCHAR(40) NOT NULL , PRIMARY KEY (`Name`)) ENGINE = InnoDB;

CREATE TABLE `DBSBankf`.`Customer_Details` ( `Customer_Id` INT(20) NOT NULL , `Salutation` VARCHAR(10) NOT NULL , `Mobile_No` INT(20) NOT NULL , `E-mail` VARCHAR(40) NOT NULL , `Gender` VARCHAR(20) NOT NULL , `DOB` DATE NOT NULL , `Nationality` VARCHAR(30) NOT NULL ) ENGINE = InnoDB;

CREATE TABLE `DBSBankf`.`Bank_Details` ( `Account_No` INT(20) NOT NULL , `Bank` VARCHAR(40) NOT NULL , `Branch` VARCHAR(40) NOT NULL , `IFSC_Code` VARCHAR(40) NOT NULL ) ENGINE = InnoDB;

CREATE TABLE `DBSBankf`.`Account_Details` ( `Account_No` INT(20) NOT NULL , `Account_Type` VARCHAR(40) NOT NULL , `Balance` INT(20) NOT NULL ) ENGINE = InnoDB;

CREATE TABLE `DBSBankf`.`Customer_Login` ( `Customer_Id` INT(20) NOT NULL , `Username` VARCHAR(40) NOT NULL , `Password` VARCHAR(20) NOT NULL ) ENGINE = InnoDB;

alter table `DBSBankf`.bank_details add column (Customer_Id int(20));

alter table `DBSBankf`.bank_details modify Customer_Id int(20) not null;

alter table `DBSBankf`.account_details add Customer_Id int(20) not null;

alter table `DBSBankf`.account_details add primary key(Account_No);

alter table `DBSBankf`.bank_details add primary key(Account_No);

alter table `DBSBankf`.customer_registration_table add constraint foreign key(Name) references customer_name(Name) on delete cascade on update cascade;

alter table `DBSBankf`.customer_details add constraint foreign key(Customer_Id) references customer_registration_table(Customer_Id) on delete cascade on update cascade;

alter table `DBSBankf`.account_details add constraint foreign key(Customer_Id) references customer_registration_table(Customer_Id) on delete cascade on update cascade;

alter table `DBSBankf`.bank_details add constraint foreign key(Customer_Id) references customer_registration_table(Customer_Id) on delete cascade on update cascade;

alter table `DBSBankf`.customer_login add constraint foreign key(Customer_Id) references customer_registration_table(Customer_Id) on delete cascade on update cascade;
