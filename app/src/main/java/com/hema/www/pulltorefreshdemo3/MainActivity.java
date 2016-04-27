package com.hema.www.pulltorefreshdemo3;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String > items = new ArrayList<>();
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PullToRefreshListView listView =
                (PullToRefreshListView) findViewById(R.id.pull_to_refresh_listview);
        
        geneItems();

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        geneItems();
                        adapter.notifyDataSetChanged();

                        listView.onRefreshComplete();
                    }
                }, 2500);
            }
        });
    }

    private void geneItems() {
        for (int i = 0; i < 10; i++) {
            items.add("Test Item #" + index++);
        }
    }
}
