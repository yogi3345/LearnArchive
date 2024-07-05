By default sql container will start but service container will exit because it can't connect to DB.

Reason:
When doing a fresh set up, MySQL will not have user(see application.properties) created, or table created or might also be missing the database(schema) required(named 'yo'). So first create all that and make an entry in table with id 1;

What database(schema), user & table to create?
database - yo
user -> username user, password - pass, to be created with host as '%' to allow all networks to connect. Grant all privileges to 'yo'. 
table -> create table 'test' and insert id - 1 with name 'abc'. See Entity & controller for more info.


Here are useful commands:

Connect to MySQL running inside container(will be able to login to DB using password(for root user 'root') 'admin'):
docker exec -it <your-mysql-container-id-or-name> mysql -uroot -p

create user with privileges:
CREATE USER 'user'@'%' IDENTIFIED BY 'pass';
GRANT ALL ON yo.* TO 'user'@'%';
FLUSH PRIVILEGES;


At last, install sqlWorkBench and connect to localhost, with username(if asked) 'root' and password 'admin'.


Helpful commands:

Stop service(not db, only service) container and delete the container:
docker rm $(docker stop $(docker ps -a -q --filter ancestor=<image-name> --format="{{.ID}}"))

e.g. run this command exactly as it is, when container is up:
docker rm $(docker stop $(docker ps -a -q --filter ancestor=demo-yotest --format="{{.ID}}"))

Notes:
To see code changes in container, you will have to delete the old image of the service first and then run docker-compose up -d.
Build might fail initially because a test class has @SpringBootTest annotation, comment that and build will pass.