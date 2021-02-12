package com.capstone.habitbuilder.habitmsg;

import com.capstone.habitbuilder.Auditable;
import com.capstone.habitbuilder.enjoyer.Enjoyer;
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
public class HabitMsg extends Auditable<String> {
    @Id
    @SequenceGenerator(
            name = "habitMsg_sequence",
            sequenceName = "habitMsg_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "habitMsg_sequence")

    @Column(updatable = false)
    private Long id;
    private String text;

    // Setup many to one relationship with Habit
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Habit.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "HABIT_ID", referencedColumnName = "ID", updatable = false)
    private Habit habit;

    // Friend and habitMsg relation setup?
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Enjoyer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "FRIEND_ID", referencedColumnName = "ID", updatable = false)
    private Enjoyer friend;

    public HabitMsg() {}
    // create a new habitMsg
    public HabitMsg(Habit habit,
                    String text) {
        this.habit = habit;
        this.text = text;
    }
}
