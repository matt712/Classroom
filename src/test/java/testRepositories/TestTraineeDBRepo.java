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

import com.qa.domain.Trainee;
import com.qa.repository.TraineeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestTraineeDBRepo {

	@InjectMocks
	private TraineeDBRepository repo;
	@Mock
	private EntityManager em;
	@Mock
	private Query query;
	private JSONUtil util;
	private static final String MOCK_DATA_ARRAY = "[{\"traineeID\":2,\"traineeName\":\"Matt Gadd\"}]";
	private static final String MOCK_OBJECT = "{\"traineeID\":2,\"traineeName\":\"Matt Gadd\"}";
	private static final int MOCK_ID =  2;
	@Before
	public void setUp()
	{
		repo.setEm(em);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	@Test
	public void testGetAllAccounts() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> trainees = new ArrayList<Trainee>();
		trainees.add(new Trainee(MOCK_ID, "Matt Gadd"));
		Mockito.when(query.getResultList()).thenReturn(trainees);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllTrainees());
	}
	@Test
	public void testGetAnAccount()
	{
		Mockito.when(em.find(Trainee.class, MOCK_ID)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Trainee.class));
		assertEquals(MOCK_OBJECT, repo.getATrainee(MOCK_ID));
	}
	@Test
	public void testCreateAccount()
	{
		String reply = repo.createTrainee(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Trainee created\"}");
	}
	@Test
	public void testDeleteAccount()
	{
		String reply = repo.deleteTrainee(1);
		Assert.assertEquals(reply, "{\"message\": \"Trainee successfully removed\"}");
	}
}
