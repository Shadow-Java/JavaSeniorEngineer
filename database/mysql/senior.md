# 本章节为MySQL进阶技术，以下为思维导图

<img src="https://picturestr.oss-cn-shanghai.aliyuncs.com/img/20200713220714.png" align="center" alt="数据库进阶学习导图">

_https://juejin.cn/post/6844903967365791752

MySQL 查询 树结构

https://blog.csdn.net/qq_34997906/article/details/94007556_

解决：Lock wait timeout exceeded; try restarting transaction

https://www.cnblogs.com/christopherchan/p/12390819.html

多个left join怎么保证正确

sql 查询树结构  递归向上或向下查找

```sql
with org as (
     select id, name, path,order_no
     from auth.t_auth_org t
     where id =#{org.id}
     union all
     select distinct t1.id, t1.name, t1.path,order_no
     from auth.t_auth_org t1
     inner join (select id, name, org_type, p_id
     from auth.t_auth_org
     where id = #{org.id}) t2
     on
     t2.id = case when t2.org_type = 'c' then null else t1.p_id end
     )
      select di.detailed_type as detailed,
      count(*) filter ( where tgp.partition_code like '01%' )  as protectNum,
      case count(*) when 0 then 0.0 else round((count(*) filter ( WHERE tgp.partition_code like '01%'
     )/count(*)::numeric)*100,2) end as protectPct,
      count(*) filter ( where tgp.partition_code like '02%' )  as preventionPct,
      case count(*) when 0 then 0.0 else round((count(*) filter ( WHERE tgp.partition_code like '02%'
     )/count(*)::numeric)*100,2) end as preventionNum,
      count(*) filter ( where tgp.partition_code like '03%' )  as governmentPct,
      case count(*) when 0 then 0.0 else round((count(*) filter ( WHERE tgp.partition_code like '03%'
     )/count(*)::numeric)*100,2) end as governmentNum
      from  groundwater.t_groundwater_detailed_info di
      left join groundwater.t_groundwater_partition tgp on di.id = tgp.detailed_id

      inner join auth.t_auth_org tao on tao.id = di.org_id
       inner join org on tao.path ~ org.id
       where di.del_flag = false
      GROUP BY di.detailed_type

```


abc联合索引查bc走不走索引？原理是啥？

不走  因为只有a相同 b才有序 ab相同 c才有序。你要知道索引的本质是什么，就是排序后对索引节点的数据做二分查找，然后根据查找的结果找到下一个索引节点继续这个过程，直到叶子结点。bc在a不同的情况下是乱序的，没法进行二分查找 自然不走索引

影子:
可能会，如果a的取值比较少，会通过index skip scan机制走，比全表扫描快，oracle支持，mysql在8.0.13版本之后也支持

影子:
索引是b+树，总得来说a是有序的，在a相同的情况下b是有序的，ab相同的情况下c是有序的，你跳过a，bc是无序的，怎么走索引呢

影子:
就相当于 你看书1 2 3有123级目录。 肯定得先查大标题 然后中标题 然后小标题。 如果你直接查小标题 那还不如直接检索全部的小标题了


ySQL高级知识（一）——基础

Join查询

索引

Explain

索引分析

索引优化

索引面试题分析

ORDER BY优化

慢查询日志

批量插入数据脚本

Show Profile

全局查询日志

表锁

行锁

主从复制

小表驱动大表


支 持NoSQL特性，


