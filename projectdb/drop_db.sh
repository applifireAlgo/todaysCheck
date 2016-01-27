




echo $PATH
DB_PATH=/tmp/applifire/db/BXLVHPLNJY9B98WYWKJW/134B77AE-871E-4EE2-92A7-1E80BE877AEF
MYSQL=/usr/bin
USER=project
PASSWORD=project
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'