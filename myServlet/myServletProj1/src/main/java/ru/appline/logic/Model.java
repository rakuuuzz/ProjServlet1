package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model instance = new Model();
    private final Map<Integer, User> model = new HashMap();

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        this.model.put(1, new User("A", "K", 1000));
        this.model.put(2, new User("B", "K", 2000));
        this.model.put(3, new User("C", "K", 3000));
    }

    public User add(User user, int id) {
        return this.model.put(id, user);
    }

    public User del(int id) {
        this.model.remove(id);
        return null;
    }

    public void put(User user, int id) {
        this.model.put(id, user);
    }

    public Map<Integer, User> getFromList() {
        return this.model;
    }
}
