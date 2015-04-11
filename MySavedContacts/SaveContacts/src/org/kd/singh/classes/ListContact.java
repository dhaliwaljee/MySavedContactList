package org.kd.singh.classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class ListContact extends LinkedList<Person> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4634621565409319186L;

	public static void save(String path, ListContact obj) throws IOException{
		FileOutputStream fileOut = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(obj);
		out.close();
		fileOut.close();
	}
}
