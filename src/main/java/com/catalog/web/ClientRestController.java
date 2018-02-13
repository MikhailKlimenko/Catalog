package com.catalog.web;

import com.catalog.model.Client;
import com.catalog.service.CarClientService;
import com.catalog.to.ClientTo;
import com.catalog.to.ClientWithYearOfManufacture;
import com.catalog.util.CustomErrorType;
import com.catalog.util.CustomSuccessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/client")
@Api(value = "catalog", description = "Operations pertaining to client in Catalog.")
public class ClientRestController {

    public static final Logger logger = LoggerFactory.getLogger(ClientRestController.class);

    @Autowired
    private CarClientService carClientService;


    // ------------------- Delete a Client-----------------------------------------
    @ApiOperation(value = "Delete client from the catalog.")
    @DeleteMapping(value = "/delete", produces = "application/json")
    public ResponseEntity delete(@RequestBody ClientTo client) {
        logger.info("Fetching & Deleting client with id {}", client.getName());
        if (!carClientService.delete(client.getName(), client.getCar())) {
            logger.error("Unable to delete. Client with name {} not found.", client.getName());
            return new ResponseEntity(new CustomErrorType("Unable to delete. Client with name "
                    + client.getName() + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new CustomSuccessType("Client with name " + client.getName() + " deleted."), (HttpStatus.OK));
    }


    // -------------------Create a Client-------------------------------------------
    @ApiOperation(value = "Add a client")
    @PostMapping(value = "/create")
    public ResponseEntity createClient(@RequestBody ClientWithYearOfManufacture client) {
        logger.info("Creating Client : {}", client);

        if (carClientService.isClientExist(client.getName())) {
            logger.error("Unable to create. A User with name {} already exist", client.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Client with name " +
                    client.getName() + " already exist."), HttpStatus.CONFLICT);
        }
        Client found = carClientService.create(client.getName(),
                client.getBirthDate(),
                client.getCar(),
                client.getYearOfManufactury());

        return new ResponseEntity(new CustomSuccessType("Client with name " + client.getName() + " added."), HttpStatus.CREATED);
    }

}









