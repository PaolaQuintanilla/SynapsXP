/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     31/05/2017 03:00:27 p. m.                    */
/*==============================================================*/


drop table if exists CATEGORIA;

drop table if exists CLIENTE;

drop table if exists DETALLE_PEDIDO;

drop table if exists DETALLE_PROVEEDOR;

drop table if exists PAIS;

drop table if exists PEDIDO;

drop table if exists PRODUCTO;

drop table if exists PROVEEDOR;

drop table if exists SUB_CATEGORIA;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: CATEGORIA                                             */
/*==============================================================*/
create table CATEGORIA
(
   ID_CATEGORIA         int not null auto_increment,
   CATEGORIA            varchar(20),
   primary key (ID_CATEGORIA)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   ID_CLIENTE           int not null auto_increment,
   CI                   varchar(15) not null,
   NOMBRE               varchar(30),
   DIRECCION            varchar(50),
   TELEFONO             int,
   CELULAR              int,
   CORREO               varchar(50),
   primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Table: DETALLE_PEDIDO                                        */
/*==============================================================*/
create table DETALLE_PEDIDO
(
   ID_PEDIDO            int,
   ID_DET_PRO           int,
   CANTIDAD             int,
   PRECIO_PARCIAL       double
);

/*==============================================================*/
/* Table: DETALLE_PROVEEDOR                                     */
/*==============================================================*/
create table DETALLE_PROVEEDOR
(
   ID_DET_PRO           int not null auto_increment,
   ID_PROVEEDOR         int,
   ID_PRODUCTO          int,
   PRECIO               double,
   primary key (ID_DET_PRO)
);

/*==============================================================*/
/* Table: PAIS                                                  */
/*==============================================================*/
create table PAIS
(
   ID_PAIS              int not null auto_increment,
   PAIS                 varchar(20),
   primary key (ID_PAIS)
);

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO
(
   ID_PEDIDO            int not null,
   ID_CLIENTE           int,
   ID_USER              int,
   FECHA_PEDIDO         date,
   FECHA_LLEGADA        date,
   PRECIO_TOTAL         double,
   ESTADO               bool,
   primary key (ID_PEDIDO)
);

/*==============================================================*/
/* Table: PRODUCTO                                              */
/*==============================================================*/
create table PRODUCTO
(
   ID_PRODUCTO          int not null,
   ID_SUB_CAT           int,
   PRODUCTO             varchar(50),
   MARCA                varchar(20),
   MODELO               varchar(20),
   primary key (ID_PRODUCTO)
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR
(
   ID_PROVEEDOR         int not null auto_increment,
   ID_PAIS              int,
   CI                   varchar(15) not null,
   NOMBRE               varchar(30),
   TELEFONO             int,
   CORREO               varchar(30),
   CUENTA               varchar(20),
   primary key (ID_PROVEEDOR)
);

/*==============================================================*/
/* Table: SUB_CATEGORIA                                         */
/*==============================================================*/
create table SUB_CATEGORIA
(
   ID_SUB_CAT           int not null auto_increment,
   ID_CATEGORIA         int,
   SUB_CATEGORIA        varchar(30),
   primary key (ID_SUB_CAT)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   ID_USER              int not null auto_increment,
   NOMBRE               varchar(30),
   CI                   varchar(20),
   USUARIO              varchar(15),
   PASSWORD             varchar(15),
   primary key (ID_USER)
);

alter table DETALLE_PEDIDO add constraint FK_REFERENCE_4 foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO) on delete restrict on update restrict;

alter table DETALLE_PEDIDO add constraint FK_REFERENCE_8 foreign key (ID_DET_PRO)
      references DETALLE_PROVEEDOR (ID_DET_PRO) on delete restrict on update restrict;

alter table DETALLE_PROVEEDOR add constraint FK_REFERENCE_6 foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR) on delete restrict on update restrict;

alter table DETALLE_PROVEEDOR add constraint FK_REFERENCE_7 foreign key (ID_PRODUCTO)
      references PRODUCTO (ID_PRODUCTO) on delete restrict on update restrict;

alter table PEDIDO add constraint FK_REFERENCE_10 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table PEDIDO add constraint FK_REFERENCE_5 foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE) on delete restrict on update restrict;

alter table PRODUCTO add constraint FK_REFERENCE_2 foreign key (ID_SUB_CAT)
      references SUB_CATEGORIA (ID_SUB_CAT) on delete restrict on update restrict;

alter table PROVEEDOR add constraint FK_REFERENCE_9 foreign key (ID_PAIS)
      references PAIS (ID_PAIS) on delete restrict on update restrict;

alter table SUB_CATEGORIA add constraint FK_REFERENCE_1 foreign key (ID_CATEGORIA)
      references CATEGORIA (ID_CATEGORIA) on delete restrict on update restrict;

