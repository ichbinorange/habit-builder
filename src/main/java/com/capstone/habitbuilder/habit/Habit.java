package com.capstone.habitbuilder.habit;


import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@ToString
@Entity
@Table
public class Habit {
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
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    // Setup many to one relationship with Enjoyer
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Enjoyer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ENJOYER_ID", referencedColumnName = "ID")
    private Enjoyer enjoyer;

    public Habit() {}

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
