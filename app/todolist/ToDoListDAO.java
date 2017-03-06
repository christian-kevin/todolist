package todolist;

import play.db.jpa.JPA;

import javax.persistence.Query;
import java.util.*;

/**
 * Created by kevin on 03/03/17.
 */
public enum ToDoListDAO {
    INSTANCE;

//    public List<ToDoList> getToDoListbyDate(Date date){
//        Query q = JPA.em().createQuery("select toDoList from ToDoList toDoList where toDoList.date = :date");
//        q.setParameter("date", date);
//
//        return q.getResultList();
//    }

    public List<ToDoList> getToDoLists(){
        Query q = JPA.em().createQuery("select toDoList from ToDoList toDoList");
        return q.getResultList();
    }

    public ToDoList persistToDoList(ToDoList todolist) {
        return JPA.em().merge(todolist);
    }

    public ToDoList getToDoListbyId(long id){
        Query q = JPA.em().createQuery("select toDoList from ToDoList toDoList where toDoList.id = :id");
        q.setParameter("id", id);

        List<ToDoList> toDoLists = q.getResultList();
        return toDoLists.get(0);
    }

    public void deleteTodoListbyId(long id){
        Query q = JPA.em().createQuery("delete from ToDoList toDoList where toDoList.id = :id");
        q.setParameter("id",id);
        q.executeUpdate();
    }

    public void updateTodoListbyId(long id,ToDoList toDoList){
        ToDoList currentToDo = JPA.em().find(ToDoList.class,id);
        currentToDo.setTitle(toDoList.getTitle());
        currentToDo.setDescription(toDoList.getDescription());
    }

}
