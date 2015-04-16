package iDao;



import java.util.List;

import model.Person;

public interface PersonDao {
	public int insert(Person person);
	public Person delete(Person person);
	public int update(Person person);
	public Person selectOne(int id);
	public List<Person> getAll();
}
