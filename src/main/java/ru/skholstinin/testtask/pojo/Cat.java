package ru.skholstinin.testtask.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cats")
public class Cat implements Serializable {
    private int id;
    private String name;
    private String ava_link;
    private int cnt_likes;

    public Cat() {
    }

    public Cat(int id, String name, String ava_link, int cnt_likes) {
        this.id = id;
        this.name = name;
        this.ava_link = ava_link;
        this.cnt_likes = cnt_likes;
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ava_link")
    public String getAva_link() {
        return ava_link;
    }

    public void setAva_link(String ava_link) {
        this.ava_link = ava_link;
    }

    @Column(name = "cnt_likes")
    public int getCnt_likes() {
        return cnt_likes;
    }

    public void setCnt_likes(int cnt_likes) {
        this.cnt_likes = cnt_likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id &&
                cnt_likes == cat.cnt_likes &&
                Objects.equals(name, cat.name) &&
                Objects.equals(ava_link, cat.ava_link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ava_link, cnt_likes);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ava_link='" + ava_link + '\'' +
                ", cnt_likes=" + cnt_likes +
                '}';
    }
}
