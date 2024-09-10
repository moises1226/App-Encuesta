package mos.appencuesta.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import mos.appencuesta.model.Alimento;
import mos.appencuesta.service.AlimentoService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import mos.appencuesta.controller.ComponentsController.*;

import java.util.List;

@Component
public class ViewController {

    @Autowired
    private AlimentoService alimentoService;
    @Autowired
    private ComponentsController componentsController;

    @FXML
    private ListView<Alimento> listComida = new ListView<>();

    @FXML
    private TextField fieldFood;
    @FXML
    private TextField fieldDrink;
    @FXML
    private TextField fieldDessert;

    @FXML
    private Spinner<Integer> DeleteID;

    @FXML
    private void initialize() {
        // Llama a mostrar cuando se inicialice el controlador
        componentsController.Spinner(DeleteID);
    }


    @FXML
    private void guardadoDatos(){

        String food = fieldFood.getText();
        String drink = fieldDrink.getText();
        String dessert = fieldDessert.getText();

        alimentoService.guardarDatos(food , drink , dessert);

        fieldFood.clear();
        fieldDrink.clear();
        fieldDessert.clear();
        getAlimentos();

    }

    @FXML
    private void getAlimentos() {


        List<Alimento> listaAlimentos = alimentoService.getAllAlimento();
        listComida.getItems().setAll(listaAlimentos);

    }



    @FXML
    private void deleteAlimentoID(){

        Long id = Long.valueOf(DeleteID.getValue());
        alimentoService.DeleteAlimento(id);
        getAlimentos();

    }

    @FXML
    private void deleteSelectedAlimento() {
        Alimento selectedItem = listComida.getSelectionModel().getSelectedItem(); // Obtén el ítem seleccionado
        if (selectedItem != null) {
            alimentoService.DeleteAlimento(selectedItem.getId()); // Elimina por ID de la BD
            getAlimentos(); // Actualiza la lista después de eliminar
        }
    }






}