package com.tool.jizhang.views.fg;

import com.tool.jizhang.base.MingXiBaseFragment;
import com.xuexiang.xpage.AppPageConfig;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.enums.CoreAnim;
import com.xuexiang.xpage.model.PageInfo;

import java.util.List;

@Page(name = "明细", anim = CoreAnim.none)
public class MingXiFragment extends MingXiBaseFragment {

    @Override
    protected List<PageInfo> getPageContents() {
        return AppPageConfig.getInstance().getComponents();
    }

}
