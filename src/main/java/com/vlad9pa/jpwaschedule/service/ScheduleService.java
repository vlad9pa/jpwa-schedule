package com.vlad9pa.jpwaschedule.service;

import com.vlad9pa.jpwaschedule.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    boolean isInOffice();

    void comeToOffice();

    void leaveOffice();

    List<Schedule> findAllInMonth();
}
