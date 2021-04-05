package com.merit.sample;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.merit.ewr.EwrEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sampleId;                                    //--- automatically generated
    private String sampleNumber;
    //private String sampleEWR;


    public SampleEntity(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "samplesInProject")
    private Set<EwrEntity> ewrList = new HashSet<>();
}
