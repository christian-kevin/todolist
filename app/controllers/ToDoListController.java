package controllers;

import java.util.List;
import controllers.*;
import exceptions.ErrorListException;
import play.data.Form;
import play.data.FormFactory;
import todolist.ToDoListManager;
import todolist.ToDoList;
import request.newToDoRequest;
import static java.util.Comparator.comparing;
import static play.data.Form.form;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;

import response.BaseResponse;

import views.html.*;
/**
 * Created by kevin on 03/03/17.
 */
@Transactional
public class ToDoListController extends Controller {

    public Result showToDoList(){
        List<ToDoList> todolists = ToDoListManager.INSTANCE.getToDoLists();
        return ok(todolist_view.render(null,todolists));
    }

    public Result createNewToDo() throws ErrorListException {
        List<ToDoList> todolists = ToDoListManager.INSTANCE.getToDoLists();
        newToDoRequest request = new newToDoRequest(request());
        try {
            ToDoListManager.INSTANCE.createNewToDo(request);
        }
        catch (ErrorListException e){
            return ok(todolist_view.render(e.getErrors(),todolists));
        }
        return redirect(routes.ToDoListController.showToDoList());
    }

    public Result index(){
        return ok(todolist_form.render());
    }

    public Result deleteToDo(Long id){
        ToDoListManager.INSTANCE.deleteToDoListbyId(id);
        return ok("To Do has been deleted");
    }

    public Result redirectEdit(Long id){
        ToDoList toDoEdit = ToDoListManager.INSTANCE.getToDoListbyId(id);
        Form<ToDoList> toDoListForm = form(ToDoList.class).fill(toDoEdit);
        return ok(todolist_form.render());
    }

    public Result updateToDobyId(Long id) throws ErrorListException {
        List<ToDoList> todolists = ToDoListManager.INSTANCE.getToDoLists();
        newToDoRequest request = new newToDoRequest(request());
        try {
            ToDoListManager.INSTANCE.updateToDobyId(id, request);
        }
        catch (ErrorListException e){
            return ok(todolist_view.render(e.getErrors(),todolists));
        }
        return redirect(routes.ToDoListController.showToDoList());
    }
}
