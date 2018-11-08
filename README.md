容器与微服务架构
=======================================================================

# docker&kubernetes
* https://www.cncf.io/projects/
* https://github.com/kubernetes/kubernetes
* https://github.com/kubernetes/examples
* https://kubernetes.io/docs/concepts/
* https://github.com/ramitsurana/awesome-kubernetes
* https://docs.docker.com/

# volume
* https://github.com/rook/rook
* https://github.com/ceph
* https://github.com/gluster

# monitor
* https://github.com/prometheus
* https://github.com/coreos/prometheus-operator
* https://github.com/kubernetes-incubator/metrics-server
* https://github.com/grafana/grafana

# maven repository
* https://www.jfrog.com/confluence/
* https://www.sonatype.com/nexus-repository-oss
* https://hub.docker.com/r/sonatype/nexus3/

# spring cloud config
* https://github.com/dyc87112/spring-cloud-config-admin
* https://github.com/alibaba/nacos
* https://github.com/ctripcorp/apollo
* https://nacos.io/en-us/blog/Nacos-is-Coming.html

# spring-cloud
* https://spring.io/projects/spring-cloud
* https://spring.io/projects/spring-cloud-gateway
* https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
* http://cloud.spring.io/spring-cloud-static/Finchley.SR2/single/spring-cloud.html
* https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-starters
* https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Finchley-Release-Notes
* https://github.com/spring-cloud-samples/hystrix-dashboard

# env
```
sudo apt-get update
sudo apt-get upgrade
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

sudo yum install java-1.8.0-openjdk
sudo apt-get install software-properties-common htop
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
java -version
```

# eureka
```
#nohup java -jar microsrv-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1 &
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