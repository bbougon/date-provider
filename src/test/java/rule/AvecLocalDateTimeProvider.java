package rule;

import domain.LocaleDateTimeProvider;
import org.junit.rules.ExternalResource;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class AvecLocalDateTimeProvider extends ExternalResource {

    public AvecLocalDateTimeProvider() {
        LocaleDateTimeProvider.timeProvider = new LocaleDateTimeProvider.TimeProvider(FIXED);
    }

    public void plus(int amount, ChronoUnit unit) {
        LocaleDateTimeProvider.timeProvider = new LocaleDateTimeProvider.TimeProvider(FIXED){
            @Override
            public LocalDateTime now() {
                return LocalDateTime.now(FIXED).plus(amount, unit);
            }
        };
    }

    public void resetClock() {
        LocaleDateTimeProvider.timeProvider = new LocaleDateTimeProvider.TimeProvider(Clock.systemDefaultZone());
    }

    public static final Clock FIXED = Clock.fixed(Instant.EPOCH, ZoneId.systemDefault());
}
