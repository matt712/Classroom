package testDomain;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.qa.domain.Classroom;
import com.qa.domain.Trainee;

public class TestClassroom {

	Classroom testClass1 = new Classroom(1, "Matt Hunt");
	Classroom testClass2 = new Classroom(2, "John Gordon");
	Trainee testTrainee1 = new Trainee(1, "Matt Smith");
	Trainee testTrainee2 = new Trainee(2, "Bob Smith");
	@Test
	public void testTrainer() 
	{
		assertEquals("Matt Hunt", testClass1.getTrainer());
		testClass1.setTrainer("John Gordon");
		assertEquals("John Gordon", testClass1.getTrainer());
	}
	@Test
	public void testID() 
	{
		assertEquals(1, testClass1.getId());
		assertEquals(2, testClass2.getId());
		testClass1.setId(3);
		assertEquals(3, testClass1.getId());
	}
}
