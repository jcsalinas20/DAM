package com.salinas.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen {
    final Drop game;

    Texture background;

    public MainMenuScreen(final Drop game) {
        this.game = game;
    }

    @Override
    public void show() {
        background = new Texture(Gdx.files.internal("gameStartBackground.png"));
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
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

    }
}
