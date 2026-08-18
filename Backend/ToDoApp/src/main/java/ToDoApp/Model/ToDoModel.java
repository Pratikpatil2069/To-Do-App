package ToDoApp.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Document(collection="Tasks")
public class ToDoModel {
	
	@Id
	private String id;
	
	@NotBlank(message="Please Enter the title")
	private String title;
	@NotBlank(message="Please Enter the description")
	private String description;
	@NotBlank(message="Please Enter the status")
	private String completed;
	@NotBlank(message="Please Enter the priority")
	private String priority;
	@NotNull(message="Please Enter the dueDate")
	private LocalDate dueDate;
	@NotNull(message="Please Enter the createdAt")
	private LocalDate createdAt;
}
