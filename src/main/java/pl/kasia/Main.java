package pl.kasia;

import java.util.Optional;

public class Main {
	public static void main(String[] args) {

		PersonRepository personRepository = new PersonRepository();
		personRepository.deleteAll();
		Person person1 = personRepository.insertPerson(PersonData.somePerson1());
		Person person2 = personRepository.insertPerson(PersonData.somePerson2());
		Person person3 = personRepository.insertPerson(PersonData.somePerson3());

		Optional newPerson1 = personRepository.getPerson(person1.getId());
		Optional newPerson2 = personRepository.getPerson(person2.getId());
		Optional newPerson3 = personRepository.getPerson(person3.getId());

		System.out.println("Person 1 = " + newPerson1);
		System.out.println("Person 2 = " + newPerson2);
		System.out.println("Person 3 = " + newPerson3);

		personRepository.updatePerson(person1.getId(), 66);
		System.out.println(" Perosn updated: " + personRepository.getPerson(person3.getId()));
		System.out.println("-------------" );
		personRepository.listPeople().forEach(perosn -> System.out.println(" Person: " + perosn));
		System.out.println("-------------" );
		personRepository.deletePerson(person2.getId());
		personRepository.listPeople().forEach(perosn -> System.out.println(" Person: " + perosn));
		HibernateUtil.closeSessionFactory();

	}
}
