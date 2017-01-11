package cy.com.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */

public class EssenceAdapter extends FragmentStatePagerAdapter {
    private String[] tabs={"推荐","视频","图片","段子","原创","网红","排行","社会","美女","冷知识","游戏"};
    private List<Fragment> list;
    public EssenceAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
