package com.boot.controller

import com.boot.model.BaseDataResponseModel
import com.boot.model.BaseListResponseModel
import com.boot.model.BaseResponseModel
import com.boot.model.OwnerPostRequestModel
import com.boot.model.OwnerPutRequestModel
import com.boot.model.OwnerResponseModel
import com.boot.service.OwnerService
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

@Api(value = "Owner APIs", tags = ["Owner"], description = "Owner Services")
@RestController
@RequestMapping("api/v1/owners")
class OwnerController : BaseController() {
    @Autowired
    private lateinit var ownerService: OwnerService

    @ApiOperation(value = "Create new owner", notes = "")
    @PostMapping("/")
    fun createRecord(
        @RequestBody request: ApiRequest<OwnerPostRequestModel>
    ): ResponseEntity<ApiResponse<BaseDataResponseModel>> {
        val newRecord = ownerService.createRecord(request.data)
        return getResponse(newRecord)
    }

    @ApiOperation(value = "Retrieve owners list", notes = "")
    @GetMapping("")
    fun getAllRecords(): ResponseEntity<ApiResponse<BaseListResponseModel<OwnerResponseModel>>> {
        val owners = BaseListResponseModel(ownerService.getAllRecords())
        return getResponse(owners)
    }

    @ApiOperation(value = "Retrieve owner by id", notes = "")
    @GetMapping("/{ownerId}")
    fun getRecord(@PathVariable("ownerId") ownerId: Long): ResponseEntity<ApiResponse<BaseDataResponseModel>> {
        val event = ownerService.getRecord(ownerId)
        return getResponse(event)
    }

    @ApiOperation(value = "Update owner by id", notes = "")
    @PutMapping("/{ownerId}")
    fun updateRecord(
        @PathVariable("ownerId") ownerId: Long,
        @RequestBody request: ApiRequest<OwnerPutRequestModel>
    ): ResponseEntity<ApiResponse<BaseDataResponseModel>> {
        val updatedRecord = ownerService.updateRecord(ownerId, request.data)
        return getResponse(updatedRecord)
    }

    @ApiOperation(value = "Delete owner by id", notes = "")
    @DeleteMapping("/{ownerId}")
    fun deleteRecord(@PathVariable("ownerId") ownerId: Long): ResponseEntity<ApiResponse<BaseResponseModel>> {
        val deletedOwner = ownerService.deleteRecord(ownerId)
        return getResponse(deletedOwner)
    }
}