package com.tool.jizhang

import android.os.Bundle
import com.tool.jizhang.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()


    }

    fun initData(){

    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}
