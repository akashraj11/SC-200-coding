#! /bin/bash

ssh ubuntu@ip-10-20-1-4 "docker-compose scale empty-container=1"
#ssh ubuntu@<private-ip> "docker exec -it empty-container bash"
ssh root@ip-10-20-1-4 "cd challenges/program ; mvn clean package ; cd .. ; rm -rf program ; cd .. "
ssh ubuntu@ip-10-20-1-4 "docker-compose scale empty-container=0"


