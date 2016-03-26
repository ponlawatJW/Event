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

/**
 * Created by Chatethakhun on 23/3/2559.
 */
public class HomeScreen extends UIScreen {
    public static final Font TITLE_FONT = graphics().createFont(
            "Helvetica",
            Font.Style.PLAIN,
            25);

    private final ScreenStack ss;
    private final TestScreen testScreen;

    private Root root;
    private   ImageLayer start;

    public HomeScreen(ScreenStack ss) {
        
        this.ss = ss;
        this.testScreen = new TestScreen(ss);

    }

    @Override

    public void wasShown() {
        super.wasShown();
        root = iface.createRoot(
                AxisLayout.vertical().gap(15),
                SimpleStyles.newSheet(), layer);

        /////////

        root.addStyles(Style.BACKGROUND
                .is(Background.image(assets().getImage("images/Bg0.png"))));
        root.setSize(width(), height());

        /////////  Start

        Image startButton = assets().getImage("images/start.png");
        start = graphics().createImageLayer(startButton);
        start.setTranslation(245,330);
        
        start.addListener(new Mouse.LayerAdapter() {
        
    @Override
        public void onMouseUp(Mouse.ButtonEvent event) {
            System.out.printf("Click Play Game.\n");
                ss.push(testScreen);
        }
        });

        this.layer.add(start);

        ///////

        root.add(new Label("Event Driven Programmimg")
                .addStyles(Style.FONT.is(HomeScreen.TITLE_FONT)));



        root.add(new Button("Start").onClick(new UnitSlot(){
            @Override
            public void onEmit() {
                ss.push(new TestScreen(ss));
            }
        }));
    }
}










