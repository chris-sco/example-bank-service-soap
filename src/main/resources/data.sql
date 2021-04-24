drop table if exists customers;
drop table if exists accounts;

create table customers (
    customerID varchar(8) primary key,
    firstName varchar(30) not null,
    surname varchar(250) not null,
    dateOfBirth date not null
);

insert into customers (customerID, firstName, surname, dateOfBirth) values
    ('00000001', 'Jean', 'Picard', '1980-01-01'),
    ('00000002', 'James', 'Kirk', '1982-03-11'),
    ('00000003', 'Ben', 'Sisko', '1990-11-04'),
    ('00000004', 'Catherine', 'Janeway', '1985-06-10'),
    ('00000005', 'Walter', 'White', '1970-06-10');

create table accounts (
    customerID varchar(8) not null,
    accountNumber varchar(8) primary key,
    accountType varchar(30) not null,
    openAccount bit default 1,
    jointAccount bit default 0
);

insert into accounts (customerID, accountNumber, accountType, openAccount, jointAccount) values
    ('00000001', '10000001', 'Current Account', 1, 0),
    ('00000002', '10000002', 'Current Account', 1, 1),
    ('00000002', '10000003', 'Savings Account', 1, 1),
    ('00000003', '10000004', 'Current Account', 0, 1),
    ('00000003', '10000005', 'Loan', 1, 0),
    ('00000004', '10000006', 'Current Account', 0, 0),
    ('00000004', '10000007', 'Savings Account', 1, 1),
    ('00000004', '10000008', 'Loan', 1, 0);

