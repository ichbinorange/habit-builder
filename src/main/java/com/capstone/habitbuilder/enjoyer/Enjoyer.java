package com.capstone.habitbuilder.enjoyer;

import com.capstone.habitbuilder.habit.Habit;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@ToString
@Entity
@Table
public class Enjoyer {
    @Id
    @SequenceGenerator(
            name = "enjoyer_sequence",
            sequenceName = "enjoyer_sequence",
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

    // Setup one to many relationship with Habit
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity = Habit.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "enjoyer")
    private List<Habit> habits = new ArrayList<>();

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

}
