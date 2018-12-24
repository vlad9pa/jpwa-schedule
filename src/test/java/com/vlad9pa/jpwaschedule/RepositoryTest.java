package com.vlad9pa.jpwaschedule;

import com.vlad9pa.jpwaschedule.entity.Schedule;
import com.vlad9pa.jpwaschedule.repository.ScheduleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ScheduleRepository repository;

    @Test
    public void testFindToday(){

        Schedule actual = Schedule.builder().comeDate(new Date()).build();

        repository.save(actual);

        Optional<Schedule> firstByComeDateIsNotNullAndLeaveDateIsNull = repository.findFirstByComeDateIsNotNullAndLeaveDateIsNull();
        Schedule today = firstByComeDateIsNotNullAndLeaveDateIsNull.get();

        Assert.assertEquals(actual.getComeDate(), today.getComeDate());
    }
}
