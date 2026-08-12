package ToDoApp.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Document(collection="Tasks")
public class ToDoModel {
	
	@Id
	private String id;
	private String title;
	private String description;
	private String completed;
	private String priority;
	private LocalDate dueDate;
	private LocalDate createdAt;
}
