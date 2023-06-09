package ve.com.abicelis.planetracker.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ve.com.abicelis.planetracker.R;

/**
 * Created by abicelis on 4/9/2017.
 */

public class TripHeaderViewHolder extends RecyclerView.ViewHolder {
    //UI
    @BindView(R.id.list_item_trip_header_title)
    TextView mHeaderTitle;


    public TripHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(String headerTitle) {
        mHeaderTitle.setText(headerTitle);
    }
}