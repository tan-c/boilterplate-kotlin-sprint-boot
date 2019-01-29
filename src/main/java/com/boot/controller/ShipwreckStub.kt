//package com.boot.controller
//
//import java.util.ArrayList
//import java.util.HashMap
//
//import com.boot.model.Shipwreck
//import org.springframework.data.jpa.domain.AbstractPersistable_.id
//
//object ShipwreckStub {
//    private val wrecks = HashMap<Long, Shipwreck>()
//    private var idIndex: Long = 3L
//
//    //populate initial wrecks
//    init {
//        val a = Shipwreck(1L, "U869", "A very deep German UBoat", "FAIR", 200, 44.12, 138.44, 1994)
//        wrecks[1L] = a
//        val b = Shipwreck(2L, "Thistlegorm", "British merchant boat in the Red Sea", "GOOD", 80, 44.12, 138.44, 1994)
//        wrecks[2L] = b
//        val c = Shipwreck(
//            3L,
//            "S.S. Yongala",
//            "A luxury passenger ship wrecked on the great barrier reef",
//            "FAIR",
//            50,
//            44.12,
//            138.44,
//            1994
//        )
//        wrecks[3L] = c
//    }
//
//    fun list(): List<Shipwreck> {
//        return ArrayList(wrecks.values)
//    }
//
//    fun create(wreck: Shipwreck): Shipwreck {
//        idIndex += idIndex
//        wreck.id = idIndex
//        wrecks[idIndex] = wreck
//        return wreck
//    }
//
//    operator fun get(id: Long?): Shipwreck? {
//        return wrecks.get(id)
//    }
//
//    fun update(id: Long, wreck: Shipwreck): Shipwreck? {
//        wrecks[id] = wreck
//        return wreck
//    }
//
//    fun delete(id: Long?): Shipwreck? {
//        return wrecks.remove(id)
//    }
//}
