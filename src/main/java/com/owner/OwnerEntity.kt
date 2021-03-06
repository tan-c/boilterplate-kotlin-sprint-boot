package com.owner

import com.helper.base.BaseDataResponseModel
import com.helper.base.BaseModel
import com.helper.base.BaseRepository
import com.helper.base.BaseRequestModel
import com.helper.base.loadBase
import com.pet.PetEntity
import com.pet.PetResponseModel
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "owner", schema = "PUBLIC")
@DynamicUpdate
data class OwnerEntity (
    var name: String = "",
    var gender: String = "",
    var email: String? = null,

    @OneToMany(
        mappedBy = "owner",
        fetch = FetchType.LAZY
    )
    val pets: List<PetEntity>? = null
): BaseModel() {
    override infix fun modelOf(params: Any): OwnerResponseModel = OwnerResponseModel(
        name = name,
        gender = gender,
        email = email,
        pets = pets?.map { it simpleModelOf "" }
    ) loadBase this

    override infix fun simpleModelOf(params: Any): OwnerResponseModel = OwnerResponseModel(
        name = name,
        gender = gender,
        email = email,
        pets = null
    ) loadBase this
}

interface OwnerRepository : BaseRepository<OwnerEntity>

data class OwnerResponseModel(
    val name: String,
    val gender: String,
    val email: String?,
    val pets:  List<PetResponseModel>?
) : BaseDataResponseModel()

data class OwnerPostRequestModel(
    val name: String,
    val gender: String,
    val email: String?
) : BaseRequestModel()

data class OwnerPutRequestModel(
    val name: String,
    val gender: String,
    val email: String?
) : BaseRequestModel()
