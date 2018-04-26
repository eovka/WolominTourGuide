package pl.pisze_czytam.wolomintourguide;

import android.os.Bundle;
import android.support.constraint.solver.GoalRow;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RetainedFragment extends Fragment {

    // data object we want to retain
    private Fragment data;

    // this method is only called once for this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void setData(Fragment data) {
        this.data = data;
    }

    public Fragment getData() {
        return data;
    }
}