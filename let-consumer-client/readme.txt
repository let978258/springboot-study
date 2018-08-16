创建第一个consumer:
1)创建maven项目(let-consumer-client)
2)在pom.xml里添加需要的jar包(spring-cloud-starter-eureka)
3)配置applicatoin.yml文件
4)添加HelloController层,获取请求路径并响应.
5)使用main方法实现调用spring-boot-starter-web项目(实现RestTemplate对象初始化)
6)使用Eureka Server查看该服务是否注册成功.
7)访问http://localhost:8010/hello/{name},检查是否能有效获取数据.

test启动项目顺序?
        先启动服务端	 	8761	let-eureka-server		EurekaServerApplication
        再启动提供者1 	7900	let-provider-user		ProviderRunApplication
        再启动提供者2	 	7901	let-provider-user2		Provider2RunApplication
        最后启动消费者	8010	let-consumer-client		ConsumerRunApplication

Ribbon导包问题?
        无需引入jar包，在spring-cloud-start-euraka已经依赖了ribbon的jar包。
        
负载均衡的策略?
        第一种为轮询(Ribbon的默认负载均衡机制是轮询)
        第二种为random随机
        第三种为WeightedResponseTimeRule，响应时间

扩展:怎么把普通的消费者改为Ribbon消费者?
1)main中添加注释@RibbonClient(name="let-provider-user",configuration=RibbonRuleConfig.class)
2)自定义规则扩展对象
自定义Ribbon配置
规定：这个类不能再@ComponentScan和@SpringBootApplication本包和子包下，否则引起@RibbonClients扫描冲突
注意：随机第一次打断点进入，之后多次刷新就不进入，可能由于本地缓存原因
@Configuration
public class RibbonRuleConfig {
	@Bean
	public IRule ribbonRule(){
		return new RandomRule();
	}
}