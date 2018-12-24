package com.vlad9pa.jpwaschedule.service;

import com.vlad9pa.jpwaschedule.entity.Schedule;
import com.vlad9pa.jpwaschedule.repository.ScheduleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository repo;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean isInOffice() {
        Optional<Schedule> today = repo.findFirstByComeDateIsNotNullAndLeaveDateIsNull();

        return today.isPresent();
    }

    @Override
    public void comeToOffice() {
        Schedule schedule = Schedule.builder().comeDate(new Date()).build();

        repo.save(schedule);
    }

    @Override
    public void leaveOffice() {
        Optional<Schedule> today = repo.findFirstByComeDateIsNotNullAndLeaveDateIsNull();

        if(today.isPresent()){
            Schedule schedule = today.get();
            schedule.setLeaveDate(new Date());

            repo.save(schedule);
        }else{
            throw new IllegalArgumentException("You are not in office to leave");
        }
    }
}
