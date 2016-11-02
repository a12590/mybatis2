# mybatis2
使用级联查询，分别有一对一、一对多、多对多
在resultMap中引入<association property="card" resultMap="cardNamespace.cardMap"/>，id为
studentMap；
然后下面的select语句的result为id：studentMap

这里不得不提到的是：上次我们使用的sqlSession来进行数据库的操作，这里加入了dataSource的创建连接方式，也就是jdbc的方式处理数据库，
这里有了stament的概念，CallableStatement的对象csmt，这里对于我们书写mapper.xml的原因有了一个解释。
