package ru.schoolarlife.logic.bo.location;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by victor on 01.11.16.
 */
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String zip;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id")
    private Country country;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id")
    private City city;

    @NotNull
    private String addressLine;
    private String comment;

    public Address() {
    }

    public Address(String zip, Country country, City city, String addressLine, String comment) {
        this.zip = zip;
        this.country = country;
        this.city = city;
        this.addressLine = addressLine;
        this.comment = comment;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
