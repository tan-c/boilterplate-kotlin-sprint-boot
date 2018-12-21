package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Shipwreck get(@PathVariable Long id) {
		return shipwreckRepository.findOne(id);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck);
		return shipwreckRepository.saveAndFlush(existingShipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id) {
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(existingShipwreck);
		return existingShipwreck;
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
