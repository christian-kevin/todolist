package todolist;

import java.util.Date;
import java.util.List;
import request.newToDoRequest;
import com.google.common.base.Preconditions;


/**
 * Created by kevin on 03/03/17.
 */
public enum ToDoListManager {
    INSTANCE;

    public List<ToDoList> getToDoLists() {
        return ToDoListDAO.INSTANCE.getToDoLists();
    }

    public ToDoList createNewToDo(newToDoRequest request){
        Preconditions.checkNotNull(request);
        ToDoList newToDo = new ToDoList(request.getTitle(),
                                     request.getDescription());
        newToDo = ToDoListDAO.INSTANCE.persistToDoList(newToDo);
        return newToDo;
    }

    public ToDoList getToDoListbyId(long id){
        return ToDoListDAO.INSTANCE.getToDoListbyId(id);
    }

    public void deleteToDoListbyId(long id){
        ToDoListDAO.INSTANCE.deleteTodoListbyId(id);
    }

    public void updateToDobyId(long id, newToDoRequest request){
        Preconditions.checkNotNull(request);
        ToDoList newToDo = new ToDoList(request.getTitle(),
                                        request.getDescription());
        ToDoListDAO.INSTANCE.updateTodoListbyId(id,newToDo);
    }
}
