package smashattack.smashattack.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import smashattack.smashattack.base.BaseScene;
import smashattack.smashattack.manager.SceneManager.SceneType;

public class SplashScene extends BaseScene {

    private Sprite splash;
    private static final int positionX = 540;
    private static final int positionY = 960;

    @Override
    public void createScene() {

        splash = new Sprite(0, 0, resourcesManager.splash_region, vbom){
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera){
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };

        splash.setScale(1.5f);
        splash.setPosition(positionX, positionY);
        attachChild(splash);

    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public SceneType getSceneType() {

        return SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene() {

        splash.detachSelf();
        splash.dispose();
        this.detachSelf();
        this.dispose();
    }
}
