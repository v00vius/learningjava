package service;

import dto.Response;
import entity.Client;


import repository.ClientDatabase;
import util.ConsoleIO;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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

        return new Response<>(true, newClient, "Ok");
}

public Response<Client> findById(int id)
{
        Optional<Client> clientOptional = database.findById(id);

        return new Response<>(clientOptional.isPresent(), clientOptional.get(), "Client not found");
}

public Response<Client> findByName(String name)
{
        Optional<Client> clientOptional = database.find(client -> client.getName().equals(name));

        return new Response<>(clientOptional.isPresent(), clientOptional.get(), "Client not found");
}
public Response<Client> findAny(String name)
{
        String aName = name.toLowerCase();

        Optional<Client> clientOptional = database.find(
                client ->
                {
                        String text = client.getName() + client.getDescription();

                        return text.toLowerCase().contains(aName);
                }
        );

        return new Response<>(clientOptional.isPresent(), clientOptional.get(), "Client not found");
}

public Response<Boolean> update(Client client)
{
        boolean updateResult = database.update(client);

        return new Response<>(updateResult, true, "Update failed");
}

public Response<Boolean> delete(int idForDelete)
{
        Optional<Client> clientOptional = database.findById(idForDelete);

        if (clientOptional.isEmpty()) {
                return new Response<>(false, false, "Client not found");
        }

        Client clientForDelete = clientOptional.get();

        boolean deleteResult = database.delete(clientForDelete);

        return new Response<>(deleteResult, true, "Delete failed");
}

public Response<List<Client>> findAll()
{
        List<Client> findAllList = database.findAll();

        return new Response<>(!findAllList.isEmpty(), findAllList, "Database is empty");
}
}
