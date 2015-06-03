package com.example.najwa.isfragmentadded.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.najwa.isfragmentadded.R;
import com.example.najwa.isfragmentadded.custom.widget.CustomToast;

/**
 * Created by najwa on 5/30/2015.
 */
public class FragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        if (this.isAdded())
            CustomToast.makeText(getActivity(), "fragment added", Toast.LENGTH_SHORT).show();
        else if (this.isHidden())
            CustomToast.makeText(getActivity(), "fragment hidden", Toast.LENGTH_SHORT).show();
        else
            CustomToast.makeText(getActivity(), "fragment status unknown", Toast.LENGTH_SHORT).show();
        return view;
    }
}
