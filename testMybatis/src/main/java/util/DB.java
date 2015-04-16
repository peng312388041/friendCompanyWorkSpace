package util;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DB {
//	static {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	private static Connection connection=null;
//	private static String url="jdbc:mysql://localhost:3306/test";
//	private static String username="root";
//	private static String password="";
	public static Connection getConnection()
	{
//		synchronized (Connection.class) {
//			if(null==connection)
//			{
//				try {
//					connection=DriverManager.getConnection(url,username,password);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			
//		}

		return connection;
	}
	
	public static SqlSessionFactory getSessionFactory()
	{
		String resource = "mybatis-config.xml";
        Reader reader=null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        return factory;
	}
}
