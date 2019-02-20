package com.boot.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserDetailsModel(
    val userNumber: String,
    val authorityList: ArrayList<SimpleGrantedAuthority>,
    val allAccessPortals: String
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorityList
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return userNumber
    }

    override fun getPassword(): String {
        // FIXME: Where does this password come from
        return password
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

//    companion object {
//        private val serialVersionUID = 1043347018227720658L
//    }
}
