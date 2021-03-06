package pl.rzeszow.wsiz.zhekabandit97.recipe4u;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LastFragment extends Fragment {
    ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_last,container,false);
        final StarterActivity activity = (StarterActivity)getActivity();



        listView = (ListView)view.findViewById(R.id.listViewLastMain);
        ListViewLastAdapter myAdapter = new ListViewLastAdapter(this.getActivity(),R.layout.customlist,activity.getAllRecipesFromSearch());
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Recipe> recipesTempList = new ArrayList<>(activity.getAllRecipesFromSearch());
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(recipesTempList.get(position).getUrl_recipe()));
                startActivity(i);
            }
        });





        return view;
    }

}
