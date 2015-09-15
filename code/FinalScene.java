package com.WNLCreation.funmath;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.WNLCreation.funmath.SceneManager.SceneType;


public class FinalScene extends BaseScene implements IOnMenuItemClickListener{

	private Entity completedWindow;
	private MenuScene backChildScene;	
	private final int BACK = 10;
	
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
		createCompletedWindow();
		createBackMenu();
	}

	private void createBackground() {

		attachChild(new Sprite(270, 480,resourcesManager.final_background_region, vbom) {

			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});			
	}
	
	private void createCompletedWindow(){

		completedWindow = new Entity();
		attachChild(completedWindow);
		completedWindow.setAnchorCenter(0, 0);
		completedWindow.setAlpha(0f);
		completedWindow.attachChild(new Sprite(270, 540, resourcesManager.completedWindow_region, vbom));

	}
	
	public void createBackMenu(){
		
		backChildScene = new MenuScene(camera);
		backChildScene.setPosition(0, 0);
		
		final IMenuItem next = new ScaleMenuItemDecorator(new SpriteMenuItem(BACK, resourcesManager.menu_button_region, vbom), 1.2f, 1);
				
		backChildScene.addMenuItem(next);
		
		backChildScene.buildAnimations();
		backChildScene.setBackgroundEnabled(false);
		
		next.setPosition(270, 290);
		
		backChildScene.setOnMenuItemClickListener(this);
		
		setChildScene(backChildScene);
		
	}	
	
	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_FINAL;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		switch(pMenuItem.getID()){
			case BACK:	
			SceneManager.getInstance().loadMenuFromFinalScene(engine);				
			return true;
		default:
			return false;
		}
	}

}
