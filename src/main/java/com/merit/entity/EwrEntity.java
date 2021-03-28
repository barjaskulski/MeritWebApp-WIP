package com.merit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class EwrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;                                    //--- automatically generated
    private String ewrName;
    private String XXX;
}
