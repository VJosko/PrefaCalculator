package com.vudrag.prefacalculator;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vudrag.prefacalculator.databinding.ScoresFragmentBinding;

public class ScoresFragment extends Fragment {

    private static final String TAG = "ScoresFragment";

    private ScoresViewModel viewModel;
    ResultSingleton result;

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
        binding.setViewModel(viewModel);
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ScoresViewModel.class);
        viewModel.setFragment(this);

        result = ResultSingleton.getInstance();

        if(getArguments() != null){
            party = ScoresFragmentArgs.fromBundle(getArguments()).getParty();
            instanceNumber = ScoresFragmentArgs.fromBundle(getArguments()).getInstanceNumber();
        }

        Score score = getSavedScore(instanceNumber);
        if (score != null) {
            viewModel.setScore(score);
        }
        viewModel.setInstanceNumber(instanceNumber);
        viewModel.setNames(party, instanceNumber);
    }

    @Override
    public void onResume() {
        super.onResume();
        result.removeScores(viewModel.getScore(),instanceNumber);
    }

    public void saveScore(){
        Score score = viewModel.getScore();
        switch (instanceNumber){
            case 0:
                result.setFirstScore(score);
                break;
            case 1:
                result.setSecondScore(score);
                break;
            case 2:
                result.setThirdScore(score);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + instanceNumber);
        }
    }

    private Score getSavedScore(Integer instanceNumber){
        switch (instanceNumber){
            case 0:
                return result.getFirstScore();
            case 1:
                return result.getSecondScore();
            case 2:
                return result.getThirdScore();
            default:
                throw new IllegalStateException("Unexpected value: " + instanceNumber);
        }
    }
}