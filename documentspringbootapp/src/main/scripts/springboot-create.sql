--create table hibernate_sequence (
--    next_val bigint
--);

--insert into hibernate_sequence values ( 100 );


--create table documents (
--	id              				integer primary key IDENTITY,
--	name            				varchar(255),
--	numberOfRevisions   			integer,
--	latestRevisionTimestamp			datetime2,
--);

--create table document_revisions (
--	id        			integer primary key IDENTITY,
--	note            	varchar(255),
--	revision   			integer,
--	date_timestamp		datetime2,
--  document_id			integer references documents(id),
--);


GO

SET IDENTITY_INSERT documents ON 
insert into documents (id, name, number_of_revisions, latest_revision_timestamp) values (1, 'Basic Document', 1, '2019-05-07');
insert into documents (id, name, number_of_revisions, latest_revision_timestamp) values (2, 'Advanced Document', 1, '2019-09-08');
insert into documents (id, name, number_of_revisions, latest_revision_timestamp) values (3, 'Professional Document', 1, '2019-07-09');
SET IDENTITY_INSERT documents OFF

GO

insert into document_revisions (document_id, note, revision, date_timestamp) values (1, 'Added first revision...', 1, '2019-05-07', 1);
insert into document_revisions (document_id, note, revision, date_timestamp) values (2, 'Added first revision...', 1, '2019-07-08', 2);
insert into document_revisions (document_id, note, revision, date_timestamp) values (3, 'Added first revision...', 1, '2019-07-09', 3);