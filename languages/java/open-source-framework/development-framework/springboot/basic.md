springboot点击run是运行？不是编译   运行加载配置文件

什么是spring  怎么引入才算有spring

切面只有spring才有吗  如果没有spring  怎么写切面


```java
@Resource(name = "groudwaterServiceImpl")
    private IGroudwaterService iGroudwaterService;


    @Test
    public void test() throws Exception{
        OrgInfo orgInfo = new OrgInfo();
        orgInfo.setId("5422036EF35743FF939F864ED6455084");
        iGroudwaterService.eachReform(orgInfo);
    }
```
为什么是空指针，bean没有注入成功
