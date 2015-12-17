package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.Person;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import util.AppUtils;
import dao.PersonDao;
import dao.PersonDaoImpl;

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
	public void validateData(Person p) {
		if(StringUtils.isBlank(p.getName())){
			throw new IllegalArgumentException("Name cannot be blank!");
		}
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
	public void createPerson(HttpServletRequest req) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("UTF-8");

		Person p = new Person();
		p.setName(req.getParameter(AppUtils.NAME));
		p.setMsisdn(req.getParameter(AppUtils.MSISDN));
		p.setEmail(req.getParameter(AppUtils.MAIL));
		p.setComment(req.getParameter(AppUtils.COMMENT));
		p.setPhotoUrl(getPhotoPath(req.getParameter(AppUtils.NAME)));
		p.setCity(req.getParameter(AppUtils.CITY));
		p.setStreet(req.getParameter(AppUtils.STREET));
		p.setStreetNumber(req.getParameter(AppUtils.STREET_NUMBER));
		p.setFlatNumber(req.getParameter(AppUtils.FLAT_NUMBER));
		
		validateData(p);
		savePerson(p);
	}

}
