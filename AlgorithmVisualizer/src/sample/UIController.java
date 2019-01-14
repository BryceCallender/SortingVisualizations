package sample;

import Sorts.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class UIController implements Initializable
{
    @FXML
    public BorderPane sortingBorderPane;
    @FXML
    private Pane sortPane;

    private Sort currentSort;
    private boolean isSorting = false;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        sortPane.setStyle("-fx-background-color: black");
    }

    public void bubbleSort()
    {
        BubbleSort bubbleSort = new BubbleSort();
        isSorting = true;
        currentSort = bubbleSort;
        new Thread(bubbleSort).start();
        System.out.println("Bubble Sort");
    }

    public void insertionSort()
    {
        InsertionSort insertionSort = new InsertionSort();
        isSorting = true;
        currentSort = insertionSort;
        new Thread(insertionSort).start();
        System.out.println("Insertion Sort");
    }

    public void selectionSort()
    {
        SelectionSort selectionSort = new SelectionSort();
        isSorting = true;
        currentSort = selectionSort;
        new Thread(selectionSort).start();
        System.out.println("Selection Sort");
    }

    public void quickSort()
    {
        QuickSort quickSort = new QuickSort();
        isSorting = true;
        currentSort = quickSort;
        new Thread(quickSort).start();
        System.out.println("Quick Sort");
    }

    public void mergeSort()
    {
        MergeSort mergeSort = new MergeSort();
        isSorting = true;
        currentSort = mergeSort;
        new Thread(mergeSort).start();
        System.out.println("Quick Sort");
    }

    public Sort getCurrentSort()
    {
        return currentSort;
    }

    public boolean isSorting()
    {
        return isSorting;
    }

    public Pane getSortPane()
    {
        return sortPane;
    }
}
