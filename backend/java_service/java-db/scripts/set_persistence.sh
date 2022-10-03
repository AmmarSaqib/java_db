#!/bin/bash -e

XML_TMP=/usr/src/app/src/resources/META-INF/persistence.temp.xml
XML_OUT=/usr/src/app/src/resources/META-INF/persistence.xml
# XML_TMP=../src/resources/META-INF/persistence.temp.xml
# XML_OUT=../src/resources/META-INF/persistence.xml

# ls -li ../src/resources

export DB_URL="jdbc:postgresql://$POSTGRES_HOST/$DB_NAME"
export DB_USR=$POSTGRES_USERNAME
export DB_PASS=$POSTGRES_PASSWORD

echo env $POSTGRES_HOST
echo $DB_USR
exit 1

envsubst "`printf '${%s} ' $(sh -c "env|cut -d'=' -f1")`" < $XML_TMP > $XML_OUT