package repository;

import entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface ClientRepository {

    /*
    CRUD - create, reade (find), update, delete
     */

    Client add(Client client);

    Optional<Client> findById(int id);

    Optional<Client> findByName(Predicate<Client> pred);

    boolean update(Client client);

    boolean delete(Client client);

    List<Client>  findAll();
}
