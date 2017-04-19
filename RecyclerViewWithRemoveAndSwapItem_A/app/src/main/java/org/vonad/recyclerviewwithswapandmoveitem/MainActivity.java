package org.vonad.recyclerviewwithswapandmoveitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recySwapDemo = (RecyclerView) findViewById(R.id.recySwapDemo);

        //  adapter
        SwapAdapter swapAdapter = new SwapAdapter();
        recySwapDemo.setLayoutManager(new LinearLayoutManager(this,
                                                              LinearLayoutManager.VERTICAL,
                                                              false));
        // attach swap.
        ItemTouchHelper mItemTouchHelper =
                new ItemTouchHelper(new ItemTouchHelperCallback(swapAdapter));
        mItemTouchHelper.attachToRecyclerView(recySwapDemo);

        recySwapDemo.setAdapter(swapAdapter);
        // fill data.
        swapAdapter.fillData(getListData());
    }

    private List<SwapModel> getListData() {
        List<SwapModel> swapModelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SwapModel swapModel = new SwapModel("Name :" + i);
            swapModelList.add(swapModel);
        }
        return swapModelList;
    }
}
