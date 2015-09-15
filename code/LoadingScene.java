package com.WNLCreation.funmath;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.WNLCreation.funmath.SceneManager.SceneType;

public class LoadingScene extends BaseScene {

	private Sprite loading;
	
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
	}

	private void createBackground() {

		loading = new Sprite(0, 0,resourcesManager.loading_region, vbom) 
		{
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		};
		loading.setPosition(270, 480);
		attachChild(loading);
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_LOADING;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

}
