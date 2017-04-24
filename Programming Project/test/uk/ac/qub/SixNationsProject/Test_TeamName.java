/**
 * 
 */
package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.hamcrest.Matcher;

/**
 * @author Kathy
 *
 */
public class Test_TeamName {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	//Test the enum Scotland
	
	@Test
	public void testScotland() {
		
		assertThat(TeamName.valueOf("SCOTLAND"), is(notNullValue()));
	}
// Test the enum England

		@Test
	public void testENGLAND() {
		
		assertThat(TeamName.valueOf("ENGLAND"), is(notNullValue()));
	}
		//Test the enum Wales
		
		@Test
		public void testWales() {
			
			assertThat(TeamName.valueOf("WALES"), is(notNullValue()));
		}
		
		// Test the enum Ireland
		@Test
		public void testIreland() {
			
			assertThat(TeamName.valueOf("IRELAND"), is(notNullValue()));
		}
		
		//Test the enum Italy
		@Test
		public void testItaly() {
			
			assertThat(TeamName.valueOf("ITALY"), is(notNullValue()));
		}
		
	private Matcher<? super TeamName> is(Object notNullValue) {
		// Matching the enum to a value
		return null;
	}

	private Object notNullValue() {
		// creating the not null value object for testing
		return null;
	}
}
