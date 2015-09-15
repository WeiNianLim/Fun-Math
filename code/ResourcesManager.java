package com.WNLCreation.funmath;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

public class ResourcesManager {

	private static final ResourcesManager INSTANCE = new ResourcesManager();
	
	public Engine engine;
	public Camera camera;
	public BaseGameActivity activity;
	public VertexBufferObjectManager vbom;
	//--------Splash--------//
	public ITextureRegion splash_region;
	public BitmapTextureAtlas splashTextureAtlas;
	//--------Menu----------//
	public ITextureRegion menu_background_region;
	public ITextureRegion play_region;
	public ITextureRegion options_region;
	private BuildableBitmapTextureAtlas menuTextureAtlas;
	//--------Loading--------//
	public ITextureRegion loading_region;
	public BitmapTextureAtlas loadingTextureAtlas;
	//--------Game-----------//
	public ITextureRegion game_background_region;
	public ITextureRegion apple_region;
	public ITextureRegion green_apple_region;
	public ITextureRegion orange_region;
	public ITextureRegion watermelon_region;
	public ITextureRegion question_1_region;
	public ITextureRegion question_2_region;
	public ITextureRegion question_3_region;
	public ITextureRegion question_4_region;
	public ITextureRegion question_5_region;
	public ITextureRegion question_6_region;
	public ITextureRegion question_7_region;
	public ITextureRegion question_8_region;
	public ITextureRegion question_9_region;
	//public ITextureRegion question_10_region;
	public ITextureRegion num4;
	public ITextureRegion num8;
	public ITextureRegion num12;
	public ITextureRegion num16;	
	public ITextureRegion tryAgain;
	public ITextureRegion menu_tryAgain;
	public BitmapTextureAtlas questionTextureAtlas;
	public BuildableBitmapTextureAtlas gameTextureAtlas;
	public Font font;
	//QuestionCompleted
	public ITextureRegion questionCompleted_background_region; 
	public ITextureRegion next_button_region;
	//Final Scene
	public BuildableBitmapTextureAtlas finalTextureAtlas;
	public ITextureRegion completedWindow_region;
	public ITextureRegion menu_button_region;
	public ITextureRegion final_background_region;
	//Options
	public BuildableBitmapTextureAtlas optionTextureAtlas;
	public ITextureRegion option_background_region;
	
	
	public void loadSplashScreen(){
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
		splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "logo_1.png", 0, 0);
		splashTextureAtlas.load();
	}
	
	public void loadMenuResources(){
		loadMenuGraphics();
		loadMenuAudio();
	}

	public void loadGameResources(){
		loadGameGraphics();
		//loadGameFonts();
		loadGameAudio();
	}
	
	public void loadLoadingResources(){
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
		loadingTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 1024, 1024);
		loading_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(loadingTextureAtlas, activity, "math_loading.png",0,0);
		loadingTextureAtlas.load();
	}
	
	private void loadMenuAudio() {
		// TODO Auto-generated method stub
		
	}

	private void loadMenuGraphics() {
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
		menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024);
		menu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "math_menu.png");
		play_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "math_play.png");
		options_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "math_option.png");
		
		try
		{
			this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,1,0));
			this.menuTextureAtlas.load();
		}catch( final  TextureAtlasBuilderException e){
			Debug.e(e);
		}
	}
	
	
	private void loadGameAudio() {
		// TODO Auto-generated method stub
		
	}

	/*private void loadGameFonts() {
		// TODO Auto-generated method stub
		FontFactory.setAssetBasePath("font/");
		final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		//font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "DarkistheNight.ttf", 50, true, Color.WHITE, 10, Color.BLUE);
		font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "cartoon_character.ttf", 50, true, Color.WHITE, 5, Color.BLUE);		
		font.load();
	
	}*/
	

	private void loadGameGraphics() {
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
		gameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 2048, 2048, TextureOptions.BILINEAR);		
		game_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "math_game.png");
		apple_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "apple.png");
		green_apple_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "green_apple.png");
		orange_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "orange.png");
		watermelon_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "watermelon.png");
		question_1_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "question1.png");
		question_2_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "question2.png");
		question_3_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "question3.png");
		question_4_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "question4.png");
		question_5_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "question5.png");
		question_6_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "question6.png");
		question_7_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "question7.png");
		question_8_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "question8.png");
		question_9_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "question9.png");
		menu_tryAgain = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "menuForTryAgain_button.png");
		tryAgain = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "tryAgain.png");
		num4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "four.png");
		num8 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "eight.png");
		num12 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "twelve.png");
		num16 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "sixteen.png");		
		questionCompleted_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "questionCompleted.png");
		next_button_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "next_button.png");
				
		try
		{
			this.gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,1,0));
			this.gameTextureAtlas.load();
		}catch( final  TextureAtlasBuilderException e){
			Debug.e(e);
		}		
	}

	public void loadFinalResources(){
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
		finalTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 2048, 2048, TextureOptions.BILINEAR);
		completedWindow_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(finalTextureAtlas, activity, "completedWindow.png");
		menu_button_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(finalTextureAtlas, activity, "menu_button2.png");
		final_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(finalTextureAtlas, activity, "math_game.png");
		
		try
		{
			this.finalTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,1,0));
			this.finalTextureAtlas.load();
		}catch( final  TextureAtlasBuilderException e){
			Debug.e(e);
		}		
	}
	
	public void loadOptionsResources(){
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
		optionTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 2048, 2048, TextureOptions.BILINEAR);
		option_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(optionTextureAtlas, activity, "option_background.png");
		try
		{
			this.optionTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,1,0));
			this.optionTextureAtlas.load();
		}catch( final  TextureAtlasBuilderException e){
			Debug.e(e);
		}		
	}
	
	public void unloadSplashScreen(){
		splashTextureAtlas.unload();
		splash_region = null;
	}
	
	public void unloadMenuTextures(){
		menuTextureAtlas.unload();
	}
	
	public void unloadOptionTextures(){
		optionTextureAtlas.unload();
	}
	
	public void unloadGameTextures(){
		gameTextureAtlas.unload();
	}
	
	public void loadMenuTextures(){
		menuTextureAtlas.load();
	}
	
	public void unloadFinalTextures(){
		finalTextureAtlas.unload();
	}
	
	public static void prepareManager(Engine engine, BaseGameActivity activity, Camera camera, VertexBufferObjectManager vbom){
		
		
		getInstance().engine = engine;
		getInstance().activity = activity;
		getInstance().camera = camera;
		getInstance().vbom = vbom;
	}
	
	public static ResourcesManager getInstance(){
		
		return INSTANCE;
	}

	
}
