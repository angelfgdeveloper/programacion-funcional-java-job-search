package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {
    CLIArguments() { }

    @Parameter( // Esta propiedad es un parametro que se puede ingresar por terminal
            required = true, // Es requerido
            descriptionKey = "KEYWORD", // La ayuda
            description = "KEYWORD" // Descripcion
    )
    private String keyword;

    @Parameter(
            names = {"--location", "-l"}, // Nombres con los cuales podemos ingresar
            description = "Cada busqueda puede incluir una ubicacion" // Descripcion
    )
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "La API devuelve 50 resultados, usa un numero para la pagina"
    )
    private int page = 0;

    @Parameter(
            names = {"--full-time"}, // Varios datos para ingresar
            description = "Agrega si queremos trabajos de tiempo completo"
    )
    private boolean isFullTime = false;

    @Parameter(
            names = "--markdown", // Un solo parametro para ingresar
            description = "Obtener los resultados en markdown"
    )
    private boolean isMarkdown = false;

    @Parameter(
            names = "--help",
            help = true, // notacion para especificar que es la ayuda
            description = "Mostrar esta ayuda"
    )
    private boolean isHelp;

    // Solo Getters => para que los datos sean inmutables
    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    // Devuelve una instancia de esta clase CLIArguments
    // Es para cambiar a nuevas instancias
    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}
