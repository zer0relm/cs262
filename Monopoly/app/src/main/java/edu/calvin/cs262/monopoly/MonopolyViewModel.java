package edu.calvin.cs262.monopoly;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class MonopolyViewModel extends AndroidViewModel {

    private MonopolyRepository mRepository;

    private LiveData<List<Player>> mAllPlayers;

    public MonopolyViewModel (Application application) {
        super(application);
        mRepository = new MonopolyRepository(application);
        mAllPlayers = mRepository.getAllPlayers();
    }

    LiveData<List<Player>> getAllPlayers() { return mAllPlayers; }

    public void insert(Player player) { mRepository.insert(player); }

    public void deleteAll() {mRepository.deleteAll();}

    public void deletePlayer(Player player) {mRepository.deletePlayer(player);}

}