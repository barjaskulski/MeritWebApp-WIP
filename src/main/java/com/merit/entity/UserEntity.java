package com.merit.entity;

import com.merit.ENUM.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;                                    //--- automatically generated
    private String userLogin;                               //--- login
    private String userPassword;                            //--- password
    private Position userPosition = Position.STUDENT;       //--- to be assigned by admin after acc verification - student default
    private String firstName;                               //--- name
    private String lastName;                                //--- surname

    public UserEntity(String userLogin, String userPassword, String firstName, String lastName) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
