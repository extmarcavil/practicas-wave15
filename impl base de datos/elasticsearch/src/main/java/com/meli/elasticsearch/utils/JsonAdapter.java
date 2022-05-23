package com.meli.elasticsearch.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import java.util.Set;

@Configuration
@Scope("singleton")
public class JsonAdapter {

    private final ObjectMapper mapper;

    public JsonAdapter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    private ObjectMapper defaultConfiguration() {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper;
    }

    public <T> String toJsonRemovingFields(T object, String... fieldsToRemove) {
        final ObjectNode jsonNode = mapper.valueToTree(object);
        jsonNode.remove(Set.of(fieldsToRemove));

        return jsonNode.toString();
    }
}
