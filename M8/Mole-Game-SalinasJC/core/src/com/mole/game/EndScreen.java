package com.mole.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.event.KeyEvent;

public class EndScreen implements Screen {

    Main game;
    int contador;
    private Stage stage;
    private Texture background;
    private Texture restart;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton btnRestart;

    public EndScreen(Main game, int contador) {
        this.game = game;
        this.contador = contador;
    }

    @Override
    public void show() {
        background = new Texture(Gdx.files.internal("endScreen.png"));

        restart = new Texture(Gdx.files.internal("restart.png"));
        myTextureRegion = new TextureRegion(restart);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        btnRestart = new ImageButton(myTexRegionDrawable); //Set the button up

        btnRestart.setPosition(Gdx.graphics.getWidth()-160,10);
        btnRestart.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //He tenido que moverlo de posicion porque se bugeaba
                btnRestart.setPosition(-1000, -1000);
                game.setScreen( new GameScreen(game) );
            };
        });
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(btnRestart); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(background, 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.font.draw(game.batch, "Topos Machacados: " + contador, 290, 130);
        game.font.getData().setScale(2);
        game.batch.end();

        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw(); //Draw the ui
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        background.dispose();
        restart.dispose();
    }
}
