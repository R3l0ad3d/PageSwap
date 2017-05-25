package com.example.r3l0ad3d.newapp;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.r3l0ad3d.newapp.databinding.FragmentPageSwapFramentBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageSwapFrament extends Fragment {

    private FragmentPageSwapFramentBinding binding;
    private List<String> item;
    private FragmentPageAdapter adapter;

    public PageSwapFrament() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_page_swap_frament, container, false);

        binding = DataBindingUtil.bind(view);

        item = new ArrayList<>();
        setItem();

        adapter = new FragmentPageAdapter(getContext(),item);
        binding.mViewpager.setAdapter(adapter);

        return view;
    }

    private void setItem() {
        for(int i=0;i<10;i++){
            String s="Fragment : "+i;
            item.add(s);
        }
    }

}
