package mos.appencuesta.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class ComponentsController {


    @FXML
    public void Spinner(Spinner<Integer> id) {

        SpinnerValueFactory<Integer> valores1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        id.setValueFactory(valores1);

    }



}
