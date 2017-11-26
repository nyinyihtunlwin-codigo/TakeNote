package projects.nyinyihtunlwin.takenote.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import projects.nyinyihtunlwin.takenote.R;

/**
 * Created by Dell on 11/23/2017.
 */

public class NoteListViewHolder extends RecyclerView.ViewHolder {

    public TextView tvNote;

    public NoteListViewHolder(View itemView) {
        super(itemView);
        tvNote = itemView.findViewById(R.id.tv_note);
    }
}
