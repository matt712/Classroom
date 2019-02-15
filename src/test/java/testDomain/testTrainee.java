package testDomain;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.qa.domain.Trainee;

public class testTrainee 
{
	Trainee testTrainee1 = new Trainee(1, "Matt Smith");
	Trainee testTrainee2 = new Trainee(2, "Bob Smith");
	@Test
	public void testName() 
	{
		assertEquals("Matt Smith", testTrainee1.getName());
		testTrainee1.setName("Matt Gadd");
		assertEquals("Matt Gadd", testTrainee1.getName());
	}
	@Test
	public void testId()
	{
		assertEquals(1, testTrainee1.getId());
		assertEquals(2, testTrainee2.getId());
		testTrainee1.setId(3);
		assertEquals(3, testTrainee1.getId());
	}
}
