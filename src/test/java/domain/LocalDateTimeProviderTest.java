package domain;

import org.junit.Rule;
import org.junit.Test;
import rule.AvecLocalDateTimeProvider;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import static org.fest.assertions.api.Assertions.assertThat;

public class LocalDateTimeProviderTest {

    @Test
    public void localDateTimeProviderReturnDesiredLocaleDateTime() {
        assertThat(LocaleDateTimeProvider.now()).isEqualTo(LocalDateTime.now(Clock.fixed(Instant.EPOCH, ZoneId.systemDefault())));
        avecLocalDateTimeProvider.plus(10, ChronoUnit.DAYS);
        assertThat(LocaleDateTimeProvider.now()).isEqualTo(LocalDateTime.of(1970, 1, 11, 1, 0, 0, 0));
    }

    @Test
    public void localDateTimeProviderReturnsRealDate() {
        avecLocalDateTimeProvider.resetClock();

        assertThat(LocaleDateTimeProvider.now()).isNotSameAs(LocalDateTime.now());
    }

    @Rule
    public AvecLocalDateTimeProvider avecLocalDateTimeProvider = new AvecLocalDateTimeProvider();

}