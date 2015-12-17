package service;

import model.Person;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 *
 * @author Tomasz Śmiechowicz
 * @since 0.0.1-SNAPSHOT
 */
public class ControllerImplTest {

	private ControllerImpl c = new ControllerImpl();

	@Test
	public void testValidateData() {
		Person p = new Person();
		p.setName("  ");
		try{
			c.validateData(p);
		}catch(Exception e ){
			Assert.assertTrue(true);
		}
	}

}
