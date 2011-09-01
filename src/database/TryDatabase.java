package database;

public class TryDatabase {

	public static void main(String[] args) {
		IDao dao = DaoFactory.getInstance().getDao();
		for (Address a : dao.getAllAddresses()) {
			System.out.println(a);
		}
		dao.insertAddress(new Address("Brodowsky", "Bernhard", null, 0));
	}

}
