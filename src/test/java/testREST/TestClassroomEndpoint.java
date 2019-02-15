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

import com.qa.REST.ClassroomEndpoint;
import com.qa.businessService.ClassroomService;

@RunWith(MockitoJUnitRunner.class)
public class TestClassroomEndpoint {

	private static final String MOCK_DATA_ARRAY = "[{\"id\":2,\"trainer\":\"Matt Hunt\"}]";
	private static final String MOCK_OBJECT = "{\"id\":2,\"trainer\":\"Matt Hunt\"}";
	private static final String MOCK_OBJECT2 = "{\"traineeID\":2,\"traineeName\":\"Matt Gadd\"}";
	private static final int MOCK_ID =  2;
	@InjectMocks
	private ClassroomEndpoint endy;
	@Mock
	private ClassroomService serv;
	@Before
	public void setUp()
	{
		endy.setService(serv);
	}
	@Test
	public void testCreateClassroom() {
		Mockito.when(serv.createClassroom(MOCK_OBJECT)).thenReturn(MOCK_OBJECT2);
		assertEquals(MOCK_OBJECT2, endy.createClassroom(MOCK_OBJECT));
	}
	@Test
	public void testGetAClassroom()
	{
		Mockito.when(serv.getAClassroom(MOCK_ID)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, endy.getAClassroom(MOCK_ID));
	}
	@Test
	public void testGetAllClassrooms()
	{
		Mockito.when(serv.getAllClassrooms()).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, endy.getallClassrooms());
	}
	@Test
	public void testDeleteClassrooms()
	{
		Mockito.when(serv.deleteClassrooms(MOCK_ID)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, endy.deleteClassroom(MOCK_ID));
	}

}
