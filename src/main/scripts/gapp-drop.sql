
    alter table application 
        drop constraint FK_g5s17lcstdjeagtvhavy3kngu;

    alter table application 
        drop constraint FK_d4wgtxy25s6tqdnah3h4rc5c1;

    alter table application 
        drop constraint FK_1oshvkdyivl8odu9wqvgbljb3;

    alter table applicationstatus 
        drop constraint FK_7jwujewncukhec7in0brbysn4;

    alter table files 
        drop constraint FK_ncghh9puu45tevoc5a0n63sjb;

    alter table files 
        drop constraint FK_na5t7lbl1ygw4v5m31ncrx8k5;

    alter table programs 
        drop constraint FK_7uqveppgk7t923t3bl20dgyql;

    alter table requirements 
        drop constraint FK_ow8k0yxr4mtk0mm40135n7t9k;

    alter table students 
        drop constraint FK_fsbgwl8grwq8ebm12ig0ow2j4;

    alter table studentsedu 
        drop constraint FK_61x7ieabbpe1r3ywvl6gwlm2t;

    alter table studentsedu 
        drop constraint FK_eg4b8kp4g2gg67ya9i2xe3pxb;

    drop table if exists application cascade;

    drop table if exists applicationstatus cascade;

    drop table if exists departments cascade;

    drop table if exists files cascade;

    drop table if exists programs cascade;

    drop table if exists requirements cascade;

    drop table if exists students cascade;

    drop table if exists studentsedu cascade;

    drop table if exists users cascade;

    drop sequence hibernate_sequence;
