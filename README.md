# SyPastebin
An online light Pastebin for developers.

一个前后端分离、读写服务拆分的在线剪贴板，提供在线粘贴代码、生成可供访问的url的功能。

![The Great Wall of China](./READMESrc/sypastebin.png)

# Usage

## Main

1. springboot 2.4.2
2. maven 3.6.3
3. mysql 8.0
4. mongodb 4.4.3
5. JDK 1.8

## Others

1. Log framework: Logback
2. RestApi document: Swagger2  
visit:http://localhost:8080/swagger-ui.html
3. DatabasePool: Druid  
visit: http://localhost:8080/druid/index.html
4. Editor framework: [Ace](https://ace.c9.io/)

# 基本功能

- [x] 通过Mybatis对MySQL的CRUD；
- [x] 通过SpringDataMongoDB对MongoDB的CR；
- [x] 用户自定义短URL（仅一次自定义机会）；
- [x] 前端优化：美观、在线源代码编辑器插件；
- [x] 获取用户IP；
- [x] 生成短URL算法；
- [x] 定期删除过期paste服务；
- [x] 增加全局异常处理；
- [x] 集成Druid连接池，监控数据库操作；
- [x] 集成Swagger API接口文档展示；

# ToDo List

## 新功能
- [ ] 增加用户登录及其相关功能；
- [ ] 利用websocket做实时编辑功能，用户能够开辟一个在线粘贴板，得到一个url分享出去。对方可实时查看到最新编辑。
- [ ] 在粘贴板下增加一个评论系统，用户可实时在当前粘贴面板上评论、聊天。


## 前端
- [ ] 优化前端交互，人机页面更友好；
- [ ] 优化前端代码，删除无用代码；
- [ ] 研究 and 开启更多 **Ace** 插件的功能。

## 后端
- [ ] 服务跟踪：生成点击次数；
- [ ] 增加内容安全保障：使用非对称加密技术对内容加密。
- [ ] 网站用户访问数计算：布隆过滤器，对相同用户去重。
- [ ] 从应用层面对两个数据库的操作增加事务，保证事务一致性。
- [ ] 使用redis增加缓存，提高用户访问速度。
- [ ] 使用Docker部署上线。
- [ ] 部署时使用Nginx反向代理，感受多服务器处理。
- [ ] 项目优化（包括服务逻辑、数据库索引、数据库逻辑、代码结构等）。

有些想到再加……

持续撸码维护中~~~😁😁

# License
[Apache license](https://www.apache.org/licenses/LICENSE-2.0)
