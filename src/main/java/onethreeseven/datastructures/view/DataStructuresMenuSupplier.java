package onethreeseven.datastructures.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import onethreeseven.trajsuitePlugin.model.BaseTrajSuiteProgram;
import onethreeseven.trajsuitePlugin.view.*;

import java.io.IOException;
import java.net.URL;

/**
 * Menu supplier for this plugin.
 * @author Luke Bermingham
 */
public class DatastructuresMenuSupplier implements MenuSupplier {

    @Override
    public void supplyMenus(AbstractMenuBarPopulator populator, BaseTrajSuiteProgram program, Stage stage) {

        TrajSuiteMenu fileMenu = new TrajSuiteMenu("File", -99);
        TrajSuiteMenu loadSubMenu = new TrajSuiteMenu("Load", -1);
        fileMenu.addChild(loadSubMenu);
        loadSubMenu.addChild(new TrajSuiteMenuItem("Trajectory", ()->{
            ViewUtil.loadUtilityView(DatastructuresMenuSupplier.class, stage, "Load Trajectories",
                    "/onethreeseven/datastructures/view/LoadTrajectory.fxml");
        }));

        populator.addMenu(fileMenu);
    }

    private void showLoadTrajectoryView(){
        URL viewUrl = DatastructuresMenuSupplier.class
                .getResource("/onethreeseven/datastructures/view/LoadTrajectory.fxml");

        if(viewUrl == null){
            System.err.println("Could not get LoadTrajectory view for some reason.");
            return;
        }

        FXMLLoader loader = new FXMLLoader(viewUrl);
        try {
            Parent view = loader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Load Trajectory");
            stage.initOwner(stage);
            stage.setScene(new Scene(view));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
