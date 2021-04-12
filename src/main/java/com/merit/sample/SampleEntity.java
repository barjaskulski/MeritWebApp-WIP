package com.merit.sample;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    private Long sampleId;                                    //--- automatically generated
    private String sampleNumber;

    public SampleEntity(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "samplesInProject")
    private Set<EwrEntity> ewrList = new HashSet<>();
}
