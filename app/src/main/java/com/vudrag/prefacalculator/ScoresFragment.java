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

import com.vudrag.prefacalculator.databinding.ScoresFragmentBinding;

public class ScoresFragment extends Fragment {

    private ScoresViewModel viewModel;

    private Integer instanceNumber;
    private Party party;

    public static ScoresFragment newInstance() {
        return new ScoresFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ScoresFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.scores_fragment, container, false);
        View view = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(ScoresViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.setFragment(this);
        if(getArguments() != null){
            party = ScoresFragmentArgs.fromBundle(getArguments()).getParty();
            instanceNumber = ScoresFragmentArgs.fromBundle(getArguments()).getInstanceNumber();
        }
        viewModel.setNames(party, instanceNumber);
        return view;
    }

    public void openScoresFragment(){
        NavDirections action =
                ScoresFragmentDirections.actionScoresFragmentSelf(party, instanceNumber + 1);
        Navigation.findNavController(getView()).navigate(action);
    }

    public void openResultFragment(){
        NavDirections action =
                ScoresFragmentDirections.actionScoresFragmentToResultFragment(party);
        Navigation.findNavController(getView()).navigate(action);
    }


}