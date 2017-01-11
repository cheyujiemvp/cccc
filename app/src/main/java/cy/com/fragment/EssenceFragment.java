package cy.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cy.com.adapter.EssenceAdapter;
import cy.com.videoapp.R;

/**
 * Created by Administrator on 2017/1/10.
 */

public class EssenceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.essence,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager vp = (ViewPager) view.findViewById(R.id.essence_vp);
        TabLayout tab = (TabLayout) view.findViewById(R.id.essence_tb);
        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new VideoFragment());
        fragmentList.add(new ImgFragment());
        fragmentList.add(new DuanziFragment());
        fragmentList.add(new YuanChuangFragment());
        fragmentList.add(new WanghongFragment());
        fragmentList.add(new PaiHangFragment());
        fragmentList.add(new SheHuiFragment());
        fragmentList.add(new MeinvFragment());
        fragmentList.add(new LenzhishiFragment());
        fragmentList.add(new GameFragment());
        EssenceAdapter essenceAdapter=new EssenceAdapter(getFragmentManager(),fragmentList);
        vp.setAdapter(essenceAdapter);
        tab.setupWithViewPager(vp);
    }
}
