Command Line Build

1. Dependency
   ProcessCVS.java depends on commons-io 2.5 jar file which contains 
   LineIterator for reading large file.

   The jar file can be downloaded from following URL:
   https://mvnrepository.com/artifact/commons-io/commons-io/2.5

2. Input/output files
   Modify the cvsFile/outFile variables to point to CVS file and [ACL data file structure] file in test() method:
   For example. 
   cvsFile = "./text/acl.cvs";
   outFile = "./text/acl_out.txt";

3. Build in command line(bash)
   javac -cp jarfile/*:. ProcessCVS.java
   java  -cp jarfile/*:. ProcessCVS

--------------------------------------------------------------------------------
My development environment:

OS: 
Mac OX El Capitan  10.11.4

Java:
java version "1.8.0_45"
Java(TM) SE Runtime Environment (build 1.8.0_45-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
