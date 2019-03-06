package com.service

import com.model.BaseModel
import com.model.PetEntity
import com.model.PetPostRequestModel
import com.model.PetPutRequestModel
import com.model.PetResponseModel
import com.model.PetRepository
import org.springframework.stereotype.Service

@Service
open class PetService : BaseService<
    PetPostRequestModel,
    PetPutRequestModel,
    PetResponseModel,
    PetEntity,
    PetRepository
    >() {

    override fun getCreatedRecordEntity(recordPostRequest: PetPostRequestModel): BaseModel {
        return PetEntity(
            name = recordPostRequest.name,
            gender = recordPostRequest.gender,
            owner = if (recordPostRequest.owner_id == null) null else getEntity(recordPostRequest.owner_id)
        )
    }

    override fun getUpdatedRecordEntity(recordId: Long, recordPutRequest: PetPutRequestModel): BaseModel {
        val record = getEntity<PetEntity>(recordId)
        record.name = recordPutRequest.name
        record.gender = recordPutRequest.gender
        record.owner = if(recordPutRequest.owner_id == null) null else getEntity(recordPutRequest.owner_id)
        return record
    }
}
