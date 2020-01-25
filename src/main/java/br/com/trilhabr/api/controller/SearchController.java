package br.com.trilhabr.api.controller;

import javax.validation.Valid;

import br.com.trilhabr.api.exception.TrilhaBusinessException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@Api(value = "Search operations")
public class SearchController {
	
	@Value("${trilhabr.userlessAuth:config}")
	private String userlessAuth;
	@Value("${trilhabr.pathUrlGetLocaisByIdRegion:config}")
	private String pathUrlGetLocaisByIdRegion;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@ApiOperation(value = "", nickname = "locaisByIdRegionGet", notes = "Retorna uma lista de locais por uma região")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Sucesso", response = String.class)
    })
    @RequestMapping(value = "/locais", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> locaisByIdRegionGet(@ApiParam(value="Id da região para pesquisa", required=true) @Valid @RequestParam(value = "idRegion", required=true) String idRegion) {
		String url = this.pathUrlGetLocaisByIdRegion;
		url = url + "?near=" + idRegion + "&"+ userlessAuth;
		
		String local = null;
		try {
			local = restTemplate.getForObject(url, String.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new TrilhaBusinessException("Erro ao consulta locais");
		}
		
		
		return new ResponseEntity<>(local, HttpStatus.OK);
	}
}
