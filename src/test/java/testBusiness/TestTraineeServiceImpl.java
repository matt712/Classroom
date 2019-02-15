package testBusiness;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.businessService.TraineeServiceImpl;
import com.qa.domain.Trainee;
import com.qa.repository.TraineeRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestTraineeServiceImpl {

	private static final String MOCK_OBJECT = "{\"traineeID\":2,\"traineeName\":\"Matt Gadd\"}";
	private static final String MOCK_OBJECT2 = "{\"traineeID\":3,\"traineeName\":\"Matt Badd\"}";
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final int MOCK_ID = 1;
	private static final Trainee testObject = new Trainee(1, "Tom Riddle");
	@InjectMocks 
	private TraineeServiceImpl serv;
	@Mock
	private TraineeRepository repo;
	@Mock 
	private JSONUtil util;
	@Before
	public void setUp()
	{
		serv.setRepo(repo);
		serv.setUtil(util);
	}
	@Test
	public void testTraineeCreation()
	{
		Mockito.when(repo.createTrainee(MOCK_OBJECT2)).thenReturn(MOCK_VALUE2);
		Mockito.when(util.getObjectForJSON(MOCK_OBJECT2, Trainee.class)).thenReturn(testObject);
		assertEquals(MOCK_VALUE2, serv.addTrainee(MOCK_OBJECT2));
	}
	@Test
	public void testTraineeDelete()
	{
		Mockito.when(repo.deleteTrainee(MOCK_ID)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, serv.deleteTrainee(MOCK_ID));
	}
	@Test
	public void testGetAllTrainees()
	{
		Mockito.when(repo.getAllTrainees()).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, serv.getAllTrainees());
	}
	@Test
	public void testgetATrainee()
	{
		Mockito.when(repo.getATrainee(MOCK_ID)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, serv.getATrainee(MOCK_ID));
	}
	@Test
	public void testUpdateTrainee()
	{
		Mockito.when(repo.updateTrainee(MOCK_ID, MOCK_OBJECT)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, serv.updateTrainee(MOCK_ID, MOCK_OBJECT));
	}
}
