public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }

    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = p.xxPos-xxPos;
        double dy = p.yyPos-yyPos;
        dx*=dx;
        dy*=dy;
        return Math.sqrt(dx+dy);
    }

    public double calcForceExertedBy(Planet p){
        double g = 6.67/1e11;
        double dx = p.xxPos-xxPos;
        double dy = p.yyPos-yyPos;
        dx*=dx;
        dy*=dy;
        return p.mass*mass*g/(dx+dy);
    }

    public double calcForceExertedByX(Planet p){
        if(calcDistance(p)==0) return 0;
        double dx = p.xxPos-xxPos;
        double f = calcForceExertedBy(p)*dx/calcDistance(p);
        return f;
    }

    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos-yyPos;
        if(calcDistance(p)==0) return 0;
        double f = calcForceExertedBy(p)*dy/calcDistance(p);
        return f;
    }

    public double calcNetForceExertedByX(Planet[] p){
        double f =0;
        for (Planet i:p){
            f+=calcForceExertedByX(i);
        }
        return f;
    }
    public double calcNetForceExertedByY(Planet[] p){
        double f =0;
        for (Planet i:p){
            f+=calcForceExertedByY(i);
        }
        return f;
    }

    public void update(double dt,double fx,double fy){
        double ax=fx/mass;
        double ay=fy/mass;
        xxVel+=dt*ax;
        yyVel+=dt*ay;
        xxPos+=dt*xxVel;
        yyPos+=dt*yyVel;
    }

    public void draw(){
        String a = "images/"+imgFileName;
        StdDraw.picture(xxPos, yyPos, a);
        StdDraw.show();
    }
}