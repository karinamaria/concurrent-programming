#!/bin/bash

for ((i=4; i<=2048; i*=2)); do
 ./main $i S
 # sleep for 10 seconds
 sleep 10
done

sleep 20

for ((i=4; i<=2048; i*=2)); do
 ./main $i C
 # sleep for 10 seconds
 sleep 10
done