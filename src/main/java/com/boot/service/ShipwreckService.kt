package com.boot.service

import com.boot.model.Shipwreck
import com.boot.model.ShipwreckRepository
import com.boot.model.ShipwreckResponseModel
import org.springframework.stereotype.Service

@Service
class ShipwreckService : BaseService<
    ShipwreckResponseModel,
    Shipwreck,
    ShipwreckRepository
    >() {


}