package com.service

import com.model.BaseModel
import com.model.OwnerEntity
import com.model.OwnerPostRequestModel
import com.model.OwnerPutRequestModel
import com.model.OwnerResponseModel
import com.model.OwnerRepository
import org.springframework.stereotype.Service

@Service
open class OwnerService : BaseService<
    OwnerPostRequestModel,
    OwnerPutRequestModel,
    OwnerResponseModel,
    OwnerEntity,
    OwnerRepository
    >() {

    override fun getCreatedRecordEntity(recordPostRequest: OwnerPostRequestModel): BaseModel {
        return OwnerEntity(
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
