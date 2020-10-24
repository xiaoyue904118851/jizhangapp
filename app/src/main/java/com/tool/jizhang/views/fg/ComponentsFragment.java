package com.tool.jizhang.views.fg;

import com.tool.jizhang.base.BaseHomeFragment;
import com.xuexiang.xpage.AppPageConfig;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.enums.CoreAnim;
import com.xuexiang.xpage.model.PageInfo;

import java.util.List;

/**
 * 组件的主要界面
 *
 * @author xuexiang
 * @since 2018/11/14 下午2:22
 */
@Page(name = "组件", anim = CoreAnim.none)
public class ComponentsFragment extends BaseHomeFragment {

    @Override
    protected List<PageInfo> getPageContents() {
        return AppPageConfig.getInstance().getComponents();
    }

}
