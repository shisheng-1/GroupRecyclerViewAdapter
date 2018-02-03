package com.sunfusheng.adapter.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.sunfusheng.adapter.sample.adapter.HeaderGroupAdapter;
import com.sunfusheng.adapter.sample.util.GroupData;
import com.sunfusheng.adapter.sample.util.Utils;

/**
 * @author sunfusheng on 2018/2/3.
 */
public class AddDeleteUpdateActivity extends AppCompatActivity {

    private HeaderGroupAdapter mAdapter;

    private String[] new_insert_group = {"插入的新组", "a", "b", "c"};
    private String new_insert_item = "插入的新组项";
    private String[] new_insert_items = {"插入的新组项1", "插入的新组项2", "插入的新组项3"};

    private String[] new_update_group = {"更新的新组", "a", "b", "c"};
    private String new_update_item = "更新的新组项";
    private String[] new_update_items = {"更新的新组项1", "更新的新组项2", "更新的新组项3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler_view);

        setTitle(R.string.add_delete_update);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HeaderGroupAdapter(this, GroupData.items);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener((adapter, holder, groupPosition, childPosition) -> {
            String header = mAdapter.getItem(groupPosition, 0);
            String child = mAdapter.getItem(groupPosition, childPosition);
            Utils.toast(this, header + " : " + child +
                    "\ngroupPosition: " + groupPosition +
                    "\nchildPosition: " + childPosition);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_delete_update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_group:
                mAdapter.insertGroup(1, new_insert_group);
                break;
            case R.id.add_item:
                mAdapter.insertItem(1, 1, new_insert_item);
                break;
            case R.id.add_items:
                mAdapter.insertItems(1, 1, new_insert_items);
                break;
            case R.id.delete_group:

                break;
            case R.id.delete_item:

                break;
            case R.id.delete_items:

                break;
            case R.id.update_group:

                break;
            case R.id.update_item:

                break;
            case R.id.update_items:

                break;
        }
        return true;
    }
}
