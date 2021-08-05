package se.group2.Recepies;

import javax.persistence.*;

@Entity
public class FollowerCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private User follow;

    public FollowerCollection() {
    }

    public FollowerCollection(User user, User follow) {
        this.user = user;
        this.follow = follow;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollow() {
        return follow;
    }

    public void setFollow(User follow) {
        this.follow = follow;
    }
}
