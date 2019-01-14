package Sorts;

import javafx.scene.paint.Color;
import sample.UIController;

public class SelectionSort extends Sort
{

    public SelectionSort(Color[] colors, UIController uiController)
    {
        super(colors,uiController);
    }

    public SelectionSort() {}

    @Override
    public void run()
    {
        for (int i = 0; i < colors.length; i++)
        {
            int minimumIndex = i;
            for (int j = i+1; j < colors.length; j++)
            {
                if(colors[j].getHue() < colors[minimumIndex].getHue())
                {
                    minimumIndex = j;
                }
            }
            try
            {
                swap(minimumIndex,i);
                Thread.sleep(threadSleepTime);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }


        }
    }
}
