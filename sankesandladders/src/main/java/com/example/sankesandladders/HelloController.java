package com.example.sankesandladders;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ImageView cover;

    @FXML
    private ImageView icon;

    @FXML
    private ImageView startbutton;

    @FXML
    private ImageView back;

    @FXML
    private ImageView bluetoken;

    @FXML
    private ImageView board;

    @FXML
    private ImageView dice;

    @FXML
    private ImageView greentoken;

    @FXML
    private ImageView endback;

    @FXML
    private ImageView endgame;

    @FXML
    private  ImageView okaybutton;

    @FXML
    private AnchorPane gmboardanchor;

    @FXML
    private ImageView player1;

    @FXML
    private ImageView player2;

    @FXML
    private ImageView arrow;

    @FXML
    private ImageView player1dialogue;

    @FXML
    private ImageView player2dialogue;

    @FXML
    private ImageView winbox;

    @FXML
    private ImageView replay;

    @FXML
    private ImageView menu;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    private MediaPlayer mediaPlayer;

    public void gameboard(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gameboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Snake and Ladders");
        Image image = new Image(getClass().getResourceAsStream("icon.png"));
        stage.getIcons().add(image);
//        stage.setHeight(714);
//        stage.setWidth(429);
        stage.setResizable(false);
        stage.show();
    }

    public void backgame(){
            okaybutton.setVisible(true);
            endback.setVisible(true);
            endgame.setVisible(true);
            gmboardanchor.setOpacity(1);
            okaybutton.setOnMouseClicked(event -> {
                try {
                    frontpage(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            endback.setOnMouseClicked(event -> {
                okaybutton.setVisible(false);
                endback.setVisible(false);
                endgame.setVisible(false);
                gmboardanchor.setDisable(false);
            });
    }



    public void frontpage(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Snake and Ladders");
        Image image = new Image(getClass().getResourceAsStream("icon.png"));
        stage.getIcons().add(image);
//        stage.setHeight(714);
//        stage.setWidth(429);
        stage.setResizable(false);
        stage.show();
    }

    public void initialize(URL arg0, ResourceBundle arg1){
        TranslateTransition trans = new TranslateTransition();
        trans.setNode(arrow);
        trans.setDuration(Duration.millis(600));
        trans.setCycleCount(TranslateTransition.INDEFINITE);
        trans.setFromY(-20);
        trans.setToY(18);
        trans.setAutoReverse(true);
        trans.play();
    }

    private int greendicetotal = 0;
    private int bluedicetoatal =0;

    Image player1highlight = new Image(getClass().getResourceAsStream("player1_highlight.png"));
    Image player2highlight = new Image(getClass().getResourceAsStream("player2_highlight.png"));
    Image player1shadow = new Image(getClass().getResourceAsStream("player1_shadow.jpg"));
    Image player2shadow = new Image(getClass().getResourceAsStream("player2_shadow.jpg"));
    int check =0;
    int j;
    public void diceno(MouseEvent event) {
        if((bluedicetoatal == 100) || (greendicetotal == 100)) {
        }
        else{
            check++;
            dice.setDisable(true);
            Thread th = new Thread() {
                public void run() {
                    Random rand = new Random();
                    int k = 0;
                    Media sound = null;
                    try {
                        sound = new Media(getClass().getResource("dicemusic.mp3").toURI().toString());
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                    while (k < 15) {
                        j = rand.nextInt(6);
                        j = j + 1;
                        Image image = new Image(getClass().getResourceAsStream("dice" + j + ".png"));
                        dice.setImage(image);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        k++;
                    }
                    dice.setDisable(false);
                    arrow.setVisible(true);
                    if (check % 2 == 0) {
                        player1.setImage(player1highlight);
                        player2.setImage(player2shadow);
                    } else {
                        player1.setImage(player1shadow);
                        player2.setImage(player2highlight);
                    }
                    check();

                }
            };
            arrow.setVisible(false);
            th.start();
        }

    }

    int greenpositon[][] = {{13,-40},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{0,-49},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{0,-49},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{0,-49},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{0,-49},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0}};
    int bluepositon[][] = {{-14,-40},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{0,-49},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{0,-49},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{0,-49},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{0,-49},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{33,0},{0,-49},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0},{-33,0}};

    public void translate(int x , int y, ImageView player){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(player);
        translate.setByX(x);
        translate.setByY(y);
        translate.setAutoReverse(false);
        translate.play();
        translate.setOnFinished(actionEvent -> {
            dice.setDisable(false);
        });
    }

    private int checkposgreen =0;
    private int checkposblue = 0;
    private int g =0;
    private int b =0;

    public void check(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                if(check%2==1){
                    if(checkposblue==0 && j==1){
                        checkposblue = 1;
                        bluedicetoatal = bluedicetoatal + j;
                        Media sound = null;
                        try {
                            sound = new Media(getClass().getResource("unlocksound.mp3").toURI().toString());
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                        mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                        for(;b<bluedicetoatal;b++){
                            dice.setDisable(true);
                            translate(bluepositon[b][0],bluepositon[b][1],bluetoken);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else if(checkposblue==1 ){
                        bluedicetoatal = bluedicetoatal + j;
                        if(bluedicetoatal <= 100) {
                            for (; b < bluedicetoatal; b++) {
                                dice.setDisable(true);
                                translate(bluepositon[b][0], bluepositon[b][1], bluetoken);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        else{bluedicetoatal = bluedicetoatal - j;}
                        bluetokenladder();
                        bluetokensnake();
                    }
                }
                else {
                    if(checkposgreen==0 && j==1) {
                        checkposgreen =1;
                        greendicetotal = greendicetotal + j;
                        Media sound = null;
                        try {
                            sound = new Media(getClass().getResource("unlocksound.mp3").toURI().toString());
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                        mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                        for (; g < greendicetotal; g++) {
                            dice.setDisable(true);
                            translate(greenpositon[g][0], greenpositon[g][1], greentoken);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else if(checkposgreen == 1){
                        greendicetotal = greendicetotal + j;
                        if(greendicetotal <= 100) {
                            for (; g < greendicetotal; g++) {
                                dice.setDisable(true);
                                translate(greenpositon[g][0], greenpositon[g][1], greentoken);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        else{greendicetotal= greendicetotal -j;}
                        greentokenladder();
                        greentokensnake();
                    }
                }
                if((bluedicetoatal == 100) || (greendicetotal == 100)) {
                    Media sound = null;
                    try {
                        sound = new Media(getClass().getResource("Victorysound.mp3").toURI().toString());
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                    replay.setVisible(true);
                    menu.setVisible(true);
                    winbox.setVisible(true);
                    if(bluedicetoatal==100) {
                        player1dialogue.setVisible(true);
                    }
                    else{
                        player2dialogue.setVisible(true);
                    }
                }
            }
        };
        thread.start();

    }

    public void greentokenladder(){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(greentoken);
        if(greendicetotal == 3){
            greendicetotal = greendicetotal + 18;
            g = g + 18;
            translate.setToY(-138);
            translate.setToX(13);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 8){
            greendicetotal = greendicetotal + 38;
            g = g + 38;
            translate.setToY(-236);
            translate.setToX(178);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 29){
            greendicetotal = greendicetotal + 4;
            g = g + 4;
            translate.setToY(-187);
            translate.setToX(244);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 16){
            greendicetotal = greendicetotal + 10;
            g = g + 10;
            translate.setToY(-138);
            translate.setToX(178);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 37){
            greendicetotal = greendicetotal + 28;
            g = g + 28;
            translate.setToY(-334);
            translate.setToX(145);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 50){
            greendicetotal = greendicetotal + 20;
            g = g + 20;
            translate.setToY(-334);
            translate.setToX(310);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 64){
            greendicetotal = greendicetotal + 13;
            g = g + 13;
            translate.setToY(-383);
            translate.setToX(112);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 61){
            greendicetotal = greendicetotal + 21;
            g = g + 21;
            translate.setToY(-432);
            translate.setToX(46);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 76){
            greendicetotal = greendicetotal + 19;
            g = g + 19;
            translate.setToY(-481);
            translate.setToX(178);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 89){
            greendicetotal = greendicetotal + 2;
            g = g + 2;
            translate.setToY(-481);
            translate.setToX(310);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();

        }


    }

    public void bluetokenladder(){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(bluetoken);
        if(bluedicetoatal == 3){
            bluedicetoatal = bluedicetoatal + 18;
            b = b + 18;
            translate.setToY(-138);
            translate.setToX(-14);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 8){
            bluedicetoatal = bluedicetoatal + 38;
            b = b + 38;
            translate.setToY(-236);
            translate.setToX(151);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 29){
            bluedicetoatal = bluedicetoatal + 4;
            b = b + 4;
            translate.setToY(-187);
            translate.setToX(217);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 16){
            bluedicetoatal = bluedicetoatal + 10;
            b = b + 10;
            translate.setToY(-138);
            translate.setToX(151);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 37){
            bluedicetoatal = bluedicetoatal + 28;
            b = b + 28;
            translate.setToY(-334);
            translate.setToX(118);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 50){
            bluedicetoatal = bluedicetoatal + 20;
            b = b + 20;
            translate.setToY(-334);
            translate.setToX(283);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 64){
            bluedicetoatal = bluedicetoatal + 13;
            b = b + 13;
            translate.setToY(-383);
            translate.setToX(85);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 61){
            bluedicetoatal = bluedicetoatal + 21;
            b = b + 21;
            translate.setToY(-432);
            translate.setToX(19);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 76){
            bluedicetoatal = bluedicetoatal + 19;
            b = b + 19;
            translate.setToY(-481);
            translate.setToX(151);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 89){
            bluedicetoatal = bluedicetoatal + 2;
            b = b + 2;
            translate.setToY(-481);
            translate.setToX(283);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("laddersound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }

    }
    
    public void greentokensnake(){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(greentoken);
        if(greendicetotal == 24){
            greendicetotal = greendicetotal - 19;
            g = g - 19;
            translate.setToY(-40);
            translate.setToX(145);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 43){
            greendicetotal = greendicetotal - 21;
            g = g - 21;
            translate.setToY(-138);
            translate.setToX(46);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 56){
            greendicetotal = greendicetotal - 31;
            g = g - 31;
            translate.setToY(-138);
            translate.setToX(145);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 60){
            greendicetotal = greendicetotal - 18;
            g = g - 18;
            translate.setToY(-236);
            translate.setToX(45);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 69){
            greendicetotal = greendicetotal - 21;
            g = g - 21;
            translate.setToY(-236);
            translate.setToX(244);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 86){
            greendicetotal = greendicetotal - 33;
            g = g - 33;
            translate.setToY(-285);
            translate.setToX(244);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 90){
            greendicetotal = greendicetotal - 18;
            g = g - 18;
            translate.setToY(-383);
            translate.setToX(277);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 94){
            greendicetotal = greendicetotal - 21;
            g = g - 21;
            translate.setToY(-383);
            translate.setToX(244);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 96){
            greendicetotal = greendicetotal - 31;
            g = g - 31;
            translate.setToY(-432);
            translate.setToX(112);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(greendicetotal == 98){
            greendicetotal = greendicetotal - 40;
            g = g - 40;
            translate.setToY(-285);
            translate.setToX(79);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }

    }

    public void bluetokensnake(){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(bluetoken);
        if(bluedicetoatal == 24){
            bluedicetoatal = bluedicetoatal - 19;
            b = b - 19;
            translate.setToY(-40);
            translate.setToX(118);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 43){
            bluedicetoatal = bluedicetoatal - 21;
            b = b - 21;
            translate.setToY(-138);
            translate.setToX(19);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 56){
            bluedicetoatal = bluedicetoatal - 31;
            b = b - 31;
            translate.setToY(-138);
            translate.setToX(118);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 60){
            bluedicetoatal = bluedicetoatal - 18;
            b = b - 18;
            translate.setToY(-236);
            translate.setToX(19);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 69){
            bluedicetoatal = bluedicetoatal - 21;
            b = b - 21;
            translate.setToY(-236);
            translate.setToX(217);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 86){
            bluedicetoatal = bluedicetoatal - 33;
            b = b - 33;
            translate.setToY(-285);
            translate.setToX(217);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 90){
            bluedicetoatal = bluedicetoatal - 18;
            b = b - 18;
            translate.setToY(-383);
            translate.setToX(250);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 94){
            bluedicetoatal = bluedicetoatal - 21;
            b = b - 21;
            translate.setToY(-383);
            translate.setToX(217);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 96){
            bluedicetoatal = bluedicetoatal - 31;
            b = b - 31;
            translate.setToY(-432);
            translate.setToX(85);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
        if(bluedicetoatal == 98){
            bluedicetoatal = bluedicetoatal - 40;
            b = b - 40;
            translate.setToY(-285);
            translate.setToX(52);
            translate.setAutoReverse(false);
            Media sound = null;
            try {
                sound = new Media(getClass().getResource("snakesound.mp3").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            translate.play();
        }
    }

}