##四、此时的架构
####此时架构图
![avatar](src/main/resources/static/架构图.png)

一个服务注册中心，eureka server,端口为8761

service-hi工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册

sercvice-ribbon端口为8764,向服务注册中心注册

当sercvice-ribbon通过restTemplate调用service-hi的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-hi：8762和8763 两个端口的hi接口；

|name|age|
|:---:|:---:|
|小池|永远18岁|