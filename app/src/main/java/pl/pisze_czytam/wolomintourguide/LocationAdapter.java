package pl.pisze_czytam.wolomintourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<Location> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Location currentLoc = getItem(position);

        ImageView locImage = listItemView.findViewById(R.id.location_image);
        locImage.setImageResource(currentLoc.getImageResource());
        TextView locName = listItemView.findViewById(R.id.location_name);
        locName.setText(currentLoc.getLocationName());
        TextView locAddress = listItemView.findViewById(R.id.location_address);
        locAddress.setText(currentLoc.getLocationDescription());

        return listItemView;
    }
}
