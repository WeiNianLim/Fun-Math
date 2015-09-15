package com.WNLCreation.funmath;

import org.andengine.engine.Engine;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.scene.background.Background;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;
import org.andengine.util.adt.color.Color;

public class SceneManager {

	private BaseScene splashScene;
	private BaseScene menuScene;
	private BaseScene gameScene;
	private BaseScene loadingScene;
	private BaseScene finalScene;
	private BaseScene optionScene;
	
	private static final SceneManager INSTANCE = new SceneManager();
	
	private SceneType currentSceneType = SceneType.SCENE_SPLASH;
	
	private BaseScene currentScene;
	
	private Engine engine = ResourcesManager.getInstance().engine;
	
	public enum SceneType
	{	
		SCENE_SPLASH,
		SCENE_MENU,
		SCENE_GAME,
		SCENE_LOADING,
		SCENE_FINAL,
		SCENE_OPTION,
	}
	
	public void setScene(BaseScene scene){
		
		engine.setScene(scene);
		currentScene = scene;
		currentSceneType = scene.getSceneType();
	}
	
	public void setScene(SceneType sceneType){
		switch(sceneType){
		case SCENE_SPLASH:
			setScene(splashScene);
			break;
		case SCENE_MENU:
			setScene(menuScene);
			break;
		case SCENE_GAME:
			setScene(gameScene);
			break;
		case SCENE_LOADING:
			setScene(loadingScene);
			break;
		case SCENE_FINAL:
			setScene(finalScene);
			break;
		case SCENE_OPTION:
			setScene(optionScene);
			break;
		default:
			break;
		}
	}
	
	public void setCurrentSceneType(SceneType currentSceneType) {
		this.currentSceneType = currentSceneType;
	}

	public void setCurrentScene(BaseScene currentScene) {
		this.currentScene = currentScene;
	}

	public static SceneManager getInstance(){
		return INSTANCE;
	}
	
	public SceneType getCurrentSceneType(){
		return currentSceneType;
	}
	
	public BaseScene getCurrentScene(){
		return currentScene;
	}
	
	public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback){
		ResourcesManager.getInstance().loadSplashScreen();
		splashScene = new SplashScene();
		splashScene.setBackground(new Background(Color.WHITE));
		currentScene = splashScene;
		pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
	}
	
	public void createMenuScene(){
		ResourcesManager.getInstance().loadMenuResources();
		menuScene = new MainMenuScene();
		SceneManager.getInstance().setScene(menuScene);
		disposeSplashScene();
	}	
	
	private void disposeSplashScene(){
		ResourcesManager.getInstance().unloadSplashScreen();
		splashScene.disposeScene();
		splashScene = null;
	}
	
	 public void loadGameScene(final Engine mEngine){
			
			ResourcesManager.getInstance().loadLoadingResources();
			loadingScene = new LoadingScene();
			setScene(loadingScene);
			ResourcesManager.getInstance().unloadMenuTextures();
			mEngine.registerUpdateHandler(new TimerHandler(0.5f, new ITimerCallback(){

				@Override
				public void onTimePassed(final TimerHandler pTimerHandler) {
					// TODO Auto-generated method stub
					mEngine.unregisterUpdateHandler(pTimerHandler);
					ResourcesManager.getInstance().loadGameResources();
					gameScene = new GameScene();
					setScene(gameScene);
				}
				
			}));
		}
	
	public void loadMenuScene(final Engine mEngine){
		
		ResourcesManager.getInstance().loadLoadingResources();
		loadingScene = new LoadingScene();
		setScene(loadingScene);
		gameScene.dispose();
		ResourcesManager.getInstance().unloadGameTextures();
		mEngine.registerUpdateHandler(new TimerHandler(0.5f, new ITimerCallback(){

			@Override
			public void onTimePassed(final TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				ResourcesManager.getInstance().loadMenuTextures();
				setScene(menuScene);
			}
			
		}));
	}
	
	public void createFinalScene(final Engine mEngine){
		
		ResourcesManager.getInstance().loadFinalResources();
		finalScene = new FinalScene();
		SceneManager.getInstance().setScene(finalScene);
		gameScene.dispose();
		
	}	
	
    public void loadMenuFromFinalScene(final Engine mEngine){
		
		ResourcesManager.getInstance().loadLoadingResources();
		loadingScene = new LoadingScene();
		setScene(loadingScene);
		finalScene.dispose();
		ResourcesManager.getInstance().unloadFinalTextures();
		mEngine.registerUpdateHandler(new TimerHandler(0.5f, new ITimerCallback(){

			@Override
			public void onTimePassed(final TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				ResourcesManager.getInstance().loadMenuTextures();
				setScene(menuScene);
			}
			
		}));
	}
    
    public void loadOptionScene(final Engine mEngine){
		
		ResourcesManager.getInstance().loadLoadingResources();
		loadingScene = new LoadingScene();
		setScene(loadingScene);
		ResourcesManager.getInstance().unloadMenuTextures();
		mEngine.registerUpdateHandler(new TimerHandler(0.5f, new ITimerCallback(){

			@Override
			public void onTimePassed(final TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				ResourcesManager.getInstance().loadOptionsResources();
				optionScene = new Options();
				setScene(optionScene);
			}
			
		}));
	}

    public void loadMenuFromOptionScene(final Engine mEngine){
		
		ResourcesManager.getInstance().loadLoadingResources();
		loadingScene = new LoadingScene();
		setScene(loadingScene);
		optionScene.dispose();
		ResourcesManager.getInstance().unloadOptionTextures();
		mEngine.registerUpdateHandler(new TimerHandler(0.5f, new ITimerCallback(){

			@Override
			public void onTimePassed(final TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				ResourcesManager.getInstance().loadMenuTextures();
				setScene(menuScene);
			}
			
		}));
	}
    
}
