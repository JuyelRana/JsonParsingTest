package org.careerop.jsonparsingtest;

/**
 * Created by JuyelRana on 17/04/22.
 */

public class Student {
    String id,name;

    public Student() {
    }

    public Student(String id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
