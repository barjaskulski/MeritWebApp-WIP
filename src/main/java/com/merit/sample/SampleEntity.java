package com.merit.sample;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long sampleId;                                    //--- automatically generated
    private String sampleNumber;
    private String sampleEWR;
}
