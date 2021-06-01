package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Automovil;
import com.example.demo.repositories.AutomovilRepository;


@CrossOrigin
@RestController
public class AutomovilController {
	@Autowired
	public AutomovilRepository automovilRepository;

	// falto integrar el filtro 'not like Estado "eliminado"'
	@GetMapping(value = "/vehiculos")
	public List<Automovil> getAll() {
		
		return automovilRepository.findAll();	
	}
	
	@GetMapping(value = "/vehiculos/{id}")
	public Optional<Automovil> getOne(@PathVariable String id) {	
		return automovilRepository.findById(id);	
	}
	
	
	@PostMapping("/vehiculos")
	public Automovil create(@RequestBody Automovil automovil) {
		double _interes = interes(automovil.getCantidadCuota());
		int valorCuota = (int) (_interes * automovil.getPrecio())/automovil.getCantidadCuota();

		Automovil _automovil = automovilRepository.save(new Automovil(
				automovil.get_id(),
				automovil.getPatente(),
				automovil.getMarca(),
				automovil.getModelo(),
				automovil.getVersion(),
				automovil.getPrecio(),
				automovil.getCantidadCuota(),
				_interes,
				valorCuota,
				automovil.getEstado()));
		return _automovil;
	}
	

	@DeleteMapping(value = "/vehiculos/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		automovilRepository.deleteById(id);
		return new ResponseEntity<>("vehiculo elimindado", HttpStatus.OK);
	}
	
	@PutMapping("/vehiculos/{id}")
	public ResponseEntity<Automovil> updateTutorial(@PathVariable("id") String id, @RequestBody Automovil automovil) {
	  Optional<Automovil> automovilData = automovilRepository.findById(id);

	  if (automovilData.isPresent()) {	
		  					
		double _interes = interes(automovil.getCantidadCuota());
		int valorCuota = (int) (_interes * automovil.getPrecio())/automovil.getCantidadCuota();

	    Automovil _automovil= automovilData.get();
	    _automovil.setPatente(automovil.getPatente());
	    _automovil.setMarca(automovil.getMarca());
	    _automovil.setModelo(automovil.getModelo());
	    _automovil.setVersion(automovil.getVersion());
	    _automovil.setPrecio(automovil.getPrecio());
	    _automovil.setCantidadCuota(automovil.getCantidadCuota());
	    _automovil.setInteres(_interes);
	    _automovil.setValorCuota(valorCuota);
	    _automovil.setEstado(automovil.getEstado());
	    
	    return new ResponseEntity<>(automovilRepository.save(_automovil), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	public static double interes(int cantCouta){
		double porcentajeInteres = 0;
		
		if(cantCouta==12) {
			porcentajeInteres = 1.1;	
		} else if (cantCouta==24) {
			porcentajeInteres = 1.2;
		}else if (cantCouta==48) {
			porcentajeInteres = 1.35;
		}
		
		return porcentajeInteres;   
	}
	
}
