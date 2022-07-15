package com.vudrag.prefacalculator;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vudrag.prefacalculator.databinding.ResultFragmentBinding;

public class ResultFragment extends Fragment {

    private ResultViewModel viewModel;

    private Party party;

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ResultFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.result_fragment, container, false);
        View view = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(ResultViewModel.class);
        binding.setViewModel(viewModel);
        if(getArguments() != null){
            party = ResultFragmentArgs.fromBundle(getArguments()).getParty();
        }
        viewModel.setScoreBoard(party);
        return view;
    }

}