package com.tool.jizhang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.tool.jizhang.base.BaseActivity
import com.xuexiang.xui.utils.WidgetUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()


    }

    fun initData(){
        val mingxi: TabLayout.Tab = mTabLayout.newTab()
        mTabLayout.addTab(mingxi)

        val count: TabLayout.Tab = mTabLayout.newTab()
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
        mTabLayout.addTab(reward)

        val my: TabLayout.Tab = mTabLayout.newTab()
        mTabLayout.addTab(my)


        mingxi.customView =(getTabView("明细",R.drawable.img_home_tab_mingxi));
        count.customView =(getTabView("统计",R.drawable.img_home_tab_count_g));
        reward.customView =(getTabView("福利",R.drawable.img_home_tab_reward_g));
        my.customView =(getTabView("我的",R.drawable.img_home_tab_my_g));
        WidgetUtils.setTabLayoutTextFont(mTabLayout)

       /* switchPage(ComponentsFragment::class.java)*/

        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
//                mAdapter.setSelected(tab.position)
                val view = tab.customView ?: return
                val img_title =
                    view?.findViewById(R.id.imageview) as ImageView
                when (tab.position) {
//                    MainActivity.POS_COMPONENTS -> switchPage(ComponentsFragment::class.java)
         /*           0 -> switchPage(UtilitiesFragment::class.java)
                    2 -> switchPage(ExpandsFragment::class.java)
                    else -> {
                    }*/
                    0->{
                        img_title.setImageResource(R.drawable.img_home_tab_mingxi)
                    }
                    1->{
                        img_title.setImageResource(R.drawable.img_home_tab_count)
                    }
                    4->{
                        img_title.setImageResource(R.drawable.img_home_tab_reward)
                    }
                    5->{
                        img_title.setImageResource(R.drawable.img_home_tab_my)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val view = tab.customView ?: return
                val img_title =
                    view.findViewById(R.id.imageview) as ImageView
                when (tab.position) {
                    0->{
                        img_title.setImageResource(R.drawable.img_home_tab_mingxi_g)
                    }
                    1->{
                        img_title.setImageResource(R.drawable.img_home_tab_count_g)
                    }
                    4->{
                        img_title.setImageResource(R.drawable.img_home_tab_reward_g)
                    }
                    5->{
                        img_title.setImageResource(R.drawable.img_home_tab_my_g)
                    }
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        btn_add.setOnClickListener {
            if(jizhang_manager.visibility==View.GONE){
                jizhang_manager.visibility = View.VISIBLE;
            }else{
                jizhang_manager.visibility = View.GONE;
            }
        }
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
    // Tab自定义view
    private fun getTabView(title: String?, image_src: Int): View? {
        val v: View =
            LayoutInflater.from(applicationContext).inflate(R.layout.tab_item_view, null)
        val textView = v.findViewById(R.id.textview) as TextView
        textView.text = title
        val imageView: ImageView = v.findViewById(R.id.imageview) as ImageView
        imageView.setImageResource(image_src)
        return v
    }
}
