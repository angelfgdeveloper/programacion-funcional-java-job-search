package com.platzi.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIHelpValidator implements IParameterValidator {

    // Es para validar que lo que enviamos se encuentre correcto
    @Override
    public void validate(String name, String value) throws ParameterException {
        boolean actualValue = Boolean.parseBoolean(value);
        if(actualValue){
            throw new ParameterException("Ayuda solicitada");
        }
    }
}
