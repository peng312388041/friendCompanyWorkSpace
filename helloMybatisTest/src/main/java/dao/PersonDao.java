package dao;

import model.Person;

public interface PersonDao {
	public Person  get(int id);
	public void  insert(Person person);
}
