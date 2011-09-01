package database;

import java.util.Collection;

public interface IDao {

	Collection<Address> getAllAddresses();
	void insertAddress (Address address);
}
