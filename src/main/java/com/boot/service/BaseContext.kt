package com.boot.service

import com.boot.model.BaseModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.util.Date
import javax.persistence.EntityManager
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.PersistenceContext

interface BaseRepository<T : BaseModel> : CrudRepository<T, Long>, JpaRepository<T, Long>

open class BaseContext<R : BaseRepository<*>> {
    @Autowired
    lateinit var repo: R

    @PersistenceContext
    protected lateinit var em: EntityManager

}
