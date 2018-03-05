public class NBody{
	public static double readRadius(String file){
		In in = new In(file);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String file){
		In in = new In(file);
		int num = in.readInt();
		double radius = in.readDouble();
		int i = 0;
		double xP, yP, xV, yV, m;
		String img;
		Planet[] planets = new Planet[num];
		while(i < num){
			xP = in.readDouble();
			yP = in.readDouble();
			xV = in.readDouble();
			yV = in.readDouble();
			m = in.readDouble();
			img = in.readString();
			planets[i] = new Planet(xP, yP, xV, yV, m, "images/" + img);


			i += 1;
		}
		return planets;

	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		String starField = "images/starfield.jpg";
		double radius = NBody.readRadius(filename);
		Planet[] planets = NBody.readPlanets(filename);
		int numPlanets = planets.length;

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		
		for(double t = 0; t <= T; t += dt){
			double[] xForces = new double[numPlanets];
			double[] yForces = new double[numPlanets];

			for(int i = 0; i < numPlanets; i += 1){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int i = 0; i < numPlanets; i += 1){
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, starField, radius * 2, radius * 2);
			for(Planet planet : planets){
				planet.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}
		

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}

	}
}