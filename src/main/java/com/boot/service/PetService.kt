package com.boot.service

import com.boot.model.BaseModel
import com.boot.model.Pet
import com.boot.model.PetPostRequestModel
import com.boot.model.PetPutRequestModel
import com.boot.model.PetResponseModel
import com.boot.model.PetRepository
import org.springframework.stereotype.Service

@Service
open class PetService : BaseService<
    PetPostRequestModel,
    PetPutRequestModel,
    PetResponseModel,
    Pet,
    PetRepository
    >() {

    override fun getCreatedRecordEntity(recordPostRequest: PetPostRequestModel): BaseModel {
        return Pet (
            name = recordPostRequest.name,
            gender = recordPostRequest.gender,
            owner = if(recordPostRequest.owner_id == null) null else getEntity(recordPostRequest.owner_id)
        )
    }

    override fun getUpdatedRecordEntity(recordId: Long, recordPutRequest: PetPutRequestModel): BaseModel {
        val record = getEntity<Pet>(recordId)
        record.name = recordPutRequest.name
        record.gender = recordPutRequest.gender
        record.owner = if(recordPutRequest.owner_id == null) null else getEntity(recordPutRequest.owner_id)
        return record
    }
}