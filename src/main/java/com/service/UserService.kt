package com.service

import com.model.BaseModel
import com.model.UserEntity
import com.model.UserPostRequestModel
import com.model.UserPutRequestModel
import com.model.UserResponseModel
import com.model.UserRepository
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
        return UserEntity(
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
