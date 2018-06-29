# 配置JAVA运行环境

```
sudo yum install java-1.8.0-openjdk

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


http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html
https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle
https://github.com/spring-cloud-samples/hystrix-dashboard


netstat -tunlp
netstat -apn | grep 8000

java -jar microsrv-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
java -jar microsrv-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
java -jar microsrv-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3

vi /etc/hosts

10.255.131.162       microsrv-eureka-server-peer1
10.255.131.163       microsrv-eureka-server-peer2
10.255.131.164       microsrv-eureka-server-peer3

vi /etc/hosts
iZuf6i3b97wsrn5x2oic17Z