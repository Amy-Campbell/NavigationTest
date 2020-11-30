package com.example.navigationtest;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    //public int[] imageList = {R.drawable.cup, R.drawable.candyapple, R.drawable.monster,R.drawable.pizza,R.drawable.skull,R.drawable.spider,R.drawable.werewolf,R.drawable.witch};
    public static int[] imageList = {
            R.drawable.image0,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10,
            R.drawable.image11};

    static public List<String> storedImageList = new ArrayList<String>();
    static public List<String> storedDescriptionsList = new ArrayList<String>();
    static public List<String> storedDatesList = new ArrayList<String>();
    static public List<String> storedTitlesList = new ArrayList<String>();

    public String[] titles = {"My Family",
            "Agatha and Mom",
            "Ben's Family",
            "Agatha and I",
            "Mom and Dad",
            "Agatha and Elise",
            "Our Wedding",
            "Mom and Dad",
            "My Nieces",
            "Tabitha's Family",
            "Me and Agatha",
            "Gregory",
            "Name13"};

    public String[] descriptions = {"My Family",
            "Baby Agatha (My Sister) on the left, next to Mom",
            "Ben (My son) with his wife (Angela) and their eldest child (Ryan)",
            "My Sister (Agatha) and Me. (1955)",
            "Mom and Dad",
            "Agatha (my sister) and her daughter, Elise",
            "Me and my husband, Gregory, at our wedding. (1960)",
            "Mom and Dad in 1993",
            "My nieces, Elise and Charlotte",
            "Portrait of my cousin Tabitha's family",
            "Me and Agatha",
            "An image of Gregory in his Navy uniform",
            "Name13"};

    public String[] dates = {
            "1957",
            "1963",
            "1999",
            "1955",
            "1950",
            "1983",
            "1960",
            "1993",
            "2000",
            "1997",
            "1964",
            "1939",
            "1956"};


    public ImageAdapter(Context con){
        this.context = con;
    }

    public int getImageFromSD(){
        return 0;

    }


    @Override
    //returns length of image list
    public int getCount() {
        return imageList.length + storedImageList.size();
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
    /**
     * this method is called to draw each image and scale it
     * @param position
     * @param convertView
     * @param parent acts as a constraint for the child
     */

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);

        //scale the image
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new GridView.LayoutParams(450,450));
        imageView.setPadding(8, 8, 8, 8);

        //set image
        if(position < imageList.length) {
            imageView.setImageResource(imageList[position]);

        }
        else{
            try{
                if ((storedImageList.get(position - imageList.length)).charAt(0) == 'h'){
                    Glide.with(parent.getContext()).load(storedImageList.get(position - imageList.length)).into(imageView);
                }
                else{
                    File imageFile = new File(storedImageList.get(position - imageList.length));
                    BitmapDrawable d = new BitmapDrawable(parent.getContext().getResources(), imageFile.getAbsolutePath());


                    imageView.setImageDrawable(d);
                }




            }
            catch(Exception e){

            }
        }
        return imageView;
    }
    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}