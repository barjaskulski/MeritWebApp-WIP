package com.merit.chamber;

import com.merit.enums.TestStatus;
import com.merit.enums.TestType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ChamberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long chamberId;                                    //--- automatically generated
    private String chamberName;
    private boolean isFree;
    private TestType currentTestType;
    private TestStatus testStatus;
}
