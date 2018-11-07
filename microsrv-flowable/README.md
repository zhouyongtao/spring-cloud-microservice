## docs
* https://www.flowable.org/docs/userguide/index.html
* https://github.com/flowable/flowable-engine

## database
```
CREATE DATABASE `flowable` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
```

## docker(Flowable 6)
> docker run -p8080:8080 flowable/flowable-rest
* http://localhost:8080/flowable-rest/docs/
> docker run -p8080:8080 flowable/all-in-one
* Flowable Modeler; http://localhost:8080/flowable-modeler
* Flowable Task; http://localhost:8080/flowable-task
* Flowable Admin; http://localhost:8080/flowable-admin
* Flowable IDM; http://localhost:8080/flowable-idm