package 基于JavaGUI和MySql的学生宿舍管理系统;
import java.sql.*;
public class GetDBConnect
{
	public static Connection connectDB(String name ,String id,String p)
	{
		Connection con=null;
		String 
		uri="jdbc:mysql://localhost:3306/"+name;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
		}
		catch (Exception e)
		{
		}
		try{
			con=DriverManager.getConnection(uri,id,p);//连接代码
		}
		catch(SQLException e)
		{
		}
		return con;

	}
}