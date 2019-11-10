package ru.skholstinin.testtask.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "liked_cats")
public class LikedCat implements Serializable {
    private int id;
    private int userId;
    private int catsId;

    public LikedCat() {
    }

    public LikedCat(int userId, int catsId, int id) {
        this.userId = userId;
        this.catsId = catsId;
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "cats_id")
    public int getCatsId() {
        return catsId;
    }

    public void setCatsId(int catsId) {
        this.catsId = catsId;
    }
}
