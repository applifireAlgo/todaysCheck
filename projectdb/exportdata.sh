




echo $PATH
OSNAME=`uname -s`
ART_DATA_PATH=/tmp/applifire/db/BXLVHPLNJY9B98WYWKJW/134B77AE-871E-4EE2-92A7-1E80BE877AEF/art/data
AST_DATA_PATH=/tmp/applifire/db/BXLVHPLNJY9B98WYWKJW/134B77AE-871E-4EE2-92A7-1E80BE877AEF/ast/data
DB_NAME=applifire
USER=root
PASSWORD=Glass4#21
PORT=3306
HOST=qa.applifire.com
MYSQL=/usr/bin
PROJECT_ID=BXLVHPLNJY9B98WYWKJW
PROJECT_VERSION_ID=1

if [ $OSNAME == "Darwin" ]; then
echo "Setting up MYSQL PATH for OS $OSNAME"
MYSQL=/usr/local/mysql/bin/
fi



echo 'copy ART data from applifire starts....'
echo 'copy ART data from applifire ends....'

