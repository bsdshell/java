#!/bin/sh
echo "cool"

javac -cp ./joda-time-2.1.jar MyTime.java 
java -cp .:./joda-time-2.1.jar MyTime 


