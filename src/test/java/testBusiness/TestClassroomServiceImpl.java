package testBusiness;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.businessService.ClassroomService;
import com.qa.businessService.ClassroomServiceImpl;
import com.qa.domain.Classroom;
import com.qa.domain.Trainee;
import com.qa.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestClassroomServiceImpl {

	
	private static final String MOCK_DATA_ARRAY = "[{\"id\":2,\"trainer\":\"Matt Hunt\"}]";
	private static final String MOCK_OBJECT = "{\"id\":2,\"trainer\":\"Matt Hunt\"}";
	private static final String MOCK_OBJECT2 = "{\"traineeID\":2,\"traineeName\":\"Matt Gadd\"}";
	private static final int MOCK_ID =  2;
	private static final Classroom testObject = new Classroom(1, "Tom Riddle");
	@InjectMocks
	private ClassroomServiceImpl serv;
	@Mock
	private ClassroomRepository repo;
	@Mock
	private JSONUtil util;
	@Before
	public void setUp()
	{
		serv.setRepo(repo);
		serv.setUtil(util);
	}
	@Test
	public void testClassroomCreate()
	{
		Mockito.when(repo.createClassRoom(MOCK_OBJECT2)).thenReturn(MOCK_OBJECT);
		Mockito.when(util.getObjectForJSON(MOCK_OBJECT, Classroom.class)).thenReturn(testObject);
		assertEquals(MOCK_OBJECT, serv.createClassroom(MOCK_OBJECT2));
	}
	@Test
	public void testGetAllClassrooms()
	{
		Mockito.when(repo.getAllClassRooms()).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, serv.getAllClassrooms());
	}
	@Test
	public void testGetAClassroom()
	{
		Mockito.when(repo.getAClassRoom(MOCK_ID)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, serv.getAClassroom(MOCK_ID));
	}
	@Test
	public void testDeleteClassroom()
	{
		Mockito.when(repo.deleteClassRoom(MOCK_ID)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, serv.deleteClassrooms(MOCK_ID));
	}
}
