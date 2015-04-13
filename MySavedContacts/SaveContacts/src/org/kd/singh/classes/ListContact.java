package org.kd.singh.classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;


public class ListContact extends LinkedList<Person> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4634621565409319186L;
	private int count = 0;

	public static void save(String path, ListContact obj) throws IOException{
		FileOutputStream fileOut = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(obj);
		out.close();
		fileOut.close();
	}
	
	public Person[] findPersonsByName(String firstName, String middleName, String lastName){
		ArrayList<Person> list = new ArrayList<Person>();
		for(Person person: this){
			//System.out.println(person.getFirstName());
			String fname = person.getFirstName();
			String mname = person.getMiddleName();
			String lname = person.getSurName();
			
			boolean isFirstName = true;
			boolean isMiddleName = true;
			boolean isSurName = true;
			
			if(firstName!=null && firstName.length()>0){
				if(!fname.equalsIgnoreCase(firstName)){
					isFirstName = false;
				}
			}
			if(middleName!=null && middleName.length()>0){
				if(!mname.equalsIgnoreCase(middleName)){
					isMiddleName = false;
				}
			}
			if(lastName!=null && lastName.length()>0){
				if(!lname.equalsIgnoreCase(lastName)){
					isSurName = false;
				}
			}
			
			// if all names are matched then that object will be saved into the list.
			if(isFirstName && isMiddleName && isSurName){
				list.add(person);
			}

		}
		return list.toArray(new Person[list.size()]);
	}

	public Person[] findPersonByContact(String key, String value) {
		ArrayList<Person> list = new ArrayList<Person>();
		
		for(Person person: this){
			Contact<String, String> currentContact = person.getContactList();
			
			String keyValueReturned = currentContact.get(key);
//			if(keyValueReturned!=null && keyValueReturned.equalsIgnoreCase(value)){
			
			if(keyValueReturned!=null && Pattern.compile(".*"+value+".*").matcher(keyValueReturned).matches()){
				list.add(person);
			}
		}
		return list.toArray(new Person[list.size()]);
	}
	
	public Person findPersonById(String id){
		Person found = null;
		for(Person person: this){
			if(id!=null){
				if(person.getId().equalsIgnoreCase(id)){
					found = person;
					break;
				}
			}
		}
		return found;
	}
	
	public Person[] findPersonsByLocation(String city, String province, String country){
		ArrayList<Person> list = new  ArrayList<Person>();
		for (Person person : this) {
			String _city = person.getCity();
			String _province = person.getProvince();
			String _country = person.getCountry();
			
			boolean isCity = true;
			boolean isProvince = true;
			boolean isCountry = true;
			
			if(city!=null && city.length()>0){
				if(!city.equalsIgnoreCase(_city)){
					isCity = false;
				}
			}
			if(province!=null && province.length()>0){
				if(!province.equalsIgnoreCase(_province)){
					isProvince = false;
				}
			}
			if(country!=null && country.length()>0){
				if(!country.equalsIgnoreCase(_country)){
					isCountry = false;
				}
			}
			
			// if all locations are matched then that object will be saved into the list.
			if(isCity && isProvince && isCountry){
				list.add(person);
			}
		}
		
		return list.toArray(new Person[list.size()]);
	}
}
