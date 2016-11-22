# mybatis2
## 使用级联查询，分别有一对一、一对多、多对多
# 一对一 
##  数据库mysql 外键级联 
    constraint 表1_fk foreign key(表1) references 表2(cid)
## xml
    一个select语句
    <select id="findById" parameterType="int" resultMap="studentMap">
		select s.sid,s.sname,c.cid,c.cnum
		from students s inner join cards c
		on s.scid = c.cid 		
		and s.sid = #{id}
	  </select>
    2个 resultMap 语句，一个是 主resultMap 一个是从resultMap

    
    <resultMap type="cn.itcast.javaee.mybatis.one2one.Card" id="cardMap">
		<id property="id" column="cid"/>
		<result property="num" column="cnum"/>
	  </resultMap>
    
    在resultMap中引入<association property="card" resultMap="cardNamespace.cardMap"/>，id为
    studentMap；
    然后下面的select语句的result为id：studentMap
    
    <resultMap type="cn.itcast.javaee.mybatis.one2one.Student" id="studentMap">
		<id property="id" column="sid"/>
		<result property="name" column="sname"/>
		<!-- 引入CardMapper.xml文件中的映射信息 
			 property表示Student类的关联属性
			 resultMap表示引入CardMapper.xml文件的映射类型
		-->
		<association property="card" resultMap="cardNamespace.cardMap"/>
	</resultMap>
    
# 一对多(待定。。)
##  数据库mysql 外键级联 
    constraint sgid_fk foreign key(sgid) references grades(gid)
## xml
   
    <select id="findAllByName" parameterType="string" resultMap="studentMap">
      select s.sid,s.sname
      from students s inner join grades g
      on s.sgid = g.gid
      and g.gname = #{namexxxxxxxxxxxxxxxx}
    </select>
    
     <resultMap type="cn.itcast.javaee.mybatis.one2many.Student" id="studentMap">
		<id property="id" column="sid"/>
		<result property="name" column="sname"/>
	</resultMap>	
  
  
    <resultMap type="cn.itcast.javaee.mybatis.one2many.Grade" id="gradeMap">
      <id property="id" column="gid"/>
      <result property="name" column="gname"/>
    </resultMap>	
    
    <select id="findByName" parameterType="string" resultMap="gradeMap">
      select g.gname
      from students s inner join grades g
      on s.sgid = g.gid
      and s.sname = #{xxxxx}
    </select>
    
## 多对多(待定)
## sql 多了一张表
    create table middles(
      msid int(5),
      mcid int(5),
      primary key(msid,mcid)
    );

    <select id="findAllByName" parameterType="string" resultMap="courseMap">
        select c.cid,c.cname
        from students s inner join middles m
        on s.sid = m.msid
        inner join courses c
        on m.mcid = c.cid
        and s.sname = #{name}
      </select>

      <resultMap type="cn.itcast.javaee.mybatis.many2many.Course" id="courseMap">
        <id property="id" column="cid"/>
        <result property="name" column="cname"/>
      </resultMap>

      <resultMap type="cn.itcast.javaee.mybatis.many2many.Student" id="studentMap">
        <id property="id" column="sid"/>
        <result property="name" column="sname"/>
      </resultMap>	


      <select id="findAllByCourseName" parameterType="string" resultMap="studentMap">
        select s.sname
        from students s inner join middles m
        on s.sid = m.msid 
        inner join courses c
        on m.mcid = c.cid
        and c.cname = #{name}
      </select>
  

>这里不得不提到的是：上次我们使用的sqlSession来进行数据库的操作，这里加入了dataSource的创建连接方式，也就是jdbc的方式处理数据库，
>这里有了stament的概念，CallableStatement的对象csmt，这里对于我们书写mapper.xml的原因有了一个解释。
