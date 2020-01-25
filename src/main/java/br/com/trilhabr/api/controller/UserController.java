package br.com.trilhabr.api.controller;

import br.com.trilhabr.api.exception.TrilhaBusinessException;
import br.com.trilhabr.api.model.trilhabr.User;
import br.com.trilhabr.api.ms.UserOperation;
import br.com.trilhabr.api.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
@Api(value = "user", description = "User operations")
public class UserController {

    @Autowired
    private UserOperation operation;

    @ApiOperation(value = "", nickname = "loginByEmailAndPassword", notes = "Retorna cadastro de um usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = User.class)
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<User> loginByEmailAndPassword(@ApiParam(value="email do usuario para login", required=true) @Valid @RequestParam(value = "email", required=true) String email,
                                       @ApiParam(value="senha do usuario para login", required=true) @Valid @RequestParam(value = "senha", required=true) String senha) {
        return operation.loginByEmailAndPassword(email, senha);
    }
    
    @ApiOperation(value = "", nickname = "insertUserPost", notes = "Usuario para cadastro")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuario cadastrado", response = String.class)
    })
    @RequestMapping(value = "/usuario", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<Void> insertUserPost(@ApiParam(value="body", required=true) @Valid @RequestBody(required=true) User body) {
        return operation.insertUserPost(body);
    }
    
    @ApiOperation(value = "", nickname = "deleteUserById", notes = "Deleta cadastro de um usuario pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = String.class)
    })
    @RequestMapping(value = "/usuario", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Void> deleteUserById(@ApiParam(value="Id do usuario para deletar", required=true) @Valid @RequestParam(value = "idUsuario", required=true) String idUsuario) {
        return operation.deleteUserById(idUsuario);
    }

//    @ApiOperation(value = "", nickname = "userGet", notes = "Retorna todos cadastro de usuario")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Sucesso", response = String.class)
//    })
//    @RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces="application/json")
//    public List<User> usersGet() {
//        List<User> user;
//        try {
//            user = userRepository.findAll();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new TrilhaBusinessException("Erro ao consulta usuario");
//        }
//
//        return user;
//    }
}
