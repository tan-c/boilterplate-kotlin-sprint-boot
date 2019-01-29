package com.boot.controller


import com.boot.model.BaseListResponseModel
import com.boot.model.Shipwreck
import com.boot.model.ShipwreckResponseModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.boot.service.ShipwreckService
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@RestController
@RequestMapping("api/v1/")
class ShipwreckController : BaseController() {
    @Autowired
    private lateinit var shipwreckService: ShipwreckService

    @ApiOperation(value = "Retrieve shipwrect list", notes = "")
    @GetMapping("")
    fun getAllRecords(): ResponseEntity<ApiResponse<BaseListResponseModel<ShipwreckResponseModel>>> {
        val shipwrecks = BaseListResponseModel(shipwreckService.getAllRecords())
        return getResponse(shipwrecks)
    }

//    @RequestMapping(value = "shipwrecks", method = arrayOf(RequestMethod.POST))
//    fun create(@RequestBody shipwreck: Shipwreck): Shipwreck {
//        return shipwreckRepository!!.saveAndFlush(shipwreck)
//    }
//
//    @RequestMapping(value = "shipwrecks/{id}", method = arrayOf(RequestMethod.GET))
//    @Throws(ResourceNotFoundException::class)
//    operator fun get(@PathVariable id: Long?): Shipwreck? {
//        val record = shipwreckRepository!!.findById(id)
//        return if (record.isPresent) {
//            record.get()
//        } else {
//            null
//        }
//
//        //		Shipwreck record = shipwreckRepository.findById(id)
//        //					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//        ////		return record.get();
//        //		if (record.isPresent()) {
//        //			return record.get();
//        //		} else {
//        //			return null;
//        //		}
//    }
//
//    //	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
//    //	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) throws ResourceNotFoundException {
//    //		Optional<Shipwreck> existingShipwreck = shipwreckRepository.findById(id);
//    //		BeanUtils.copyProperties(shipwreck, existingShipwreck);
//    //		return shipwreckRepository.saveAndFlush(existingShipwreck);
//    //	}
//
//    @RequestMapping(value = "shipwrecks/{id}", method = arrayOf(RequestMethod.DELETE))
//    @Throws(ResourceNotFoundException::class)
//    fun delete(@PathVariable id: Long?): Shipwreck {
//        val existingRecord = shipwreckRepository!!.findById(id)
//            .orElseThrow { ResourceNotFoundException("Employee not found for this id :: " + id!!) }
//        shipwreckRepository.delete(existingRecord)
//        return existingRecord
//    }
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
