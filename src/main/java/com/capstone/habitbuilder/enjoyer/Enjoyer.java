package com.capstone.habitbuilder.enjoyer;

import com.capstone.habitbuilder.Auditable;
import com.capstone.habitbuilder.friendship.Friendship;
import com.capstone.habitbuilder.habit.Habit;
import com.capstone.habitbuilder.oauthapi.AuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@ToString
@Entity(name = "Enjoyer")
@Table
public class Enjoyer extends Auditable<String> {
    @Id
    @SequenceGenerator(
            name = "enjoyer_sequence",
            sequenceName = "enjoyer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "enjoyer_sequence")

    //    private Long chat-botId;   for later
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    private String password;

    private String imageUrl;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    private String about;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;
    private String providerId;

    // Setup one to many relationship with Habit
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity = Habit.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "enjoyer")
    private List<Habit> habits = new ArrayList<>();

    // Setup relationship with Friendship
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity = Friendship.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "requester")
    private Set<Friendship> friendRequesters = new HashSet<>();

    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity = Friendship.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "receiver")
    private Set<Friendship> friendReceivers = new HashSet<>();

    public Enjoyer() {}

    //    Need to setup different options for user update

    // create a user account
    public Enjoyer(String name,
                   String email,
                   String imageUrl,
                   String about) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.about = about;
    }
}
