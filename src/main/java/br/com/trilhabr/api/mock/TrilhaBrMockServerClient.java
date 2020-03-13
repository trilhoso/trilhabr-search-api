package br.com.trilhabr.api.mock;

import org.mockserver.client.MockServerClient;

import java.io.*;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.Parameter.param;

public class TrilhaBrMockServerClient {

    private static final String RESPONSE_PATH = File.separator + "mock"
            + File.separator + "response" + File.separator;

    public void scenarioRotas01() {
        new MockServerClient("localhost", 8080)
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/rotas")
                                .withQueryStringParameters(
                                        param("region", "Gramado"),
                                        param("cash", "500"),
                                        param("initialDate", "22/02/2020"),
                                        param("endDate", "23/02/2020")
                                )
                )
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody(fileToString(RESPONSE_PATH + "response_scenarioRotas01.txt"))
                );
    }

    public void scenarioRotas02() {
        new MockServerClient("localhost", 8080)
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/rotas")
                                .withQueryStringParameters(
                                        param("region", "Gramado"),
                                        param("cash", "800"),
                                        param("initialDate", "27/02/2020"),
                                        param("endDate", "01/03/2020")
                                )
                )
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody(fileToString(RESPONSE_PATH + "response_scenarioRotas02.txt"))
                );
    }

    public void scenarioRotas03() {
        new MockServerClient("localhost", 8080)
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/rotas")
                                .withQueryStringParameters(
                                        param("region", "Gramado"),
                                        param("cash", "1200"),
                                        param("initialDate", "02/03/2020"),
                                        param("endDate", "08/03/2020")
                                )
                )
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody(fileToString(RESPONSE_PATH + "response_scenarioRotas03.txt"))
                );
    }

    private String fileToString(String file) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
        StringBuilder resuStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resuStringBuilder.append(line);
            }
        } catch (IOException e) {
            System.err.println("Falha ao ler arquivo.");
            e.getCause();
        }

        return resuStringBuilder.toString();
    }
}
