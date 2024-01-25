package dto.message;

import java.util.ArrayList;
import java.util.List;

public  class Response extends Message {
private List<Error> errors;

public Response(Object data, List<Error> errors)
{
        super(data);
        this.errors = errors;
}
public boolean success()
{
        return errors.isEmpty();
}

public List<Error> getErrors()
{
        return errors;
}

@Override
public String toString()
{
        return "Response{" + super.toString() +
               " errors=" + errors +
               '}';
}

public static void main(String[] args)
{
//        test
        Integer data = 20;

        Message message = new Message(data);

        System.out.println(message);

        Response response = new Response(40, List.of(new Error(ErrorCode.OK, "Success!")));
        System.out.println(response.success() + ", "  + response);

        Response response1 = new Response(50, new ArrayList<>());
        System.out.println(response1.success() + ", "  + response1);
}
}
