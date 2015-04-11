package org.kd.singh.example;

import java.io.IOException;

import org.kd.singh.classes.Contact;
import org.kd.singh.classes.ListContact;
import org.kd.singh.classes.Person;

public class MyTest {
	
	public static void main(String[] args){
		Person person = new Person();
		person.setFirstName("Karandeep");
		person.setMiddleName("Singh");
		person.setSurName("Dhaliwal");
		
		Contact<String, String> contact1 = new Contact<String, String>();
		contact1.add("email", "dhaliwal@gmail.com");
		contact1.add("phone", "204-963-3859");
		person.setContactList(contact1);
		
		Person person1 = new Person();
		person1.setFirstName("Harpreet");
		person1.setMiddleName("Singh");
		person1.setSurName("Dhaliwal");

		
		ListContact list = new ListContact();
		list.add(person);
		try {
			ListContact.save("b:\\file.txt", list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
