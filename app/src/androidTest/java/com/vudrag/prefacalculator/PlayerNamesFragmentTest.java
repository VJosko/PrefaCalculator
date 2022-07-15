package com.vudrag.prefacalculator;

import static androidx.test.espresso.Espresso.onView;

import androidx.annotation.IdRes;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import android.os.Bundle;

@RunWith(AndroidJUnit4.class)
public class PlayerNamesFragmentTest {

    @Test
    public void testNavigationToInScoresFragment() {

        // Create a TestNavHostController
        /*TestNavHostController navController = new TestNavHostController(
                ApplicationProvider.getApplicationContext());

        // Create a graphical FragmentScenario for the TitleScreen
        Bundle args = new Bundle();
        FragmentScenario<PlayerNamesFragment> playerNamesScenario = FragmentScenario.launchInContainer(PlayerNamesFragment.class).moveToState(Lifecycle.State.STARTED);

        playerNamesScenario.onFragment(fragment -> {
            // Set the graph on the TestNavHostController
            navController.setGraph(R.navigation.navigation);

            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController);
        });

        // Verify that performing a click changes the NavController’s state
        onView(ViewMatchers.withId(R.id.player_names_next)).perform(ViewActions.click());
        assertEquals(navController.getCurrentDestination().getId(), R.id.resultFragment);*/
    }


}
