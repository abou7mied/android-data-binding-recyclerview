package net.droidlabs.mvvmdemo.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import net.droidlabs.mvvmdemo.adapter.BindingRecyclerViewAdapter;
import net.droidlabs.mvvmdemo.adapter.binder.ItemBinder;

import java.util.Collection;

public class RecyclerViewBindings
{
    private static final int KEY = -123;

    @SuppressWarnings("unchecked")
    @BindingAdapter("items")
    public static <T> void setItems(RecyclerView recyclerView, Collection<T> items)
    {
        BindingRecyclerViewAdapter<T> adapter = (BindingRecyclerViewAdapter<T>) recyclerView.getAdapter();
        if (adapter != null)
        {
            adapter.setItems(items);
        }
        else
        {
            recyclerView.setTag(KEY, items);
        }
    }


    @SuppressWarnings("unchecked")
    @BindingAdapter("itemView")
    public static <T> void setItemView(RecyclerView recyclerView, ItemBinder<T> itemViewMapper)
    {
        Collection<T> items = (Collection<T>) recyclerView.getTag(KEY);
        recyclerView.setAdapter(new BindingRecyclerViewAdapter<>(itemViewMapper, items));
    }
}