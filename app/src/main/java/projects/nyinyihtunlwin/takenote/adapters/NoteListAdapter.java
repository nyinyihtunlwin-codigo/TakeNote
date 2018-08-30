package projects.nyinyihtunlwin.takenote.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import projects.nyinyihtunlwin.takenote.R;
import projects.nyinyihtunlwin.takenote.models.NoteModel;
import projects.nyinyihtunlwin.takenote.viewholders.NoteListViewHolder;

/**
 * Created by Dell on 11/23/2017.
 */

public class NoteListAdapter extends RecyclerView.Adapter<NoteListViewHolder> {

    private ArrayList<NoteModel> dataList;
    private LayoutInflater inflater;
    private Context context;

    public NoteListAdapter(Context context, ArrayList<NoteModel> dataList) {
        this.dataList = dataList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public NoteListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_item_note, parent, false);
        return new NoteListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteListViewHolder holder, int position) {
        holder.tvNote.setText(dataList.get(position).getContent());
        holder.tvTitle.setText(dataList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
