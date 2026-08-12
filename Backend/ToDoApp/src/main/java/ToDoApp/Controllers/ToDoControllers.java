package ToDoApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/ToDo")
public class ToDoControllers {
	
	@Autowired
	private ToDoServices toDoServices;
	
	@PostMapping("/addTask")
	public ToDoModel addTask(@RequestBody ToDoModel toDoModel) {
		return toDoServices.addTask(toDoModel);
	}
	
	@GetMapping("/getAllTasks")
	public List<ToDoModel> getAllTasks() {
		return toDoServices.getAllTasks();
	}
	
	@GetMapping("/getTaskById/{id}")
	public ToDoModel getTaskByID(@PathVariable String id) {
		return toDoServices.getTaskById(id);
	}
	
	@DeleteMapping("/deleteTaskById/{id}")
	public void addTask(@PathVariable String id) {
		 toDoServices.deleteTaskById(id);
	}
	
	@PutMapping("/updateTaskById/{id}")
	public ToDoModel updateTask(@PathVariable String id, @RequestBody ToDoModel toDoModel) {
		return toDoServices.updateTaskById(id,toDoModel);
	}
}
