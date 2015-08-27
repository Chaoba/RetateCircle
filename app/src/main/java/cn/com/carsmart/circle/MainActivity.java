package cn.com.carsmart.circle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<Integer> contents = new ArrayList<>();

    LinearInterpolator lin = new LinearInterpolator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contents.add(R.mipmap.circle1);
        contents.add(R.mipmap.circle2);
        contents.add(R.mipmap.circle3);
        contents.add(R.mipmap.circle4);
        contents.add(R.mipmap.circle5);
        contents.add(R.mipmap.circle6);
        contents.add(R.mipmap.circle7);
        contents.add(R.mipmap.circle8);
        contents.add(R.mipmap.circle9);
        contents.add(R.mipmap.circle10);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new CircleAdapter());
    }


    class CircleAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return contents.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = View.inflate(MainActivity.this, R.layout.item, null);
            final ImageView imageView = (ImageView) v.findViewById(R.id.img);
            imageView.setImageResource(contents.get(position));
            final Animation operatingAnim  = AnimationUtils.loadAnimation(MainActivity.this, R.anim.circle);
            operatingAnim.setInterpolator(lin);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        imageView.startAnimation(operatingAnim);
                }
            });
            return v;
        }
    }
}
