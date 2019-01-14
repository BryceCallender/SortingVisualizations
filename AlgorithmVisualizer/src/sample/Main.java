package sample;

import Sorts.Sort;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("visualizer.fxml"));
        TabPane root = loader.load();

        Scene scene = new Scene(root,600,400);

        primaryStage.setTitle("Algorithm Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();

        UIController uiController = loader.getController();

        Pane pane = uiController.getSortPane();

        final int numRects = 100;

        Color[] colors = new Color[numRects];

        double offset = pane.getWidth() / colors.length;
        colors = Sort.fillAndShuffleColors(colors.length);

        for (int i = 0; i < numRects; i++)
        {
            Rectangle rectangle = new Rectangle(offset * i ,0, offset, pane.getHeight());
            rectangle.setFill(colors[i]);
            pane.getChildren().add(rectangle);
        }

        new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                //If we are currently sorting lets do all these updates
                if(uiController.isSorting())
                {
                    int index = 0;

                    //Loop through all the items in the window
                    for (Node node : pane.getChildren())
                    {
                        if (node instanceof Rectangle && index < numRects)
                        {
                            ((Rectangle) node).setFill(uiController.getCurrentSort().getColors()[index]);
                            ((Rectangle) node).setStroke(uiController.getCurrentSort().getColors()[index]);
                        }

                        //Track where we are in foreach loop
                        index++;
                    }
                }
            }
        }.start();

        primaryStage.setOnCloseRequest(t ->
        {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
