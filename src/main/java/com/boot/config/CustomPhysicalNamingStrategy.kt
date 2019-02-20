package com.boot.config

import com.google.common.base.CaseFormat
import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment

class CustomPhysicalNamingStrategy : PhysicalNamingStrategyStandardImpl() {
    override fun toPhysicalColumnName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return getSafeName(name)
    }

    override fun toPhysicalTableName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return getSafeName(name)
    }

    override fun toPhysicalSchemaName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return getSafeName(name)
    }

    override fun toPhysicalCatalogName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return getSafeName(name)
    }

    override fun toPhysicalSequenceName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return getSafeName(name)
    }

    private fun getSafeName(identifier: Identifier?): Identifier? {
        return identifier?.let { Identifier.toIdentifier("[${it.text.removeSurrounding("[", "]")}]") }
    }

//    private fun toLowerCase(identifier: Identifier?): Identifier? {
//        return identifier?.let {
//            Identifier.toIdentifier(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, it.text))
//        }
//    }
//
//    private fun convertCamelToUnderScoreName(identifier: Identifier?): Identifier? {
//        return identifier?.let {
//            Identifier.toIdentifier(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, it.text))
//        }
//    }

    //    private fun convertToSnakeCase(identifier: Identifier): Identifier {
    //        val regex = "([a-z])([A-Z])"
    //        val replacement = "$1_$2"
    //        val newName = identifier.text
    //            .replace(regex.toRegex(), replacement)
    //            .toLowerCase()
    //        return Identifier.toIdentifier(newName)
    //    }
}
