package todolist;

import java.util.Date;
import javax.persistence.*;


/**
 * Created by kevin on 03/03/17.
 */
@Entity
@Table(name = "todolist")
public class ToDoList {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    public ToDoList(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ToDoList() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}