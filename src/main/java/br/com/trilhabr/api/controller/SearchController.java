package br.com.trilhabr.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.trilhabr.api.model.Local;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class SearchController {
	
	@ApiOperation(value = "Retorna uma lista de locais por região")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna uma lista de locais por região", response = Local.class)
    })
    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Local>> getLugaresByIdRegion(@ApiParam(value="Id da região para pesquisa", required=true) String idRegion) {
		return new ResponseEntity<>(new ArrayList<Local>(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insere um local por região")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Insere um local por região", response = Local.class)
    })
    @RequestMapping(value = "/locations", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<Local> postLugaresByIdRegion(@ApiParam(value="", required=true) @Valid @RequestBody Local local) {
		return new ResponseEntity<>(local, HttpStatus.CREATED);
	}
}
