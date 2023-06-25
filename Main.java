import java.net.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;

public class Main extends Application {

    static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {

        // start reading the file from line number 84.
        for (int lineNumber = 84; lineNumber < 248; lineNumber++) {
            String line = Files.readAllLines(Paths.get("theRaven.html")).get(lineNumber);
            while (line.contains("<") && line.contains(">")) {
                String htmlTag = line.substring(line.indexOf("<"), line.indexOf(">") + 1);
                line = line.replace(htmlTag, "");
            }

            String[] words = line.split(" ");

            for (String word : words) {
                word = word.replace(',', ' ').replace('.', ' ').replace('“', ' ').replace('”', ' ').toLowerCase().trim();
                if (word.length() > 0) {
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, (int) 1L);
                    }
                }
            }
        }

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set);
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> one, Map.Entry<String, Integer> two) {
                return (two.getValue()).compareTo(one.getValue());
            }
        });

        String wordCounts = "";
        for (int i = 0; i < 20 && i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
            wordCounts = wordCounts + " \n" + sortedList.get(i).toString();
        }

        stage.setTitle("Count Words in a File");
        stage.setWidth(400);
        stage.setHeight(450);

        Label lbl_counts = new Label(wordCounts);
        lbl_counts.setPadding(new Insets(10, 5, 5, 10));

        Button btn = new Button("Close");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
//				Alert a = new Alert(Alert.AlertType.INFORMATION);
//				a.setHeaderText("Thank you");
//				a.show();

                stage.close();

            }
        });

        VBox layout = new VBox(lbl_counts, btn);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();


    }
}
