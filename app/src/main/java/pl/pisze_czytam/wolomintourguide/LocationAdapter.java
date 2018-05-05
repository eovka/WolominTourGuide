package pl.pisze_czytam.wolomintourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<Location> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        ViewHolder holder;
        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.locImage = listItemView.findViewById(R.id.location_image);
            holder.locName = listItemView.findViewById(R.id.location_name);
            holder.locDescription = listItemView.findViewById(R.id.location_description);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        Location currentLoc = getItem(position);
        holder.locImage.setImageResource(currentLoc.getImageResource());
        holder.locName.setText(currentLoc.getLocationName());
        holder.locDescription.setText(currentLoc.getLocationDescription());

        return listItemView;
    }
}
