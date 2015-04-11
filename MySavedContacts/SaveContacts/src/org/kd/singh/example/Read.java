package org.kd.singh.example;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.kd.singh.classes.Contact;
import org.kd.singh.classes.ListContact;
import org.kd.singh.classes.Person;

public class Read {
	public static void main(String[] args){
		try{
			ListContact list = null;
			FileInputStream in = new FileInputStream("b:/file.txt");
			ObjectInputStream objInput = new ObjectInputStream(in);
			list = (ListContact) objInput.readObject();
			in.close();
			objInput.close();
			
			for (Person person : list) {
				System.out.println(person.getFirstName());
				ArrayList<String> values = person.getContactList().getContactValues();
				for (String string : values) {
					System.out.println(string.toString());
				}
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
