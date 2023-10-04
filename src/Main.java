import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    private static String MAIN_APP_SCENE_PATH = "/test.fxml";
    private static String APPLICATION_TITLE = "Генетический Алгоритм";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Pane root = FXMLLoader.load(getClass().getResource(MAIN_APP_SCENE_PATH));
            stage.setScene(new Scene(root));
            stage.setTitle(APPLICATION_TITLE);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Error: no scene file found under path: \"" + MAIN_APP_SCENE_PATH + "\"");
            return;
        }
        stage.show();
    }
}