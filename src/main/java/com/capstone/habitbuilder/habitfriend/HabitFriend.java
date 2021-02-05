package com.capstone.habitbuilder.habitfriend;

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
public class HabitFriend extends Auditable<String> {
    @Id
    @SequenceGenerator(
            name = "habitFriend_sequence",
            sequenceName = "habitFriend_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "habitFriend_sequence")

    @Column(updatable = false)
    private Long id;
    private Boolean liked = false; // like is reserved keyword for psql

    // Setup many to one relationship with Habit --> belongs to owner
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Habit.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "HABIT_ID", referencedColumnName = "ID", updatable = false)
    private Habit habit;

    // Friend and habit relation setup?

    public HabitFriend() {}
    // create a new habitFriend
    public HabitFriend(Habit habit,
                       Boolean liked) {
        this.habit = habit;
        this.liked = liked;
    }
}
