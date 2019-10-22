--create table hibernate_sequence (
--    next_val bigint
--);

--insert into hibernate_sequence values ( 100 );


--create table documents (
--	id              	integer primary key,
--	name            	varchar(255),
--	numberOfRevisions   integer,
--	latestRevisionTimestamp			datetime2,
--);


insert into documents (id, name, number_of_revisions, latest_revision_timestamp) values (1, 'Basic Document', 1, '2019-05-07');
insert into documents (id, name, number_of_revisions, latest_revision_timestamp) values (2, 'Advanced Document', 1, '2019-09-08');
insert into documents (id, name, number_of_revisions, latest_revision_timestamp) values (3, 'Professional Document', 1, '2019-07-09');