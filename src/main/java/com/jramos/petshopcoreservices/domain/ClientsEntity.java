package com.jramos.petshopcoreservices.domain;


import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name="Clients")

public class ClientsEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NonNull
    private String firstName;

    @NonNull
    private String secondName;

    private long phoneNumber;

    private String email;

    private String otherPhoneNumbers;

    private LocalDateTime created;

    public void setId(Long id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOtherPhoneNumbers(String otherPhoneNumbers) {
        this.otherPhoneNumbers = otherPhoneNumbers;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getOtherPhoneNumbers() {
        return otherPhoneNumbers;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsEntity that = (ClientsEntity) o;
        return phoneNumber == that.phoneNumber && Objects.equals(Id, that.Id) && firstName.equals(that.firstName) && secondName.equals(that.secondName) && Objects.equals(email, that.email) && Objects.equals(otherPhoneNumbers, that.otherPhoneNumbers) && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, secondName, phoneNumber, email, otherPhoneNumbers, created);
    }

    @Override
    public String toString() {
        return "ClientsEntity{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", otherPhoneNumbers='" + otherPhoneNumbers + '\'' +
                ", created=" + created +
                '}';
    }
}
