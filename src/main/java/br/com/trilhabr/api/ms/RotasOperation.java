package br.com.trilhabr.api.ms;

import br.com.trilhabr.api.exception.TrilhaBusinessException;
import br.com.trilhabr.api.model.trilhabr.Locais;
import br.com.trilhabr.api.model.trilhabr.Local;
import br.com.trilhabr.api.repository.LocalRepository;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Service
public class RotasOperation {

    @Autowired
    private LocalRepository localRepository;

    public ResponseEntity<Locais> rotasByRegionGet(@ApiParam(value="região para pesquisa", required=true) @Valid @RequestParam(value = "region", required=true) String region,
                                                   @ApiParam(value="valor disponível", required=true) @Valid @RequestParam(value = "cash", required=true) String cash,
                                                   @ApiParam(value="Data inicial", required=true) @Valid @RequestParam(value = "initialDate", required=true) String initialDate,
                                                   @ApiParam(value="Data final", required=true) @Valid @RequestParam(value = "endDate", required=true) String endDate) {
        Locais locais = new Locais();
        List<Local> localList = null;
        try {
            localList = localRepository.findAll();
        } catch (Exception e) {
            throw new TrilhaBusinessException("Error ao listar locais");
        }

        if (localList != null && !localList.isEmpty()) {
            locais.setLocalList(localList);
        }

        return new ResponseEntity<Locais>(locais, HttpStatus.OK);
    }
}
