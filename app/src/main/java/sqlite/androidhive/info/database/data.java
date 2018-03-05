package sqlite.androidhive.info.database;

import java.util.Date;

/**
 * Created by mathi on 02-03-2018.
 */

public class data {
    int id;
    Date time;
    long shock;

    // constructors
    public Data() {
    }

    public Todo(int id, Date time, long shock) {
        this.id = id;
        this.time = time;
        this.shock = shock;
    }

    public Todo(Date time, long shock) {
        this.time = time;
        this.shock = shock;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setShock(int shock) {this.shock = shock;}



    // getters
    public int getId() {
        return this.id;
    }

    public Date getTime() {
        return this.time;
    }

    public long getShock() {
        return this.shock;
}
