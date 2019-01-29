package com.boot.controller

import com.boot.model.BaseListResponseModel
import com.boot.model.PetResponseModel
import com.boot.service.PetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@Api(value = "Pet APIs", tags = ["Pet"], description = "Pet Services")
@RestController
@RequestMapping("api/v1/pets")
class PetController : BaseController() {
    @Autowired
    private lateinit var petService: PetService

    @ApiOperation(value = "Retrieve pet list", notes = "")
    @GetMapping("")
    fun getAllRecords(): ResponseEntity<ApiResponse<BaseListResponseModel<PetResponseModel>>> {
        val pets = BaseListResponseModel(petService.getAllRecords())
        return getResponse(pets)
    }

//    @RequestMapping(value = "shipwrecks", method = arrayOf(RequestMethod.POST))
//    fun create(@RequestBody shipwreck: Pet): Pet {
//        return shipwreckRepository!!.saveAndFlush(shipwreck)
//    }
//
//    @RequestMapping(value = "shipwrecks/{id}", method = arrayOf(RequestMethod.GET))
//    @Throws(ResourceNotFoundException::class)
//    operator fun get(@PathVariable id: Long?): Pet? {
//        val record = shipwreckRepository!!.findById(id)
//        return if (record.isPresent) {
//            record.get()
//        } else {
//            null
//        }
//
//        //		Pet record = shipwreckRepository.findById(id)
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
//    //	public Pet update(@PathVariable Long id, @RequestBody Pet shipwreck) throws ResourceNotFoundException {
//    //		Optional<Pet> existingPet = shipwreckRepository.findById(id);
//    //		BeanUtils.copyProperties(shipwreck, existingPet);
//    //		return shipwreckRepository.saveAndFlush(existingPet);
//    //	}
//
//    @RequestMapping(value = "shipwrecks/{id}", method = arrayOf(RequestMethod.DELETE))
//    @Throws(ResourceNotFoundException::class)
//    fun delete(@PathVariable id: Long?): Pet {
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
//import com.boot.model.Pet;
//
//@RestController
//@RequestMapping("api/v1/")
//public class PetController {
//
//	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
//	public List<Pet> list() {
//		return PetStub.list();
//	}
//
//	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
//	public Pet create(@RequestBody Pet shipwreck) {
//		return PetStub.create(shipwreck);
//	}
//
//	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
//	public Pet get(@PathVariable Long id) {
//		return PetStub.get(id);
//	}
//
//	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
//	public Pet update(@PathVariable Long id, @RequestBody Pet shipwreck) {
//		return PetStub.update(id, shipwreck);
//	}
//
//	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
//	public Pet delete(@PathVariable Long id) {
//		return PetStub.delete(id);
//	}
//
//}
