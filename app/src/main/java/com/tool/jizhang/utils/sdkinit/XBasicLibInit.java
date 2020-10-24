/*
 * Copyright (C) 2019 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tool.jizhang.utils.sdkinit;

import android.app.Application;
import android.content.Context;

import com.tool.jizhang.BuildConfig;
import com.tool.jizhang.MyApp;
import com.tool.jizhang.base.BaseActivity;
import com.tool.jizhang.base.db.InternalDataBase;
import com.tool.jizhang.utils.XToastUtils;
import com.xuexiang.xaop.XAOP;

import com.xuexiang.xaop.util.PermissionUtils;
import com.xuexiang.xormlite.logs.DBLog;
import com.xuexiang.xpage.AppPageConfig;
import com.xuexiang.xpage.PageConfig;
import com.xuexiang.xpage.PageConfiguration;
import com.xuexiang.xpage.model.PageInfo;
import com.xuexiang.xrouter.launcher.XRouter;
import com.xuexiang.xutil.XUtil;
import com.xuexiang.xutil.common.StringUtils;

import java.util.List;

/**
 * X系列基础库的初始化
 *
 * @author xuexiang
 * @since 2019-07-06 9:24
 */
public final class XBasicLibInit {

    private XBasicLibInit() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化基础库
     */
    public static void init(Application application) {
        initUtils(application);
        initPage(application);
        initAOP(application);
        initRouter(application);
        initDB(application);
    }

    /**
     * 初始化工具类
     *
     * @param application
     */
    private static void initUtils(Application application) {
        XUtil.init(application);
        XUtil.debug(isDebug());
        //百度定位
    }


    /**
     * 初始化XPage页面框架
     *
     * @param application
     */
    private static void initPage(Application application) {
        //自动注册页面
        PageConfig.getInstance()
                .setPageConfiguration(new PageConfiguration() { //页面注册
                    @Override
                    public List<PageInfo> registerPages(Context context) {
                        //自动注册页面,是编译时自动生成的，build一下就出来了。如果你还没使用@Page的话，暂时是不会生成的。
                        return AppPageConfig.getInstance().getPages(); //自动注册页面
                    }
                })
                .debug(isDebug() ? "PageLog" : null)
                .setContainActivityClazz(BaseActivity.class)
                .enableWatcher(isDebug())
                .init(application);
    }
    private static Boolean isDebug() {
        return BuildConfig.DEBUG;
    }
    /**
     * 初始化XAOP切片框架
     *
     * @param application
     */
    private static void initAOP(Application application) {
        //初始化插件
        XAOP.init(application);
        //日志打印切片开启
        XAOP.debug(isDebug());
        //设置动态申请权限切片 申请权限被拒绝的事件响应监听
        //设置动态申请权限切片 申请权限被拒绝的事件响应监听
        XAOP.setOnPermissionDeniedListener(new PermissionUtils.OnPermissionDeniedListener() {
            @Override
            public void onDenied(List<String> permissionsDenied) {
                XToastUtils.error("权限申请被拒绝:" + StringUtils.listToString(permissionsDenied, ","));
            }
        });
    }

    /**
     * 初始化XRouter路由
     *
     * @param application
     */
    private static void initRouter(Application application) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (isDebug()) {
            XRouter.openLog();     // 打印日志
            XRouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        XRouter.init(application);
    }

    /**
     * 初始化数据库框架
     *
     * @param application
     */
    private static void initDB(Application application) {
/*        XUIDataBaseRepository.getInstance()
                //设置内部存储的数据库实现接口
                .setIDatabase(new InternalDataBase())
                .init(application);
        DBLog.debug(isDebug());*/
    }

//    /**
//     * 初始化video的存放路径[xvideo项目太大，去除]
//     */
//    public static void initVideo() {
//        XVideo.setVideoCachePath(PathUtils.getExtDcimPath() + "/xvideo/");
//        // 初始化拍摄
//        XVideo.initialize(false, null);
//    }


}
