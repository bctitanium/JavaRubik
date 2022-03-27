package DAL;

public class DatabaseService
{
	protected static String db_connection = "jdbc:sqlserver://BC;databaseName=JavaRubik;integratedSecurity=true";
	protected static String db_username = "sa";
	protected static String db_password = "123";
	
	/*public static Connection getConnection(String dbURL, String userName, String password) 
	{
        Connection conn = null;
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) 
        {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        
        return conn;
    }*/
}
