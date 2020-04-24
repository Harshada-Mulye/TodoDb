package se.kth.sda8.todo.projects;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    public Project(String name) {
        this.name = name;
    }
    public Project() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}