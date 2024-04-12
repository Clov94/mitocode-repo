package com.mitocode.repo.CommonLibrary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReading {

    public static Object convertJsonToObject(String jsonPayload, Class clazz) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.readValue(jsonPayload, clazz);
    }
}
