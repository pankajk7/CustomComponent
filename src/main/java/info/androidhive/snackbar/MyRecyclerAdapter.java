package info.androidhive.snackbar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {
    private List<String> stringList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, List<String> stringList) {
        this.stringList = stringList;
        this.mContext = context;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textView;

        public CustomViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.titleTextView);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        String str = stringList.get(i);

        //Setting text view title
        customViewHolder.textView.setText(str);

        //Handle click event on both title and image click
        customViewHolder.textView.setOnClickListener(clickListener);

        customViewHolder.textView.setTag(customViewHolder);
    }

    @Override
    public int getItemCount() {
        return (null != stringList ? stringList.size() : 0);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CustomViewHolder holder = (CustomViewHolder) view.getTag();
            int position = holder.getAdapterPosition();

            String str = stringList.get(position);
            Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
        }
    };
}