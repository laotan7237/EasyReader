package com.laotan.easyreader.utils;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;

/**
 * Created by quantan.liu on 2017/4/17.
 */

public class ColorUtils {
    public static @Nullable
    Palette.Swatch getMostPopulousSwatch(Palette palette) {
        Palette.Swatch mostPopulous = null;
        if (palette != null) {
            for (Palette.Swatch swatch : palette.getSwatches()) {
                if (mostPopulous == null || swatch.getPopulation() > mostPopulous.getPopulation()) {
                    mostPopulous = swatch;
                }
            }
        }
        return mostPopulous;
    }
    public static int getStatusBarColor(int color) {
        float[] arrayOfFloat = new float[3];
        Color.colorToHSV(color, arrayOfFloat);
        arrayOfFloat[2] *= 0.9F;
        return Color.HSVToColor(arrayOfFloat);
    }
}
