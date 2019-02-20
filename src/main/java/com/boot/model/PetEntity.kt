package com.boot.model

import com.boot.service.BaseRepository
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "pet", schema = "public")
@DynamicUpdate
data class PetEntity (
    var name: String = "",
    var gender: String = "",

    @ManyToOne(
        fetch = FetchType.LAZY
//        cascade = [CascadeType.PERSIST]
    )
    @JoinColumn(name = "owner_id")
    var owner: OwnerEntity? = null
//    var owner_id: Int?
//    var depth: Int? = null,
//    var latitude: Double? = null,
//    var longitude: Double? = null,
//    var yearDiscovered: Int? = null
): BaseModel() {
    override infix fun modelOf(params: Any): PetResponseModel = PetResponseModel(
        name = name,
        gender = gender,
        owner = owner?.simpleModelOf("")
    ) loadBase this

    override infix fun simpleModelOf(params: Any): PetResponseModel = PetResponseModel(
        name = name,
        gender = gender,
        owner = null
    ) loadBase this
}

interface PetRepository : BaseRepository<PetEntity>

data class PetResponseModel(
    val name: String,
    val gender: String,
    val owner: OwnerResponseModel?
) : BaseDataResponseModel()

data class PetPostRequestModel(
    val name: String,
    val gender: String,
    val owner_id: Long?
) : BaseRequestModel()

data class PetPutRequestModel(
    val name: String,
    val gender: String,
    val owner_id: Long?
) : BaseRequestModel()

