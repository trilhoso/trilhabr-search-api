package br.com.trilhabr.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import br.com.trilhabr.api.model.Local;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller(value = "search")
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
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<>(local, HttpStatus.OK);
	}
	
//	@ApiOperation(value = "Retorna um local através do Id")
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Retorna um local através do Id", response = Local.class)
//    })
//    @RequestMapping(value = "/local", method = RequestMethod.GET, produces="application/json")
//	public ResponseEntity<Local> getLocalById(@ApiParam(value="Id do local para pesquisa", required=true) String idLocal) {
//		Local local = null;
//		
//		try {
//			local = localRepository.list();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return new ResponseEntity<>(localList, HttpStatus.OK);
//	}
//	
//	@ApiOperation(value = "Insere um local por região")
//    @ApiResponses(value = {
//        @ApiResponse(code = 204, message = "Insere um local por região", response = Local.class)
//    })
//    @RequestMapping(value = "/locations", method = RequestMethod.POST, produces="application/json")
//	public ResponseEntity<Local> postLugaresByIdRegion(@ApiParam(value="", required=true) @Valid @RequestBody Local local) {
//		return new ResponseEntity<>(local, HttpStatus.CREATED);
//	}
}
