package br.com.akira.test;

import java.util.List;

import br.com.akira.model.User;
import br.com.akira.model.UserDAO;

public class UserTest {
	public static void main(String[] args) {

//		addUser();
//		deleteUser();
//		updateUser();
//		allUsers();
//		findByName();
//		findByID();
		
		

	}

	private static void findByID() {
		UserDAO dao = new UserDAO();
		User u = dao.findById(5);
		
		System.out.println("ID    : " + u.getUserid());
		System.out.println("Name  : " + u.getName());
		System.out.println("Login : " + u.getLogin());
		System.out.println("Pass  : " + u.getPass());
	}

	private static void findByName() {
		UserDAO dao = new UserDAO();
		List<User> list = dao.findByName("lu");
		
		for (User u : list) {
			System.out.println("ID    : " + u.getUserid());
			System.out.println("Name  : " + u.getName());
			System.out.println("Login : " + u.getLogin());
			System.out.println("Pass  : " + u.getPass());
			System.out.println();
		}
	}

	private static void allUsers() {
		UserDAO dao = new UserDAO();
		List<User> list = dao.allUsers();
		for (User u : list) {
			System.out.println("ID    : " + u.getUserid());
			System.out.println("Name  : " + u.getName());
			System.out.println("Login : " + u.getLogin());
			System.out.println("Pass  : " + u.getPass());
			System.out.println();
		}
	}

	private static void updateUser() {
		User u = new User();
		u.setName("sofi1");
		u.setLogin("sofi1");
		u.setPass("sofi1");
		u.setUserid(41);

		UserDAO dao = new UserDAO();
		dao.updateUser(u);
	}

	private static void deleteUser() {
		UserDAO dao = new UserDAO();
		dao.deleteUser(42);
	}

	private static void addUser() {
		User u = new User();
		u.setName("Elias");
		u.setLogin("elias");
		u.setPass("234");

		UserDAO dao = new UserDAO();
		dao.addUser(u);
	}
}
