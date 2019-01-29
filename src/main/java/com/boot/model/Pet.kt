package com.boot.model

import com.boot.service.BaseRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity

@Entity
data class Pet (
    var name: String = "",
    var description: String = "",
    var condition: String = "",
    var depth: Int? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
    var yearDiscovered: Int? = null
): BaseModel()

//@Repository("shipwreckRepository")
interface ShipwreckRepository : BaseRepository<Pet>

data class PetResponseModel(
    val name: String,
    val description: String
) : BaseDataResponseModel()