package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Levelscreen implements Screen {
    private Viewport viewport;
    private Stage stage;
    private Game game;
    public  String[] str = {"level1","level2","level3"};
    public Levelscreen(Game game ){
        this.game=game;
        viewport=new FitViewport(MyGdxGame.width,MyGdxGame.height, new OrthographicCamera());
        stage=new Stage(viewport,((MyGdxGame)game).batch);
        Label.LabelStyle font=new Label.LabelStyle(new BitmapFont(), Color.RED);
        Table table=new Table();
        table.center();
        table.setFillParent(true);

        Label gameover=new Label(str[PlayScreen.i],font);
        Label play=new Label("Click to Start ",font);
        table.add(gameover).expandX();
        table.row();
        table.add(play).expandX().padTop(10f);
        stage.addActor(table);




    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            game.setScreen(new PlayScreen((MyGdxGame) game));
            dispose();

        }
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();

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

    }
}
