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

    override fun getCreateRecordEntity(petRequest: PetPostRequestModel): BaseModel {
        return Pet (
            name = petRequest.name,
            gender = petRequest.gender,
            owner_id = petRequest.owner_id
        )
    }
}