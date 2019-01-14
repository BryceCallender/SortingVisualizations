package Sorts;

import javafx.scene.paint.Color;
import sample.UIController;

public class InsertionSort extends Sort
{
    public InsertionSort() {}

    public InsertionSort(Color[] colors, UIController uiController)
    {
        super(colors,uiController);
    }

    @Override
    public void run()
    {
        for (int i = 1; i < colors.length; i++)
        {
            Color value = colors[i];
            int j = i - 1;

            while(j >= 0 && colors[j].getHue() > value.getHue())
            {
                colors[j+1] = colors[j];
                j -= 1;
            }
            colors[j+1] = value;

            try
            {
                Thread.sleep(threadSleepTime);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
