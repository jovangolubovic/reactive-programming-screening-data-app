drop table if exists screening_result;
drop table if exists screening_task;

create table screening_result
(
    id                                 bigint AUTO_INCREMENT,
    booked_by_customer_code            bigint,
    booked_by_customer_name            varchar(255),
    cargo_documentation_description    varchar(255),
    commodity_code                     varchar(255),
    commodity_description              varchar(255),
    consignee_address_line1            varchar(255),
    consignee_customer_code            bigint,
    consignee_customer_name            varchar(255),
    contractual_customer_customer_code bigint,
    contractual_customer_customer_name varchar(255),
    first_notify_address_line1         varchar(255),
    first_notify_customer_code         bigint,
    first_notify_customer_name         varchar(255),
    haz                                varchar(255),
    operator                           varchar(255),
    pod_country_name                   varchar(255),
    por_country_name                   varchar(255),
    second_notify_address_line1        varchar(255),
    second_notify_customer_code        bigint,
    second_notify_customer_name        varchar(255),
    shipment_number                    bigint,
    shipper_address_line1              varchar(255),
    shipper_address_line2              varchar(255),
    shipper_customer_code              bigint,
    shipper_customer_name              varchar(255),
    tp_doc                             bigint,
    primary key (id)
);

create table if not exists screening_task
(
    id                   BIGINT    AUTO_INCREMENT,
    result_id            BIGINT       NOT NULL,
    assigned_to          VARCHAR(256) NOT NULL,
    status               VARCHAR(256) NOT NULL,
    created_at           TIMESTAMP    NOT NULL,
    updated_at           TIMESTAMP    NOT NULL,
    CONSTRAINT result_unique UNIQUE (result_id),
    CONSTRAINT task_management_pk PRIMARY KEY (id)
    );

alter table screening_result
    add column screening_task_id bigint;

alter table screening_result
    add constraint screening_task_fk
        foreign key (screening_task_id) references screening_task (id);
