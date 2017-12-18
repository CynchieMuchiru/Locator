package ke.co.locator.hostel.hostelInfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import ke.co.locator.hostel.R;
import ke.co.locator.hostel.utility.CustomVolleyRequest;

/**
 * Created by muath on 12/13/2017.
 */

public class HostelsAdapter extends RecyclerView.Adapter<HostelsAdapter.ViewHolder> {
    Context context;
    //List to store all the Hostel details
    List<HostelModel> hostels;
    //Image Loader to load hostel image
    ImageLoader imageLoader;

    HostelsAdapter(List<HostelModel> hostels, Context context){
        super();
        //Getting all the hostels
        this.hostels = hostels;
        this.context= context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //getting a particular house from the list
        HostelModel hostel = hostels.get(position);
        //Loading Image from Url
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(hostel.getImageUrl(),
                ImageLoader.getImageListener(viewHolder.imgId, R.mipmap.ic_launcher,android.R.drawable.ic_dialog_alert));
        //Showing data on the views
        viewHolder.imgId.setImageUrl(hostel.getImageUrl(),imageLoader);
        viewHolder.imgTitle.setText(hostel.getImageTitle());
    }

    @Override
    public int getItemCount() {
        return hostels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView imgTitle;
        public NetworkImageView imgId;

        public ViewHolder(View itemView) {
            super(itemView);

            imgTitle = (TextView) itemView.findViewById(R.id.imgTitle);
            imgId = (NetworkImageView) itemView.findViewById(R.id.imgId);


        }
    }
}
