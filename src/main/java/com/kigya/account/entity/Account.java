package com.kigya.account.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(fluent = true)
@Entity
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Basic
    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Basic
    @Column(name = "username", nullable = false, length = 12)
    private String username;

    @Basic
    @Column(name = "bio", nullable = true, length = 256)
    private String bio;

    @Basic
    @Column(name = "gender", nullable = false)
    private short gender;

    @Basic
    @Column(name = "country", nullable = false, length = 30)
    private String country;

    @Basic
    @Column(name = "city", nullable = true, length = 30)
    private String city;

    @Basic
    @Column(name = "street_address", nullable = true, length = 50)
    private String streetAddress;

    public static Account.@NotNull Builder newBuilder() {
        return new Account().new Builder();
    }

    public class Builder {
        protected Builder() {
        }

        public Account.Builder setEmail(String email) {
            Account.this.email = email;
            return this;
        }

        public Account.Builder setPassword(String password) {
            Account.this.password = password;
            return this;
        }

        public Account.Builder setUsername(String username) {
            Account.this.username = username;
            return this;
        }

        public Account.Builder setBio(String bio) {
            Account.this.bio = bio;
            return this;
        }

        public Account.Builder setGender(short gender) {
            Account.this.gender = gender;
            return this;
        }

        public Account.Builder setCountry(String country) {
            Account.this.country = country;
            return this;
        }

        public Account.Builder setCity(String city) {
            Account.this.city = city;
            return this;
        }

        public Account.Builder setStreetAddress(String streetAddress) {
            Account.this.streetAddress = streetAddress;
            return this;
        }

        public Account build() {
            return Account.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && gender == account.gender && Objects.equals(email, account.email) &&
                Objects.equals(password, account.password) && Objects.equals(username, account.username) &&
                Objects.equals(bio, account.bio) && Objects.equals(country, account.country) &&
                Objects.equals(city, account.city) && Objects.equals(streetAddress, account.streetAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, username, bio, gender, country, city, streetAddress);
    }
}
