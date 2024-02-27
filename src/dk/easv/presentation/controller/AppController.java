package dk.easv.presentation.controller;

import dk.easv.entities.*;
import dk.easv.presentation.model.AppModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.skin.LabeledSkinBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppController implements Initializable {

    private AppModel model;
    private long timerStartMillis = 0;
    private String timerMsg = "";

    @FXML
    private Label cat1Lbl, cat2Lbl, cat3Lbl, cat4Lbl, cat5Lbl, cat6Lbl, cat7Lbl;

    @FXML
    private Label top1Lbl, top2Lbl, top3Lbl, top4Lbl, top5Lbl, top6Lbl, top7Lbl;

    @FXML
    private Label rate1Lbl, rate2Lbl, rate3Lbl, rate4Lbl, rate5Lbl, rate6Lbl, rate7Lbl;

    @FXML
    private Label pop1Lbl, pop2Lbl, pop3Lbl, pop4Lbl, pop5Lbl, pop6Lbl, pop7Lbl;

    @FXML
    private ImageView cat1, cat2, cat3, cat4, cat5, cat6, cat7;

    @FXML
    private ImageView top1, top2, top3, top4, top5, top6, top7;

    @FXML
    private ImageView rate1, rate2, rate3, rate4, rate5, rate6, rate7;

    @FXML
    private ImageView pop1, pop2, pop3, pop4, pop5, pop6, pop7;




    private List<Movie> topMovies;

    private ArrayList<Image> randomImages = new ArrayList<>();

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

        cat1Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat2Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat3Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat4Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat5Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat6Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat7Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());

        top1Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top2Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top3Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top4Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top5Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top6Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        top7Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());

        pop1Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        pop2Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        pop3Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        pop4Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        pop5Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        pop6Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        pop7Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());

        rate1Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        rate2Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        rate3Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        rate4Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        rate5Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        rate6Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        rate7Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());

        setImages();

    }

    private void setRandomImages(){
        try{
            Stream<Path> stream = Files.list(Paths.get(getClass().getResource("/movie_covers/").toURI()));
            List<String> imgs = stream.filter(file -> !Files.isDirectory(file)).map(Path::getFileName).map(Path::toString).collect(Collectors.toList());
            List<Image> imgsConv = imgs.stream()
                    .map(name -> new Image("/movie_covers/"+name)).collect(Collectors.toList());
            randomImages.addAll(imgsConv);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        Collections.shuffle(randomImages);
    }

    private void setImages(){
        setRandomImages();

        top1.setImage(randomImages.get(1));
        top2.setImage(randomImages.get(2));
        top3.setImage(randomImages.get(3));
        top4.setImage(randomImages.get(4));
        top5.setImage(randomImages.get(5));
        top6.setImage(randomImages.get(6));
        top7.setImage(randomImages.get(7));

        pop1.setImage(randomImages.get(7));
        pop2.setImage(randomImages.get(8));
        pop3.setImage(randomImages.get(9));
        pop4.setImage(randomImages.get(10));
        pop5.setImage(randomImages.get(11));
        pop6.setImage(randomImages.get(12));
        pop7.setImage(randomImages.get(13));

        rate1.setImage(randomImages.get(14));
        rate2.setImage(randomImages.get(15));
        rate3.setImage(randomImages.get(16));
        rate4.setImage(randomImages.get(17));
        rate5.setImage(randomImages.get(18));
        rate6.setImage(randomImages.get(19));
        rate7.setImage(randomImages.get(20));

        cat1.setImage(randomImages.get(21));
        cat2.setImage(randomImages.get(22));
        cat3.setImage(randomImages.get(23));
        cat4.setImage(randomImages.get(24));
        cat5.setImage(randomImages.get(25));
        cat6.setImage(randomImages.get(26));
        cat7.setImage(randomImages.get(27));
    }

    public void categories(ActionEvent actionEvent) {
        setRandomImages();

        cat1.setImage(randomImages.get(28));
        cat2.setImage(randomImages.get(29));
        cat3.setImage(randomImages.get(30));
        cat4.setImage(randomImages.get(31));
        cat5.setImage(randomImages.get(32));
        cat6.setImage(randomImages.get(33));
        cat7.setImage(randomImages.get(34));

        cat1Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat2Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat3Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat4Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat5Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat6Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
        cat7Lbl.setText(topMovies.get((int) (Math.random() * topMovies.size())).getTitle());
    }
}
