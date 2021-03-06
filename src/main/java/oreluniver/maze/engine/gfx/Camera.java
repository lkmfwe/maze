package oreluniver.maze.engine.gfx;

import org.joml.Vector3f;

public class Camera {

    private final Vector3f position;

    private final Vector3f rotation;

    public Camera() {
        position = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
    }

    public Camera(Vector3f position, Vector3f rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(float x, float y, float z) {
        position.x = x;
        position.y = y;
        position.z = z;
    }

    public void movePosition(Vector3f v, int [][] m) {
        if ( v.z != 0 ) {
            position.x += (float) Math.sin(Math.toRadians(rotation.y)) * -1.0f * v.z;
            position.z += (float) Math.cos(Math.toRadians(rotation.y)) * v.z;
        }
        if ( v.x != 0) {
            position.x += (float) Math.sin(Math.toRadians(rotation.y - 90)) * -1.0f * v.x;
            position.z += (float) Math.cos(Math.toRadians(rotation.y - 90)) * v.x;
        }
        position.y += v.y;

    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(float x, float y, float z) {
        rotation.x = x;
        rotation.y = y;
        rotation.z = z;
    }

    public void moveRotation(float offsetX, float offsetY, float offsetZ) {
        rotation.x += offsetX;
        rotation.y += offsetY;
        rotation.z += offsetZ;
    }
}