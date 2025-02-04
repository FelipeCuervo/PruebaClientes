package com.example.pruebacliente.service;

import com.example.pruebacliente.entities.Cliente;
import com.example.pruebacliente.entities.ClienteDTO;
import com.example.pruebacliente.entities.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente saveCliente (Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getClientesOrderByFullNameAsc(){
       return clienteRepository.findAllByOrderByFullName();

    }

    public List<ClienteDTO> getClientesOrderByAgeAsc(){
        List<Cliente> clientes = clienteRepository.findAllByOrderByBirthDayDesc();
        List<ClienteDTO> clienteDTOList = new ArrayList<>();

        for (Cliente cliente:clientes) {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setFullName(cliente.getFullName());
            clienteDTO.setAge(cliente.calculateAge());
            clienteDTOList.add(clienteDTO);
        }
         return clienteDTOList;
    }

    public String getQuantityClienteAvarage(){
        long count = clienteRepository.count();
        long ageSumatory = 0;
        List<Cliente>clienteList = clienteRepository.findAll();

        for (Cliente cliente :clienteList) {
            ageSumatory+=cliente.calculateAge();
        }

        double avarageAge = count > 0 ? (double) ageSumatory / count : 0;
        return "La cantidad de clientes es: "+count+" \nEl promedio de edad es: "+avarageAge;
    }
}
