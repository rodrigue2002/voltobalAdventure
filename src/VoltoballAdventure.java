import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
public class VoltoballAdventure extends PApplet{

    private Voltoball voltoball = new Voltoball(0,0);
    private PImage volto;
    public static void main(String[]args){
        PApplet.main(VoltoballAdventure.class);
    }

    public void settings(){
        size(1000,1000);
        displayDensity(2);   // pour obtenir une densité de pixels

    }

    public void setup(){
        volto = loadImage("https://assets.pokemon.com/assets/cms2/img/pokedex/full/100.png");
        voltoball.voltobalPosition( (int) (Math.random() * (width - voltoball.size)), (int) (Math.random() * (height - voltoball.size)));   // pour generer un nombre entre 0 et width - size
        rectMode(CENTER);           // pour faire tourner le rectangle autour de son centre
        imageMode(CENTER);          // ................... limage..........................

    }
    int vitesseVoltoballX = (int) random(2) > 0 ? 3 : -3;  // il choisi un nombre random entre 0 et 1. si le nombre est > 0, allors vitesse = 3 sinon -3
    int vitesseVoltoballY = (int) random(3,5);       //  afin de randomiser la vitesse pour que la balle aille partout
    float angle = 0;

    public void draw(){
        background(200);
        push();
        translate(voltoball.x , voltoball.y );
        rotate(angle);
        image(volto,0,0,voltoball.size,voltoball.size);    // coordonnees centre largeurs hauteurs image
        pop();
        voltoball.x += vitesseVoltoballX ;
        voltoball.y +=  vitesseVoltoballY;
        if(voltoball.x + voltoball.size/2 >= width || voltoball.x - voltoball.size/2 <= 0 ){
            vitesseVoltoballX *= -1;
            vitesseVoltoballY = (int) random(-5,5);
        }
        if(voltoball.y + voltoball.size/2 >= height || voltoball.y - voltoball.size/2 <=0){
            vitesseVoltoballY *= -1;
            vitesseVoltoballX = (int) random(2) > 0 ? 3 : -3;
        }
        angle +=  radians(7) ;
    }
}
