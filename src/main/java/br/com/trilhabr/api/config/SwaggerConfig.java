package br.com.trilhabr.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.trilhabr.api.controller"))
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("TrilhaBR REST API")
                .description("REST API de busca do TrilhaBR")
                .version("1.0.0")
                .license("GNU GENERAL PUBLIC LICENSE 3.0")
                .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.pt-br.html")
                .contact(new Contact("TrilhaBR", "https://github.com/trilhoso", "trilhaword@gmail.com"))
                .build();
    }

    private List<ResponseMessage> globalDefaultResponseMessage()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                    .code(500)
                    .message("Internal Error")
                    .build());
            add(new ResponseMessageBuilder()
                    .code(401)
                    .message("Unauthorized")
                    .build());
        }};
    }

}
