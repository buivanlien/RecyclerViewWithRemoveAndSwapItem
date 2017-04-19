package org.vonad.recyclerviewwithswapandmoveitem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * ---- Description by VO NAD------
 **/
public class SwapAdapter
        extends RecyclerView.Adapter<SwapAdapter.MyViewHolder> {
    private List<SwapModel> mListModels;

    public SwapAdapter() {
    }

    /**
     * input  data from outside.
     */
    public void fillData(List<SwapModel> dataModels) {
        if (dataModels == null) {
            dataModels = new ArrayList<>();
        }
        if (mListModels == null) {
            mListModels = new ArrayList<>();
        }
        this.mListModels.clear();
        this.mListModels.addAll(dataModels);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        int LAYOUT_RES = R.layout.item_swap;
        View itemView = LayoutInflater.from(parent.getContext())
                                      .inflate(LAYOUT_RES,
                                               parent,
                                               false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,
                                 int position) {

        //fill data to view.
        fillDataToView(holder,
                       mListModels,
                       position);
    }

    @Override
    public int getItemCount() {
        return mListModels == null ?
               0 :
               mListModels.size();
    }

    /**
     * fill data.
     */
    private void fillDataToView(final MyViewHolder viewHolder,
                                final List<SwapModel> listModels,
                                final int position) {
        if (viewHolder == null || listModels == null) {
            return;
        }
        viewHolder.tvItemSwap.setText(listModels.get(position)
                                                .getName());

    }


    public boolean onItemMove(final int fromPosition,
                              final int toPosition) {
        if (mListModels == null) {
            return false;
        }

        notifyItemMoved(fromPosition,
                        toPosition);

//        if (fromPosition < mListModels.size() && toPosition < mListModels.size()) {
//            if (fromPosition < toPosition) {
//                for (int i = fromPosition; i < toPosition; i++) {
//                    Collections.swap(mListModels, i,  i + 1);
//
//                }
//            } else {
//                for (int i = fromPosition; i > toPosition; i--) {
//                    Collections.swap(mListModels,
//                                     i,
//                                     i - 1);
//                }
//            }
//            // save list.
//        }

        return true;
    }

    public void onItemDismiss(final int position) {
        // remove item.
        if (mListModels != null) {
            mListModels.remove(position);
        }
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    static class MyViewHolder
            extends RecyclerView.ViewHolder {
        private TextView tvItemSwap;

        MyViewHolder(View view) {
            super(view);
            tvItemSwap = (TextView) view.findViewById(R.id.tvItemSwap);
        }
    }
}
