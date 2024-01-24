package shoppinglist.service;

import shoppinglist.dto.ProductDto;
import shoppinglist.dto.error.ErrorCode;
import shoppinglist.dto.error.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    public List<ErrorDto> validate(ProductDto productDto) {
        List<ErrorDto> errors = new ArrayList<>();

        if (productDto.getProductName().isBlank()) {
            addError(errors, ErrorCode.IE_413, "Product name must not be null");
        }

        int productNameLength = productDto.getProductName().trim().length();
        if (productNameLength < 3 || productNameLength >10) {
            addError(errors,ErrorCode.IE_413, "Product name length should be between 3 and 10 letters");
        }

        if (productDto.getPrice() == null || productDto.getPrice() <= 0) {
            addError(errors,ErrorCode.IE_415, "Product price must not be null and should be greater 0");
        }

        return errors;
    }

    private void addError(List<ErrorDto> errors, ErrorCode errorCode, String message){
        errors.add(new ErrorDto(errorCode, message));
    }
}
