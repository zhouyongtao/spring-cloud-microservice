# 配置JAVA运行环境

```
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install software-properties-common htop
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
java -version
```

```
spring-cloud(Finchley.RC2) document
http://cloud.spring.io/spring-cloud-static/Finchley.RC2/single/spring-cloud.html

nohup java -jar microsrv-eureka-server-0.0.1-SNAPSHOT.jar &