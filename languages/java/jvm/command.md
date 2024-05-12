


## 堆内存

1.配置新生代和老年代堆结构占比
> -XX:NewRatio=2

默认 **-XX:NewRatio=2** , 标识新生代占1 , 老年代占2 ,新生代占整个堆的1/3
修改占比 -XX:NewPatio=4 , 标识新生代占1 , 老年代占4 , 新生代占整个堆的1/5

2.Eden空间和另外两个Survivor空间占比分别为8:1:1;新生代 (Young) 被细分为Eden和两个Survivor 区域，这两个 Survivor 区域分别被命名为 from 和 to，以示区分。默认的，Eden:from:to =8:1:1(可以
通过参数–XX:SurvivorRatio来设定
> -XX:SurvivorRatio=8

3.堆大小 = 新生代 + 老年代,配置堆内存大小,堆的大小可以通过参数 –Xms、-Xmx 来指定
> -Xms5m -Xmx20m  #当下Java应用最大可用内存为20M， 最小内存为5M

4.新生代设置大小
>Young Gen -Xmn

5.本地内存元空间Metaspace中
>-XX:MetaspaceSize  -XX:MaxMetaspaceSize

6.设置虚拟机栈的大小,-Xss 为jvm启动的每个线程分配的内存大小，默认JDK1.4中是256K，JDK1.5+中是1M
>-Xss1m