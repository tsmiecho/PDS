package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import pojo.Person;
import util.AppUtils;

/**
 * 
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public class PersonDaoImpl implements PersonDao {

	private static final Logger logger = Logger.getLogger(PersonDaoImpl.class);

	private static final String COMMA = ",";

	private static final String APOSTROPHE = "'";

	@Override
	public boolean savePerson(Person p) {

		StringBuilder sb = new StringBuilder(
				"insert into Person ( name, msisdn, email, person_comment, photo_url, city, street, street_number, flat_number ) values (");
		sb.append(APOSTROPHE).append(p.getName()).append(APOSTROPHE).append(COMMA);
		sb.append(APOSTROPHE).append(p.getMsisdn()).append(APOSTROPHE).append(COMMA);
		sb.append(APOSTROPHE).append(p.getEmail()).append(APOSTROPHE).append(COMMA);
		sb.append(APOSTROPHE).append(p.getComment()).append(APOSTROPHE).append(COMMA);
		sb.append(APOSTROPHE).append(p.getPhotoUrl()).append(APOSTROPHE).append(COMMA);
		sb.append(APOSTROPHE).append(p.getCity()).append(APOSTROPHE).append(COMMA);
		sb.append(APOSTROPHE).append(p.getStreet()).append(APOSTROPHE).append(COMMA);
		sb.append(APOSTROPHE).append(p.getStreetNumber()).append(APOSTROPHE).append(COMMA);
		sb.append(APOSTROPHE).append(p.getFlatNumber()).append(APOSTROPHE).append(")");

		if(logger.isDebugEnabled()){
			logger.debug(sb.toString());
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			logger.error(e1, e1);
		}
		
		try (Connection connection = DriverManager.getConnection(
																		AppUtils.getBundle("jdbc.url"),
																		AppUtils.getBundle("db.login"),
																		AppUtils.getBundle("db.password"));
			 Statement statement = connection.createStatement();) {

			statement.execute(sb.toString());

		} catch (SQLException e) {
			logger.error(e, e);
		}
		return true;
	}

}
