/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.ifsc.fln.controller;

import br.edu.ifsc.fln.model.domain.Motor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mpisc
 */
public class FXMLAnchorPaneProcessoEstoqueMovimentoDialogController implements Initializable {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btConfirmar;

    @FXML
    private TextField tfQuantidade;
    
    @FXML
    private Label lbQuantidadeAtual;
    
    private Stage dialogStage;
    private boolean btConfirmarClicked = false;
    private Motor motor;
    
    private String tipoMovimento;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }       

    public boolean isBtConfirmarClicked() {
        return btConfirmarClicked;
    }

    public void setBtConfirmarClicked(boolean btConfirmarClicked) {
        this.btConfirmarClicked = btConfirmarClicked;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        btConfirmar.setText(tipoMovimento);
    }

    public Motor getEstoque() {
        return motor;
    }

    public void setEstoque(Motor motor) {
        this.motor = motor;
        this.lbQuantidadeAtual.setText(Integer.toString(motor.getQuantidade()));
    }
    
    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }
    
    @FXML
    public void handleBtConfirmar() {
        try {
            if (tipoMovimento.equalsIgnoreCase("Repor")) {
                motor.repor(Integer.parseInt(tfQuantidade.getText()));
            } else {
                motor.retirar(Integer.parseInt(tfQuantidade.getText()));
            }
            btConfirmarClicked = true;
            dialogStage.close();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro na movimentação");
            alert.setHeaderText("Corrija a quantidade ou cancele a operação!");
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }
    
    @FXML
    public void handleBtCancelar() {
        dialogStage.close();
    }
    
    
}
