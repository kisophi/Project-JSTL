package br.com.akira.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("Added User : " + toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	 * 
	 * @param Integer
	 */
	public void deleteUser(Integer id) {
		try {
			ps = conn.prepareStatement("DELETE FROM user WHERE userid=?");
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Delete User : " + toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * update User
	 * 
	 * @param User
	 */
	public void updateUser(User u) {
		try {
			ps = conn.prepareStatement("UPDATE user SET name=?, login=?, pass=? WHERE userid=?");
			ps.setString(1, u.getName());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getPass());
			ps.setInt(4, u.getUserid());
			ps.execute();
			System.out.println("Update User : " + toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Find all Users
	 * 
	 * @return list
	 */
	public List<User> allUsers() {
		ArrayList<User> list = new ArrayList<User>();
		try {
			ps = conn.prepareStatement("SELECT * FROM user");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setUserid(rs.getInt("userid"));
				u.setName(rs.getString("name"));
				u.setLogin(rs.getString("login"));
				u.setPass(rs.getString("pass"));
				list.add(u);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Find by name
	 * 
	 * @param String
	 * @return list
	 */
	public List<User> findByName(String name) {
		ArrayList<User> list = new ArrayList<User>();
		try {
			ps = conn.prepareStatement("SELECT * FROM user WHERE name LIKE ?");
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setUserid(rs.getInt("userid"));
				u.setName(rs.getString("name"));
				u.setLogin(rs.getString("login"));
				u.setPass(rs.getString("pass"));
				list.add(u);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	/**
	 * Find by ID
	 * 
	 * @param Integer
	 * @return User
	 */
	public User findById(Integer id) {
		User u = new User();
		try {
			ps = conn.prepareStatement("SELECT * FROM user WHERE userid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				u.setUserid(rs.getInt("userid"));
				u.setName(rs.getString("name"));
				u.setLogin(rs.getString("login"));
				u.setPass(rs.getString("pass"));
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * User Autentication
	 * 
	 * @param String
	 * @return User
	 */
	public User userAutentication(String login,String pass) {
		User u = new User();
		try {
			ps = conn.prepareStatement("SELECT * FROM user WHERE login=? AND pass=?");
			ps.setString(1, login);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				u.setUserid(rs.getInt("userid"));
				u.setName(rs.getString("name"));
				u.setLogin(rs.getString("login"));
				u.setPass(rs.getString("pass"));
			}
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * save User
	 * @param user 
	 */
	public void saveUser(User u) {
		if(u.getUserid()==0) {
			addUser(u);
		}else {
			updateUser(u);
		}
	}
	
}
