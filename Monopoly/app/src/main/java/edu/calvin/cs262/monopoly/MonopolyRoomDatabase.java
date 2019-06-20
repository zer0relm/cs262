package edu.calvin.cs262.monopoly;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Player.class}, version = 1, exportSchema = false)
public abstract class MonopolyRoomDatabase extends RoomDatabase {

    public abstract PlayerDao playerDao();
    private static MonopolyRoomDatabase INSTANCE;

    static MonopolyRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MonopolyRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MonopolyRoomDatabase.class, "monopoly_database")
                            // Wipes and rebuilds instead of migrating 
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Populate the database in the background.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PlayerDao mDao;
        String[] players = {"me", "The King", "Dog Breath"};

        PopulateDbAsync(MonopolyRoomDatabase db) {
            mDao = db.playerDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            // If we have no words, then create the initial list of words
            if (mDao.getAnyPlayer().length < 1) {
                for (int i = 0; i <= players.length - 1; i++) {
                    Player player = new Player(players[i]);
                    mDao.insert(player);
                }
            }
            return null;
        }
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

}