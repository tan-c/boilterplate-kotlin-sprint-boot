package com.boot.controller

import com.boot.model.BaseDataResponseModel
import com.boot.model.BaseListResponseModel
import com.boot.model.BaseResponseModel
import com.boot.model.UserPostRequestModel
import com.boot.model.UserPutRequestModel
import com.boot.model.UserResponseModel
import com.boot.service.UserService
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

@Api(value = "User APIs", tags = ["User"], description = "User Services")
@RestController
@RequestMapping("api/v1/users")
class UserController : BaseController() {
    @Autowired
    private lateinit var userService: UserService

    @ApiOperation(value = "Create new user", notes = "")
    @PostMapping("/")
    fun createRecord(
        @RequestBody request: ApiRequest<UserPostRequestModel>
    ): ResponseEntity<ApiResponse<BaseDataResponseModel>> {
        val newRecord = userService.createRecord(request.data)
        return getResponse(newRecord)
    }

    @ApiOperation(value = "Retrieve users list", notes = "")
    @GetMapping("")
    fun getAllRecords(): ResponseEntity<ApiResponse<BaseListResponseModel<UserResponseModel>>> {
        val users = BaseListResponseModel(userService.getAllRecords())
        return getResponse(users)
    }

    @ApiOperation(value = "Retrieve user by id", notes = "")
    @GetMapping("/{userId}")
    fun getRecord(@PathVariable("userId") userId: Long): ResponseEntity<ApiResponse<BaseDataResponseModel>> {
        val event = userService.getRecord(userId)
        return getResponse(event)
    }

    @ApiOperation(value = "Update user by id", notes = "")
    @PutMapping("/{userId}")
    fun updateRecord(
        @PathVariable("userId") userId: Long,
        @RequestBody request: ApiRequest<UserPutRequestModel>
    ): ResponseEntity<ApiResponse<BaseDataResponseModel>> {
        val updatedRecord = userService.updateRecord(userId, request.data)
        return getResponse(updatedRecord)
    }

    @ApiOperation(value = "Delete user by id", notes = "")
    @DeleteMapping("/{userId}")
    fun deleteRecord(@PathVariable("userId") userId: Long): ResponseEntity<ApiResponse<BaseResponseModel>> {
        val deletedUser = userService.deleteRecord(userId)
        return getResponse(deletedUser)
    }
}
