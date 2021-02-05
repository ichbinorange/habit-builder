package com.capstone.habitbuilder.habit;

import com.capstone.habitbuilder.Auditable;
import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.habitfriend.HabitFriend;
import com.capstone.habitbuilder.habitmsg.HabitMsg;
import com.capstone.habitbuilder.habittracker.HabitTracker;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@ToString
@Entity
@Table
public class Habit extends Auditable<String> {
    @Id
    @SequenceGenerator(
            name = "habit_sequence",
            sequenceName = "habit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "habit_sequence")

    @Column(updatable = false)
    private Long id;

    private String title;
    private String goal;
    private String description;
    private String streak;
    private Boolean reminder;
    private Boolean habitBuilt;

    // Setup many to one relationship with Enjoyer
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Enjoyer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ENJOYER_ID", referencedColumnName = "ID", updatable = false)
    private Enjoyer enjoyer;

    // Setup one to many relationship with HabitTracker
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity = HabitTracker.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "habit")
    private List<HabitTracker> habitTrackers = new ArrayList<>();

    // Setup one to many relationship with HabitMsg
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity = HabitMsg.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "habit")
    private List<HabitMsg> habitMsgs = new ArrayList<>();

    // Setup one to many relationship with HabitFriend
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity = HabitFriend.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "habit")
    private Set<HabitFriend> habitFriends;

    public Habit() {}

    //    Need to setup different options for user update

    // create a new habit
    public Habit(Enjoyer enjoyer,
                 String title,
                 String goal,
                 String description,
                 String streak,
                 Boolean reminder) {
        this.enjoyer = enjoyer;
        this.title = title;
        this.goal = goal;
        this.description = description;
        this.streak = streak;
        this.reminder = reminder;
    }
}
