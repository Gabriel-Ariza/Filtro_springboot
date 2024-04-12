package com.filtro.inmobiliaria.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.filtro.inmobiliaria.repository.entitiesDTO.OficinaDTO;
import com.filtro.inmobiliaria.service.OficinaService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/oficinas")
public class OficinaController {


    @Autowired
    private OficinaService OficinaService;
    
    @GetMapping("/")
    public List<OficinaDTO> findAll() {
        return OficinaService.findAll();
    }


    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Validated @RequestBody OficinaDTO OficinaDTO, BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        try {

            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            OficinaDTO OficinaSave = null;
            OficinaSave = OficinaService.save(OficinaDTO);

            response.put("mensaje", "La Oficina ha sido creado con éxito");
            response.put("Oficina", OficinaSave);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el guardado en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @Validated @RequestBody OficinaDTO OficinaDTO, BindingResult result) {

        Map<String, Object> response = new HashMap<>();

        try {

            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            OficinaDTO OficinaUpdate = null;
            OficinaUpdate = OficinaService.update(id, OficinaDTO);

            response.put("mensaje", "La Oficina ha sido actualizado con éxito");
            response.put("Oficina", OficinaUpdate);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        OficinaService.deleteById(id);
    } 

}
