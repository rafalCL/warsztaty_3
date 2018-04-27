package pl.coderslab.warsztaty3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pl.coderslab.warsztaty3.model.User;

public class UserDao {
	public void save(Connection connection, User user) {
		// TODO finish writing this method!!! Look at the example of 
		// active record from workshop 2
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO user(id, name, email) VALUES(default, ?, ?);");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Connection connection, User user) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM user WHERE id=?;");
			ps.setLong(1, user.getId()); // TODO finish writing User class
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ... rest of the class
}
