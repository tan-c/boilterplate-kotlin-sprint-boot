package com.boot.model

import com.boot.service.BaseRepository
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user", schema = "public")
@DynamicUpdate
data class UserEntity (
    var name: String = "",
    var username: String = "",
    var password: String = ""
): BaseModel() {
    override infix fun modelOf(params: Any): UserResponseModel = UserResponseModel(
        name = name,
        username = username,
        password = password
    ) loadBase this
}

interface UserRepository : BaseRepository<UserEntity>

data class UserResponseModel(
    val name: String,
    val username: String,
    val password: String
) : BaseDataResponseModel()

data class UserPostRequestModel(
    val name: String,
    val username: String,
    val password: String
) : BaseRequestModel()

data class UserPutRequestModel(
    val name: String,
    val username: String,
    val password: String
) : BaseRequestModel()

