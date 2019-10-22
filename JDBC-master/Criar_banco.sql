create database App_tarefa;

use App_tarefa;

create table Usuario (
	Id_usu int primary key auto_increment,
    Nome varchar(50),
    Sobrenome varchar(50),
    email nvarchar(50) unique
);

create table Tarefa(
	Id_tar int primary key auto_increment,
    Nome_tarefa varchar(250) not null,
    tarefa_status varchar(20),
    nivel_Prioridade int,
    FK_usuario int,
    constraint FK_usuario foreign key(FK_usuario) references Usuario(Id_usu)
);

