package domain;

import java.time.Clock;
import java.time.LocalDateTime;

public class LocaleDateTimeProvider {

    public static LocalDateTime now() {
        return timeProvider.now();
    }

    public static TimeProvider timeProvider = new TimeProvider(Clock.systemDefaultZone());

    public static class TimeProvider {

        public TimeProvider(Clock clock) {
            this.clock = clock;
        }

        public LocalDateTime now() {
            return LocalDateTime.now(clock);
        }

        private Clock clock;
    }
}
