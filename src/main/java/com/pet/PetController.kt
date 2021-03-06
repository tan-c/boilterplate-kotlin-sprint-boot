package com.pet

import com.helper.base.ApiRequest
import com.helper.base.ApiResponse
import com.helper.base.BaseController
import com.helper.base.BaseDataResponseModel
import com.helper.base.BaseListResponseModel
import com.helper.base.BaseResponseModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@Api(value = "Pet APIs", tags = ["Pet"], description = "Pet Services")
@RestController
@RequestMapping("api/v1/pets")
class PetController : BaseController() {
    @Autowired
    private lateinit var petService: PetService

    @ApiOperation(value = "Create new pet", notes = "")
    @PostMapping("/")
    fun createRecord(
        @RequestBody request: ApiRequest<PetPostRequestModel>
    ): ResponseEntity<ApiResponse<BaseDataResponseModel>> {
        val newRecord = petService.createRecord(request.data)
        return getResponse(newRecord)
    }

    @ApiOperation(value = "Retrieve pets list", notes = "")
    @GetMapping("")
    fun getAllRecords(): ResponseEntity<ApiResponse<BaseListResponseModel<PetResponseModel>>> {
        val pets = BaseListResponseModel(petService.getAllRecords())
        return getResponse(pets)
    }

    @ApiOperation(value = "Retrieve pet by id", notes = "")
    @GetMapping("/{petId}")
    fun getRecord(@PathVariable("petId") petId: Long): ResponseEntity<ApiResponse<BaseDataResponseModel>> {
        val event = petService.getRecord(petId)
        return getResponse(event)
    }

    @ApiOperation(value = "Update pet by id", notes = "")
    @PutMapping("/{petId}")
    fun updateRecord(
        @PathVariable("petId") petId: Long,
        @RequestBody request: ApiRequest<PetPutRequestModel>
    ): ResponseEntity<ApiResponse<BaseDataResponseModel>> {
        val updatedRecord = petService.updateRecord(petId, request.data)
        return getResponse(updatedRecord)
    }

    @ApiOperation(value = "Delete pet by id", notes = "")
    @DeleteMapping("/{petId}")
    fun deleteRecord(@PathVariable("petId") petId: Long): ResponseEntity<ApiResponse<BaseResponseModel>> {
        val deletedPet = petService.deleteRecord(petId)
        return getResponse(deletedPet)
    }
}
