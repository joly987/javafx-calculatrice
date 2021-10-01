package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        SimpleController controller = loader.getController();
        primaryStage.getIcons().add(new Image("./IMAGE/techdev.png"));
        primaryStage.setTitle("CACULETTE DE LA MORT DE RANIHAU VETS MOE");
        Scene scene = new Scene(root, 610, 482);

        /** Instanciation avec la fonction clavier du SimpleController **/
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent KeyEvent) {
                System.out.println(String.valueOf(KeyEvent.getCode()));
                switch (String.valueOf(KeyEvent.getText())) {
                    case "-" :
                        controller.clavier("SUBTRACT");
                        break;
                    default :
                        controller.clavier(String.valueOf(KeyEvent.getCode()));
                        break;
                }

            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
