package com.capstone.habitbuilder.habit;

import com.capstone.habitbuilder.Auditable;
import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.habittracker.HabitTracker;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private Long id;
    private String title;
    private String goal;
    private String description;
    private String streak;
    private Boolean reminder;

    // Setup many to one relationship with Enjoyer
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Enjoyer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ENJOYER_ID", referencedColumnName = "ID")
    private Enjoyer enjoyer;

    // Setup one to many relationship with HabitTracker
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity = HabitTracker.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "habit")
    private List<HabitTracker> habitTrackers = new ArrayList<>();

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
