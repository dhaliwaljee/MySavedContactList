package org.kd.singh.example;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.kd.singh.classes.ListContact;
import org.kd.singh.classes.Person;

/**
 * TEST CLASS: only to test the classes in package org.kd.singh.classes
 * @author Karandeep Singh Dhaliwal
 *
 */
public class Read {
	public static void main(String[] args){
		try{
			ListContact list = null;
			FileInputStream in = new FileInputStream("b:/file.txt");
			ObjectInputStream objInput = new ObjectInputStream(in);
			list = (ListContact) objInput.readObject();
			in.close();
			objInput.close();
			
			/*		//display all persons in the list 
			for (Person person : list) {
				System.out.println(person.getFirstName());
				ArrayList<String> values = person.getContactList().getContactValues();
				if(values!=null){
					for (String string : values) {
						System.out.println(string.toString());
					}
				}
			}
			*/
			/* find any person by his/her name
			 */
/*			Person[] persons = list.findPersonsByName("Simran", "", null);
			for (Person person : persons) {
				System.out.println(person.getFirstName());
			}
*/			
			/* find by regex */
			//Person[] persons = list.findPersonByContact("email", "gmail");
			
			/* find by ID */
			//Person persons = list.findPersonById("a");
			
			/* Find by location */
			Person[] persons = list.findPersonsByLocation("", null, null);
			
			for (Person person : persons) {
				System.out.println(person.getId() + " " + person.getFirstName() + " " + (person.getContactList()).get("email"));
			}
		
			
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
