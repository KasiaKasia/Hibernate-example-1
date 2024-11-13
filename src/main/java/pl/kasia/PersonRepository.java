package pl.kasia;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonRepository {
	 
	private void executeInsideTransaction(Session session, Runnable action) {
		Transaction transaction = session.beginTransaction();
		try {
			action.run();
			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		}
	}
/*
	To jest anty-wzorzec otwierania i zamykania sesji dla każdego wywołania bazy danych w pojedynczym wątku. 
	Otwieranie i zamykanie sesji za każdym razem, gdy jest wykonywane pojedyncze zapytanie do bazy danych w 
	jednym wątku jest NIEEFEKTYWNE, kosztowne i może prowadzić do problemów z wydajnością.
	Zaleca się, aby grupować zapytania do bazy danych w przemyślaną sekwencję. 
	Co pozwala na użycie jednej sesji i jednej transakcji dla całej grupy operacji. 
	Jest to bardziej wydajne i bezpieczne.
*/
	public Person insertPerson(final Person person) {
		try (Session session = HibernateUtil.getSession()) {
			Objects.requireNonNull(session, "Session is null");
			executeInsideTransaction(session, () -> session.persist(person));
			return person;
		}
	}
	
	public void deleteAll() {
		try (Session session = HibernateUtil.getSession()) {
			Objects.requireNonNull(session, "Session is null");
			executeInsideTransaction(session, () -> {
				String query = "select p from Person p"; // Jakarta Persistence Query Language - JPQL
				session.createQuery(query, Person.class).list().forEach(session::remove);
			});
		}
	}
	
	public List<Person> listPeople() {
		try (Session session = HibernateUtil.getSession()) {
			Objects.requireNonNull(session, "Session is null");
			return session.createQuery("SELECT p FROM Person p", Person.class).list();
		}
	}
	
	public Optional<Person> getPerson(Integer personId) {
		try (Session session = HibernateUtil.getSession()) {
			Objects.requireNonNull(session, "Session is null");
			return Optional.ofNullable(session.find(Person.class, personId));
		}
	}
	
	public void updatePerson(Integer personId, Integer newAge) {
		try (Session session = HibernateUtil.getSession()) {
			Objects.requireNonNull(session, "Session is null");
			executeInsideTransaction(session, () -> {
				Person person = session.find(Person.class, personId);
				if (person != null) {
					person.setAge(newAge);
				}
			});
		}
	}
	
	public void deletePerson(Integer personId) {
		try (Session session = HibernateUtil.getSession()) {
			Objects.requireNonNull(session, "Session is null");
			executeInsideTransaction(session, () -> {
				Person person = session.find(Person.class, personId);
				if (person != null) {
					session.remove(person);
				}
			});
		}
	}

}
