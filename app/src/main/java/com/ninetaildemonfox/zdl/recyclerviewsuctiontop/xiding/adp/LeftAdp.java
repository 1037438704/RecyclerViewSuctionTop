package com.ninetaildemonfox.zdl.recyclerviewsuctiontop.xiding.adp;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ninetaildemonfox.zdl.recyclerviewsuctiontop.R;

import java.util.List;
import java.util.Map;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2019/9/22
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author NineTailDemonFox
 */

public class LeftAdp extends BaseQuickAdapter<Map<String, String>, BaseViewHolder> {

    public LeftAdp(int item_left) {
        super(item_left);
    }

    @Override
    protected void convert(BaseViewHolder helper, Map<String, String> item) {
        helper.setText(R.id.text_name, item.get("name"));
        TextView text_name = helper.itemView.findViewById(R.id.text_name);
        String type = item.get("type");
        if (type.equals("1")) {
            text_name.setTextColor(ContextCompat.getColor(mContext, R.color.colorWhile));
            text_name.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorAccent));
        } else {
            text_name.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
            text_name.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhile));
        }
    }

}