package com.capstone.habitbuilder.habit;


import com.capstone.habitbuilder.enjoyer.Enjoyer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Habit {
    @Id
    @SequenceGenerator(
            name = "habit_sequence",
            sequenceName = "habit_squence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "habit_sequence")

//    private Long userId;   for to connect with User table
    private Long id;
    private String title;
    private String goal;
    private String description;
    private String streak;
    private Boolean reminder;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    // Setup many to one relationship with Enjoyer
    @ManyToOne
    @JoinColumn(name = "ENJOYER_ID", referencedColumnName = "ID" )
    private Enjoyer enjoyer;

    public Habit() {}

    // create a new habit
    public Habit(String title,
                 String goal,
                 String description,
                 String streak,
                 Boolean reminder) {
        this.title = title;
        this.goal = goal;
        this.description = description;
        this.streak = streak;
        this.reminder = reminder;
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreak() {
        return streak;
    }

    public void setStreak(String streak) {
        this.streak = streak;
    }

    public Boolean getReminder() {
        return reminder;
    }

    public void setReminder(Boolean reminder) {
        this.reminder = reminder;
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
        return "Habit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", goal='" + goal + '\'' +
                ", description='" + description + '\'' +
                ", streak='" + streak + '\'' +
                ", reminder='" + reminder + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
