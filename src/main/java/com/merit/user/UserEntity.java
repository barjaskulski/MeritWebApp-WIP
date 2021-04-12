package com.merit.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.merit.enums.Position;
import com.merit.ewr.EwrEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;                                    //--- automatically generated
    private String userLogin;                               //--- login
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userPassword;                            //--- password
    private Position userPosition = Position.STUDENT;       //--- to be assigned by admin after acc verification - student default
    private String firstName;                               //--- name
    private String lastName;                                //--- surname
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private LocalDateTime userCreated;                          //--- date of user creation
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private LocalDateTime userLastLogin;

    public UserEntity(String userLogin, String userPassword, String firstName, String lastName) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userCreated = LocalDateTime.now();
        this.userLastLogin = LocalDateTime.now();
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "usersInProject")
    private Set<EwrEntity> ewrList = new HashSet<>();
}
