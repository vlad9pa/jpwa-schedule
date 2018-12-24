package com.vlad9pa.jpwaschedule.repository;

import com.vlad9pa.jpwaschedule.entity.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    Optional<Schedule> findFirstByComeDateIsNotNullAndLeaveDateIsNull();
}
