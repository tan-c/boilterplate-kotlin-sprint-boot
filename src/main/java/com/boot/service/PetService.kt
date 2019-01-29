package com.boot.service

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
}