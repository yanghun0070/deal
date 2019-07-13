
-- 리소스
insert into deal_resource(resource_id, name, description)
values (1, '/user/authorization/create', '권한 생성');
insert into deal_resource(resource_id, name, description)
values (2, '/user/login', '로그인');
insert into deal_resource(resource_id, name, description)
values (3, '/**', '리소스 전체');
insert into deal_resource(resource_id, name, description)
values (4, '/user/join', '회원가입');
insert into deal_resource(resource_id, name, description)
values (5, '/h2-console/**', 'H2 Console');
COMMIT;

--권한
insert into deal_authorization(authorization_id, name, description)
values (1, 'ROLE_USER', 'Default 권한');
insert into deal_authorization(authorization_id, name, description)
values (2, 'ROLE_ADMIN', '슈퍼 권한');
insert into deal_authorization(authorization_id, name, description)
values (3, 'ROLE_MANAGER', '관리자 권한');
insert into deal_authorization(authorization_id, name, description)
values (4, 'ROLE_ANONYMOUS', '익명 사용자');
COMMIT;

-- 권한 리소스
insert into deal_authorization_resource(authorization_id, resource_id)
values (
  select authorization_id from deal_authorization where name='ROLE_MANAGER',
  select resource_id from deal_resource where name='/user/authorization/create');
insert into deal_authorization_resource(authorization_id, resource_id)
values (
  select authorization_id from deal_authorization where name='ROLE_USER',
  select resource_id from deal_resource where name='/user/login');
-- insert into deal_authorization_resource(authorization_id, resource_id)
-- values (
--   select authorization_id from deal_authorization where name='ROLE_ADMIN',
--   select resource_id from deal_resource where name='/**');
insert into deal_authorization_resource(authorization_id, resource_id)
values (
  select authorization_id from deal_authorization where name='ROLE_ANONYMOUS',
  select resource_id from deal_resource where name='/user/join');
insert into deal_authorization_resource(authorization_id, resource_id)
values (
  select authorization_id from deal_authorization where name='ROLE_USER',
  select resource_id from deal_resource where name='/h2-console/**');
COMMIT;

-- 유저
insert into deal_user(user_id, age, name, password, sex)
values ('test', 99, 'test@m.m', 'test', 0);
insert into deal_user(user_id, age, name, password, sex)
values ('test1', 99, 'test@m.m', 'test1', 0);
insert into deal_user(user_id, age, name, password, sex)
values ('test2', 99, 'test@m.m', 'test2', 0);
COMMIT;

-- 유저 권한
insert into deal_userauthorization(id, role_name, user_id)
values (1, 'ROLE_USER', 'test');
insert into deal_userauthorization(id, role_name, user_id)
values (2, 'ROLE_USER', 'test1');
insert into deal_userauthorization(id, role_name, user_id)
values (3, 'ROLE_MANAGER', 'test2');
COMMIT;
