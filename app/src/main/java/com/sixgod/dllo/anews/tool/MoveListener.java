package com.sixgod.dllo.anews.tool;

/**
 * Created by dllo on 16/3/16.
 */
public interface MoveListener {
    //拿到起始位置和结束位置的参数
    boolean onItemMove(int fromPosition, int toPosition);

    //擦除消失/
    void onItemDismiss(int position);
}
