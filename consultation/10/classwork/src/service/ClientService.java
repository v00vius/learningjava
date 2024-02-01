package service;

import dto.Response;
import entity.Client;


import repository.ClientDatabase;
import util.ConsoleIO;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class ClientService {

private final ClientDatabase database;

private final ConsoleIO userInput = new ConsoleIO();

public ClientService(ClientDatabase database)
{
        this.database = database;
}

public Supplier<Client> createClientSupplier()
{
        return () ->
        {
                String clientName = userInput.gets("Введите имя клиента");
                String descriptionName = userInput.gets("Введите описание клиента");
                return new Client(clientName, descriptionName);
        };
}

public Client createClient()
{
        Supplier<Client> clientSupplier = createClientSupplier();
        return clientSupplier.get();
}

public Response<Client> add(Client client)
{
        Client newClient = database.add(client);
        return new Response<>(newClient, "Ok");
}

public Response<Client> findById(int id)
{
        Optional<Client> clientOptional = database.findById(id);

        if (clientOptional.isPresent()) {
                return new Response<>(clientOptional.get(), "Ok");
        } else {
                return new Response<>(null, "Client not found");
        }
}

public Response<Client> findByName(String name)
{
        Optional<Client> clientOptional = database.findByName(client -> client.getName().equals(name));

        return clientOptional.map(client -> new Response<>(client, "Ok"))
                .orElseGet(() -> new Response<>(null, "Client not found"));
}

public Response<Boolean> update(Client client)
{
        boolean updateResult = database.update(client);

        return new Response<>(updateResult, updateResult ? "Ok" : "Update failed");
}

public Response<Boolean> delete(int idForDelete)
{
        Optional<Client> clientOptional = database.findById(idForDelete);

        if (clientOptional.isEmpty()) {
                return new Response<>(false, "Client not found");
        }

        Client clientForDelete = clientOptional.get();

        boolean deleteResult = database.delete(clientForDelete);

        return new Response<>(deleteResult, deleteResult ? "Ok" : "Delete failed");
}

public Response<List<Client>> findAll()
{
        List<Client> findAllList = database.findAll();

        return new Response<>(findAllList, findAllList.isEmpty() ? "Database is empty" : "Ok");
}
}
