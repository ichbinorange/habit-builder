package com.capstone.habitbuilder.enjoyer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Enjoyer {
    @Id
    @SequenceGenerator(
            name = "enjoyer_sequence",
            sequenceName = "enjoyer_squence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "enjoyer_sequence")

    private Long id;
    private String name;
    private String email;
    private String photoUrl;
    private String about;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
//    private Long chat-botId;   for later

    public Enjoyer() {}

    // create a user account
    public Enjoyer(String name,
                   String email,
                   String photoUrl,
                   String about) {
        this.name = name;
        this.email = email;
        this.photoUrl = photoUrl;
        this.about = about;
    }
//    Need to setup different options for user update

    // Getter & Setter
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

    public void setEmail(String email) {
        this.email = email;
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

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Enjoyer{" +
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
