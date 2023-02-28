package HomeManager.View;

import HomeManager.Controller.Util;

public class Main {
    public static void main(String[] args) throws Exception{
        Util.loadFile();
        
        HomeJFrame JHome = new HomeJFrame();
        JHome.setVisible(true);
    }
}
