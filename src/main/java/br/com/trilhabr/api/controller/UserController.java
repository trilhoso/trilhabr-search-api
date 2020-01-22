package br.com.trilhabr.api.controller;

import br.com.trilhabr.api.exception.TrilhaBusinessException;
import br.com.trilhabr.api.model.trilhabr.User;
import br.com.trilhabr.api.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.Optional;

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "", nickname = "userByIdGet", notes = "Retorna cadastro de um usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = String.class)
    })
    @RequestMapping(value = "/usuario", method = RequestMethod.GET, produces="application/json")
    public User userByIdGet(@ApiParam(value="Id do usuario para pesquisa", required=true) @Valid @RequestParam(value = "idUsuario", required=true) String idUsuario) {
        Optional<User> user;
        try {
            user = userRepository.findById(Long.parseLong(idUsuario));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new TrilhaBusinessException("Erro ao consulta usuario");
        }

        return user.get();
    }
}
