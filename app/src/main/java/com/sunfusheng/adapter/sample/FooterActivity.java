package com.sunfusheng.adapter.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sunfusheng.adapter.sample.adapter.FooterGroupAdapter;
import com.sunfusheng.adapter.sample.util.GroupData;
import com.sunfusheng.adapter.sample.util.Utils;

/**
 * @author sunfusheng on 2018/2/3.
 */
public class FooterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler_view);

        setTitle(R.string.footer);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FooterGroupAdapter footerAdapter = new FooterGroupAdapter(this, GroupData.items);
        recyclerView.setAdapter(footerAdapter);

        footerAdapter.setOnItemClickListener((adapter, holder, groupPosition, childPosition) -> {
            Utils.toast(this, "groupPosition: " + groupPosition + "\nchildPosition: " + childPosition);
        });

    }
}
