package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class JdbcDao implements IDao {
	
        private static final String DRIVER = "org.postgresql.Driver";
        private static final String DB_USER = "livia";
        private static final String DB_PASSWD = "thierry";
        private static final String DB_PATH = "jdbc:postgresql://localhost/addresses";
		private Connection conn;

        public JdbcDao() throws SQLException,
                        ClassNotFoundException {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWD);
                conn.setAutoCommit(true);
        }
        
		@Override
		public Collection<Address> getAllAddresses() {
			String sql = "select lastname,givenname,phonenumber,id from addresses";
			Collection<Address> allAddresses = new ArrayList<Address>();
			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet result = pstm.executeQuery();
				while (result.next()) {
					int id = result.getInt("id");
					String lastName = result.getString("lastname");
					String givenName = result.getString("givenname");
					String phoneNumber = result.getString("phonenumber");
					Address address = new Address(lastName,givenName,phoneNumber,id);
					allAddresses.add(address);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return allAddresses;
		}

		@Override
		public void insertAddress(Address address) {
			String sql = "insert into addresses (lastname,givenname,phonenumber,id)" +
					" values (?,?,?,nextval('seq_addresses_id'))";
			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(2, address.getGivenName());
				pstm.setString(1, address.getLastName());
				pstm.setString(3, address.getPhoneNumber());
				pstm.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

}
