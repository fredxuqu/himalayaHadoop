#!/bin/bash

echo "Hello, world!"

WORKSPACES=/opt/workspaces/

function clearzk(){
  echo "rm -rf $WORKSPACES/zookeeper/logs";
  rm -rf $WORKSPACES/zookeeper/logs;
  echo "rm -rf $WORKSPACES/zookeeper/data/version-2";
  rm -rf $WORKSPACES/zookeeper/data/version-2;
}

function error(){
  echo $1;
}

case $1 in
  -clearzk)
    clearzk;;
  -*) error "no such operation " + $1;;
  *)  exist 0;;
esac;
