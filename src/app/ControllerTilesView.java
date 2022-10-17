/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ControllerTilesView implements Initializable {

    @FXML private TilePane tilePane;
    public static FileExplorerFx Fx3;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Fx3 = new ClassTilesView();
        Fx3.tilePane = tilePane;
        Fx3.CreateTiles();
    }    
    
}
