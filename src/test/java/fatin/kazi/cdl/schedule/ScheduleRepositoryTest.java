package fatin.kazi.cdl.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ScheduleRepositoryTest {

    @Autowired
    private ScheduleRepository underTest;

    @Test
    void scheduleForDayOne() {
      assertThat(false).isFalse();

    }


}