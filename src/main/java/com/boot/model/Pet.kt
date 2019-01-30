package com.boot.model

import com.boot.service.BaseRepository
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "PET", schema = "PUBLIC")
@DynamicUpdate
data class Pet (
    var name: String,
    var gender: String,
    var owner_id: Int?
//    var depth: Int? = null,
//    var latitude: Double? = null,
//    var longitude: Double? = null,
//    var yearDiscovered: Int? = null
): BaseModel() {
    override infix fun modelOf(params: Any): PetResponseModel = PetResponseModel(
        name = name,
        gender = gender,
        owner_id = owner_id
    ) loadBase this
}

interface PetRepository : BaseRepository<Pet>

data class PetResponseModel(
    val name: String,
    val gender: String,
    val owner_id: Int?
) : BaseDataResponseModel()

data class PetPostRequestModel(
    val name: String,
    val gender: String,
    val owner_id: Int?
) : BaseRequestModel()

data class PetPutRequestModel(
    val name: String,
    val gender: String,
    val owner_id: Int?
) : BaseRequestModel()