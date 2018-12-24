package com.vlad9pa.jpwaschedule.repository;

import com.vlad9pa.jpwaschedule.entity.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

}
