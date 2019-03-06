package com.helper.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

interface BaseRepository<T : BaseModel> : JpaRepository<T, Long>

open class BaseContext<R : BaseRepository<*>> {
    @Autowired
    lateinit var repo: R

    @PersistenceContext
    protected lateinit var em: EntityManager
}
