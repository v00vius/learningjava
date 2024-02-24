package session.client;

import session.Session;
import utils.data.DTO;

import java.util.Optional;

public class Client implements Session  {
@Override
public Optional<DTO> receive()
{
        return null;
}

@Override
public boolean send(DTO message)
{

        return false;
}
}
