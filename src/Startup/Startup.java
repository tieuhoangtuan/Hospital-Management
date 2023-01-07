package Startup;
import java.sql.*;

public class Startup {
    private static Connection connection=null;
    public Startup(){

        startup();
    }

    private static void establishConnectionDB(){
        try {
			String connectionURL="jdbc:mysql://localhost:3306/qlbv?useSSL=false";
			

			connection=DriverManager.getConnection(connectionURL,"root","");
			
			

		} catch (Exception e) {
            e.printStackTrace();
			System.out.println("Kết nối thất bại !!!");
		}
    }

    private static void startup(){

        establishConnectionDB();
    }

    public static Connection getConnection(){

        if(connection==null){

            establishConnectionDB();
        }
        return connection;
    }
}

