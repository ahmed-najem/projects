#Local path - C:\Python27\my_scripts
#Author 	- Brandon Lacquement
#Created 	- Spring 2015
#Intent		- Demonstrate CRUD with MySQL (5.6.17) using PySQL (0.6.6)
#Version	- Python (2.7.9)

#MODULES
import pymysql
import sys

#CONNECTION VARIABLES
HOST 	= "localhost"
PORT 	= 3306
USER 	= "root"
PWD 	= ""
DB 		= "python_test"

try:
	#Connect to database
	conn = pymysql.connect(host=HOST, port=PORT, user=USER, passwd=PWD, db=DB)

	#Create cursor for result enumeration
	cur = conn.cursor()

	#BUILD QUERIES
	#Create a table
	DDL_CREATE = 	(	
					"CREATE TABLE IF NOT EXISTS user( "
					"id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
					"name VARCHAR(30), "
					"age INT(6), "
					"time TIMESTAMP"
					")"
					)
	
	#Show all current tables		
	DDL_READ = 		(
					"SHOW TABLES"
					)
	
	#Change a field in a table
	DDL_UPDATE =	(
					"ALTER TABLE user CHANGE age weight INTEGER "
					)
	
	#Drop a table
	DDL_DESTROY =	(
					"DROP TABLE IF EXISTS user "
					)
	
	#Insert some rows
	DML_CREATE = 	(	
					"INSERT INTO user (name,weight) "
					"VALUES ('Jeff',150),('John',180),('Luke',220),('Bill',135),('Bob',190),('Mark',160),('Paul',145),('Jim',250)"
					)		
	
	#Select anyone over 150
	DML_READ = 		(
					"Select name From user "
					"WHERE weight > 150"
					)

	#Add everyone's freshman 15
	DML_UPDATE =	(
					"UPDATE user "
					"SET weight = weight + 15"
					)
	
	#Drop the last two guys who were over 150 after their freshman 15
	DML_DESTROY =	(
					"DELETE FROM user "
					"WHERE weight > 150 "
					"ORDER BY time"
					"LIMIT 2"
					)
	
	#Run queries
	for query in [DDL_DESTROY, DDL_CREATE, DDL_UPDATE, DDL_READ, DML_CREATE, DML_READ, DML_UPDATE, DML_DESTROY]:
		cur.execute(query)
		print(cur.description)
		print
		for row in cur:
		   print(row)
	print "Query Success!"

except:
	print "Query Failure!"
	sys.exit(1)

finally:
	if conn:
		#Close cursor and connection
		cur.close()
		conn.close()
