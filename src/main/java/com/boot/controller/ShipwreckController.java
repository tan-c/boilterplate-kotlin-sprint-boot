package com.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return shipwreckRepository.findAll();
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return shipwreckRepository.saveAndFlush(shipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Shipwreck> record = shipwreckRepository.findById(id);
		if (record.isPresent()) {
			return record.get();
		} else {
			return null;
		}

//		Shipwreck record = shipwreckRepository.findById(id)
//					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
////		return record.get();
//		if (record.isPresent()) {
//			return record.get();
//		} else {
//			return null;
//		}
	}


//	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
//	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) throws ResourceNotFoundException {
//		Optional<Shipwreck> existingShipwreck = shipwreckRepository.findById(id);
//		BeanUtils.copyProperties(shipwreck, existingShipwreck);
//		return shipwreckRepository.saveAndFlush(existingShipwreck);
//	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id) throws ResourceNotFoundException {
		Shipwreck existingRecord = shipwreckRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		shipwreckRepository.delete(existingRecord);
		return existingRecord;
	}

}


//package com.boot.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.boot.model.Shipwreck;
//
//@RestController
//@RequestMapping("api/v1/")
//public class ShipwreckController {
//
//	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
//	public List<Shipwreck> list() {
//		return ShipwreckStub.list();
//	}
//
//	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
//	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
//		return ShipwreckStub.create(shipwreck);
//	}
//
//	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
//	public Shipwreck get(@PathVariable Long id) {
//		return ShipwreckStub.get(id);
//	}
//
//	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
//	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
//		return ShipwreckStub.update(id, shipwreck);
//	}
//
//	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
//	public Shipwreck delete(@PathVariable Long id) {
//		return ShipwreckStub.delete(id);
//	}
//
//}
