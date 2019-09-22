package com.ninetaildemonfox.zdl.recyclerviewsuctiontop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    private MainAdpRight adpRight;
    private List<XiDingBean> mData;

    private String image = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568994898659&di=44a60dc75f7c1b1ebbadff58359047b4&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fc3d32441738f566e4a4cfa7df4631d4648446b7a25c91-SG6G5V_fw658";

    private String CYM_CHAD = "哈哈哈";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new GridSectionAverageGapItemDecoration(50, 20, 20, 20));

        mData = new ArrayList<>();
        mData.add(new XiDingBean(true, "Section 1", true));
        mData.add(new XiDingBean(new VideoBean("", CYM_CHAD)));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(true, "Section 2", false));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(true, "Section 3", false));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(true, "Section 4", false));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(true, "Section 5", false));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));
        mData.add(new XiDingBean(new VideoBean(image, CYM_CHAD)));


        adpRight = new MainAdpRight(R.layout.item_section_content, R.layout.def_section_head, mData);
        recyclerView.setAdapter(adpRight);

    }
}
