//package tests.front;
//
//import javafx.geometry.Point2D;
//import javafx.scene.Node;
//
///**
// * @author Almas Baimagambetov (almaslvl@gmail.com)
// */
//@SuppressWarnings("restriction")
//public class GameObject {
//
//    private Node view;
//    private Point2D velocity = new Point2D(0, 0);
//
//    private boolean alive = true;
//
//    public GameObject(Node view) {
//        this.view = view;
//    }
//
//    public void update() {
//        view.setTranslateX(view.getTranslateX() + velocity.getX());
//        view.setTranslateY(view.getTranslateY() + velocity.getY());
//    }
//    
//    public void update(double sourisX, double sourisY) {
//    	
//    	
//    	if (sourisX < view.getTranslateX()) {
//    		rotateGauche();
//    	} else if (sourisX > view.getTranslateX()) {
//    		rotateDroite();
//    	}
//    	
//    	if (sourisY < view.getTranslateY()) {
//    		rotateHaut();
//    	} else if (sourisY > view.getTranslateY()) {
//    		rotateBas();
//    	}
//    	
////    	view.setRotate(180);
////    	setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
//    	
//        view.setTranslateX(view.getTranslateX() + velocity.getX());
//        view.setTranslateY(view.getTranslateY() + velocity.getY());
//    }
//
//
//	public void setVelocity(Point2D velocity) {
//        this.velocity = velocity;
//    }
//
//    public Point2D getVelocity() {
//        return velocity;
//    }
//
//    public Node getView() {
//        return view;
//    }
//
//    public boolean isAlive() {
//        return alive;
//    }
//
//    public boolean isDead() {
//        return !alive;
//    }
//
//    public void setAlive(boolean alive) {
//        this.alive = alive;
//    }
//
//    public double getRotate() {
//        return view.getRotate();
//    }
//    
//    private void rotateGauche() {
//    	view.setRotate(180);
//    	setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
//    }
//    
//    private void rotateDroite() {
//    	view.setRotate(0);
//    	setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
//    }
//
//    private void rotateHaut() {
//    	view.setRotate(270);
//    	setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
//    }
//
//    private void rotateBas() {
//    	view.setRotate(90);
//    	setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
//    }
//    
//    public void rotateRight() {
//        view.setRotate(view.getRotate() + 5);
//        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
//    }
//
//    public void rotateLeft() {
//        view.setRotate(view.getRotate() - 5);
//        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
//    }
//
//    public boolean isColliding(GameObject other) {
//        return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
//    }
//}