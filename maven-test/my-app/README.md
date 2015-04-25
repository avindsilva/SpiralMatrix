###How to build using Maven  
  

Install Maven if you don't have one
`$ sudo apt-get install maven`  

####Building
```bash
$ cd my-app
$ mvn compile
$ mvn package
$ java -classpath target/<snapshot_jar_file> Demo
```
