package ToDoApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ToDoApp.LocalException.ResourceException;
import ToDoApp.Model.ToDoModel;
import ToDoApp.Repository.ToDoRepository;

@Service
public class ToDoServices {
	
	@Autowired
	private ToDoRepository toDoRepository;
	
	public ToDoModel addTask(ToDoModel toDoModel) {
		return toDoRepository.save(toDoModel);
	}
	
	public List<ToDoModel> getAllTasks(){
		return toDoRepository.findAll();
	}
	
	public ToDoModel getTaskById(String id) {
		return toDoRepository.findById(id).orElseThrow(()->new ResourceException("Task not found by id: "+id));
	}
	
	public ToDoModel deleteTaskById(String id) {
		ToDoModel toDoModel=toDoRepository.findById(id).orElseThrow(()->new ResourceException("Task not found by id: "+id));
		toDoRepository.deleteById(id);
		return toDoModel;
		
	}
	
	public ToDoModel updateTaskById(String id, ToDoModel toDoModel) {
		ToDoModel old=toDoRepository.findById(id).orElseThrow(()->new ResourceException("Task not found by id: "+id));
		
			old.setId(toDoModel.getId());
			old.setTitle(toDoModel.getTitle());
			old.setDescription(toDoModel.getDescription());
			old.setCompleted(toDoModel.getCompleted());
			old.setPriority(toDoModel.getPriority());
			old.setDueDate(toDoModel.getDueDate());
			old.setCreatedAt(toDoModel.getCreatedAt());
			
			return toDoRepository.save(old);
	
	}
}
