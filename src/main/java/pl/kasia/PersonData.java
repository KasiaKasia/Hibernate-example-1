package pl.kasia;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class PersonData {
	static Person somePerson1() {
			  return pl.kasia.Person.builder()
					  .firstName("Staś")
					  .lastName("Janko")
					  .age(11)
					   .dateOfDirth(OffsetDateTime.of(1984,1,4,10,20,11,0, ZoneOffset.UTC))
					  .build();
		  
		  }
		  static Person somePerson2() {
			  return Person.builder()
					  .firstName("Stefan")
					  .lastName("Kowalewski")
					  .age(22)
					  .dateOfDirth(OffsetDateTime.of(1991,4,6,10,20,11,0, ZoneOffset.UTC))
					  .build();
		  }
		  static Person somePerson3() {
			  return Person.builder()
					  .firstName("Tomasz")
					  .lastName("Dacha")
					  .age(33)
				 	  .dateOfDirth(OffsetDateTime.of(1981,2,5,10,20,11,0, ZoneOffset.UTC))
					  .build();
		  }
		 
}
