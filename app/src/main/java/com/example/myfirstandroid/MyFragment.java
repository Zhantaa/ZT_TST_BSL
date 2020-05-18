package com.example.myfirstandroid;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


@SuppressLint("NewApi")
public class MyFragment extends Fragment {

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  此处的布局文件是普通的线性布局
        View view = inflater.inflate(R.layout.fragment1, container, false);
        return view;
    }


}
