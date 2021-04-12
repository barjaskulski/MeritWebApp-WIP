package com.merit.ewr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.merit.sample.SampleEntity;
import com.merit.user.UserEntity;
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
public class EwrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ewrId;                                    //--- automatically generated
    private String ewrName;
    private String ewrProjectLeader;

    public EwrEntity(String ewrName, String ewrProjectLeader) {
        this.ewrName = ewrName;
        this.ewrProjectLeader = ewrProjectLeader;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    //@JsonIgnore
    @JoinTable(
            name="samples_in_project",
            joinColumns = @JoinColumn(name="ewr_id"),
            inverseJoinColumns = @JoinColumn(name = "sample_id")
    )
    private Set<SampleEntity> samplesInProject = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    //@JsonIgnore
    @JoinTable(
            name="users_in_project",
            joinColumns = @JoinColumn(name="ewr_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserEntity> usersInProject = new HashSet<>();


    public void addSampleToEwr(SampleEntity sampleEntity) {
        samplesInProject.add(sampleEntity);
    }

    public void removeSampleFromEwr(SampleEntity sampleEntity) {
        samplesInProject.remove(sampleEntity);
    }

    public void addUserToEwr(UserEntity userEntity) {
        usersInProject.add(userEntity);
    }
    public void removeUserFromEwr(UserEntity userEntity) {
        usersInProject.remove(userEntity);
    }
}
