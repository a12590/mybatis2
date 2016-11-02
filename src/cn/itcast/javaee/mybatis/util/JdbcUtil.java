package cn.itcast.javaee.mybatis.util;

import java.sql.Connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBCπ§æﬂ¿‡
 * @author AdminTC
 */
public class JdbcUtil {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	public static Connection getConnection() throws Exception{
		return dataSource.getConnection();
	}
}
