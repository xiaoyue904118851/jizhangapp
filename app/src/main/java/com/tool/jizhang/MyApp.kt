package com.tool.jizhang

import android.app.Application
import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import com.tool.jizhang.utils.SettingSPUtils
import com.xuexiang.xui.XUI

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        //解决4.x运行崩溃的问题
        MultiDex.install(this)
    }
    /**
     * 初始化XUI 框架
     */
    private fun initUI() {
        XUI.init(this)
        XUI.debug(isDebug())
/*        if (SettingSPUtils.getInstance().isUseCustomFont()) { //设置默认字体为华文行楷
            XUI.initFontStyle("fonts/hwxk.ttf")
        }*/
/*        PictureFileUtils.setAppName("xui")
        //字体图标库
        Iconics.init(this)
        //这是自己定义的图标库
        Iconics.registerFont(XUIIconFont())
        CameraView.setICameraStrategy(AutoCameraStrategy(1920 * 1080))*/
    }
    fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}