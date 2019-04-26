package com.pramati.flashsale.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.flashsale.beans.Response;
import com.pramati.flashsale.beans.Sale;
import com.pramati.flashsale.service.SaleService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/**
 * @author sudhirk
 *
 *  Rest Controller which contains api calls related to User Data
 *  
 *
 */
@RestController
@RequestMapping(value = "/sales", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiModel(value = "Sale details API's", description = "Contains CRUD API's for sale details")
public class SaleController {
	
	  private @Autowired SaleService saleService;
	  
	  
	  @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation("Creates a new sale")
	  public ResponseEntity<Response> createSale(@RequestBody  @Valid Sale sale) {
		 
		  Response response = new Response(null, null, saleService.createSale(sale));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		  
	  }
	  
	  
	  
	  @GetMapping(value = "/{saleId}")
	  @ApiOperation("Get Sale Details By ID")
	  public ResponseEntity<Response> getSaleById(@PathVariable("saleId") Integer saleId) {
		  
			  Response response = new Response(null, null, saleService.getSaleById(saleId));
			  return new ResponseEntity<Response>(response,HttpStatus.OK);
	  }
	  
	  
	  
	  
}
