package todolist;

import java.util.Date;
import java.util.List;
import request.newToDoRequest;
import com.google.common.base.Preconditions;
import exceptions.ErrorListException;
import play.api.mvc.Flash;
import org.apache.commons.lang3.StringUtils;


/**
 * Created by kevin on 03/03/17.
 */
public enum ToDoListManager {
    INSTANCE;

    public List<ToDoList> getToDoLists() {
        return ToDoListDAO.INSTANCE.getToDoLists();
    }

    public ToDoList createNewToDo(newToDoRequest request) throws ErrorListException{
        Preconditions.checkNotNull(request);
        ToDoList newToDo = new ToDoList(request.getTitle(),
                request.getDescription());
            if (StringUtils.isBlank(newToDo.getTitle()))
                throw new ErrorListException("Kolom title harus terisi!");
            newToDo = ToDoListDAO.INSTANCE.persistToDoList(newToDo);
        return newToDo;
    }

    public ToDoList getToDoListbyId(long id){
        return ToDoListDAO.INSTANCE.getToDoListbyId(id);
    }

    public void deleteToDoListbyId(long id){
        ToDoListDAO.INSTANCE.deleteTodoListbyId(id);
    }

    public void updateToDobyId(long id, newToDoRequest request) throws ErrorListException{
        Preconditions.checkNotNull(request);
        ToDoList newToDo = new ToDoList(request.getTitle(),
                request.getDescription());
            if (StringUtils.isBlank(newToDo.getTitle()))
                throw new ErrorListException("Kolom title harus terisi!");
            ToDoListDAO.INSTANCE.updateTodoListbyId(id,newToDo);
    }
}
