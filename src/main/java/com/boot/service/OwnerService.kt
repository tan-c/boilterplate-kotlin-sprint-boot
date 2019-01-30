package com.boot.service

import com.boot.model.BaseModel
import com.boot.model.OwnerEntity
import com.boot.model.OwnerPostRequestModel
import com.boot.model.OwnerPutRequestModel
import com.boot.model.OwnerResponseModel
import com.boot.model.OwnerRepository
import org.springframework.stereotype.Service
import java.security.acl.Owner

@Service
open class OwnerService : BaseService<
    OwnerPostRequestModel,
    OwnerPutRequestModel,
    OwnerResponseModel,
    OwnerEntity,
    OwnerRepository
    >() {

    override fun getCreatedRecordEntity(recordPostRequest: OwnerPostRequestModel): BaseModel {
        return OwnerEntity (
            name = recordPostRequest.name,
            gender = recordPostRequest.gender,
            email = recordPostRequest.email
        )
    }

    override fun getUpdatedRecordEntity(recordId: Long, recordPutRequest: OwnerPutRequestModel): BaseModel {
        val record = getEntity<OwnerEntity>(recordId)
        record.name = recordPutRequest.name
        record.gender = recordPutRequest.gender
        record.email = recordPutRequest.email
        return record
    }
}