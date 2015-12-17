package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Person;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import util.AppUtils;

/**
 * 
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public class PersonDaoImplTest {

	private static final Logger logger = Logger.getLogger(PersonDaoImplTest.class);

	PersonDaoImpl pd = new PersonDaoImpl();

	@Test
	public void testSavePerson() {

		Person p = new Person();
		p.setName("AĘń");
		p.setMsisdn("1");
		pd.savePerson(p);

		try {
			Class.forName(AppUtils.getBundle("jdbc.driver"));
		} catch (ClassNotFoundException e1) {
			logger.error(e1, e1);
		}

		try (Connection connection = DriverManager.getConnection(AppUtils.getBundle("jdbc.url"), AppUtils.getBundle("db.login"),
		        AppUtils.getBundle("db.password"));
		        Statement statement = connection.createStatement();) {

			String sql = "SELECT name FROM Person WHERE msisdn='1'";
			ResultSet rs = statement.executeQuery(sql);
			String name = null;
			while (rs.next()) {
				name = rs.getString("name");
			}
			rs.close();
			Assert.assertEquals(p.getName(), name);
			
		} catch (SQLException e) {
			logger.error(e, e);
		}
	}
	@Test
	public void testRemovePersonByName() {

		Person p = new Person();
		p.setName("AĘń");
		pd.removePersonByName(p);

		try {
			Class.forName(AppUtils.getBundle("jdbc.driver"));
		} catch (ClassNotFoundException e1) {
			logger.error(e1, e1);
		}

		try (Connection connection = DriverManager.getConnection(AppUtils.getBundle("jdbc.url"), AppUtils.getBundle("db.login"),
		        AppUtils.getBundle("db.password"));
		        Statement statement = connection.createStatement();) {

			String sql = "SELECT * FROM Person WHERE name='AĘń'";
			ResultSet rs = statement.executeQuery(sql);
			boolean hasElement = rs.next();
			rs.close();
			
			Assert.assertFalse(hasElement);
			
		} catch (SQLException e) {
			logger.error(e, e);
		}
	}
}
