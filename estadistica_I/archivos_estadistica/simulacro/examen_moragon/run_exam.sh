#! /bin/bash

DIR="$(find /run/media/user/ -maxdepth 1 -mindepth 1 -type d)"
echo $DIR
rstudio "$DIR" 
