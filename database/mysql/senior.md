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
