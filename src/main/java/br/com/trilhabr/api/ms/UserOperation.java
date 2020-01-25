package br.com.trilhabr.api.ms;

import br.com.trilhabr.api.exception.TrilhaBusinessException;
import br.com.trilhabr.api.model.trilhabr.User;
import br.com.trilhabr.api.repository.UserRepository;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Getter
@Setter
@Service
public class UserOperation {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> loginByEmailAndPassword(String email, String senha) {
        Optional<User> user;
        try {
            user = userRepository.findUserByEmailAndPassword(email, senha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new TrilhaBusinessException("Erro ao consulta usuario");
        }

        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    public ResponseEntity<Void> insertUserPost(User body) {
        try {
            if (body.getId() != null)
                body.setId(null);

            userRepository.save(body);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new TrilhaBusinessException("Erro ao cadastrar usuario");
        }

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteUserById(String idUsuario) {
        try {
            userRepository.deleteById(Long.parseLong(idUsuario));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new TrilhaBusinessException("Erro ao deletar usuario");
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    public ResponseEntity<Void> updateUserPut(User body) {
        try {
            if (body.getId() != null)
                body.setId(null);

            userRepository.save(body);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new TrilhaBusinessException("Erro ao cadastrar usuario");
        }

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
