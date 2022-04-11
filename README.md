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
![account](https://user-images.githubusercontent.com/73034324/162642669-b1bae58e-9ff1-4f9b-ab61-1030a8a91f24.png)



##### 📁 Example of a query to create a database

```sql
create sequence accounts_id_seq
    as integer;

create sequence users_id_seq
    as integer;

create sequence addresses_id_seq
    as integer;

create table account
(
    id       integer default nextval('accounts_id_seq'::regclass) not null
        constraint accounts_pk
            primary key,
    email    varchar(30)                                          not null,
    password varchar(16)                                          not null
);

comment on table account is 'User accounts data';

comment on column account.id is 'Account ID';

comment on column account.email is 'Account email';

comment on column account.password is 'Account password';

alter sequence accounts_id_seq owned by account.id;

create unique index accounts_email_uindex
    on account (email);

create unique index accounts_id_uindex
    on account (id);

create table "user"
(
    id       integer default nextval('users_id_seq'::regclass) not null
        constraint users_accounts_id_fk
            references account,
    username varchar(20)                                       not null,
    bio      varchar(256),
    gender   varchar(30)                                       not null
);

comment on column "user".id is 'Account ID';

comment on column "user".username is 'User username';

comment on column "user".bio is 'User bio';

comment on column "user".gender is 'User gender';

alter sequence users_id_seq owned by "user".id;

create unique index users_id_uindex
    on "user" (id);

create unique index users_username_uindex
    on "user" (username);

create table address
(
    id             integer default nextval('addresses_id_seq'::regclass) not null
        constraint addresses_users_id_fk
            references "user" (id),
    country        varchar(30)                                           not null,
    city           varchar(30),
    street_address varchar(50)
);

comment on table address is 'User addresses';

comment on column address.id is 'Account ID';

comment on column address.country is 'Address country';

comment on column address.city is 'Address city';

comment on column address.street_address is 'User street address';

alter sequence addresses_id_seq owned by address.id;

create unique index addresses_id_uindex
    on address (id);

create table credit_card
(
    id          serial
        constraint credit_card_account_id_fk
            references account,
    card_number integer                    not null,
    card_type   varchar                    not null,
    balance     numeric(10, 3) default 0.0 not null
);

comment on column credit_card.id is 'Account ID';

comment on column credit_card.card_number is 'Credit card number';

comment on column credit_card.card_type is 'Credit card type';

comment on column credit_card.balance is 'Credit card balance';
```

##### 📁 JSON Parsing Query

```sql
with account_json (doc) as (
    values (''::json)
)
insert
into account (id, email,password)
select p.*
from account_json l
         cross join lateral json_populate_recordset(null::account, doc) as p
on conflict (id) do update
    set (email, password) =
            (excluded.email, excluded.password)
```
