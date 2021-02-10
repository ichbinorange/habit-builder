package com.capstone.habitbuilder.habittracker;

import com.capstone.habitbuilder.Auditable;
import com.capstone.habitbuilder.habit.Habit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@ToString
@Entity
@Table
public class HabitTracker extends Auditable<String> {
    @Id
    @SequenceGenerator(
            name = "habitTracker_sequence",
            sequenceName = "habitTracker_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "habitTracker_sequence")

    @Column(updatable = false)
    private Long id;
    // Setup many to one relationship with Habit
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Habit.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "HABIT_ID", referencedColumnName = "ID", updatable = false)
    private Habit habit;

    private String memo;
    private  Long workTime;

    public HabitTracker() {}

    //    Need to setup different options for tracker update

    // create a new habit
    public HabitTracker(Habit habit,
                        Long workTime,
                        String memo) {
        this.habit = habit;
        this.workTime = workTime;
        this.memo = memo;
    }
}
