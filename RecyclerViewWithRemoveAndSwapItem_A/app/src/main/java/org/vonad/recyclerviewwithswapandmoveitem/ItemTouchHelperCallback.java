package org.vonad.recyclerviewwithswapandmoveitem;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * ---- Description by VO NAD------
 **/
public class ItemTouchHelperCallback
        extends ItemTouchHelper.Callback {
    // adapter call.
    private final SwapAdapter mAdapter;

    public ItemTouchHelperCallback(SwapAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView,
                                RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags,
                                 swipeFlags);
    }

    @Override
    public boolean onMove(final RecyclerView recyclerView,
                          final RecyclerView.ViewHolder viewHolder,
                          final RecyclerView.ViewHolder target) {
//        // set item move to adapter.
        mAdapter.onItemMove(viewHolder.getAdapterPosition(),
                            target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder,
                         int direction) {
        // set swiped.
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

}
