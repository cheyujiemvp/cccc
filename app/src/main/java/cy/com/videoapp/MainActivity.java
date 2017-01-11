package cy.com.videoapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cy.com.fragment.EssenceFragment;
import cy.com.fragment.LatestFragment;
import cy.com.fragment.MyFragment;
import cy.com.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    @ViewInject(R.id.main_bottom_rg1)
    private RadioGroup radioGroup;
    @ViewInject(R.id.main_bottom_rg11)
    private RadioGroup text_rg;
    RadioButton childAt;
    private FragmentManager manager;
    private FragmentTransaction ft;
    EssenceFragment essenceFragment;
    LatestFragment latestFragment;
    NewsFragment newsFragment;
    MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        radioGroup.setOnCheckedChangeListener(this);
        text_rg.setOnCheckedChangeListener(this);
        manager = getSupportFragmentManager();
        ft = manager.beginTransaction();
        essenceFragment = new EssenceFragment();
        latestFragment = new LatestFragment();
        newsFragment = new NewsFragment();
        myFragment = new MyFragment();
        ft.add(R.id.mian_ll, essenceFragment);
        ft.add(R.id.mian_ll, latestFragment);
        ft.add(R.id.mian_ll, newsFragment);
        ft.add(R.id.mian_ll, myFragment);
        ft.show(essenceFragment);
        ft.hide(latestFragment);
        ft.hide(newsFragment);
        ft.hide(myFragment);
        ft.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


        switch (checkedId) {
            case R.id.mian_rb1:
                childAt = (RadioButton) text_rg.getChildAt(0);
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.show(essenceFragment);
                transaction.hide(latestFragment);
                transaction.hide(newsFragment);
                transaction.hide(myFragment);
                transaction.commit();
                break;
            case R.id.mian_rb2:
                childAt = (RadioButton) text_rg.getChildAt(1);
                FragmentTransaction transaction1 = manager.beginTransaction();
                transaction1.hide(essenceFragment);
                transaction1.show(latestFragment);
                transaction1.hide(newsFragment);
                transaction1.hide(myFragment);
                transaction1.commit();
                break;
            case R.id.mian_rb3:
                childAt = (RadioButton) text_rg.getChildAt(2);

                break;
            case R.id.mian_rb4:
                childAt = (RadioButton) text_rg.getChildAt(3);
                FragmentTransaction transaction2 = manager.beginTransaction();
                transaction2.hide(essenceFragment);
                transaction2.hide(latestFragment);
                transaction2.show(newsFragment);
                transaction2.hide(myFragment);
                transaction2.commit();
                break;
            case R.id.mian_rb5:
                childAt = (RadioButton) text_rg.getChildAt(4);
                FragmentTransaction transaction3 = manager.beginTransaction();
                transaction3.hide(essenceFragment);
                transaction3.hide(latestFragment);
                transaction3.hide(newsFragment);
                transaction3.show(myFragment);
                transaction3.commit();
                break;

        }
        childAt.setChecked(true);
    }
}
