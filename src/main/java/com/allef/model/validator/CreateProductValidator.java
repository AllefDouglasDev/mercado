package com.allef.model.validator;

import com.allef.model.dto.CreateProductDTO;
import com.allef.model.InputError;

public class CreateProductValidator {
    private CreateProductDTO createProductDTO;

    public CreateProductValidator(CreateProductDTO createProductDTO) {
        this.createProductDTO = createProductDTO;
    }

    public InputError validate() {
        InputError errors = new InputError();
        String name = this.createProductDTO.getName();
        int amount = this.createProductDTO.getAmount();
        String barCode = this.createProductDTO.getBarCode();
        int price = this.createProductDTO.getPrice();
        int profitMargin = this.createProductDTO.getProfitMargin();
        int sellingValue = this.createProductDTO.getSellingValue();
        if (name.isBlank()) {
            errors.add("name", "Informe o nome.");
        }
        if (name.length() < 2) {
            errors.add("name", "Informe pelo menos 2 caracteres.");
        }
        if (amount < 0) {
            errors.add("amount", "Informe a quantidade.");
        }
        if (barCode.isBlank()) {
            errors.add("barCode", "Informe o código de barras.");
        }
        if (barCode.length() < 2) {
            errors.add("barCode", "Informe pelo menos 2 caracteres.");
        }
        if (price < 0) {
            errors.add("price", "Informe o preço.");
        }
        if (profitMargin < 0) {
            errors.add("profitMargin", "Informe a margem de lucro.");
        }
        if (sellingValue < 0) {
            errors.add("sellingValue", "Informe o valor de venda.");
        }
        return errors;
    }
}
