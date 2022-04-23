// Ali Sbeih 12/2/2021
// This is an interactive game. Click the mouse to shoot and try to hit as many targets as you can
public class Finalproj {
    public static void main(String[] args) {
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-10, 10);
        game();
    }

    static void game() {
        int score = 0;
        StdDraw.enableDoubleBuffering();

        double[] airplanes = new double[10];
        for (int i = 0; i < 10; i++) {
            double x = 10 * Math.random();
            if (x >= 5) {
            } else {
                x = x + 5;
            }
            airplanes[i] = x;
        }
        double[] speedplanes = new double[10];
        for (int i = 0; i < 10; i++) {
            speedplanes[i]=0.8+(Math.random()*4);
        }

        for (int opp = 0; opp < 10; opp++) {
            score=score+oppPlane(airplanes[opp],speedplanes[opp]);
        }
        System.out.println("You destroyed "+score+"/10 airplanes");
        if(score==0)System.out.println("You need more practice");
        else if(score==10)System.out.println("Perfect!!!");
        else if(score>5)System.out.println("Well done!");
        else if(score<5)System.out.println("You are almost there");

        for (double location = -8; location <= 12; location++) {
            background();
            clouds();
            playerPlane(location);
            StdDraw.show();
            StdDraw.pause(300);
            StdDraw.clear();
        }
    }

    static int oppPlane(double p, double s) {
        int hit=0;
        for (int xpos = -10; xpos < 13; xpos++) {
            background();
            clouds();
            StdDraw.setPenColor(255, 255, 0);
            StdDraw.filledRectangle(s*xpos, p, 0.4, 1.8);
            StdDraw.setPenColor(64, 64, 64);
            StdDraw.filledRectangle(s*xpos, p, 1.2, 0.4);
            StdDraw.filledCircle(s*xpos + 1.2, p, 0.4);

            StdDraw.show();

            playerPlane(-8);
            StdDraw.show();

            StdDraw.pause(300);

            if (StdDraw.isMousePressed()) {
                bullet();
                StdDraw.show();
                StdDraw.pause(300);
                if (s*xpos <= 1.8 & s*xpos >= -1.8) {
                    explosion(p);
                    StdDraw.show();
                    StdDraw.pause(500);
                    hit=1;
                    break;
                } else {
                    break;
                }
            }
        }
        return hit;
    }


    static void playerPlane(double p) {
        StdDraw.setPenColor(0, 0, 255);
        StdDraw.filledRectangle(0, p, 1.8, 0.4);
        StdDraw.setPenColor(233, 233, 233);
        StdDraw.filledRectangle(0, p, 0.4, 1.2);
        StdDraw.filledCircle(0, p + 1.2, 0.4);
    }

    static void explosion(double p) {
        StdDraw.setPenColor(204, 0, 0);
        StdDraw.filledCircle(0, p, 2);
        StdDraw.setPenColor(204, 204, 0);
        StdDraw.filledCircle(1.5, p + 1.5, 1.1);
        StdDraw.filledCircle(1.5, p - 1.5, 1.4);
        StdDraw.filledCircle(-1.5, p + 1.5, 1.3);
        StdDraw.filledCircle(-1.5, p - 1.5, 1.2);
        StdDraw.setPenColor(64, 64, 64);
        StdDraw.filledCircle(0, p, 0.5);
    }

    static void bullet() {
        StdDraw.setPenColor(153, 0, 0);
        StdDraw.filledRectangle(0, 1.9, 0.1, 8.1);
    }


    static void background() {
        StdDraw.setPenColor(153, 204, 255);
        StdDraw.filledSquare(0, 0, 10);
    }

    static void clouds() {
        StdDraw.setPenColor(224, 224, 224);
        StdDraw.filledCircle(-8, 8, 0.8);
        StdDraw.filledCircle(-9, 8, 0.8);
        StdDraw.filledCircle(-8, 9, 0.8);
        StdDraw.filledCircle(-9, 9, 0.8);
        StdDraw.filledCircle(-7, 8, 0.8);
        StdDraw.filledCircle(-7, 9, 0.8);

        StdDraw.filledCircle(8, 8, 0.8);
        StdDraw.filledCircle(9, 8, 0.8);
        StdDraw.filledCircle(8, 9, 0.8);
        StdDraw.filledCircle(9, 9, 0.8);
        StdDraw.filledCircle(7, 8, 0.8);
        StdDraw.filledCircle(7, 9, 0.8);

        StdDraw.filledCircle(-8, -8, 0.8);
        StdDraw.filledCircle(-9, -8, 0.8);
        StdDraw.filledCircle(-8, -9, 0.8);
        StdDraw.filledCircle(-9, -9, 0.8);
        StdDraw.filledCircle(-7, -8, 0.8);
        StdDraw.filledCircle(-7, -9, 0.8);

        StdDraw.filledCircle(8, -8, 0.8);
        StdDraw.filledCircle(9, -8, 0.8);
        StdDraw.filledCircle(8, -9, 0.8);
        StdDraw.filledCircle(9, -9, 0.8);
        StdDraw.filledCircle(7, -8, 0.8);
        StdDraw.filledCircle(7, -9, 0.8);
    }
}



