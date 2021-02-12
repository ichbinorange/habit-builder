package com.capstone.habitbuilder.friendship;

import com.capstone.habitbuilder.Auditable;
import com.capstone.habitbuilder.enjoyer.Enjoyer;
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
public class Friendship extends Auditable<String> {
    @Id
    @SequenceGenerator(
            name = "friendship_sequence",
            sequenceName = "friendship_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "friendship_sequence")

    @Column(updatable = false)
    private Long id;
    private Boolean activated = false;

    // Setup relationship with Enjoyer
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Enjoyer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUESTER_ID", referencedColumnName = "ID", updatable = false)
    private Enjoyer requester;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity = Enjoyer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "RECEIVER_ID", referencedColumnName = "ID", updatable = false)
    private Enjoyer receiver;

    public Friendship() {}

    public Friendship(Boolean activated) {
        this.activated = activated;
    }

}
