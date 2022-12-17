package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.APIJobs;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.platzi.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.platzi.jobsearch.CommanderFunctions.parseArguments;
import static com.platzi.jobsearch.api.APIFunctions.buildAPI;

public class JobSearch {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        // Recibir argumentos de jCommander
        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage) // Transformar de la terminal a objetos de java, uso de jcommander, args => para saber los argumentos y usage para la ayuda
                .orElse(Collections.emptyList()) // Sino regresa argumentos, no regrese una lista vacia
                .stream() // La lista la convertimos en stream
                .map(obj -> (CLIArguments) obj); // mapear a un objeto, convertir el objeto a CLIArguments

        Optional<CLIArguments> cliArgumentsOptional = streamOfCLI.filter(cli -> !cli.isHelp()) // Para filtrar el stream y que sea diferente del de ayuda
                .filter(cli -> cli.getKeyword() != null) // filtrar nuevamente que tenga un keyboard para hacer busqueda
                .findFirst(); // y encontrar el primer argumento de ese argumento

        cliArgumentsOptional.map(CLIFunctions::toMap) // Convertir el opcional arguments a algo que podamos mapear convertir a Map
                .map(JobSearch::executeRequest) // Metodo personalizado
                .orElse(Stream.empty()) // Sino hay valores, regresar un stream empty
                .forEach(System.out::println); // Mostrarlo por terminal
    }

    // Creacion de funcion interna
    // Regresa un JobPosition
    private static Stream<JobPosition> executeRequest(Map<String, Object> params){
        APIJobs api = buildAPI(APIJobs.class, "https://jobs.github.com"); // construir nuestra API

        return Stream.of(params) // Regresa los params
                .map(api::jobs) // Mapeamos el objeto que obtenemos de la api
                .flatMap(Collection::stream); // Transformamos en elementos individuales
    }
}
