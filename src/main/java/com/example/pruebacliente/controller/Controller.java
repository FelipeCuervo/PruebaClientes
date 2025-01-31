package com.example.pruebacliente.controller;


import com.example.pruebacliente.entities.Cliente;
import com.example.pruebacliente.entities.ClienteDTO;
import com.example.pruebacliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("save")
    public ResponseEntity<String> saveCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente guardado exitosamente");
    }

    @GetMapping("findAllOrderByFullName")
    public List<Cliente> getClientesOrderByFullNameAsc(){

        return clienteService.getClientesOrderByFullNameAsc();
    }

    @GetMapping("getClientesOrderByAgeAsc")
    public List<ClienteDTO> getClientesOrderByAgeAsc(){

        return clienteService.getClientesOrderByAgeAsc();
    }

    @GetMapping("getQuantityClienteAvarage")
    public String getQuantityClienteAvarage(){
        return clienteService.getQuantityClienteAvarage();
    }


}
