package com.boot.service

import com.boot.model.BaseModel
import com.boot.model.UserEntity
import com.boot.model.UserPostRequestModel
import com.boot.model.UserPutRequestModel
import com.boot.model.UserResponseModel
import com.boot.model.UserRepository
import org.springframework.stereotype.Service

@Service
open class UserService : BaseService<
    UserPostRequestModel,
    UserPutRequestModel,
    UserResponseModel,
    UserEntity,
    UserRepository
    >() {

    override fun getCreatedRecordEntity(recordPostRequest: UserPostRequestModel): BaseModel {
        return UserEntity (
            name = recordPostRequest.name,
            username = recordPostRequest.username,
            password = recordPostRequest.password
        )
    }

    override fun getUpdatedRecordEntity(recordId: Long, recordPutRequest: UserPutRequestModel): BaseModel {
        val record = getEntity<UserEntity>(recordId)
        record.name = recordPutRequest.name
        record.username = recordPutRequest.username
        record.password = recordPutRequest.password
        return record
    }
}
