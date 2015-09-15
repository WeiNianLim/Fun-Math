package com.WNLCreation.funmath;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.WNLCreation.funmath.SceneManager.SceneType;

public class SplashScene extends BaseScene{

	private Sprite splash;
	
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		splash = new Sprite(0,0,resourcesManager.splash_region, vbom)
		{
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}			
		};
		
		splash.setPosition(270, 480);
		attachChild(splash);
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_SPLASH;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		splash.detachSelf();
		splash.dispose();
		this.detachSelf();
		this.dispose();
	}

}
