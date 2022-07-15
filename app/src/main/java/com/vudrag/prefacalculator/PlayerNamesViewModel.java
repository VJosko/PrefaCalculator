package com.vudrag.prefacalculator;

import androidx.lifecycle.ViewModel;

public class PlayerNamesViewModel extends ViewModel {

    private PlayerNamesFragment fragment;

    private Party party;

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public void setFragment(PlayerNamesFragment fragment){
        this.fragment = fragment;
    }

    public PlayerNamesViewModel() {
        party = new Party();
    }

    public void logPlayers(){
        party.fillEmptyNames(fragment.getContext());
        fragment.openScoresFragment(party);
    }
}