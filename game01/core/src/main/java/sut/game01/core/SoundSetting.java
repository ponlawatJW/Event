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
public class SoundSetting extends Screen {

    private final ScreenStack ss;
    private final Image sound;
    private  final ImageLayer soundLayer;
    private  final  Image back;
    private  final  ImageLayer backLayer;



    public SoundSetting(final ScreenStack ss){
        this.ss = ss;

        sound = assets().getImage("images/Bg1.png");
        soundLayer = graphics().createImageLayer(sound);

 //=======================================================================
//                      Sound
//=======================================================================
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
        this.layer.add(soundLayer);
        this.layer.add(backLayer);
    }
}
