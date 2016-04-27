package cn.com.carsmart.circle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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

        for (int i = 18; i > 0; i--) {
            int id = getResources().getIdentifier("circle" + i, "mipmap", getPackageName());
            contents.add(id);
        }
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
            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(MainActivity.this, R.layout.item, null);

                holder = new ViewHolder();
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.img = (ImageView) convertView.findViewById(R.id.img);
            Animation animation = holder.img.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            holder.img.setImageResource(contents.get(position));
            Log.i("test", "id:" + holder.img.getId() + "   hashcod:" + holder.img.hashCode());
            final Animation operatingAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.circle);
            operatingAnim.setInterpolator(lin);
            final ViewHolder finalHolder = holder;
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finalHolder.img.startAnimation(operatingAnim);
                }
            });
            return convertView;
        }
    }

    class ViewHolder {
        ImageView img;
    }

}
