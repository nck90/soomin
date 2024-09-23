package io.github.cuzurmyhabit;

public abstract class User {
    protected int room;
    protected int grade;
    protected int classRoom;
    protected String name;

    public User(int room, int grade, int classRoom, String name) {
        this.room = room;
        this.grade = grade;
        this.classRoom = classRoom;
        this.name = name;
    }

    public abstract boolean authenticate(int room, int grade, int classRoom, String name);
}