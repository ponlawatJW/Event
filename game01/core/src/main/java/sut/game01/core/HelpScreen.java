package sut.game01.core;


import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Mouse;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

import static playn.core.PlayN.*;

/**
 * Created by PONLAWAT_JW on 26/3/2559.
 */
public class HelpScreen extends Screen {
    private final ScreenStack ss;
    private final Image help;
    private final ImageLayer helpLayer;
    private  final  Image back;
    private  final  ImageLayer backLayer;

    public HelpScreen(final ScreenStack ss) {
        this.ss = ss;


        help = assets().getImage("images/Bg1.png");
        helpLayer = graphics().createImageLayer(help);

        back = assets().getImage("images/pum.png");
        backLayer = graphics().createImageLayer(back);
        backLayer.setTranslation(10,10);

        backLayer.addListener(new Mouse.LayerAdapter(){
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.remove(ss.top());
            }

        });
    }

    @Override
    public void wasShown() {
        super.wasShown();
        this.layer.add(helpLayer);
        this.layer.add(backLayer);
    }
}



