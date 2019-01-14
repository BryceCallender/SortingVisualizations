package Sorts;

import javafx.scene.paint.Color;

public class QuickSort extends Sort
{
    public QuickSort() {}

    @Override
    public void run()
    {
        quickSort(colors,0,colors.length-1);
    }

    private void quickSort(Color[] colors, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(colors, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(colors, low, pi-1);
            quickSort(colors, pi+1, high);
        }
    }

    int partition(Color[] colors, int low, int high)
    {
        Color pivot = colors[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (colors[j].getHue() <= pivot.getHue())
            {
                i++;

                swap(i,j);
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        swap(i+1,high);

        try
        {
            Thread.sleep(threadSleepTime);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        return i+1;
    }
}
