package com.allef.view.product;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.allef.controller.ProductController;
import com.allef.exception.FormException;
import com.allef.model.InputError;
import com.allef.model.dto.CreateProductDTO;
import com.allef.view.components.Input;
import com.allef.view.components.Modal;

public class CreateProduct {
    private Modal modal;

    private Input nameInput;
    private Input amountInput;
    private Input barCodeInput;
    private Input priceInput;
    private Input profitMarginInput;
    private Input sellingValueInput;

    public CreateProduct() {
        this.modal = new Modal("Criar Produto");
        this.modal.setOnConfirmListener(e -> submit());
        this.modal.setOnCancelListener(e -> modal.dispose());
        this.modal.getDialog().setLocationRelativeTo(null);
        renderForm();
    }

    private void renderForm() {
        int padding = 20;

        nameInput = new Input("name", "Nome");
        nameInput.setLocation(padding, padding);
        modal.add(nameInput.getContainer());

        amountInput = new Input("amount", "Quantidade");
        amountInput.setLocation(nameInput.getXEnd() + padding, padding);
        modal.add(amountInput.getContainer());

        barCodeInput = new Input("barCode", "Código de Barras");
        barCodeInput.setLocation(padding, amountInput.getYEnd());
        modal.add(barCodeInput.getContainer());

        priceInput = new Input("price", "Custo");
        priceInput.setLocation(barCodeInput.getXEnd() + padding, barCodeInput.getY());
        modal.add(priceInput.getContainer());

        profitMarginInput = new Input("profitMargin", "Margem de Lucro");
        profitMarginInput.setLocation(padding, priceInput.getYEnd());
        modal.add(profitMarginInput.getContainer());

        sellingValueInput = new Input("sellingValue", "Valor de Venda");
        sellingValueInput.setLocation(
                profitMarginInput.getXEnd() + padding,
                profitMarginInput.getY());
        modal.add(sellingValueInput.getContainer());
    }

    public void setVisible(boolean visible) {
        modal.setVisible(visible);
    }

    private void submit() {
        try {
            String name = nameInput.getValue();
            int amount = amountInput.getIntValue();
            String barCode = barCodeInput.getValue();
            int price = priceInput.getIntValue();
            int profitMargin = profitMarginInput.getIntValue();
            int sellingValue = sellingValueInput.getIntValue();
            ProductController productController = new ProductController();
            productController.create(
                    new CreateProductDTO(name, amount, barCode, price, profitMargin, sellingValue));
            modal.dispose();
        } catch (FormException formException) {
            HashMap<String, Input> inputs = new HashMap<>();
            inputs.put(nameInput.getId(), nameInput);
            inputs.put(amountInput.getId(), amountInput);
            inputs.put(barCodeInput.getId(), barCodeInput);
            inputs.put(priceInput.getId(), priceInput);
            inputs.put(profitMarginInput.getId(), profitMarginInput);
            inputs.put(sellingValueInput.getId(), sellingValueInput);
            inputs.forEach((k, v) -> v.removeError());
            formException.getErrors().getErrors().forEach((k, v) -> inputs.get(k).setError(v));
        }
    }
}
