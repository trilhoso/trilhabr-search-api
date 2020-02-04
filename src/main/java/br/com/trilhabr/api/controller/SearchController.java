package br.com.trilhabr.api.controller;

import javax.validation.Valid;

import br.com.trilhabr.api.model.trilhabr.Locais;
import br.com.trilhabr.api.ms.locais.LocaisOperation;
import br.com.trilhabr.api.ms.RotasOperation;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Api(value = "Search operations")
public class SearchController {

	@Autowired
	private LocaisOperation locaisOperation;

	@Autowired
	private RotasOperation rotasOperation;

	@ApiOperation(value = "", nickname = "insertLocaisByRegionPost", notes = "Cadastra locais por uma região")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Locais cadastrados com sucesso"),
		@ApiResponse(code = 400, message = "Invalid syntax"),
		@ApiResponse(code = 401, message = "Unauthorized"),
		@ApiResponse(code = 415, message = "Unsupported Media Type"),
		@ApiResponse(code = 500, message = "Internal error")
    })
    @RequestMapping(value = "/locais",
			method = RequestMethod.POST,
			produces="application/json")
	public ResponseEntity<Void> insertLocaisByRegionPost(@ApiParam(value="região para pesquisa", required=true) @Valid @RequestParam(value = "region", required=true) String region) {
		return locaisOperation.insertLocaisByRegionPost(region);
	}

	@ApiOperation(value = "", nickname = "rotasByRegion", notes = "Retorna uma lista de rotas com base nos filtros passados", response = Locais.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso", response = Locais.class),
			@ApiResponse(code = 400, message = "Invalid syntax"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 415, message = "Unsupported Media Type"),
			@ApiResponse(code = 500, message = "Internal error")
	})
	@RequestMapping(value = "/rotas",
			method = RequestMethod.GET,
			produces="application/json")
	public ResponseEntity<Locais> rotasByRegionGet(@ApiParam(value="região para pesquisa", required=true) @Valid @RequestParam(value = "region", required=true) String region,
												   @ApiParam(value="valor disponível", required=true) @Valid @RequestParam(value = "cash", required=true) String cash,
												   @ApiParam(value="Data inicial", required=true) @Valid @RequestParam(value = "initialDate", required=true) String initialDate,
												   @ApiParam(value="Data final", required=true) @Valid @RequestParam(value = "endDate", required=true) String endDate) {
		return rotasOperation.rotasByRegionGet(region, cash, initialDate, endDate);
	}
}
