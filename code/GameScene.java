package com.WNLCreation.funmath;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.util.adt.align.HorizontalAlign;

import com.WNLCreation.funmath.SceneManager.SceneType;

public class GameScene extends BaseScene implements IOnMenuItemClickListener{

	private Text scoreText;
	//private int score = 0;
	private MenuScene gameChildScene;
	private MenuScene nextChildScene;
	private MenuScene tryChildScene;
	private final int NUM4 = 0;
	private final int NUM8 = 1;
	private final int NUM12 = 2;
	private final int NUM16 = 3;
	private final int NEXT = 4;
	private final int TRY = 5;
	private final int MENU_TRY = 6;
	private Entity fruits;
	private QuestionCompleted questionCompleted;
	int questionTracker = 0;
	private ITextureRegion region;

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
		createQuestionImage();
		createChoicesMenu();
		questionCompleted = new QuestionCompleted(vbom);
	}

	private void createBackground() {

		attachChild(new Sprite(270, 480,resourcesManager.game_background_region, vbom) {

			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});			
	}
		
	private void createQuestionImage(){
		
		fruits = new Entity();
		attachChild(fruits);
		fruits.setAnchorCenter(0, 0);
		fruits.setAlpha(0f);
		fruits.attachChild(new Sprite(45, 900, resourcesManager.apple_region, vbom));
		fruits.attachChild(new Sprite(45, 830, resourcesManager.apple_region, vbom));
		fruits.attachChild(new Sprite(45, 760, resourcesManager.apple_region, vbom));
		fruits.attachChild(new Sprite(45, 690, resourcesManager.apple_region, vbom));
		fruits.attachChild(new Sprite(120, 900, resourcesManager.green_apple_region, vbom));
		fruits.attachChild(new Sprite(120, 830, resourcesManager.green_apple_region, vbom));
		fruits.attachChild(new Sprite(120, 760, resourcesManager.green_apple_region, vbom));
		fruits.attachChild(new Sprite(120, 690, resourcesManager.green_apple_region, vbom));
		fruits.attachChild(new Sprite(195, 900, resourcesManager.orange_region, vbom));
		fruits.attachChild(new Sprite(195, 830, resourcesManager.orange_region, vbom));
		fruits.attachChild(new Sprite(195, 760, resourcesManager.orange_region, vbom));
		fruits.attachChild(new Sprite(195, 690, resourcesManager.orange_region, vbom));
		fruits.attachChild(new Sprite(270, 900, resourcesManager.watermelon_region, vbom));
		fruits.attachChild(new Sprite(270, 830, resourcesManager.watermelon_region, vbom));
		fruits.attachChild(new Sprite(270, 760, resourcesManager.watermelon_region, vbom));
		fruits.attachChild(new Sprite(270, 690, resourcesManager.watermelon_region, vbom));
		fruits.attachChild(new Sprite(345, 900, resourcesManager.apple_region, vbom));
		fruits.attachChild(new Sprite(345, 830, resourcesManager.apple_region, vbom));
		fruits.attachChild(new Sprite(345, 760, resourcesManager.apple_region, vbom));
		fruits.attachChild(new Sprite(345, 690, resourcesManager.apple_region, vbom));
		fruits.attachChild(new Sprite(425, 900, resourcesManager.green_apple_region, vbom));
		fruits.attachChild(new Sprite(425, 830, resourcesManager.green_apple_region, vbom));
		fruits.attachChild(new Sprite(425, 760, resourcesManager.green_apple_region, vbom));
		fruits.attachChild(new Sprite(425, 690, resourcesManager.green_apple_region, vbom));
		fruits.attachChild(new Sprite(500, 900, resourcesManager.orange_region, vbom));
		fruits.attachChild(new Sprite(500, 830, resourcesManager.orange_region, vbom));
		fruits.attachChild(new Sprite(500, 760, resourcesManager.orange_region, vbom));
		fruits.attachChild(new Sprite(500, 690, resourcesManager.orange_region, vbom));		
		createQuestionDisplay();
	}
	
	private void createQuestionDisplay() {
		// TODO Auto-generated method stub
		
		if( questionTracker == 0){
			region = resourcesManager.question_1_region;
		}else if (questionTracker == 1) {
			region = resourcesManager.question_2_region;
		}else if (questionTracker == 2) {
			region = resourcesManager.question_3_region;
		}else if (questionTracker == 3) {
			region = resourcesManager.question_4_region;
		}else if (questionTracker == 4) {
			region = resourcesManager.question_5_region;
		}else if (questionTracker == 5) {
			region = resourcesManager.question_6_region;
		}else if (questionTracker == 6) {
			region = resourcesManager.question_7_region;
		}else if (questionTracker == 7) {
			region = resourcesManager.question_8_region;
		}else if (questionTracker == 8) {
			region = resourcesManager.question_9_region;
		}
		
		fruits.attachChild(new Sprite(270, 480, region, vbom));
	}

	public void createScoreTextDisplay(){
		scoreText = new Text(20, 20, resourcesManager.font, "Score: 0123456789", new TextOptions(HorizontalAlign.LEFT),vbom);
		scoreText.setAnchorCenter(0, 0);
		scoreText.setText("Score:0");
		fruits.attachChild(scoreText);	
			
	}
	//private void addToScore(int i) {
		//score += i;
		//scoreText.setText("Score: " + score);
	//}
	
	public void createChoicesMenu(){
		
		gameChildScene = new MenuScene(camera);
		gameChildScene.setPosition(0, 0);
		
		final IMenuItem num_4 = new ScaleMenuItemDecorator(new SpriteMenuItem(NUM4, resourcesManager.num4, vbom), 1.2f, 1);
		final IMenuItem num_8 = new ScaleMenuItemDecorator(new SpriteMenuItem(NUM8, resourcesManager.num8, vbom), 1.2f, 1);
		final IMenuItem num_12 = new ScaleMenuItemDecorator(new SpriteMenuItem(NUM12, resourcesManager.num12, vbom), 1.2f, 1);
		final IMenuItem num_16 = new ScaleMenuItemDecorator(new SpriteMenuItem(NUM16, resourcesManager.num16, vbom), 1.2f, 1);
		
		gameChildScene.addMenuItem(num_4);
		gameChildScene.addMenuItem(num_8);
		gameChildScene.addMenuItem(num_12);
		gameChildScene.addMenuItem(num_16);
		
		gameChildScene.buildAnimations();
		gameChildScene.setBackgroundEnabled(false);
				
		num_4.setPosition(75, 200);
		num_8.setPosition(205, 200);
		num_12.setPosition(335, 200);
		num_16.setPosition(465, 200);
		gameChildScene.setOnMenuItemClickListener(this);
		
		setChildScene(gameChildScene);
		
	}	
	public void createNextMenu(){
		
		nextChildScene = new MenuScene(camera);
		nextChildScene.setPosition(0, 0);
		
		final IMenuItem next = new ScaleMenuItemDecorator(new SpriteMenuItem(NEXT, resourcesManager.next_button_region, vbom), 1.2f, 1);
				
		nextChildScene.addMenuItem(next);
		
		nextChildScene.buildAnimations();
		nextChildScene.setBackgroundEnabled(false);
		
		next.setPosition(275, 265);
		
		nextChildScene.setOnMenuItemClickListener(this);
		
		setChildScene(nextChildScene);
		
	}	
	
	public void createTryAgainMenu(){
		
		tryChildScene = new MenuScene(camera);
		tryChildScene.setPosition(0, 0);
		
		final IMenuItem try_again = new ScaleMenuItemDecorator(new SpriteMenuItem(TRY, resourcesManager.tryAgain, vbom), 1.2f, 1);
		final IMenuItem menu_try_again = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_TRY, resourcesManager.menu_tryAgain, vbom), 1.2f, 1);
		
		tryChildScene.addMenuItem(try_again);
		tryChildScene.addMenuItem(menu_try_again);
		
		tryChildScene.buildAnimations();
		tryChildScene.setBackgroundEnabled(false);
		
		try_again.setPosition(270, 600);
		menu_try_again.setPosition(270, 380);
		
		tryChildScene.setOnMenuItemClickListener(this);
		
		setChildScene(tryChildScene);
		
		
	}	
			
	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		switch(pMenuItem.getID()){
		case NUM4:
			
			if( questionTracker ==  2){
				
			questionCompleted.display(GameScene.this, camera);
			gameChildScene.detachSelf();
			fruits.detachSelf();
			createNextMenu();			
			questionTracker++;
			
			} else {
				gameChildScene.detachSelf();
				fruits.detachSelf();
				createTryAgainMenu();				
			}
			return true;
			
		case NUM8:
			
			if(questionTracker == 0 || questionTracker == 1 || questionTracker == 3)
			{
			questionCompleted.display(GameScene.this, camera);
			gameChildScene.detachSelf();
			fruits.detachSelf();
			createNextMenu();			
			questionTracker++;
			
			} else {
				gameChildScene.detachSelf();
				fruits.detachSelf();
				createTryAgainMenu();				
			}
			return true;
			
		case NUM12:
			
			if(questionTracker == 6 || questionTracker == 7)
			{
			questionCompleted.display(GameScene.this, camera);
			gameChildScene.detachSelf();
			fruits.detachSelf();
			createNextMenu();			
			questionTracker++;
			
			} else {
				gameChildScene.detachSelf();
				fruits.detachSelf();
				createTryAgainMenu();				
			}
			return true;	
			
		case NUM16:
			
			if(questionTracker == 4 || questionTracker == 5 ) 
			{
			questionCompleted.display(GameScene.this, camera);
			gameChildScene.detachSelf();
			fruits.detachSelf();
			createNextMenu();			
			questionTracker++;
			
			} else if (questionTracker == 8) {
				
				SceneManager.getInstance().createFinalScene(engine);
				
			}else{
				
				gameChildScene.detachSelf();
				fruits.detachSelf();
				createTryAgainMenu();				
			}
			return true;			
		case NEXT:			
			
				nextChildScene.detachSelf();
				questionCompleted.detachSelf();
				createQuestionDisplay();
				createChoicesMenu();
				createQuestionImage();
					
			return true;
		case TRY:			
			
			tryChildScene.detachSelf();
			createQuestionDisplay();
			createChoicesMenu();
			createQuestionImage();
				
		return true;
		
		case MENU_TRY:			
			
			SceneManager.getInstance().loadMenuScene(engine);
				
		return true;
		default:
			return false;
		}
		
	}
	
	
	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		 SceneManager.getInstance().loadMenuScene(engine);
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_GAME;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}

}
