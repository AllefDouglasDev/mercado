package com.allef.view.product;

import javax.swing.JOptionPane;

import com.allef.controller.ProductController;
import com.allef.model.Product;
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

        nameInput = new Input("Nome");
        nameInput.setLocation(padding, padding);
        modal.add(nameInput.getContainer());

        amountInput = new Input("Quantidade");
        amountInput.setLocation(nameInput.getXEnd() + padding, padding);
        modal.add(amountInput.getContainer());

        barCodeInput = new Input("Código de Barras");
        barCodeInput.setLocation(padding, amountInput.getYEnd());
        modal.add(barCodeInput.getContainer());

        priceInput = new Input("Custo");
        priceInput.setLocation(barCodeInput.getXEnd() + padding, barCodeInput.getY());
        modal.add(priceInput.getContainer());

        profitMarginInput = new Input("Margem de Lucro");
        profitMarginInput.setLocation(padding, priceInput.getYEnd());
        modal.add(profitMarginInput.getContainer());

        sellingValueInput = new Input("Valor de Venda");
        sellingValueInput.setLocation(
            profitMarginInput.getXEnd() + padding,
            profitMarginInput.getY());
        modal.add(sellingValueInput.getContainer());
    }

    public void setVisible(boolean visible) {
        modal.setVisible(visible);
    }

    private void submit() {
        if (!validateFields())
            return;
        try {
            String name = nameInput.getValue();
            int amount = amountInput.getIntValue();
            String barCode = barCodeInput.getValue();
            int price = priceInput.getIntValue();
            int profitMargin = profitMarginInput.getIntValue();
            int sellingValue = sellingValueInput.getIntValue();

            ProductController productController = new ProductController();
            Product product = new Product(name, amount, barCode, price, profitMargin, sellingValue);
            productController.save(product);

            modal.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.modal.getDialog(), e.getMessage(), "Erro ao cadastrar.",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private boolean validateFields() {
        boolean ok = true;
        nameInput.removeError();
        amountInput.removeError();
        barCodeInput.removeError();
        priceInput.removeError();
        profitMarginInput.removeError();
        sellingValueInput.removeError();

        String name = nameInput.getValue();
        int amount = amountInput.getIntValue();
        String barCode = barCodeInput.getValue();
        int price = priceInput.getIntValue();
        int profitMargin = profitMarginInput.getIntValue();
        int sellingValue = sellingValueInput.getIntValue();

        if (name.isBlank()) {
            nameInput.setError("Informe o nome.");
            ok = false;
        }
        if (amount < 0) {
            amountInput.setError("Informe a quantidade.");
            ok = false;
        }
        if (barCode.isBlank()) {
            barCodeInput.setError("Informe o código de barras.");
            ok = false;
        }
        if (price < 0) {
            priceInput.setError("Informe o preço.");
            ok = false;
        }
        if (profitMargin < 0) {
            profitMarginInput.setError("Informe a margem de lucro.");
            ok = false;
        }
        if (sellingValue < 0) {
            sellingValueInput.setError("Informe o valor de venda.");
            ok = false;
        }

        return ok;
    }
}
