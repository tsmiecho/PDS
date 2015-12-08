package service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import pojo.Person;

/**
 * Część odpowiedzialna za logike aplikacji.
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public interface Controller {

	boolean validateData(Map<String, String> data);

	boolean savePerson(Person p);

	String getPhotoPath(String name);

	void createPerson(Map<String, String> data);

	Map<String, String> retrieveDataFromRequest(HttpServletRequest req);
}
