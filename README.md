# Hibernate

Hibernate jest implementacją specyfikacji Java Persistence API (JPA). Istnieje wiele projektów Hibernate:

• Hibernate ORM - Wcześniej znane jako Hibernate Core. Fundament i najstarsza część Hibernate
odpowiadająca za mapowanie obiektowo-relacyjne. Działająca niezależnie od reszty komponentów
Hibernate.
• Hibernate Search - Dostarcza pomoc do wyszukiwań na postawie zadanego tekstu.
• Hibernate Validator - Niezależny projekt implementujący specyfikację Bean Validation. Projekt wprowadza adnotacje, które pozwalają na definiowanie ograniczeń oraz
sprawdzanie czy obiekty spełniają oraniczenia.
• Hibernate Tools
• Hibernate Reactive
• Hibernate Others

## Do projektu należy zainstalować Project Lombok
Instalacja Project Lombok
Należy pobrać Project Lombok z strony https://projectlombok.org/download
W ustawieniach projektu `Properties -> Java Buils Path` w zakładce Libraries kliknąć przycisk Add External JARs i dołączyć pobrana bibliotekę lombok.jar. Dodanie zatwierdzamy przyciskiem Apply and Close


## Tabela:
```
create TABLE person (
	person_id SERIAL NOT NULL,
	firstName VARCHAR(255),
	lastName VARCHAR(255),
	age INT,
	date_of_birth TIMESTAMP WITH TIME ZONE NOT NULL,
	primary key (person_id) 
)
```
 