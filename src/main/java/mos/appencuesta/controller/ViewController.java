package mos.appencuesta.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import mos.appencuesta.model.Alimento;
import mos.appencuesta.service.AlimentoService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import mos.appencuesta.controller.ComponentsController.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        getAlimentos();
        updateVisualIds();
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
        initialize();

    }

    @FXML
    private void getAlimentos() {


        List<Alimento> listaAlimentos = alimentoService.getAllAlimento();
        listComida.getItems().setAll(listaAlimentos);

    }



    @FXML
    private void deleteAlimentoID() {
        // Obtén el ID visual a eliminar
        Integer visualId = DeleteID.getValue();
         // Encuentra el ID de la base de datos asociado con el ID visual
        Long idBd = null;
        var alimentos = listComida.getItems(); // Obtén los elementos actuales del ListView
        for (Alimento alimento : alimentos) {
            if (alimento.getVisualId() != null && alimento.getVisualId().equals(visualId)) {
                idBd = alimento.getId();
                break;
            }
        }
        if (idBd != null) {
            // Elimina el alimento usando el ID de la base de datos
            alimentoService.DeleteAlimento(idBd);
            initialize();
        }
    }


    @FXML
    private void deleteSelectedAlimento() {
        Alimento selectedItem = listComida.getSelectionModel().getSelectedItem(); // Obtén el ítem seleccionado
        if (selectedItem != null) {

            alimentoService.DeleteAlimento(selectedItem.getId()); // Elimina por ID de la BD
            initialize();
        }
    }

    @FXML
    private void updateVisualIds() {
        List<Long> ids = alimentoService.getAllId(); //traemos los id
        HashMap<Integer, Long> idSimulacion = new HashMap<>(); //creamos un instancia hashmap

        // Asocia ID visual con ID de base de datos
        for (int i = 0; i < ids.size(); i++) { //recorremos los ids
            idSimulacion.put(i + 1, ids.get(i));
        }

        // Actualiza la lista visual en la interfaz de usuario
        listComida.getItems().forEach(alimento -> {
            // Encuentra el ID visual correspondiente
            for (Map.Entry<Integer, Long> entry : idSimulacion.entrySet()) {
                if (entry.getValue().equals(alimento.getId())) {
                    alimento.setVisualId(entry.getKey()); // Asigna el ID visual correcto
                    break;
                }
            }
        });

        // Refresca el ListView para mostrar los cambios
        listComida.refresh();
    }

    //controlación de vista de pane
    @FXML
    private Pane paneMain;
    @FXML
    private Pane paneFood;
    @FXML
    private Button btnLockerRoom;
    @FXML
    private Button btnFood;
    @FXML
    private Button btnSport;
    @FXML
    private Button btnBack;

    @FXML
    private void  changePane(){
        componentsController.PaneFood(paneMain , paneFood);
    }

    @FXML
    private void Back(){
        if (paneFood.isVisible()){
            paneFood.setVisible(false);
            paneMain.setVisible(true);
        }
    }









}