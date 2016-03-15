package com.sqllite.android.azadidb.simplelistviewwithcustomadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Car> myCars = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateCarList();
        populateListView();
    }


    private void populateCarList() {

        myCars.add(new Car("FROD", 1999, R.drawable.canam, "usable"));
        myCars.add(new Car("TOYOTA", 1995, R.drawable.james, "loadable"));
        myCars.add(new Car("CELLANCE", 1998, R.drawable.lada, "usage"));
        myCars.add(new Car("LORY", 1989, R.drawable.lory, "carriage"));
        myCars.add(new Car("BMW", 1969, R.drawable.pessanger, "makeable"));
        myCars.add(new Car("TITAN", 1979, R.drawable.pigusis, "tiny"));
        myCars.add(new Car("TORS", 1939, R.drawable.police, "old"));
        myCars.add(new Car("GALAXY", 1999, R.drawable.sports, "new"));
        myCars.add(new Car("BOSTY", 1998, R.drawable.santo, "brandy"));
        myCars.add(new Car("NORISS", 1996, R.drawable.toy, "marketable"));
        myCars.add(new Car("PRIDE", 1997, R.drawable.transport, "advertisable"));
        myCars.add(new Car("PEOPLE", 1994, R.drawable.usage, "usable"));
        myCars.add(new Car("PLUS", 1995, R.drawable.usable, "travelling"));
        myCars.add(new Car("DOVE", 1969, R.drawable.travel, "lorry"));

    }

    private void populateListView() {

        ArrayAdapter<Car> adapter = new MyListAdapter();
        ListView carListView = (ListView) findViewById(R.id.carListView);
        carListView.setAdapter(adapter);
    }

    public class MyListAdapter extends ArrayAdapter<Car> {

        public MyListAdapter() {
            super(MainActivity.this, R.layout.item_view,myCars);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = convertView;

            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }
//        return super.getView(position, convertView, parent);

            Car currentcars = myCars.get(position);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(R.drawable.lada);
            //imageView.setImageResource(currentcars.getIconID());


            TextView item_txtMake = (TextView) itemView.findViewById(R.id.item_txtMake);
            item_txtMake.setText(currentcars.getMake());

            TextView item_txtYear = (TextView) itemView.findViewById(R.id.item_txtYear);
            item_txtYear.setText(""+currentcars.getYear());

            TextView item_txtCondition = (TextView) itemView.findViewById(R.id.item_txtCondition);
            item_txtCondition.setText(currentcars.getCondition());
            return itemView;
        }
    }

}
