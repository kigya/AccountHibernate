# A simple Java Clean Architecture money transfer system

### Overview


##### 📁 Tech Stack
[Java](https://www.java.com/en/)\
[Maven](https://maven.apache.org/)\
[PostgreSQL](https://www.postgresql.org/)\
[Hibernate](https://hibernate.org/)\
[Lombok](https://projectlombok.org/)\
[Log4j2](https://logging.apache.org/log4j/2.x/)\
[JetBrains Annotations](https://www.jetbrains.com/help/idea/annotating-source-code.html#bundled-annotations)


##### 📁 Database UML Diagram
![credit_card](https://user-images.githubusercontent.com/73034324/163497552-065d42f5-fc9e-4100-92b0-5c3ef2756338.png)


##### 📁 Example of a query to create a database

```sql
create table gender_info
(
    id   smallserial
        constraint gender_info_pk
            primary key,
    info varchar(30) not null
);

comment on table gender_info is 'Gender number-string connection';

comment on column gender_info.id is 'Gender ID';

comment on column gender_info.info is 'Gender info';

create table account
(
    id             serial
        constraint account_pk
            primary key,
    email          varchar(40)          not null,
    password       varchar(256)         not null,
    username       varchar(12)          not null,
    bio            varchar(256),
    gender         smallint             not null
        constraint account_gender_info_id_fk
            references gender_info,
    country        varchar(30)          not null,
    city           varchar(30),
    street_address varchar(50),
    is_active      boolean default true not null
);

comment on table account is 'User accounts';

comment on column account.id is 'Account ID';

comment on column account.email is 'Account email';

comment on column account.password is 'Account password';

comment on column account.username is 'User username';

comment on column account.bio is 'User bio';

comment on column account.gender is 'User gender';

comment on column account.country is 'User country';

comment on column account.city is 'Address city';

comment on column account.street_address is 'User street address';

comment on column account.is_active is 'User activity status';

create unique index account_email_uindex
    on account (email);

create unique index account_id_uindex
    on account (id);

create unique index gender_info_id_uindex
    on gender_info (id);

create unique index gender_info_info_uindex
    on gender_info (info);

create table credit_card_type_info
(
    id   smallserial
        constraint credit_card_type_info_pk
            primary key,
    info varchar(30) not null
);

comment on column credit_card_type_info.id is 'Credit card ID';

comment on column credit_card_type_info.info is 'Credit card info';

create table credit_card
(
    id          integer default nextval('credit_cards_id_seq'::regclass)         not null
        constraint credit_cards_pk
            primary key,
    card_number bigint                                                           not null,
    card_type   smallint                                                         not null
        constraint credit_card_credit_card_type_info_id_fk
            references credit_card_type_info,
    balance     numeric(10, 3)                                                   not null,
    account_id  integer default nextval('credit_cards_account_id_seq'::regclass) not null
        constraint credit_card_account_id_fk
            references account
            on delete cascade
);

comment on column credit_card.id is 'Credit card ID';

comment on column credit_card.card_number is 'Credit card number';

comment on column credit_card.card_type is 'User card type';

comment on column credit_card.balance is 'Credit card balance';

comment on column credit_card.account_id is 'Account ID reference';

create unique index credit_cards_card_number_uindex
    on credit_card (card_number);

create unique index credit_cards_id_uindex
    on credit_card (id);

create unique index credit_card_type_info_id_uindex
    on credit_card_type_info (id);

create unique index credit_card_type_info_info_uindex
    on credit_card_type_info (info);
```


##### 📁 JSON Parsing Query

```sql
with account_json (doc) as (
    values (''::json)
)
insert
into account (id, email, password, username, bio, gender, country, city, street_address, is_active)
select p.*
from account_json l
         cross join lateral json_populate_recordset(null::account, doc) as p
on conflict (id) do update
    set (email, password, username, bio, gender, country, city, street_address, is_active) =
            (excluded.email, excluded.password, excluded.username, excluded.bio,
             excluded.gender, excluded.country, excluded.city, excluded.street_address, excluded.street_address)
```
