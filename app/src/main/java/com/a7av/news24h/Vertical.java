package com.a7av.news24h;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 *  Setting elavator for cardview
 */
public class Vertical extends RecyclerView.ItemDecoration {
    private int space;

    public Vertical(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        //Checking if the card view is the 1st one on the list.
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = space;
        }
    }
}
