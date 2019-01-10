#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa.pub \
    target/musicshop-1.0-SNAPSHOT.jar \

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa.pub << EOF
pgrep java | xargs kill -9
nohup java -jar musicshop-1.0-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'