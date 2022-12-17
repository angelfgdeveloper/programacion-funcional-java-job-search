package com.platzi.jobsearch.api;

import com.platzi.jobsearch.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

@Headers("Accept: application/json") // Notacion que indica las cabeceras de nuestra aplicacion => acepta json
public interface APIJobs {
    @RequestLine("GET /positions.json") // la peticion GET
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap); // Regresa el listado que estan disponibles
    // QueryMap => elementos en nuestra peticion
}
