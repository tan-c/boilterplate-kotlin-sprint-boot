package com.boot.controller

import com.boot.model.BaseResponseModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class ApiResponse<T : BaseResponseModel>(
    var data: T?,
    var error: String?
)

open class BaseController {
    fun <T : BaseResponseModel> getResponse(
        resultData: T? = null,
        httpStatus: HttpStatus = HttpStatus.OK
    ): ResponseEntity<ApiResponse<T>> {
        val response: ApiResponse<T> = ApiResponse(data = resultData, error = "")
        return ResponseEntity(response, httpStatus)
    }
}
