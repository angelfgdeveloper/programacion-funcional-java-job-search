package com.platzi.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIKeywordValidator implements IParameterValidator {

    // Revisar que el contenido venga correctamente
    @Override
    public void validate(String name, String value) throws ParameterException {
        // matches => Tengan solo letras y nuemero
        if(!value.matches("^[a-zA-Z]+[0-9]*$")) { // Indeitifcar que el nuevo validador tenga un valor
            System.err.println("El Criterio de busqueda no es valido.");
            throw new ParameterException("Unicamente letras y numeros");
        }
    }
}
