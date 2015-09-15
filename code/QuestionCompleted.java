package com.WNLCreation.funmath;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;


public class QuestionCompleted extends Sprite{

    
    public QuestionCompleted(VertexBufferObjectManager pSpriteVertexBufferObject)
    {
        super(0, 0, 480, 600, ResourcesManager.getInstance().questionCompleted_background_region, pSpriteVertexBufferObject);       
    }    
   
    public void display( Scene scene, Camera camera)
    {       
        setPosition(camera.getCenterX(), camera.getCenterY());
        scene.attachChild(this);
    }
}
