package com.boot.service

import com.boot.model.Pet
import com.boot.model.PetResponseModel
import com.boot.model.PetRepository
import org.springframework.stereotype.Service

@Service
class PetService : BaseService<
    PetResponseModel,
    Pet,
    PetRepository
    >() {
}