package info.androidhive.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateView extends TextView {
   public String delimiter;
   public boolean fancyText;
   public int viewColor;
   
   public DateView(Context context) {
      super(context);
      setDate();
   }
   
   public DateView(Context context, AttributeSet attrs) {
      super(context, attrs);
      TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DateView );
      final int N = a.getIndexCount();
      for (int i = 0; i < N; ++i) 
      {
         int attr = a.getIndex(i);
         switch (attr)
         {
            case R.styleable.DateView_delimiter:
            delimiter = a.getString(attr);
            setDate();
            break;
            
            case R.styleable.DateView_fancyText:
            fancyText = a.getBoolean(attr, false);
            fancyText();
            break;

            case R.styleable.DateView_viewColor:
               viewColor = a.getColor(attr, Color.BLACK);
               fancyText();
         }
      }
      a.recycle();
   }

   public DateView(Context context, AttributeSet attrs, int defStyle) {
      super(context, attrs, defStyle);
      setDate();
   }

   private void setDate() {
      SimpleDateFormat dateFormat =
      new SimpleDateFormat("yyyy" + delimiter + "MM" + delimiter + "dd");
      String today = dateFormat.format(Calendar.getInstance().getTime());
      setText(today);  // self = DateView = subclass of TextView
   }

   private void fancyText() {
      if( this.fancyText){
         if(viewColor == 0){
            viewColor = Color.BLACK;
         }
         setShadowLayer(9, 1, 1, viewColor);
      }
   }
}