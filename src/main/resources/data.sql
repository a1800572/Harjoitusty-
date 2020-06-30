	INSERT INTO public."käyttäjä"(
	id, email, password, phone, role, username)
	VALUES (
	-1, 
	'admin@hotmail.com', 
	'$2a$12$iwaVYYYtCYEQuxd6/1wpQOcNA0obvPNREjaxUxDBLbqNQlujAb8TW', 
	'6767474734',
	'ADMIN',
	'admin') ON Conflict (id) do nothing;
	
	INSERT INTO public."käyttäjä"(
	id, email, password, phone, role, username)
	VALUES (
	0, 
	'pekka@ggg', 
	'$2a$12$KDF4TyXvkV9D/sp1K0VZY.ml/ZilUgn1DfMDR/d.iukHoi6s3JCbi', 
	'0449999999',
	'USER',
	'aaaaa') ON Conflict (id) do nothing;