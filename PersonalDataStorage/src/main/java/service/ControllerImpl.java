package service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import dao.PersonDao;
import dao.PersonDaoImpl;
import pojo.Person;
import util.AppUtils;

/**
 * 
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public class ControllerImpl implements Controller {

	private static final Logger logger = Logger.getLogger(ControllerImpl.class);

	private PersonDao dao = new PersonDaoImpl();

	@Override
	public boolean validateData(Map<String, String> data) {
		if(StringUtils.isBlank(data.get(AppUtils.NAME))){
			logger.error("Name cannot be blank!");
			return false;
		}
		return true;
	}

	@Override
	public boolean savePerson(Person p) {
		if(logger.isDebugEnabled()){
			logger.debug("Adding " + p);
		}
		return dao.savePerson(p);
	}

	@Override
	public String getPhotoPath(String name) {
		return AppUtils.PHOTO_FOLDER_PATH + name + ".bmp";
	}

	@Override
	public void createPerson(Map<String, String> data) {

		Person p = new Person();
		p.setName(data.get(AppUtils.NAME));
		p.setMsisdn(data.get(AppUtils.MSISDN));
		p.setEmail(data.get(AppUtils.MAIL));
		p.setComment(data.get(AppUtils.COMMENT));
		p.setPhotoUrl(getPhotoPath(data.get(AppUtils.NAME)));
		p.setCity(data.get(AppUtils.CITY));
		p.setStreet(data.get(AppUtils.STREET));
		p.setStreetNumber(data.get(AppUtils.STREET_NUMBER));
		p.setFlatNumber(data.get(AppUtils.FLAT_NUMBER));
		savePerson(p);
	}

	@Override
	public Map<String, String> retrieveDataFromRequest(HttpServletRequest req) {
		try {
	        req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
        	logger.error(e,e);
        }
		Map<String, String> data = new HashMap<String, String>();
		data.put(AppUtils.NAME, req.getParameter(AppUtils.NAME));
		data.put(AppUtils.MSISDN, req.getParameter(AppUtils.MSISDN));
		data.put(AppUtils.MAIL, req.getParameter(AppUtils.MAIL));
		data.put(AppUtils.COMMENT, req.getParameter(AppUtils.COMMENT));
		data.put(AppUtils.CITY, req.getParameter(AppUtils.CITY));
		data.put(AppUtils.STREET, req.getParameter(AppUtils.STREET));
		data.put(AppUtils.STREET_NUMBER, req.getParameter(AppUtils.STREET_NUMBER));
		data.put(AppUtils.FLAT_NUMBER, req.getParameter(AppUtils.FLAT_NUMBER));
		return data;
	}

}
