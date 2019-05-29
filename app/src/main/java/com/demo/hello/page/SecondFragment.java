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
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String bear="熊（英文名称：Bears）：是食肉目熊科动物的通称，熊平时还算温和，但是受到挑衅或遇到危险时，"
                +"容易暴怒，打斗起来非常凶猛。虽然一般人把熊看做是危险的动物，但在马戏团或动物园中，却是相当受"
                +"人喜爱的。分布在北半球。在南半球，除了南美洲北部外，其他地方没有它的踪迹。熊科是个大家族，可"
                +"分为4属：懒熊属 、眼镜熊属、马来熊属、熊属，8种。";
        TextView tv = getView().findViewById(R.id.tv2);
        tv.setText(bear);
    }
}
