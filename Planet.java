public class Planet {
	static final double G_CONSTANT= 6.67e-11;


   public double xxPos;
   public double yyPos;
   public double xxVel;
   public double yyVel;
   public double mass;
   public String imgFileName;


   public Planet(double xP, double yP, double xV, double yV, double m, String img){
   	xxPos = xP;
   	yyPos = yP;
   	xxVel = xV;
   	yyVel = yV;
   	mass = m;
   	imgFileName = img;

   }

   public Planet(Planet p){
   	xxPos = p.xxPos;
   	yyPos = p.yyPos;
   	xxVel = p.xxVel;
   	yyVel = p.yyVel;
   	mass = p.mass;
   	imgFileName = p.imgFileName;
   }

   	public double calcDistance(Planet P){
   		double dx = P.xxPos - this.xxPos;
   		double dy = P.yyPos - this.yyPos;
   		double d = Math.sqrt(dy * dy + dx * dx);
   		return d;
   	}

   	public double calcForceExertedBy(Planet P){
   		double r = this.calcDistance(P);
   		double force = G_CONSTANT * this.mass * P.mass / (r * r);
   		return force;
   	}

   	public double calcNetForceExertedByX(Planet[] planets){
   		// Calculate total forces exerted by other planets on X-axis
   		double dx;
   		double forceX;
   		double result = 0;
   		for (Planet planet : planets){
   			if (this.equals(planet)){
   				continue;
   			}
   			dx = planet.xxPos - this.xxPos;
   			forceX = this.calcForceExertedBy(planet) * dx / this.calcDistance(planet);
   			result += forceX;
   		}
   		return result;
   	}
   	public double calcNetForceExertedByY(Planet[] planets){
   		// Calculate total forces exerted by other planets on Y-axis
   		double dy;
   		double forceY;
   		double result = 0;
   		for (Planet planet : planets){
   			if (this.equals(planet)){
   				continue;
   			}
   			dy = planet.yyPos - this.yyPos;
   			forceY = this.calcForceExertedBy(planet) * dy / this.calcDistance(planet);
   			result += forceY;
   		}
   		return result;
   		
   	}
   	public boolean equals(Planet P){
   		if(P != this){
   			return false; 
   		}
   		return true;
   	}
   	public void update(double time, double forceX, double forceY){
   		double accelX = forceX / this.mass;
   		double accelY = forceY / this.mass; // acceleration in direction X and Y.
   		this.xxVel += time * accelX;
   		this.yyVel += time * accelY;
   		this.xxPos += time * xxVel;
   		this.yyPos += time * yyVel;
   	}
   	public void draw(){
   		StdDraw.picture(xxPos, yyPos, imgFileName);
   	}
   }