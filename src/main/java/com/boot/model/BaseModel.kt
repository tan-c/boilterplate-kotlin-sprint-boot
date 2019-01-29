package com.boot.model

import java.io.Serializable
import java.util.Date
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
    var createdBy: String? = null
    var createdAt: Date? = null
    var updatedBy: String? = null
    var updatedAt: Date? = null
}

open class BaseResponseModel : Serializable

data class BaseListResponseModel<M : BaseResponseModel>(
    val items: List<M>
) : BaseResponseModel()

open class BaseDataResponseModel : BaseResponseModel() {
    var id: Long = 0
    var createdBy: String? = null
    var createdAt: Date? = null
    var updatedBy: String? = null
    var updatedAt: Date? = null
}
