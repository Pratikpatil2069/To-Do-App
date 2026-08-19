package ToDoApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ToDoApp.Model.ToDoModel;
import ToDoApp.Services.ToDoServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ToDo")
public class ToDoControllers {
	
	@Autowired
	private ToDoServices toDoServices;
	
	@PostMapping("/addTask")
	public ResponseEntity<ToDoModel> addTask(@Valid @RequestBody ToDoModel toDoModel) {
		ToDoModel toDo= toDoServices.addTask(toDoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(toDo);
	}
	
	@GetMapping("/getAllTasks")
	public ResponseEntity<List<ToDoModel>>  getAllTasks() {
		List<ToDoModel>list= toDoServices.getAllTasks();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getTaskById/{id}")
	public ResponseEntity<ToDoModel>  getTaskByID(@PathVariable String id) {
		ToDoModel toDo= toDoServices.getTaskById(id);
		return ResponseEntity.ok(toDo);
	}
	
	@DeleteMapping("/deleteTaskById/{id}")
	public ResponseEntity<Void>  addTask(@PathVariable String id) {
		 toDoServices.deleteTaskById(id);
		 return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/updateTaskById/{id}")
	public ResponseEntity<ToDoModel>  updateTask(@PathVariable String id, @Valid @RequestBody ToDoModel toDoModel) {
		ToDoModel toDo=toDoServices.updateTaskById(id,toDoModel);
		return ResponseEntity.ok(toDo);
	}
}
