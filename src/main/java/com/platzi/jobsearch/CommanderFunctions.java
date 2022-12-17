package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;

import java.util.function.Supplier;

public class CommanderFunctions {
    /**
     * Crear comandos con nombre, uso del nombre de cli y el objeto generico
     * **/
    static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier) {
        JCommander jCommander = JCommander.newBuilder()
                .addCommand(argumentSupplier.get()) // Añadir los compandos con los que pude trabajar
                .build(); // construir el cli

        jCommander.setProgramName(cliName); // Añadimos el nombre de la cli
        return jCommander; // Regresamos la instancia de nuestra terminal
    }
}
