package com.boot.model

import com.boot.service.BaseRepository
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "OWNER", schema = "PUBLIC")
@DynamicUpdate
data class OwnerEntity (
    var name: String = "",
    var gender: String = "",
    var email: String? = null,

    @OneToMany(
        mappedBy = "owner",
        fetch = FetchType.LAZY
//        cascade = [CascadeTye.PERSIST, CascadeType.REMOVE]
    )
    val pets: List<PetEntity>? = null
): BaseModel() {
    override infix fun modelOf(params: Any): OwnerResponseModel = OwnerResponseModel(
        name = name,
        gender = gender,
        email = email,
        pets = pets?.map { it simpleModelOf ""}
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
