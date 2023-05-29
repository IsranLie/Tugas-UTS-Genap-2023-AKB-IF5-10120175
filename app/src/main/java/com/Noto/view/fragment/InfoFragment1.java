package com.Noto.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.Noto.R;

public class InfoFragment1 extends Fragment { //10120175 - I Wayan Widi P - IF5 - May 2023
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_info_slide1, container, false);
        return rootView;
    }
}

