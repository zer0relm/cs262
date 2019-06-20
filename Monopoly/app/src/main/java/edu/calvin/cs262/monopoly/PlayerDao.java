package edu.calvin.cs262.monopoly;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Player player);

    @Query("DELETE FROM player_table")
    void deleteAll();

    @Query("SELECT * from player_table ORDER BY player ASC")
    LiveData<List<Player>> getAllPlayers();

    @Query("SELECT * from player_table LIMIT 1")
    Player[] getAnyPlayer();

    @Delete
    void deletePlayer(Player player);

}