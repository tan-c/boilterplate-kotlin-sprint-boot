package com.owner

import com.helper.base.BaseService
import com.helper.base.BaseModel
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
