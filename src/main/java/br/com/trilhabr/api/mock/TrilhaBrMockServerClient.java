package br.com.trilhabr.api.mock;

import org.mockserver.client.MockServerClient;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.Parameter.param;

public class TrilhaBrMockServerClient {

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
                                .withBody("some_response_body")
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
                                .withBody("some_response_body")
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
                                .withBody("some_response_body")
                );
    }
}
