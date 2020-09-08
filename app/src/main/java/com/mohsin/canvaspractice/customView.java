package com.mohsin.canvaspractice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class customView extends View {

    private final static int sizeofREct=200;
    private final static int sizeofREctdef=200;
    private Paint mpanitcircle;

    Rect mrect;
    Paint mpanit;
    int msquarecolor;
    int msquaresize;


    private float mcircleX,mcircleY;
    private float mcirecleR=100f;

    public customView(Context context) {
        super(context);
        init(null);
    }

    public customView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public customView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public customView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    public void init(@Nullable AttributeSet a)
    {
        mrect=new Rect();
        mpanit=new Paint(Paint.ANTI_ALIAS_FLAG);
        mpanit.setColor(Color.BLACK);


        mpanitcircle=new Paint();
        mpanitcircle.setAntiAlias(true);
        mpanitcircle.setColor(Color.BLUE);

        if(a==null)
            return;
        TypedArray ta=getContext().obtainStyledAttributes(a,R.styleable.CustomView);


       msquarecolor=ta.getColor(R.styleable.CustomView_Square_color,Color.BLACK);
       msquaresize= (int) ta.getDimension(R.styleable.CustomView_Square_size,sizeofREctdef);

    }

    @Override
    protected void onDraw(Canvas canvas) {

//        mrect.left=50+sizeofREct;
//        mrect.top=50+sizeofREct;
//        mrect.bottom=mrect.top+sizeofREct;
//        mrect.right=mrect.left+sizeofREct;
        //Paint p=new Paint();
        mrect.left=50;
        mrect.top=50;
        mrect.bottom=mrect.top+msquaresize;
        mrect.right=mrect.left+msquaresize;

        canvas.drawColor(Color.YELLOW);
        canvas.drawRect(mrect,mpanit);



        if(mcircleX==0f|| mcircleY==0f)
        {
            mcircleX=getWidth()/2;//center
            mcircleY=getWidth()/2;

        }

//        float cx,cy;
//        float redius=100f;
//        cx=getWidth()-redius-50;
//        cy=mrect.top+(mrect.height()/2);

        //work for circle
       // canvas.drawCircle(cx,cy,redius,mpanitcircle);

        canvas.drawCircle(mcircleX,mcircleY,mcirecleR,mpanitcircle);
    }

    public void colorchange()
    {
       // mpanit.setColor(mpanit.getColor()==Color.BLACK?Color.RED:Color.BLACK);
        mpanit.setColor(mpanit.getColor()==msquarecolor?Color.RED:msquarecolor);
        postInvalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

                boolean value=super.onTouchEvent(event);
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN: {
                        return true;
                    }
                    case MotionEvent.ACTION_MOVE:
                        {
                            float x=event.getX();
                            float y=event.getY();

                            double dx=Math.pow(x-mcircleX,2);
                            double dy=Math.pow(y-mcircleY,2);
                            if(dx+dy<Math.pow(mcirecleR,2)){
                                mcircleX=x;
                                mcircleY=y;
                                postInvalidate();
                                return true;
                            }
                        return value;
                    }

                }
                return value;
    }
}
