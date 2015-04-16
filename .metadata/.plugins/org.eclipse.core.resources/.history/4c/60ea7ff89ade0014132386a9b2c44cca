package implDao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.DB;
import model.Person;
import iDao.IPersonDao;

public class ImplPersonDao implements IPersonDao {

	SqlSession session = DB.getMybatisSession();

	public int insert(Person person) {
		System.out.println("-------------------mybatis----------------------");
		int result = session.insert("iDao.IPersonDao.insert", person);
		session.commit();
		return result;
	}

	public Person delete(int id) {
		System.out.println("-------------------mybatis----------------------");
		Person person = null;
		person = get(id);
		session.delete("iDao.IPersonDao.delete", id);
		session.commit();
		return person;
	}

	public int update(Person person) {
		System.out.println("-------------------mybatis----------------------");
		int result = session.update("iDao.IPersonDao.update", person);
		session.commit();
		return result;
	}

	public Person get(int id) {
		System.out.println("-------------------mybatis----------------------");
		return (Person) session.selectOne("iDao.IPersonDao.get", id);
	}

	public List<Person> getAll() {

		System.out.println("-------------------mybatis----------------------");
		List<Person> personList = session.selectList("iDao.IPersonDao.getAll");
		return personList;
	}

	public long getCount() {
		System.out.println("-------------------mybatis----------------------");
		// return
		// Long.parseLong((session.selectOne("iDao.IPersonDao.getCount")+""));
		return new Long(session.selectOne("iDao.IPersonDao.getCount") + "");
	}

}
