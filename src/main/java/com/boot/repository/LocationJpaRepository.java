package com.boot.repository;

import com.boot.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationJpaRepository  extends JpaRepository<Location, Long>{
}


//package com.boot.repository;
//
//        import org.springframework.data.jpa.repository.JpaRepository;
//
//        import com.boot.model.Shipwreck;
//
//public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

//}
