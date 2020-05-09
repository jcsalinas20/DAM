package com.mole.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen {

    Main game;
    Texture background;
    Texture imgStart;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    ImageButton btnStart;
    private Stage stage;

    static boolean primerSprite = true;
    static boolean segundoSprite = true;

    TextureAtlas textureAtlas;
    Sprite spriteAnimation;
    String nameSprite;
    SpriteBatch batch;
    OrthographicCamera camera;
    ExtendViewport viewport;
    float segundos = 0.5f;
    int[] siguienteSprite = {0, 0};
    static float suma;

    public MenuScreen(final Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        textureAtlas = new TextureAtlas("sprites.txt");

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(800, 600, camera);

        background = new Texture(Gdx.files.internal("StartScreen.png"));
        imgStart = new Texture(Gdx.files.internal("btnStartGame.png"));
        myTextureRegion = new TextureRegion(imgStart);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        btnStart = new ImageButton(myTexRegionDrawable); //Set the button up

        btnStart.setPosition(220, 100);
        btnStart.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //He tenido que moverlo de posicion porque se bugeaba
                btnStart.setPosition(-1000, -1000);
                game.setScreen(new GameScreen(game));
            }
        });

        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(btnStart); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (siguienteSprite[0] > 6 && siguienteSprite[1] < 7) {
            segundoSprite = true;
            primerSprite = false;
        } else if (siguienteSprite[1] > 6) {
            segundoSprite = false;
            siguienteSprite[0] = 0;
            siguienteSprite[1] = 0;
            primerSprite = true;

        }

        if (primerSprite) {
            moleAnimation(delta, spriteAnimation, 70, 200, 0, textureAtlas);
        } else if (segundoSprite) {
            moleAnimation(delta, spriteAnimation, 630, 200, 1, textureAtlas);
        }

        batch.end();

        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw(); //Draw the ui
    }

    private void moleAnimation(float delta, Sprite sprite, int x, int y, int numSprite, TextureAtlas atlas) {
        suma += delta;
        if (suma < 0.5f) {
            sprite = atlas.createSprite("sprite_0");
            sprite.setPosition(x, y);
            sprite.draw(batch);
        } else {
            if (suma > segundos) {
                nameSprite = "sprite_" + siguienteSprite[numSprite];
                sprite = atlas.createSprite(nameSprite);
                sprite.setPosition(x, y);
                sprite.draw(batch);
                segundos += 0.5f;
                siguienteSprite[numSprite]++;
            } else {
                nameSprite = "sprite_" + siguienteSprite[numSprite];
                sprite = atlas.createSprite(nameSprite);
                try {
                    sprite.setPosition(x, y);
                    sprite.draw(batch);
                } catch (NullPointerException e) {

                }
            }
        }
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
        background.dispose();
        imgStart.dispose();
        stage.dispose();
    }
}
