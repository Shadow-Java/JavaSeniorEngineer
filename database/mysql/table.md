### 表字段尽量不要为NULL
空string不会占用空间，只是在索引中存储一个空字符串的引用；NULL值会在每个字段中记录是否为NULL，占用一个字节，且sql判断时NULL为column is null
唯一索引能给默认值空string吗？
可以，当你在唯一索引列上插入多个空字符串值时，它们不会引发唯一性冲突




https://blog.csdn.net/m0_67394360/article/details/126080529?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-126080529-blog-104021992.235^v43^pc_blog_bottom_relevance_base1&spm=1001.2101.3001.4242.1&utm_relevant_index=1