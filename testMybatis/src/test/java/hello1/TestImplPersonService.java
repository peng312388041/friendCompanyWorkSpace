package hello1;

import iDao.PersonDao;
import model.Person;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import util.DB;

public class TestImplPersonService {

	@Test
	public void test() {
		SqlSessionFactory sessionFactory = DB.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		assert (null != session);
		PersonDao dao = session.getMapper(PersonDao.class);
		Person person = dao.selectOne(7);
		System.out.println(person);
	}
}
