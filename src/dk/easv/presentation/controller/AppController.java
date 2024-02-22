package dk.easv.presentation.controller;

import dk.easv.entities.*;
import dk.easv.presentation.model.AppModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.skin.LabeledSkinBase;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;

public class AppController implements Initializable {

    private AppModel model;
    private long timerStartMillis = 0;
    private String timerMsg = "";

    @FXML
    private Label top1Lbl, top2Lbl, top3Lbl, top4Lbl, top5Lbl, top6Lbl, top7Lbl;

    @FXML
    private Label rate1Lbl, rate2Lbl, rate3Lbl, rate4Lbl, rate5Lbl, rate6Lbl, rate7Lbl;

    @FXML
    private ImageView top1, top2, top3, top4, top5, top6, top7;

    @FXML
    private ImageView rate1, rate2, rate3, rate4, rate5, rate6, rate7;

    private List<Movie> topMovies;

    private void startTimer(String message){
        timerStartMillis = System.currentTimeMillis();
        timerMsg = message;
    }

    private void stopTimer(){
        System.out.println(timerMsg + " took : " + (System.currentTimeMillis() - timerStartMillis) + "ms");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setModel(AppModel model) {
        model.loadData(model.getObsLoggedInUser());

        topMovies = model.getObsTopMovieNotSeen();
        topMovies.sort(Comparator.comparing(Movie::getAverageRating));

        top1Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top2Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top3Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top4Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top5Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top6Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top7Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
    }
}
