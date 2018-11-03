package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

/**
 * @author cszdz
 * 使用 setColorFilter() 设置一个 ColorMatrixColorFilter
 * 用 ColorMatrixColorFilter.setSaturation() 把饱和度去掉
 */
public class Practice07ColorMatrixColorFilterView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;

  public Practice07ColorMatrixColorFilterView(Context context) {
    super(context);
  }

  public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    ColorMatrix colorMatrix = new ColorMatrix();
    colorMatrix.set(new float[]{
        1, 0, 0, 0, 2,
        0, 1, 0, 0, 2,
        0, 0, 1, 0, 2,
        0, 0, 0, 1, 2
    });
    colorMatrix.setSaturation(0);
    ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
    paint.setColorFilter(colorMatrixColorFilter);

  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawBitmap(bitmap, 0, 0, paint);
  }
}
