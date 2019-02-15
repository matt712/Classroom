package testRepositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.domain.Classroom;
import com.qa.domain.Trainee;
import com.qa.repository.ClassroomDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestClassroomDBRepository {

	@InjectMocks
	private ClassroomDBRepository repo;
	@Mock
	private EntityManager em;
	@Mock
	private Query query;
	private JSONUtil util;
	private static final String MOCK_DATA_ARRAY = "[{\"id\":2,\"trainer\":\"Matt Hunt\"}]";
	private static final String MOCK_OBJECT = "{\"id\":2,\"trainer\":\"Matt Hunt\"}";
	private static final String MOCK_OBJECT2 = "{\"traineeID\":2,\"traineeName\":\"Matt Gadd\"}";
	private static final int MOCK_ID =  2;
	
	
	@Before
	public void setUp()
	{
		repo.setEm(em);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	@Test
	public void testGetAllClassrooms() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Classroom> trainees = new ArrayList<Classroom>();
		trainees.add(new Classroom(MOCK_ID, "Matt Hunt"));
		Mockito.when(query.getResultList()).thenReturn(trainees);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllClassRooms());
	}
	@Test
	public void testGetAClassRoom()
	{
		Mockito.when(em.find(Classroom.class, MOCK_ID)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Classroom.class));
		assertEquals(MOCK_OBJECT, repo.getAClassRoom(MOCK_ID));
	}
	@Test
	public void testCreateClassRoom()
	{
		String reply = repo.createClassRoom(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Classroom created\"}");
	}
	@Test
	public void testDeleteClassroom()
	{
		String reply = repo.deleteClassRoom(MOCK_ID);
		assertEquals(reply, "{\"message\": \"Classroom successfully removed\"}");
	}
}
