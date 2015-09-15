package com.WNLCreation.funmath;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.WNLCreation.funmath.SceneManager.SceneType;

public class Options extends BaseScene{

	private Sprite background;
	
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		background = new Sprite(0,0,resourcesManager.option_background_region, vbom)
		{
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}			
		};
		
		background.setPosition(270, 480);
		attachChild(background);
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		 SceneManager.getInstance().loadMenuFromOptionScene(engine);
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_OPTION;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}

}
