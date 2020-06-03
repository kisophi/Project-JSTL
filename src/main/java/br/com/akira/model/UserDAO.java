package br.com.akira.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.akira.util.ConnectionFactory;

public class UserDAO {

	Connection conn = ConnectionFactory.getConnecitonMySql();
	PreparedStatement ps = null;

	/**
	 * Add User
	 * 
	 * @param User u
	 */
	public void addUser(User u) {
		try {
			ps = conn.prepareStatement("INSERT INTO user VALUES(null,?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getPass());
			ps.execute();
			System.out.println("Added User"+toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Delete User
	 * @param Integer
	 */
	public void deleteUser(Integer id) {
		try {
			ps = conn.prepareStatement("DELETE user FROM WHERE userid=?");
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Delete User"+toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
