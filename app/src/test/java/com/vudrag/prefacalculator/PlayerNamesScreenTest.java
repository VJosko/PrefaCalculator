package com.vudrag.prefacalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerNamesScreenTest {

    private Party testParty = new Party();
    PlayerNamesViewModel playerNamesViewModel = new PlayerNamesViewModel();

    @Before
    public void initParty(){
        testParty.setPlayerOne("one");
        testParty.setPlayerTwo("two");
        testParty.setPlayerThree("three");
    }

    @Test
    public void setPartyTest(){

        playerNamesViewModel.setParty(testParty);
        Party party = playerNamesViewModel.getParty();

        assertNotNull(party);
        assertEquals(party, testParty);
    }
}
