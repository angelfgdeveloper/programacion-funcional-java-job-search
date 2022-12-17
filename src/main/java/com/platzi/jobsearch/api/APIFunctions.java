package com.platzi.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface APIFunctions {

    /**
     * metodo statico generico, se encarga de generar un objeto de API
     * **/
    static <T> T buildAPI(Class<T> clazz, String url) {
        return Feign.builder() // Construir el cliente web
                .decoder(new GsonDecoder()) // Decodificar los resultados a Gson
                .target(clazz, url); // Apuntar a una API
    }
}
