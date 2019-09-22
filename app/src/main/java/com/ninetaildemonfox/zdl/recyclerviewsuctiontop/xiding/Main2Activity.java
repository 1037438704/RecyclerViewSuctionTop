package com.ninetaildemonfox.zdl.recyclerviewsuctiontop.xiding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ninetaildemonfox.zdl.recyclerviewsuctiontop.R;
import com.ninetaildemonfox.zdl.recyclerviewsuctiontop.xiding.adp.LeftAdp;
import com.ninetaildemonfox.zdl.recyclerviewsuctiontop.xiding.adp.RecyclerViewAdapter;
import com.ninetaildemonfox.zdl.recyclerviewsuctiontop.xiding.bean.Bean;
import com.ninetaildemonfox.zdl.recyclerviewsuctiontop.xiding.utils.StickHeaderDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView recyclerView;
    private LeftAdp leftAdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        left();
        right();
    }

    private void right() {
        mRecyclerView = findViewById(R.id.rv_list);
        final List<Bean> beanList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            beanList.add(new Bean(String.format("第一组%d号", i + 1), "第一组"));
        }
        for (int i = 0; i < 6; i++) {
            beanList.add(new Bean(String.format("第二组%d号", i + 1), "第二组"));
        }
        for (int i = 0; i < 6; i++) {
            beanList.add(new Bean(String.format("第三组%d号", i + 1), "第三组"));
        }
        for (int i = 0; i < 10; i++) {
            beanList.add(new Bean(String.format("第四组%d号", i + 1), "第四组"));
        }
        for (int i = 0; i < 10; i++) {
            beanList.add(new Bean(String.format("第五组%d号", i + 1), "第五组"));
        }

        mAdapter = new RecyclerViewAdapter(this, beanList);
        mRecyclerView.addItemDecoration(new StickHeaderDecoration(this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取最后一个可见view的位置
                    int lastItemPosition = linearManager.findLastVisibleItemPosition();
                    //获取第一个可见view的位置
                    int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    //0~5  第一个
//                    if (0 <= firstItemPosition || firstItemPosition < 6) {
//                        firstItemPosition = 0;
//                    } else if (6 <= firstItemPosition || firstItemPosition < 12) {
//                        firstItemPosition = 1;
//                    } else if (12 <= firstItemPosition || firstItemPosition < 18) {
//                        firstItemPosition = 2;
//                    } else if (18 <= firstItemPosition || firstItemPosition < 28) {
//                        firstItemPosition = 3;
//                    } else if (28 <= firstItemPosition || firstItemPosition <= 38) {
//                        firstItemPosition = 4;
//                    }
                    Bean bean = beanList.get(firstItemPosition);

                    List<Map<String, String>> data = leftAdp.getData();
                    String groupName = bean.getGroupName();
                    for (int i = 0; i < data.size(); i++) {
                        if (groupName.equals(data.get(i).get("name"))) {
                            data.get(i).put("type", "2");
                            leftAdp.notifyDataSetChanged();
                        }else {
                            data.get(i).put("type", "1");
                        }
                    }
                }
            }
        });
    }

    private void left() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        leftAdp = new LeftAdp(R.layout.item_left);
        recyclerView.setAdapter(leftAdp);
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new ArrayMap<>();
        map1.put("name", "第一组");
        map1.put("type", "2");
        list.add(map1);

        Map<String, String> map2 = new ArrayMap<>();
        map2.put("name", "第二组");
        map2.put("type", "1");
        list.add(map2);

        Map<String, String> map3 = new ArrayMap<>();
        map3.put("name", "第三组");
        map3.put("type", "1");
        list.add(map3);

        Map<String, String> map4 = new ArrayMap<>();
        map4.put("name", "第四组");
        map4.put("type", "1");
        list.add(map4);

        Map<String, String> map5 = new ArrayMap<>();
        map5.put("name", "第五组");
        map5.put("type", "1");
        list.add(map5);

        leftAdp.setNewData(list);
        leftAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<Map<String, String>> list1 = leftAdp.getData();
                Map<String, String> map = list1.get(position);
                if (map.get("type").equals("1")) {
                    for (int i = 0; i < list1.size(); i++) {
                        list1.get(i).put("type", "1");
                    }
                    map.put("type", "2");
                }
                leftAdp.notifyDataSetChanged();
                //这里我自己找到自己的数据源第一组有多少个  所以我直接拿确定的参数
                if (position == 0) {
                    position = 0;
                } else if (position == 1) {
                    position = 6;
                } else if (position == 2) {
                    position = 12;
                } else if (position == 3) {
                    position = 18;
                } else if (position == 4) {
                    position = 28;
                }
                if (position != -1) {
                    mRecyclerView.scrollToPosition(position);
                    LinearLayoutManager mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(position, 0);
                }
            }
        });
    }
}
