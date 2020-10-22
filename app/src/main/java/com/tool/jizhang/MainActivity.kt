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
        val component: TabLayout.Tab = mTabLayout.newTab()
        component.text = "组件"
        component.setIcon(if (SettingSPUtils.getInstance().isUseCustomTheme()) R.drawable.custom_selector_icon_tabbar_component else R.drawable.selector_icon_tabbar_component)
        mTabLayout.addTab(component)

        val util: TabLayout.Tab = mTabLayout.newTab()
        util.text = "工具"
        util.setIcon(if (SettingSPUtils.getInstance().isUseCustomTheme()) R.drawable.custom_selector_icon_tabbar_util else R.drawable.selector_icon_tabbar_util)
        mTabLayout.addTab(util)

        val expand: TabLayout.Tab = mTabLayout.newTab()
        expand.text = "拓展"
        expand.setIcon(if (SettingSPUtils.getInstance().isUseCustomTheme()) R.drawable.custom_selector_icon_tabbar_expand else R.drawable.selector_icon_tabbar_expand)
        mTabLayout.addTab(expand)

        WidgetUtils.setTabLayoutTextFont(mTabLayout)

       /* switchPage(ComponentsFragment::class.java)*/

        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                mAdapter.setSelected(tab.position)
                when (tab.position) {
/*                    MainActivity.POS_COMPONENTS -> switchPage(ComponentsFragment::class.java)
                    1 -> switchPage(UtilitiesFragment::class.java)
                    2 -> switchPage(ExpandsFragment::class.java)
                    else -> {
                    }*/
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}
