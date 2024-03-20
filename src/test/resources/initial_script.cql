create keyspace  if not exists chat with replication = {'class':'SimpleStrategy', 'replication_factor': '3'};
create table if not exists chat.users (id uuid primary key, name text)