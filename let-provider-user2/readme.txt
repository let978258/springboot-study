创建第二个provider:
1)创建maven项目(let-provider-user2)
2)在pom.xml里添加需要的jar包(spring-cloud-starter-eureka)
3)配置applicatoin.yml文件(注意:此处端口号不同,但是提供者名是相同的.)
4)添加HelloController层,获取请求路径并响应.
5)使用main方法实现调用spring-boot-starter-web项目(@EnableEurekaClient)
6)使用Eureka Server查看该服务是否注册成功.
7)访问http://localhost:7901/hello/{name},检查是否能有效获取数据.