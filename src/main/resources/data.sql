drop table if exists customers;
drop table if exists accounts;

create table customers (
    customerid varchar(8) primary key,
    first_name varchar(30) not null,
    surname varchar(250) not null,
    date_of_birth date not null
);

insert into customers (customerid, first_name, surname, date_of_birth) values
    ('00000001', 'Jean', 'Picard', '1980-01-01'),
    ('00000002', 'James', 'Kirk', '1982-03-11'),
    ('00000003', 'Ben', 'Sisko', '1990-11-04'),
    ('00000004', 'Catherine', 'Janeway', '1985-06-10'),
    ('00000005', 'Walter', 'White', '1970-06-10');

create table accounts (
    customerid varchar(8) not null,
    account_number varchar(8) primary key,
    account_type varchar(30) not null,
    open_account bit default 1,
    joint_account bit default 0
);

insert into accounts (customerid, account_number, account_type, open_account, joint_account) values
    ('00000001', '10000001', 'Current Account', 1, 0),
    ('00000002', '10000002', 'Current Account', 1, 1),
    ('00000002', '10000003', 'Savings Account', 1, 1),
    ('00000003', '10000004', 'Current Account', 0, 1),
    ('00000003', '10000005', 'Loan', 1, 0),
    ('00000004', '10000006', 'Current Account', 0, 0),
    ('00000004', '10000007', 'Savings Account', 1, 1),
    ('00000004', '10000008', 'Loan', 1, 0);

