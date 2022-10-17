/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.awt.Desktop;
import java.io.File;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Admin
 */
public class ClassTilesView extends FileExplorerFx{
    public ClassTilesView(){}
    @Override
    public void CreateTiles() {
        File[] fl;
        if(CurrDirFile==null){
            CurrDirFile = new File("./");
        }
        fl = CurrDirFile.listFiles();
        if(CurrDirName.equals("This PC")){
            fl=File.listRoots();
        }
        int len = fl.length;
        tilePane.getChildren().clear();
        for (int i = 0; i < len; i++) {
            Label title = new Label(fl[i].getName());
            title.setId(fl[i].getName());
            ImageView imageview = new ImageView(getIconImageFX(fl[i]));
            VBox vbox = new VBox();
            vbox.setId(fl[i].getName());
            vbox.getChildren().addAll(imageview,title);
            vbox.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getClickCount()==2){
                        System.out.println("Tile pressed "+vbox.getId());
                        String str = vbox.getId();
                        String str1 = CurrDirStr+"\\"+str;
                        File f = new File(str1);
                        if(f.isFile()){
                            Desktop d = Desktop.getDesktop();
                            try{
                                d.open(f);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }else{
                            CurrDirStr = str1;
                            CurrDirFile = new File(CurrDirStr);
                            setLabelTxt();
                            tilePane.getChildren().clear();
                            CreateTiles();
                        }
                    }
                }
            });
            TilePane.setAlignment(vbox, Pos.BOTTOM_LEFT);
            tilePane.getChildren().add(vbox);
        }
    }
    @Override
    public TreeItem<String>[] TreeCreate(File dir) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String FindAbsolutePath(TreeItem<String> item, String s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CreateTreeView(TreeView<String> treeview) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CreateTableView(TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date, TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CreateTableView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void CreateTilesView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Initiate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setValues(TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date, TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
