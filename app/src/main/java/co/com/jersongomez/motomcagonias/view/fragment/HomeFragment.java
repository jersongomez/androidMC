package co.com.jersongomez.motomcagonias.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.com.jersongomez.motomcagonias.R;
import co.com.jersongomez.motomcagonias.adapter.PictureAdapterRecycleView;
import co.com.jersongomez.motomcagonias.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home), false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecycleView pictureAdapterRecycleView =
                new PictureAdapterRecycleView(buidPictures(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecycleView);

        return view;
    }

    public ArrayList<Picture> buidPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://scontent.feoh1-1.fna.fbcdn.net/v/t1.0-9/14440759_10153976569612894_197246353361726700_n.jpg?oh=8f36f71ac9b6aae10c9daec682a2312b&oe=5868C1E1", "Jerson Gomez", "4 días", "3 likes"));
        pictures.add(new Picture("https://scontent.feoh1-1.fna.fbcdn.net/v/t1.0-9/14355769_10153976570122894_1571683382511704776_n.jpg?oh=56a61e27b7ba6247cf53a800c5ee8cd1&oe=5837D921", "Azuleja", "2 días", "3 likes"));
        pictures.add(new Picture("https://scontent.feoh1-1.fna.fbcdn.net/v/t1.0-9/14333816_10153976569412894_5195825468784677565_n.jpg?oh=d341a8abe6c4b10b5bc478b386aa7386&oe=583B3D54", "Azuleja Luz", "1 días", "31 likes"));

        return pictures;
    }

    public void showToolbar(String tittle, boolean btnBack, View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(btnBack);

    }

}
