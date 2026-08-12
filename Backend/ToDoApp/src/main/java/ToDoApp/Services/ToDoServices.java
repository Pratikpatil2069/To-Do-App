package ToDoApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return toDoRepository.findById(id).orElse(null);
	}
	
	public void deleteTaskById(String id) {
		 toDoRepository.deleteById(id);
	}
	
	public ToDoModel updateTaskById(String id, ToDoModel toDoModel) {
		ToDoModel old=toDoRepository.findById(id).orElse(null);
		if(old!=null) {
			old.setId(toDoModel.getId());
			old.setTitle(toDoModel.getTitle());
			old.setDescription(toDoModel.getDescription());
			old.setCompleted(toDoModel.getCompleted());
			old.setPriority(toDoModel.getPriority());
			old.setDueDate(toDoModel.getDueDate());
			old.setCreatedAt(toDoModel.getCreatedAt());
			
			return toDoRepository.save(old);
		}else {
			return toDoRepository.save(toDoModel);
		}
	}
}
