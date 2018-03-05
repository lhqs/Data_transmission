### 数据接收server端（UDP）


* 本工程需要手动生成jar包，执行java -jar server.jar即可运行本工程。
* 配置的日志目录为当前路径下logs里面，以天为周期，记录昨天的日志信息，第二天封装为log-debug.log+日期文件( eg : log-debug.log.2018-01-22).

接收的数据格式示例如下：
```

T1W-04.94C T1S00.60% Y1W-00.75C P1H07.56 T3W+02.38C T3S00.88% Y3W+00.65C P3H07.76 T0W+02.91C T0 S01.12%
T3W+02.38C T3S00.92% Y3W+00.37C P3H07.79 T0W+03.11C T0S01.04%
T3W+02.38C T3S00.92% Y3W+00.37C P3H07.79 T0W+03.03C T0S01.12%
T1W-04.94C T1S00.68% Y1W-00.91C P1H07.55 T0W+03.75C T0S01.20%
T3W+02.6C T3S00.92% Y3W+00.45C P3H07.80 T0W+03.47C T0S01.08%
T3W+02.6C T3S00.92% Y3W+00.45C P3H07.80 T0W+03.67C T0S01.08%
T3W+02.6C T3S00.92% Y3W+00.45C P3H07.80 T0W+03.59C T0S01.12%
T1W-04.94C T1S00.68% Y1W-00.91C P1H07.55 T0W+03.75C T0S01.20%
T1W-04.86C T1S00.72% Y1W-00.67C P1H0!o55 T3W+02.62C T3S00.84% Y3W+00.37C P3H07.77 T0W+03.71C T0 S01.04%
T1W-04.86C T1S00.72% Y1W-00.67C P1H0!o55 T3W+02.62C T3S00.84% Y3W+00.37C P3H07.77 T0W+03.95C T0 S01.12%
```
其中
```

    TW 表示 '土壤温度',
    YW 表示 '湿度',
    TS 表示 '叶片温度',
    PH 表示 'PH值',
    数字序号表示节点数量.
    
```
### 关联项目
* web页面( https://github.com/lhqs/IOT_SYSTEM ) ：基于Vue.js+Element UI+ECharts+axios +Nginx快速构建；
* 物联完管理系统后台接口服务( https://github.com/lhqs/plant-rest ) ：SpringMVC + Spring + MyBatis + Maven + MySql + RESTful + Tomcat + 七牛云对象存储；
