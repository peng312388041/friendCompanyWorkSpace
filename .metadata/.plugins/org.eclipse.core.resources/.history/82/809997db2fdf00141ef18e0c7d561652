package implDao.jdbc;

import iDao.IPersonDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Person;
import util.DB;

public class ImplPersonDao implements IPersonDao {

	private Connection connection = null;
	private Statement stmt = null;
	private PreparedStatement pstm = null;
	private String sql = null;
	ResultSet rs = null;

	private void close(Connection connection, Statement stmt, ResultSet rs) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	private void close(Connection connection, PreparedStatement pstm,
			ResultSet rs) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	private void close(Connection connection, PreparedStatement pstm) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public Person get(int id) {
		System.out.println("-------------------jdbc----------------------");
		try {
			sql = "select * from person where person_id= ?";
			connection = DB.getConnection();
			connection.setAutoCommit(false);
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Person person = new Person();
				person.setPerson_id(rs.getInt(1));
				person.setPerson_name(rs.getString(2));
				person.setPerson_age(rs.getInt(3));
				connection.commit();
				connection.setAutoCommit(true);
				return person;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, pstm, rs);
		}
		return null;
	}

	public int insert(Person person) {
		System.out.println("-------------------jdbc----------------------");
		int count = 0;
		try {
			sql = "insert into person(person_name,person_age) value(?,?)";
			connection = DB.getConnection();
			connection.setAutoCommit(false);
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, person.getPerson_name());
			pstm.setInt(2, person.getPerson_age());
			pstm.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			count = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, pstm);
		}
		return count;
	}

	public Person delete(int id) {
		System.out.println("-------------------jdbc----------------------");
		Person person = get(id);
		try {
			sql = "delete from person where person.person_id= ?";
			connection = DB.getConnection();
			connection.setAutoCommit(false);
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			return person;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, pstm);
		}
		return null;
	}

	public int update(Person person) {
		int result = 0;
		System.out.println("-------------------jdbc----------------------");
		// String sql = "update person set " + "person.person_name='"
		// + person.getPerson_name() + "',person.person_age="
		// + person.getPerson_age() + " where person_id="
		// + person.getPerson_id();
		try {
			sql = "update person set person.person_name=?,person.person_age=? where person.person_id=?";
			connection = DB.getConnection();
			connection.setAutoCommit(false);
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, person.getPerson_name());
			pstm.setInt(2, person.getPerson_age());
			pstm.setInt(3, person.getPerson_id());
			System.out.println(sql);
			pstm.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, pstm);
		}
		return result;
	}

	public List<Person> getAll() {
		System.out.println("-------------------jdbc----------------------");
		List<Person> personList = new ArrayList<Person>();
		try {
			sql = "select * from person";
			connection = DB.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Person person = new Person();
				person.setPerson_id(rs.getInt(1));
				person.setPerson_name(rs.getString(2));
				person.setPerson_age(rs.getInt(3));
				personList.add(person);
			}
			return personList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, stmt, rs);
		}
		return null;
	}

	public long getCount() {
		long count = 0;
		System.out.println("-------------------jdbc----------------------");
		try {
			sql = "select count(*) from person";
			connection = DB.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, stmt, rs);
		}
		return count;
	}
}
