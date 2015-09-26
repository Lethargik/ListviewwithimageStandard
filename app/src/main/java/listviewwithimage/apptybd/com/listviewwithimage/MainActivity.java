package listviewwithimage.apptybd.com.listviewwithimage;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
public class MainActivity extends Activity {
    ListView list;
    String[] lastMeme;
    String[] titleMeme;
    String[] descriptionMeme;
    int[] imageMeme ={R.drawable.meme1,R.drawable.meme2,R.drawable.meme2,R.drawable.meme3,
            R.drawable.meme4,R.drawable.meme5,R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,
            R.drawable.meme9,R.drawable.meme10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res =getResources();
        titleMeme=res.getStringArray(R.array.titlessss);
        descriptionMeme=res.getStringArray(R.array.descriptionssss);
        lastMeme=res.getStringArray(R.array.lastssss);

        list= (ListView) findViewById(R.id.listView);
        MyAdapter adapter=new MyAdapter(this,titleMeme,imageMeme,descriptionMeme,lastMeme);
        list.setAdapter(adapter);
    }
class MyAdapter extends ArrayAdapter<String>{
    Context context;
    int[] images;
    String[] titleArray;
    String[] descriptionArray;
    String[] lastArray;

    MyAdapter(Context c, String[] titlessss,int immmmgs[],String[] descccc,String[] lasttt ) {
        super(c, R.layout.single_row,R.id.textView,titlessss);
        this.context=c;
        this.images=immmmgs;
        this.titleArray=titlessss;
        this.descriptionArray=descccc;
        this.lastArray=lasttt;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row, parent, false);

        ImageView myImage= (ImageView) row.findViewById(R.id.imageView);
        TextView myTitle= (TextView) row.findViewById(R.id.textView);
        TextView myDescription= (TextView) row.findViewById(R.id.textView2);
        TextView mylast= (TextView) row.findViewById(R.id.textView3);

        myImage.setImageResource(imageMeme[position]);
        myTitle.setText(titleArray[position]);
        myDescription.setText(descriptionArray[position]);
        mylast.setText(lastArray[position]);

        return row;
    }
}
}
