package Sorts;

import javafx.scene.paint.Color;
import sample.UIController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort implements Runnable
{
    protected Color[] colors;
    protected int threadSleepTime;
    protected UIController uiController;

    public Sort()
    {
        this.colors = fillAndShuffleColors(100);
        this.threadSleepTime = 100;
    }

    public Sort(int size)
    {
        this.colors = fillAndShuffleColors(size);
        this.threadSleepTime = 25;
    }

    public Sort(Color[] colors, UIController uiController)
    {
        this.colors = colors;
        this.threadSleepTime = 25;
        this.uiController = uiController;
    }

    public Sort(Color[] colors,int threadSleepTime)
    {
        this.colors = colors;
        this.threadSleepTime = threadSleepTime;
    }

    public void outputArray()
    {
        for (Color color : colors)
        {
            System.out.println((int) color.getHue());
        }
    }

    public Color[] getColors()
    {
        return colors;
    }

    public void swap(int i,int j)
    {
        Color temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }

    @Override
    public void run() {}

    public static Color[] fillAndShuffleColors(int size)
    {
        Color[] colors = new Color[size];

        double step = 360.0/size;

        for (int i = 0; i < colors.length; i++)
        {
            colors[i] = Color.hsb(step * i,1,1);
        }

        shuffleColors(colors);
        return colors;
    }

    public static void shuffleColors(Color[] colors)
    {
        List<Color> colorList = Arrays.asList(colors);
        Collections.shuffle(colorList);
        for (int i = 0; i < colorList.size(); i++)
        {
            colors[i] = colorList.get(i);
        }
    }
}
