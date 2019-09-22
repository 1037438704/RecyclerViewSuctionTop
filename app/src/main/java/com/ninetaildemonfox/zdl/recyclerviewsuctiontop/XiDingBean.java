package com.ninetaildemonfox.zdl.recyclerviewsuctiontop;

import android.provider.MediaStore;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/9/20
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class XiDingBean extends SectionEntity<VideoBean>{
    private boolean isMore;

    public XiDingBean(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.isMore = isMore;
    }
    public XiDingBean(VideoBean t) {
        super(t);
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean mroe) {
        isMore = mroe;
    }
}
