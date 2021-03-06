package com.example.gridview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ViewPagerFragment extends Fragment implements AdapterView.OnItemClickListener ,AdapterView.OnItemLongClickListener{

    int mNum;
    List<String> gridData;//一个Fragment的数据

    public ViewPagerFragment(int num,List<String> data) {
        //Log.i("ViewPagerFragment", num + "");
        gridData = data;
        mNum  = num;

    }
/*
    public static ViewPagerFragment newInstance(int num, List<String> data) {
        gridData = data;
        ViewPagerFragment f = new ViewPagerFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewpager_list, container, false);


        GridView gridView = (GridView) v.findViewById(R.id.gridview);
        gridView.setAdapter(new GridViewAdapter(getContext(), gridData));
        gridView.setOnItemClickListener(this);//点击事件
        gridView.setOnItemLongClickListener(this);//长按事件

      /*  View noitem = v.findViewById(R.id.empty);
        noitem.setVisibility(View.GONE);*/

        TextView tv = (TextView)v.findViewById(R.id.text);
        tv.setText("Fragment #" + mNum);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), gridData.get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "长按："+gridData.get(position), Toast.LENGTH_SHORT).show();
        return true;
    }
}

