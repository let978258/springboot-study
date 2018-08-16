Eureka的特性:
	Eureka Server采用的是Peer to Peer(点对点)对等通信。这是一种去中心化的架构.
	首先尝试从邻近节点获取所有实例注册表信息，并且会通过心跳续约的方式定期更新,当Eureka
Server节点在短时间内丢失过多的心跳时(比如发生了网络分区故障)，那么这个节点就会进入自我保
护模式。

Eureka自我保护模式?
	什么是自我保护模式？默认配置下，如果Eureka Server每分钟收到心跳续约的数量低于一个
阈值（instance的数量(60/每个instance的心跳间隔秒数)自我保护系数），并且持续15分钟，
就会触发自我保护。在自我保护模式中，Eureka Server会保护服务注册表中的信息，不再注销任何
服务实例。当它收到的心跳数重新恢复到阈值以上时，该Eureka Server节点就会自动退出自我保护
模式。它的设计哲学前面提到过，那就是宁可保留错误的服务注册信息，也不盲目注销任何可能健康的服务
实例。该模式可以通过eureka.server.enable-self-preservation = false来禁
用，同时eureka.instance.lease-renewal-interval-in-seconds可以用来更改
心跳间隔。	

创建Eureka服务端程序
1)创建maven项目(let-eureka-server)
2)添加pon.xml中所需要的依赖(spring-cloud-starter-eureka-server)
3)编写配置文件application.yml(端口号,用户名,密码)
4)使用main方法实现调用spring-boot-starter-web项目(@EnableEurekaServer)
5)使用http://localhost:8761查看所启动服务是否成功启动,并将提供者与消费者添加进来.