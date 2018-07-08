-- drop table if exists word;
-- drop table if exists practice;
-- drop table if exists word_detail;
-- drop table if exists config;

create table word (
  word character (1) not null primary key,
  input_chars varchar (5)
);

create table practice (
  param_id integer not null primary  key  auto_increment,
  practice_time timestamp ,
  practice_duration integer,
  total_count integer,
  right_count integer,
  enter_count integer,
  backspace_count integer
);

create table word_detail(
  param_id integer not null primary key auto_increment,
  word character (1),
  input_chars varchar(100),
  typing_duration integer,
  is_wrong bool,
  is_extra bool,
  backspace_entered bool,
  enter_entered bool,
  input_value character(1),
  practice_id integer
);

  create table config (
  param_id integer not null primary key,
  is_march bool,
  is_repeat bool,
  tips_on_extra bool,
  tips_on_hard bool,
  hard_time integer,
  auto_refresh bool
)