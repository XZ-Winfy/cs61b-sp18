public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
     double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
     }

    public Planet(Planet p) {
      xxPos = p.xxPos;
      yyPos = p.yyPos;
      xxVel = p.xxVel;
      yyVel = p.yyVel;
      mass = p.mass;
      imgFileName = p.imgFileName;
    }
    
    public double calcDistance(Planet p) {
      return Math.sqrt((xxPos - p.xxPos)*(xxPos - p.xxPos) + 
            (yyPos - p.yyPos)*(yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
      double r = calcDistance(p);
      return (G*mass*p.mass) / (r*r);
    }

    public double calcForceExertedByX(Planet p) {
      double dx = p.xxPos - xxPos;
      double f = calcForceExertedBy(p);
      double r = calcDistance(p);
      return (f*dx)/r;
    }

    public double calcForceExertedByY(Planet p) {
      double dy = p.yyPos - yyPos;
      double f = calcForceExertedBy(p);
      double r = calcDistance(p);
      return (f*dy)/r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
      double f = 0;
      for (Planet planet: allPlanets) {
        if (this.equals(planet)) {
          continue;
        }
        f += calcForceExertedByX(planet);
      }
      return f;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
      double f = 0;
      for (Planet planet: allPlanets) {
        if (this.equals(planet)) {
          continue;
        }
        f += calcForceExertedByY(planet);
      }
      return f;
    }

    public void update(double dt, double Fx, double Fy) {
      double ax = Fx/mass;
      double ay = Fy/mass;
      xxVel += dt*ax;
      yyVel += dt*ay;
      xxPos += dt*xxVel;
      yyPos += dt*yyVel;
    }

    public void draw() {
      StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
