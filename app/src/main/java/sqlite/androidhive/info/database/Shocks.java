package sqlite.androidhive.info.database;

import java.util.Date;

/**
 * Created by mathi on 02-03-2018.
 */

public class Shocks {

    int id;
    Date time;
    long shockStrenght;

    // constructors
    public Shocks() {
    }

    public Shocks(int id, Date time, long shockStrenght) {
        this.id = id;
        this.time = time;
        this.shockStrenght = shockStrenght;
    }

    public Shocks(Date time, long shock) {
        this.time = time;
        this.shockStrenght = shockStrenght;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setShockStrenght(long shockStrenght) {this.shockStrenght = shockStrenght;}



    // getters
    public int getId() {
        return this.id;
    }

    public Date getTime() {
        return this.time;
    }

    public long getShock() {
        return this.shockStrenght;
    }
}
