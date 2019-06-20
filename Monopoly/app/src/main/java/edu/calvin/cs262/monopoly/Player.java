package edu.calvin.cs262.monopoly;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "player_table")
public class Player {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "player")
    private String mPlayer;

    public Player(@NonNull String player) {this.mPlayer = player;}

    public String getPlayer(){return this.mPlayer;}
}