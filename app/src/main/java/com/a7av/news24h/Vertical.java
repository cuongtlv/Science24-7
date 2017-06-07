package com.a7av.news24h;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by My PC on 25-Apr-17.
 */

public class Vertical extends RecyclerView.ItemDecoration {
    int Space;

    public Vertical(int Space) {
        this.Space = Space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = Space;
        outRect.right = Space;
        outRect.bottom = Space;
        //Checking if the card view is the 1st one on the list.
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = Space;
        }
    }
}
