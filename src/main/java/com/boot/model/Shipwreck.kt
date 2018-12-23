package com.boot.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Shipwreck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var name: String = ""
    var description: String = ""
    var condition: String = ""
    var depth: Int? = null
    var latitude: Double? = null
    var longitude: Double? = null
    var yearDiscovered: Int? = null

//    constructor() {}

    constructor(
        id: Long?,
        name: String,
        description: String,
        condition: String,
        depth: Int?,
        latitude: Double?,
        longitude: Double?,
        yearDiscovered: Int?
    ) {
        this.id = id
        this.name = name
        this.description = description
        this.condition = condition
        this.depth = depth
        this.latitude = latitude
        this.longitude = longitude
        this.yearDiscovered = yearDiscovered
    }
}
