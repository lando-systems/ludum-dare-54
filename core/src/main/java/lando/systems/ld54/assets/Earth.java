package lando.systems.ld54.assets;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import lando.systems.ld54.Assets;

public class Earth {
    Animation<TextureRegion> anim;
    TextureRegion keyframe;
    float animState;
    float size = 96;

    private final Circle bounds = new Circle();
    public final Vector2 centerPosition = new Vector2();

    public Earth(Assets assets, float x, float y) {
        this.anim = assets.earthSpin;
        this.keyframe = anim.getKeyFrames()[0];
        this.animState = 0;

        setPosition(x, y);
    }

    public void setPosition(float x, float y) {
        centerPosition.set(x, y);
        bounds.set(x, y, size / 2);
    }

    public boolean contains(Vector3 worldPosition) {
        return bounds.contains(worldPosition.x, worldPosition.y);
    }

    public void update(float dt) {
        animState += dt;
        keyframe = anim.getKeyFrame(animState);
    }

    public void render(SpriteBatch batch) {
        var centerX = centerPosition.x - size / 2f;
        var centerY = centerPosition.y - size / 2f;
        batch.draw(keyframe, centerX, centerY, size, size);
    }
}
