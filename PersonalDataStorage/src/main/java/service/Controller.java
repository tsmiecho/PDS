package service;

import javax.servlet.http.HttpServletRequest;

import model.Person;

/**
 * Część odpowiedzialna za logike aplikacji.
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public interface Controller {

	void validateData(Person p);

	boolean savePerson(Person p);

	String getPhotoPath(String name);

	void createPerson(HttpServletRequest req) throws Exception;

}
