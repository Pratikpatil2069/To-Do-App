package ToDoApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ToDoApp.Model.ToDoModel;

@Repository
public interface ToDoRepository extends MongoRepository<ToDoModel, String> {

}
