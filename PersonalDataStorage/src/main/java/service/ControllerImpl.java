package service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import dao.PersonDao;
import dao.PersonDaoImpl;
import pojo.Person;

/**
 * 
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public class ControllerImpl implements Controller {

	private static final Logger logger = Logger.getLogger(ControllerImpl.class);
	
	//TODO ustawic sciezke
	private static final String PHOTO_FOLDER_PATH = "/home/tsmiecho/Desktop/photos/";
	
	private PersonDao dao = new PersonDaoImpl();

	@Override
	public boolean validateData(Map<String, String> data) {
		if(StringUtils.isBlank(data.get(NAME))){
			logger.error("Name cannot be blank!");
			return false;
		}
		return true;
	}

	@Override
	public boolean savePerson(Person p) {
		if(logger.isDebugEnabled()){
			logger.error("Adding " + p);
		}
		return dao.savePerson(p);
	}

	@Override
	public String getPhotoPath(String name) {
		return PHOTO_FOLDER_PATH + name + ".bmp";
	}

	@Override
	public void createPerson(Map<String, String> data) {

		Person p = new Person(data.get(NAME), data.get(MSISDN), data.get(MAIL), data.get(COMMENT), getPhotoPath(data.get(NAME)));
		savePerson(p);

	}

	@Override
	public Map<String, String> retrieveDataFromRequest(HttpServletRequest req) {

		Map<String, String> data = new HashMap<String, String>();
		data.put(NAME, req.getParameter(NAME));
		data.put(MSISDN, req.getParameter(MSISDN));
		data.put(MAIL, req.getParameter(MAIL));
		data.put(COMMENT, req.getParameter(COMMENT));
		return data;
	}

}
