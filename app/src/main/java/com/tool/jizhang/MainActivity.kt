package com.tool.jizhang

import android.os.Bundle
import android.util.SparseArray
import com.google.android.material.tabs.TabLayout
import com.tool.jizhang.base.BaseActivity
import com.tool.jizhang.utils.SettingSPUtils
import com.xuexiang.xui.utils.WidgetUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()


    }

    fun initData(){
        val mingxi: TabLayout.Tab = mTabLayout.newTab()
        mingxi.text = "明细"
        mingxi.setIcon(R.drawable.img_home_tab_mingxi_g)
        mTabLayout.addTab(mingxi)

        val count: TabLayout.Tab = mTabLayout.newTab()
        count.text = "统计"
        count.setIcon(R.drawable.img_home_tab_count_g)
        mTabLayout.addTab(count)

        val kongbai: TabLayout.Tab = mTabLayout.newTab()
        kongbai.text = ""
        kongbai.setIcon(R.drawable.img_home_kongbai)
        mTabLayout.addTab(kongbai)

        val kongbai1: TabLayout.Tab = mTabLayout.newTab()
        kongbai1.text = ""
        kongbai1.setIcon(R.drawable.img_home_kongbai)
        mTabLayout.addTab(kongbai1)

        val reward: TabLayout.Tab = mTabLayout.newTab()
        reward.text = "福利"
        reward.setIcon(R.drawable.img_home_tab_reward_g)
        mTabLayout.addTab(reward)

        val my: TabLayout.Tab = mTabLayout.newTab()
        my.text = "我的"
        my.setIcon(R.drawable.img_home_tab_my_g)
        mTabLayout.addTab(my)

        WidgetUtils.setTabLayoutTextFont(mTabLayout)

       /* switchPage(ComponentsFragment::class.java)*/

        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
//                mAdapter.setSelected(tab.position)
                when (tab.position) {
//                    MainActivity.POS_COMPONENTS -> switchPage(ComponentsFragment::class.java)
         /*           0 -> switchPage(UtilitiesFragment::class.java)
                    2 -> switchPage(ExpandsFragment::class.java)
                    else -> {
                    }*/
                    0->{
                        tab.setIcon(R.drawable.img_home_tab_mingxi)
                    }
                    1->{
                        tab.setIcon(R.drawable.img_home_tab_count)
                    }
                    4->{
                        tab.setIcon(R.drawable.img_home_tab_reward)
                    }
                    5->{
                        tab.setIcon(R.drawable.img_home_tab_my)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0->{
                        tab.setIcon(R.drawable.img_home_tab_mingxi_g)
                    }
                    1->{
                        tab.setIcon(R.drawable.img_home_tab_count_g)
                    }
                    4->{
                        tab.setIcon(R.drawable.img_home_tab_reward_g)
                    }
                    5->{
                        tab.setIcon(R.drawable.img_home_tab_my_g)
                    }
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}
