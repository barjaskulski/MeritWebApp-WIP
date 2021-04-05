package com.merit.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.merit.enums.Position;
import com.merit.ewr.EwrEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;                                    //--- automatically generated
    private String userLogin;                               //--- login
    private String userPassword;                            //--- password
    private Position userPosition = Position.STUDENT;       //--- to be assigned by admin after acc verification - student default
    private String firstName;                               //--- name
    private String lastName;                                //--- surname
    private String userCreated;                          //--- date of user creation
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String userLastLogin;

    public UserEntity(String userLogin, String userPassword, String firstName, String lastName) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userCreated = LocalDate.now().toString();
        this.userLastLogin = LocalDateTime.now().toString();
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "usersInProject")
    private Set<EwrEntity> ewrList = new HashSet<>();
}
