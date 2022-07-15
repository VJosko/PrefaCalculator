package com.vudrag.prefacalculator;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vudrag.prefacalculator.databinding.PlayerNamesFragmentBinding;

public class PlayerNamesFragment extends Fragment {

    private PlayerNamesViewModel viewModel;

    public static PlayerNamesFragment newInstance() {
        return new PlayerNamesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        PlayerNamesFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.player_names_fragment,container, false);
        View view = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(PlayerNamesViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.setFragment(this);
        return view;
    }

    public void openScoresFragment(Party party){
        NavDirections action =
            PlayerNamesFragmentDirections.actionPlayerNamesFragmentToScoresFragment(party, 0);
        Navigation.findNavController(getView()).navigate(action);
    }

}