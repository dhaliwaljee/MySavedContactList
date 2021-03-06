package org.kd.singh.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Contact<T1, T2> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4361628502959691204L;
	private HashMap<T1, T2> values;
	
	public Contact() {
		values = new HashMap<T1, T2>();
	}
	
	public void add(T1 name, T2 value){
		values.put(name, value);
	}
	
	public HashMap<T1, T2> get(){
		return values;
	}
	
	public T2 get(String key){
		Map<T1, T2> map = (Map<T1, T2>) values;
		return map.get(key);
	}
	
	
	
	/**
	 * return all the contact values without its label (email, phone etc.)
	 * @return 
	 */
	public ArrayList<T2> getContactValues(){
		ArrayList<T2> list = new ArrayList<T2>();
		for (T1 key : values.keySet()) {
			list.add(values.get(key));
		}
		return list;
	}
}
