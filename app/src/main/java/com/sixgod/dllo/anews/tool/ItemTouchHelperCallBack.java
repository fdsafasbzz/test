package com.sixgod.dllo.anews.tool;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by dllo on 16/3/16.
 */
public class ItemTouchHelperCallBack extends ItemTouchHelper.Callback{
    public static final float ALPHA_FULL = 1.0f;
    private MoveListener listener;

    public ItemTouchHelperCallBack(MoveListener mAdapter) {
        this.listener = mAdapter;
    }

    //返回布局移动的方向.

    /**
     * ItemTouchHelper可以让你轻易得到一个事件的方向。
     * 你需要重写getMovementFlags()方法来指定可以支持的拖放和滑动的方向。
     * 使用helperItemTouchHelper.makeMovementFlags(int, int)来构造返回的flag。
     * 这里我们启用了上下左右两种方向。注：上下左右为拖动（drag），左右为滑动（swipe）
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END;
        int swipeFlags = ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    //长按拖动
    //recyclerview布局不可以  将滑动和拖动混淆使用
    //必须指出来使用那一种来进行操作.
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    //滑动移除
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    /**
     * onMove()和onSwiped()，用于通知底层数据的更新
     */
    //编写移动布局的方法.
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //刷新移动后的样子.
        listener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    //编写滑动的方法/
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        listener.onItemDismiss(viewHolder.getAdapterPosition());
    }
}
