package dao;

import model.Person;


/**
 * Część aplikacji odpowiedzialna za komunikacje z bazą danych.
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public interface PersonDao {

	boolean savePerson(Person p);
	
	boolean removePersonByName(Person p);
}
