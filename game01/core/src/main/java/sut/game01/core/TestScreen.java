package sut.game01.core;

import  playn.core.ImageLayer;
        import playn.core.Mouse;
        import playn.core.PlayN.*;
        import tripleplay.game.Screen;
        import tripleplay.game.ScreenStack;
        import tripleplay.game.UIScreen;
        import playn.core.Image;

        import static playn.core.PlayN.*;


/**
 * Created by Administrator on 23/3/2559.
 */
public class TestScreen extends Screen {
    private final ScreenStack ss;
    private final ImageLayer bg;
    private final ImageLayer backButton;

    public TestScreen(final ScreenStack ss) {
        this.ss = ss;

        Image bgImage = assets().getImage("images/Bg1.png");
        this.bg = graphics().createImageLayer(bgImage);


        Image backImage = assets().getImage("images/pum.png");
        this.backButton = graphics().createImageLayer(backImage);
        backButton.setTranslation(10 , 10);

        backButton.addListener(new Mouse.LayerAdapter(){
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.remove(ss.top());
            }
        });

    }

    @Override
    public void wasShown() {
        super.wasShown();
        this.layer.add(bg);
        this.layer.add(backButton);
    }
}