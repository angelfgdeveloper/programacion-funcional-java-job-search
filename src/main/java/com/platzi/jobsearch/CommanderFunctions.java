package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {
    static <T> JCommander buildCommanderWithName(
            String cliName, Supplier<T> argumentSupplier
    ) {
        JCommander jCommander = JCommander.newBuilder()
                .addObject(argumentSupplier.get()) // Add argumentos para mostrar el menu
                .build();

        jCommander.setProgramName(cliName);
        return jCommander;
    }

    // Transformar los argumentos que regrese un Optional
    static Optional<List<Object>> parseArguments(
            JCommander jCommander,
            String[] arguments, // argumentos que se pasara
            Consumer<JCommander> onError
    ) {
        try {
            jCommander.parse(arguments);
            return Optional.of(jCommander.getObjects()); // retornar un objeto
        } catch (ParameterException paramEx){
            onError.accept(jCommander); // obtener la exception
        }

        return Optional.empty(); // Sino retornar vacio
    }
}
