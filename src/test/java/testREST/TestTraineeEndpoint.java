package testREST;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.REST.TraineeEndpoint;
import com.qa.businessService.TraineeService;

@RunWith(MockitoJUnitRunner.class)
public class TestTraineeEndpoint {

	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";
	private static final int MOCK_ID = 1;
	@InjectMocks
	private TraineeEndpoint endy; 
	@Mock
	private TraineeService serv;
	@Before
	public void setUp()
	{
		endy.setService(serv);
	}
	@Test
	public void testCreateTrainee() {
		Mockito.when(serv.addTrainee(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endy.addTrainee(MOCK_VALUE));
	}
	@Test
	public void testGetAllTrainees() {
		Mockito.when(serv.getAllTrainees()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endy.getAllTrainees());
	}
	@Test
	public void testGetTrainee()
	{
		Mockito.when(serv.getATrainee(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endy.getATrainee(MOCK_ID));
	}
	@Test
	public void testUpdateTrainee()
	{
		Mockito.when(serv.updateTrainee(MOCK_ID, MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endy.updateTrainee(MOCK_ID, MOCK_VALUE));
	}
	@Test
	public void testDeleteTrainee()
	{
		Mockito.when(serv.deleteTrainee(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endy.deleteTrainee(MOCK_ID));
	}
}
