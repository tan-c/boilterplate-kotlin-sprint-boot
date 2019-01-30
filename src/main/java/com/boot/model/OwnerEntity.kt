package com.boot.model

import com.boot.service.BaseRepository
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "OWNER", schema = "PUBLIC")
@DynamicUpdate
data class OwnerEntity (
    var name: String = "",
    var gender: String = "",
    var email: String? = null

//    @OneToOne(
//        mappedBy = "OWNER",
//        fetch = FetchType.EAGER,
//        cascade = [CascadeType.PERSIST]
//    )
//    @OneToOne(mappedBy = "event", fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST])
//    var owner_id: OwnerModel? = null
//    var owner_id: Int?
): BaseModel() {
    override infix fun modelOf(params: Any): OwnerResponseModel = OwnerResponseModel(
        name = name,
        gender = gender,
        email = email
    ) loadBase this
}

interface OwnerRepository : BaseRepository<OwnerEntity>

data class OwnerResponseModel(
    val name: String,
    val gender: String,
    val email: String?
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
