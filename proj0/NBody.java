public class NBody{
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] stars = readPlanets(filename);
        double radius = readRadius(filename);
        double radius2 = radius*-1;
        StdDraw.setScale(radius2, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for(Planet p:stars){
            p.draw();
        }
        StdDraw.show();
        StdDraw.enableDoubleBuffering();
        int count=stars.length;
        int time =0;

        while(time<=T)
        {
            double[] xForce= new double[count];
            double[] yForce= new double[count];
            int i=0;
            for(Planet p:stars){
                xForce[i] = p.calcNetForceExertedByX(stars);
                yForce[i] = p.calcNetForceExertedByY(stars);
                i++;
            }
            i=0;
            for(Planet p:stars){
                p.update(dt, xForce[i], yForce[i]);
                p.draw();
                i++;
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }
        StdOut.printf("%d\n", stars.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < stars.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            stars[i].xxPos, stars[i].yyPos, stars[i].xxVel,
            stars[i].yyVel, stars[i].mass, stars[i].imgFileName);
        }
    }

    public static double readRadius(String a){
        In in = new In(a);
        int b = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String a){
        In in = new In(a);
        int count = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[count];
        for(int i=0;i<count;i++){
            double aa,bb,cc,dd,ee;
            aa = in.readDouble();
            bb = in.readDouble();
            cc = in.readDouble();
            dd = in.readDouble();
            ee = in.readDouble();
            String ff;
            ff = in.readString();
            Planet temp = new Planet(aa,bb,cc,dd,ee,ff);
            planets[i]=temp;
        }
        return planets;
    }
}