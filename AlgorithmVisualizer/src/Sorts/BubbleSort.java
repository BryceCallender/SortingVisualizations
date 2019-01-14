package Sorts;

import javafx.scene.paint.Color;
import sample.UIController;

public class BubbleSort extends Sort
{
    public BubbleSort()
    {
        super();
    }

    public BubbleSort(Color[] colors, UIController uiController)
    {
        super(colors,uiController);
    }

    public BubbleSort(int size)
    {
        super(size);
    }

    @Override 
    public void run()
    {
        for (int i = 0; i < colors.length; i++)
        {
            for (int j = 0; j < colors.length-i-1; j++)
            {
                if(colors[j].getHue() > colors[j+1].getHue())
                {
                    try
                    {
                        swap(j,j+1);
                        Thread.sleep(threadSleepTime);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
