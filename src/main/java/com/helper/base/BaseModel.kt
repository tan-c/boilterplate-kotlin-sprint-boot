package com.helper.base

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
//    var createdBy: String? = null
//    var createdAt: Date? = null
//    var updatedBy: String? = null
//    var updatedAt: Date? = null

    open infix fun modelOf(params: Any): Any {
        return BaseResponseModel()
    }

    open infix fun simpleModelOf(params: Any): Any {
        return BaseResponseModel()
    }
}

open class BaseRequestModel

open class BaseResponseModel : Serializable

data class BaseListResponseModel<M : BaseResponseModel>(
    val items: List<M>
) : BaseResponseModel()

open class BaseDataResponseModel : BaseResponseModel() {
    var id: Long = 0
//    var createdBy: String? = null
//    var createdAt: Date? = null
//    var updatedBy: String? = null
//    var updatedAt: Date? = null
}

data class BaseDeletedDataResponseModel(
    open var id: Long
) : BaseResponseModel()

infix fun <T : BaseDataResponseModel> BaseDataResponseModel.loadBase(entity: BaseModel): T {
    this.apply {
        id = entity.id
//        createdBy = entity.createdBy
//        createdAt = entity.createdAt
//        updatedBy = entity.updatedBy
//        updatedAt = entity.updatedAt
    }
    return this as T
}

