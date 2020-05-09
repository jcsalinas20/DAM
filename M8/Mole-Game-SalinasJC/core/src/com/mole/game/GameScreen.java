package com.mole.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.math.Rectangle;


class GameScreen implements Screen {

    final Main game;
    Texture background;
    Texture floor;
    int altura, ancho;
    boolean posicionSeleccionada = false;
    boolean siguienteTopo = true;

    private Rectangle topo;
    private Rectangle mouse;


    TextureAtlas textureAtlas;
    Sprite spriteAnimation;
    String nameSprite;
    SpriteBatch batch;
    OrthographicCamera camera;
    ExtendViewport viewport;
    int siguienteSprite = 0;
    float segundos = 0.5f;

    float suma;
    int contador = 0;

    float velocidad = 0.5f;
    int siguineteNivelDeVelocidad = 10;

    public GameScreen(final Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        textureAtlas = new TextureAtlas("sprites.txt");// TXT que define los Sprites del Mole

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(800, 600, camera);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        topo = new Rectangle(0, 0, 110, 70);// Dimensiones y tamaño del Mole
        mouse = new Rectangle(800, 400, 5, 5);// Dimensiones y tamaño del Mouse

        background = new Texture(Gdx.files.internal("background.jpg"));
        floor = new Texture(Gdx.files.internal("floor.png"));
    }

    @Override
    public void render(float delta) {
        batch.begin();

        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());// Fondo
        batch.draw(floor, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());// Suelo

        camera.update();

        // Cada 10 topos dados se le resta 0.1 de velocidad para que vaya mas rapido
        if (contador >= siguineteNivelDeVelocidad) {
            if (velocidad >= 0.1f ) {
                siguineteNivelDeVelocidad += 10;
                velocidad -= 0.1f;
            }
        }

        // FIN DEL JUEGO
        if (!siguienteTopo)
            game.setScreen(new EndScreen(game, contador));// Pasamos a la siguiente escena

        // Teto del contador
        game.font.getData().setScale(2);
        game.font.draw(batch, "Contador: " + contador, 0, 480);

        // Si los dos rectangles se colisionan entra
        if (mouse.overlaps(topo)) {
            mouse.x = -100;//Movemos el rectangle del mouse fuera de la pantalla para que no detecte varias veces la colosion
            mouse.y = -100;
            topo.x = -100;//Movemos el rectangle del Mole fuera de la pantalla para que no detecte varias veces la colosion
            topo.y = -100;
            siguienteSprite = 0;// ponemos el numero del sprite a 0 para reiniciarlo
            posicionSeleccionada = false;// asignamos una nueva posicion al Mole
            siguienteTopo = true;// Le decimos que el juego siga
            contador++;// smamos 1 en el contador
        }

        // Detectamos cunado el Player toca la pantalla
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            // Asignamos la posicion al rectangle mouse
            mouse.x = (int) (touchPos.x);
            mouse.y = (int) (touchPos.y);
        }

        // Asignamos una posicion aleatoria al Mole
        if (!posicionSeleccionada) {
            altura = (int) (Math.random() * 254);
            ancho = (int) (Math.random() * 700);
            // Asignamos la posicion aleatoria al Rectangle del Mole
            topo.x = ancho;
            topo.y = altura;
            posicionSeleccionada = true;
        }

        // Si el siguinete sprite es el 7 se termina el juego
        if (siguienteSprite == 7) {
            siguienteTopo = false;
        }

        // Si la posicion esta seleccionada llamamos al metodo de la animacion del Sprite
        if (posicionSeleccionada)
            moleAnimation(delta, spriteAnimation, ancho, altura, textureAtlas);

        batch.end();
    }

    private void moleAnimation(float delta, Sprite sprite, int x, int y, TextureAtlas atlas) {
        // El sprite se actualiza cada X tiempo
        suma += delta;
        if (suma < velocidad) {
            sprite = atlas.createSprite("sprite_0");
            sprite.setPosition(x, y);
            sprite.draw(batch);
        } else {
            if (suma > segundos) {
                nameSprite = "sprite_" + siguienteSprite;
                sprite = atlas.createSprite(nameSprite);
                sprite.setPosition(x, y);
                sprite.draw(batch);
                segundos += velocidad;
                siguienteSprite++;// Sumamos 1 para el siguiente Sprite
            } else {
                nameSprite = "sprite_" + siguienteSprite;
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
        floor.dispose();
        textureAtlas.dispose();
        batch.dispose();
    }
}
