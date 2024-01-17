package logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable{
	private static final Model instance = new Model();
	
	private final Map<Integer,User> model;
	
	public static Model getInstance() {
		return instance;
	} 
	
	private Model() {
		model = new HashMap();
		
		model.put(1,new User("A","K",1000));
		model.put(2,new User("B","K",2000));
		model.put(3,new User("C","K",3000));
	}
	
	public void add(User user,int id) {
		model.put(id,user);
	}
	
	public void del(int id) {
		model.remove(id);
	}
	public void put(User user,int id) {
		model.put(id,user);
		
	}
	
	public Map<Integer,User> getFromList() {
		return model;
	}
	
}
