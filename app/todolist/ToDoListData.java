package todolist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by kevin on 06/03/17.
 */
public class ToDoListData {

    @JsonProperty("title")
    String title;

    @JsonProperty("description")
    String description;

    public ToDoListData(ToDoList toDoList) {
        this.title = toDoList.getTitle();
        this.description = toDoList.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


}
