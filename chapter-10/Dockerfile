#FROM：表示基础镜像，即运行环境,使用open jdk8
FROM openjdk:8-jdk-alpine
# 镜像作者信息
MAINTAINER ke.zhang  
#VOLUME 在宿主机的/var/lib/docker目录下创建一个临时文件并把它链接到容器中的/tmp目录
VOLUME /tmp
# ADD：添加文件并且重命名
ADD  target/springboot-demo-deploy-0.0.1-SNAPSHOT.jar  /app.jar
#EXPOSE：建立image暴露的端口
EXPOSE 8080
#ENTRYPOINT：容器启动时运行的命令，相当于在命令行中输入java -jar xxxx.jar
ENTRYPOINT ["java","-jar","/app.jar"]