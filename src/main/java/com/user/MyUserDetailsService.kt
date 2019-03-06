package com.user

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        val authorityList: ArrayList<SimpleGrantedAuthority> = ArrayList()
        authorityList.add(SimpleGrantedAuthority("ROLE_" + "MIMIE"))

        return UserDetailsModel(
            authorityList = authorityList,
            userNumber = "111111",
            allAccessPortals = ""
        )
//        // based on current approach, the username is a struct of "provider_id|provider_key",
//        // provide_id and provide_key are column values from user.login_info table
//        when (providerId) {
//            LoginRequestModel.Companion.ProviderId.Credential.code -> {
//                val maybePasswordInfo: Optional<PasswordInfoEntity> =
//                    passwordInfoRepository.findByLoginInfoIdAndHasher(
//                        loginInfoId = loginInfoEntity.id,
//                        hasher = tokenConfig.hasher
//                    )
//                val passwordInfo: PasswordInfoEntity? =
//                    if (maybePasswordInfo.isPresent) maybePasswordInfo.get() else null
//                passwordInfo?.password
//            }
//            LoginRequestModel.Companion.ProviderId.Token.code -> passwordEncoder.encode(RedisDeck.getValue("$redisKeyTokenAuthenticationKeyPrefix$providerKey").toString())
//            else -> null
//        }?.let { passwordOrToken: String ->
//            val authorityList: ArrayList<SimpleGrantedAuthority> = ArrayList()
//            val allAccessPortalsBuilder = StringBuilder()
//            loginInfoEntity.user.roles.forEach { role: UserToRoleEntity ->
//                authorityList.add(SimpleGrantedAuthority("ROLE_" + role.roleC.toUpperCase()))
//                allAccessPortalsBuilder.append(role.accessPortals)
//            }
//
//            UserDetailsModel(
//                userNumber = loginInfoEntity.user.userNumber,
//                authorityList = authorityList,
//                allAccessPortals = allAccessPortalsBuilder.toString()
//            )
//        }
    }
}
