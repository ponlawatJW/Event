package sut.game01.core;

import playn.core.Font;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Mouse;
import react.UnitSlot;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;
import tripleplay.ui.*;
import tripleplay.ui.layout.AxisLayout;

import static playn.core.PlayN.*;



public class HomeScreen extends UIScreen {
    public static final Font TITLE_FONT = graphics().createFont(
            "Helvetica",
            Font.Style.PLAIN,
            25);

    private final ScreenStack ss;
    private final TestScreen testScreen;
    private final HelpScreen helpScreen;


    private Root root;
    private   ImageLayer start;
    private  ImageLayer setting;
    private  final  SettingScreen settingscreen;
    private  final Image help;
    private final ImageLayer helpLayer;
    

    public HomeScreen(final ScreenStack ss) {
        
        this.ss = ss;
        this.testScreen = new TestScreen(ss);
        this.settingscreen = new SettingScreen(ss);
        this.helpScreen = new HelpScreen(ss);

        root = iface.createRoot(
                AxisLayout.vertical().gap(15),
                SimpleStyles.newSheet(), layer);

//=======================================================================
//                      background
//=======================================================================

        root.addStyles(Style.BACKGROUND
                .is(Background.image(assets().getImage("images/Bg0.png"))));
        root.setSize(width(), height());

//=======================================================================
//                      Start
//=======================================================================

        Image startButton = assets().getImage("images/start.png");
        start = graphics().createImageLayer(startButton);
        start.setTranslation(245,250);

        start.addListener(new Mouse.LayerAdapter() {

            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.push(testScreen);
            }
        });

//=======================================================================
//                      setting
//=======================================================================

        Image set = assets().getImage("images/st.png");
        setting = graphics().createImageLayer(set);
        setting.setTranslation(245,330);

        setting.addListener(new Mouse.LayerAdapter() {

            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.push(settingscreen);
            }
        });

//=======================================================================
//                     Help
//=======================================================================

        help = assets().getImage("images/help.png");
        helpLayer = graphics().createImageLayer(help);
        helpLayer.setTranslation(245,370);

        helpLayer.addListener(new Mouse.LayerAdapter(){
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.push(helpScreen);
            }
        });

    }

    @Override

    public void wasShown() {
        super.wasShown();

        this.layer.add(start);

        this.layer.add(setting);
        this.layer.add(helpLayer);

    }
}










