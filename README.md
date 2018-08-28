- env
```
yum install -y redhat-lsb
uname -a
cat /proc/version
lsb_release -a

yum install epel-release
yum makecache
yum repolist

/opt/gitlab/embedded/bin/psql --version
sudo gitlab-ctl pg-upgrade
sudo yum install gitlab-ce
sudo gitlab-ctl reconfigure
sudo gitlab-ctl restart
sudo yum install -y gitlab-ce
sudo yum install -y gitlab-ee
netstat -lntup

```

- jdk

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

- doc
```
http://cloud.spring.io/spring-cloud-static/Finchley.SR1/single/spring-cloud.html
https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Finchley-Release-Notes
https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle/

nohup java -jar microsrv-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1 &

http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html
https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle
https://github.com/spring-cloud-samples/hystrix-dashboard
```

- eureka
```
java -jar microsrv-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
java -jar microsrv-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
java -jar microsrv-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3

vi /etc/hosts

10.255.131.162       microsrv-eureka-server-peer1
10.255.131.163       microsrv-eureka-server-peer2
10.255.131.164       microsrv-eureka-server-peer3

echo `hostname`
127.0.0.1       localhost                               iZuf60cj5pna5im3va46nkZ

netstat -tunlp
netstat -apn | grep 8000
```