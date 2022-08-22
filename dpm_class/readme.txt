问题:
	jar包频繁复制粘贴,互相之间传递,jar包版本必须统一,jar包占有的空间过大
	1.jar的统一管理?
	代码的规范不一样,代码的注解方式,代码的位置
	2.src的统一路径?
	3.依赖网络平台提供的网络仓库?

解决方案:
	使用Maven项目,依托于网络仓库,只需要指明仓库中包的名字,自动去引用
	保证项目的路径统一,包版本统一

操作步骤:
	1.下载maven http://archive.apache.org/dist/
	2.修改maven中conf目录下的settings.xml文件中   localRepository改为自己的路径(斜杠是/,不是\)  
		mirrors里面加上阿里的镜像服务地址(已经添加完成,不需修改)
	3.将maven引入到idea
		在file->Settings中设置maven的路径和settings.xml文件路径
		在file->new project settings中设置maven路径和settings.xml文件路径
	4.创建maven项目,选择maven提供好的webapp模板
	5.maven项目目录规范
		src/main/java : java源文件的目录,  .java的类文件
		src/main/resources : 资源文件, 配置文件
		src/main/webapp : web前端相关的资源
		src/test/java : 用于测试的java源文件的目录
		src/test/resources : 用于测试的资源文件
		pom.xml : 提供jar包依赖的配置文件 ( 通过配置jar包的目录名称,从镜像网站中拉取对应jar包 )
				进行jar包的配置
		
    6.配置pom.xml文件(给项目指定需要的jar包)
    所有的包都可以在maven的仓库中找到   https://mvnrepository.com/
        spring,springmvc
        mybatis
        jsp/servlet
        JSR303
        mysql
        分页插件
        代码生成器
        junit测试

    7.配置web.xml文件

















