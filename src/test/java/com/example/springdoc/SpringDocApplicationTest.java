package com.example.springdoc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = SpringDocApplication.class)
class SpringDocApplicationTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String FUNCTION_OPERATION_DECLARATION = "operationId=getElementFunction";
    private static final String REST_OPERATION_DECLARATION = "operationId=getElement";
    @LocalServerPort
    int port;

    @Test
    void testFunctionIsNotAvailableOnApiDocs() {
        String docs = getDocs();
        assertThat(docs).doesNotContain(FUNCTION_OPERATION_DECLARATION);
    }

    @Test
    void testRESTEndpointIsAvailableOnApiDocs() {
        String docs = getDocs();
        assertThat(docs).contains(REST_OPERATION_DECLARATION);
    }

    @SneakyThrows
    public String getDocs() {
        URL apiDocsUrl = new URL(String.format("http://localhost:%d/v3/api-docs", port));
        return MAPPER.readValue(apiDocsUrl, Object.class).toString();
    }
}