package com.allef.view.product;

import com.allef.view.components.Input;
import com.allef.view.components.Modal;

public class CreateProduct {
    private Modal modal;

    private Input nameInput;
    private Input amountInput;
    private Input barCodeInput;
    private Input priceInput;
    private Input profitMarginInput;

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

        priceInput = new Input("Preço");
        priceInput.setLocation(barCodeInput.getXEnd() + padding, barCodeInput.getY());
        modal.add(priceInput.getContainer());

        profitMarginInput = new Input("Margem de Lucro");
        profitMarginInput.setWidth(modal.getMainPanel().getWidth() - (padding * 2));
        profitMarginInput.setLocation(padding, priceInput.getYEnd());
        modal.add(profitMarginInput.getContainer());
    }

    public void setVisible(boolean visible) {
        modal.setVisible(visible);
    }

    private void submit() {
        if (!validateFields()) return;
        try {
            String name = nameInput.getValue();
            int amount = amountInput.getIntValue();
            String barCode = barCodeInput.getValue();
            int price = priceInput.getIntValue();
            int profitMargin = profitMarginInput.getIntValue();

            System.out.println("name: " + name + ", amount: " + amount + ", barCode: " + barCode + ", price: " + price
                    + ", profitMargin: " + profitMargin);

            modal.dispose();
        } catch (Exception e) {
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

        String name = nameInput.getValue();
        int amount = amountInput.getIntValue();
        String barCode = barCodeInput.getValue();
        int price = priceInput.getIntValue();
        int profitMargin = profitMarginInput.getIntValue();

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

        return ok;
    }
}
