package sut.game01.core;


import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Mouse;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

import static playn.core.PlayN.*;


public class SettingScreen extends Screen {

    private final Image set;
    private final ImageLayer setting;
    private final ScreenStack ss;
    private final SoundSetting soundSetting;
    private  final ImageLayer settingLayer;
    private  final ImageLayer soundLayer;
    private  final HelpScreen helpScreen;



    public SettingScreen(final ScreenStack ss) {
        this.ss = ss;
        this.soundSetting = new SoundSetting(ss);
        this.helpScreen = new HelpScreen(ss);

        set = assets().getImage("images/Bg1.png");
        setting = graphics().createImageLayer(set);

//=======================================================================
//                      backSettting
//=======================================================================

        Image backImage = assets().getImage("images/pum.png");
        this.settingLayer = graphics().createImageLayer(backImage);
        settingLayer.setTranslation(10 , 10);

        settingLayer.addListener(new Mouse.LayerAdapter(){
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.remove(ss.top());
            }
        });


//=======================================================================
//                      Sound
//=======================================================================

        Image startButton = assets().getImage("images/sound.png");
        soundLayer = graphics().createImageLayer(startButton);
        soundLayer.setTranslation(245,250);

        soundLayer.addListener(new Mouse.LayerAdapter() {

            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.push(soundSetting);
            }
        });


    }

    @Override
    public void wasShown() {
        super.wasShown();
        this.layer.add(setting);
        this.layer.add(settingLayer);
        this.layer.add(soundLayer);

    }

}



