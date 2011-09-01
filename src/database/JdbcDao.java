package database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDao implements IDao {
	
        private static final String DRIVER = "org.postgresql.Driver";
        private static final String DB_USER = "livia";
        private static final String DB_PASSWD = "thierry";
        private static final String DB_PATH = "jdbc:postgresql://localhost/addresses";

        public JdbcDao() throws SQLException,
                        ClassNotFoundException {
                Class.forName(DRIVER);
                DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWD);
        }
        
        
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
        	IDao dao = new JdbcDao();
        }

}
