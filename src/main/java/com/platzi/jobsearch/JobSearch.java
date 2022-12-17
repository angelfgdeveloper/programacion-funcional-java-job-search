package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.cli.CLIArguments;

import static com.platzi.jobsearch.CommanderFunctions.buildCommanderWithName;

public class JobSearch {
    public static void main(String[] args) {
        // construccion de nuestra terminal con el nombre job-search, CLIArguments => contruir el elemento con nuetra entity
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);
    }
}
