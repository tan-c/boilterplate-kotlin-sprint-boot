package com.health;//package com.boot.health;
//
////import com.justgifit.JustGifItProperties;
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Component;
//
//import javax.inject.Inject;
//
//@Component
//public class HealthCheck implements HealthIndicator {
//
////    @Inject
////    private JustGifItProperties properties;
//
//    @Override
//    public Health health() {
////        if (!properties.getGifLocation().canWrite()) {
////            return Health.down().build();
////        }
//
//        return Health.down().withDetail("SomeKey", "SomeValue").build();
////        return Health.up().build();
////        return Health.unknown().build();
//    }
//}
