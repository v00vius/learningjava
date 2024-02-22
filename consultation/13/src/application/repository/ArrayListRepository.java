package application.repository;

import application.core.entity.ToDoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayListRepository implements ToDoRepository{

    private Integer idSequence = 1;

    private List<ToDoEntity> database = new ArrayList<>();


    @Override
    public ToDoEntity save(ToDoEntity entity) {
        if (entity.getId() != null) {
            return update(entity);
        } else {
            ToDoEntity newToDo = new ToDoEntity(idSequence, entity.getName(), entity.getDescription());
            database.add(newToDo);
            idSequence++;
            return newToDo;
        }
    }

    private ToDoEntity update(ToDoEntity entity){
        for (int i = 0; i < database.size(); i++) {
            var existingEntity = database.get(i);
            if (existingEntity.getId().equals(entity.getId())) {
                database.set(i, entity);
                return entity;
            }
        }
        throw new IllegalStateException("Failed to update");
    }

    @Override
    public List<ToDoEntity> findAll() {
        return database;
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        return database.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }
}
