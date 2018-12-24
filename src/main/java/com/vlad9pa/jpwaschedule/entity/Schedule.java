package com.vlad9pa.jpwaschedule.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document
public class Schedule {

    @Id
    private String id;

    private Date comeDate;

    private Date leaveDate;
}
