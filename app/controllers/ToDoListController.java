package controllers;

import java.util.List;
import controllers.*;
import play.api.data.Form;
import play.data.FormFactory;
import todolist.ToDoListManager;
import todolist.ToDoList;
import request.newToDoRequest;
import static java.util.Comparator.comparing;

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
        return ok(todolist_view.render(todolists));
    }

    public Result createNewToDo(){
        newToDoRequest request = new newToDoRequest(request());
        ToDoListManager.INSTANCE.createNewToDo(request);
        return redirect(routes.ToDoListController.showToDoList());
    }

    public Result index(){
        return ok(todolist_form.render());
    }

    public Result deleteToDo(Long id){
        ToDoListManager.INSTANCE.deleteToDoListbyId(id);
        return redirect(routes.ToDoListController.showToDoList());
    }

    public Result redirectEdit(Long id){
        ToDoList toDoEdit = ToDoListManager.INSTANCE.getToDoListbyId(id);
        return ok(todolist_form.render());
    }

    public Result updateToDobyId(Long id){
        newToDoRequest request = new newToDoRequest(request());
        ToDoListManager.INSTANCE.updateToDobyId(id,request);
        return redirect(routes.ToDoListController.showToDoList());
    }
    ///
}
