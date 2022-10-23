package com.sid.msBanque.web;


import com.sid.msBanque.entities.Compte;
import com.sid.msBanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque")
public class CompteRestController {

    @Autowired
    private CompteRepository compteRepository;


    @GetMapping(path = "/compte" ,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Compte> save(){
        return compteRepository.findAll();
    }

    @GetMapping(path = "/compte/{id}")
    public Compte getOne(@PathVariable Long id){
            return compteRepository.findById(id).get();
    }

    @PostMapping(path = "compte")
    public Compte save(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping (path = "/compte/{id}")
    public Compte update(@RequestBody Compte compte, Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path = "/compte/{id}")
    public void delete(Long id){
         compteRepository.deleteById(id);
    }




}
