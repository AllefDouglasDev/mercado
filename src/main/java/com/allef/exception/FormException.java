package com.allef.exception;

import com.allef.model.InputError;

public class FormException extends Exception {
    private InputError errors;

    public FormException(InputError errors) {
		super("Form error");
        this.errors = errors;
	}

	public InputError getErrors() {
		return errors;
	}
}
