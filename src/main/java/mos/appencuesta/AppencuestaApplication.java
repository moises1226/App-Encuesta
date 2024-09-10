package mos.appencuesta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppencuestaApplication extends Application {

	private ApplicationContext springContext;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		// Inicializar el contexto de Spring
		springContext = SpringApplication.run(AppencuestaApplication.class);

		// Configurar el FXMLLoader para usar Spring
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sm.appencuesta/main.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);  // Inyecta controladores desde el contexto de Spring

		// Cargar la escena y mostrarla
		var scene = new Scene(fxmlLoader.load(), 640, 610);
		stage.setTitle("Encuesta");
		stage.setScene(scene);
		stage.show();
	}
}
