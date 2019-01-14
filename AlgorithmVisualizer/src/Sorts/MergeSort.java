package Sorts;

import javafx.scene.paint.Color;

public class MergeSort extends Sort
{
    public MergeSort() {}

    @Override
    public void run()
    {
        mergeSort(colors,0,colors.length-1);
    }

    private void mergeSort(Color[] colors, int low, int high)
    {
        if(colors.length == 0)
        {
            return;
        }

        if(low < high)
        {
            int middle = low + (high - low) / 2;

            mergeSort(colors,low,middle);
            mergeSort(colors,middle+1,high);
            merge(colors,low,middle,high);

            try
            {
                Thread.sleep(threadSleepTime);

            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void merge(Color[] colors,int low, int middle, int high)
    {

        int i, j, k;
        int n1 = middle - low + 1;
        int n2 =  high - middle;

        /* create temp arrays */
        Color left[] = new Color[n1];
        Color right[] = new Color[n2];

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
        {
            left[i] = colors[low + i];
        }

        for (j = 0; j < n2; j++)
        {
            right[j] = colors[middle+ 1 + j];
        }

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = low; // Initial index of merged subarray
        while (i < n1 && j < n2)
        {
            if (left[i].getHue() <= right[j].getHue())
            {
                colors[k] = left[i];
                i++;
            }
            else
            {
                colors[k] = right[j];
                j++;
            }
            k++;
        }

        /* Copy the remaining elements of L[], if there
        are any */
        while (i < n1)
        {
            colors[k] = left[i];
            i++;
            k++;
        }

        /* Copy the remaining elements of R[], if there
         are any */
        while (j < n2)
        {
            colors[k] = right[j];
            j++;
            k++;
        }
    }
}
