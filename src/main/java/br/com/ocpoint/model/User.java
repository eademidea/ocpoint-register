package br.com.ocpoint.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "TB_USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_NAME", unique = true)
    private String user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "id")
    private AccessGroup group;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "id")
    private Person person;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate;

    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate;
}
