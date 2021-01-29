package com.capstone.habitbuilder.user;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_squence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence")

    private Long id;
    private String name;
    private String email;
    private String photoUrl;
    private String about;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
//    private Long chat-botId;   for later

    public User() {}

    // create a user account
    public User(String name,
                String email,
                String photoUrl,
                String about,
                LocalDateTime createdDate,
                LocalDateTime updatedDate) {
        this.name = name;
        this.email = email;
        this.photoUrl = photoUrl;
        this.about = about;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
//    Need to setup different options for user update

    // Getter & Setter
    // email is from Google OAuth, can't change --> no setter
    // createdDate is can't change --> no setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", about='" + about + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
