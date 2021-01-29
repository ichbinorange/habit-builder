package com.capstone.habitbuilder.habit;


import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    // Getter & Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Enjoyer getEnjoyer() {
        return enjoyer;
    }
    public void setEnjoyer(Enjoyer enjoyer) {
        this.enjoyer = enjoyer;
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
                ", enjoyer='" + enjoyer + '\'' +
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
