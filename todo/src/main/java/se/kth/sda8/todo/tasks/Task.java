package se.kth.sda8.todo.tasks;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="date")
    private String date;

    public Task() {

    }
    public Task(Long id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}