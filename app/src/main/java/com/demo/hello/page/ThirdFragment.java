package com.demo.hello.page;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String tiger="虎（学名：Panthera tigris ；英文名：Tiger）： 大型猫科动物；毛色浅黄或棕黄色，满身黑"
         +"色横纹；头圆、耳短，耳背面黑色，中央有一白斑甚显著；四肢健壮有力；尾粗长，具黑色环纹，尾端黑色。\n"
         +"老虎是典型的山地林栖动物，由南方的热带雨林、常绿阔叶林，以至北方的落叶阔叶林和针阔叶混交林，"
         +"都能很好的生活。在中国东北地区，也常出没于山脊、矮林灌丛和岩石较多或砾石塘等山地，以利于捕食。";
        TextView tv = getView().findViewById(R.id.tv3);
        tv.setText(tiger);
    }
}
