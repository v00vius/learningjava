package shoppinglist.dto;

import shoppinglist.dto.error.ErrorDto;
import java.util.List;

public class ResponseForClientDeleteById {
    private ProductForClient productForClients;
    private List<ErrorDto> errorDtoList;

    public ResponseForClientDeleteById(ProductForClient productForClients, List<ErrorDto> errorDtoList) {
        this.productForClients = productForClients;
        this.errorDtoList = errorDtoList;
    }

    public ProductForClient getProductForClients() {
        return productForClients;
    }

    public List<ErrorDto> getErrorDtoList() {
        return errorDtoList;
    }

@Override
public String toString()
{
    return "ResponseForClientDeleteById{" +
            "productForClients=" + productForClients +
            ", errorDtoList=" + errorDtoList +
            '}';
}
}
