#!/bin/bash

for ((i=4; i<=2048; i*=2)); do
 for ((j=0; j<20; ++j)); do
  ./build/main $i S
  # sleep for 5 seconds
  sleep 5
 done
done

sleep 10

for ((i=4; i<=2048; i*=2)); do
 for ((j=0; j<20; ++j)); do
  ./build/main $i C
  # sleep for 5 seconds
  sleep 5
 done
done
