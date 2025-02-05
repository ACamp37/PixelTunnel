package com.mime.minefront.graphics;

public class Render3D extends Render {

	public Render3D(int width, int height) {
		super(width, height);
	}
	
	double time = 0;
	
	public void floor() {
		for (int y = 0; y < height; y++) {
			double ceiling = (y - height / 2.0) / height;
			
			if (ceiling < 0) {
				ceiling = -ceiling;	
			}
			
			double z = 8 / ceiling;
				
			time += 0.0005;
			
			for (int x = 0; x < width; x++) {
				double depth = (x - width / 2.0) / height;
				depth *=z;
				double xx = depth; //Aaron's Notes: Search up more about & which goes under Bitwise Operators. Suggested in Video 9.
				double yy = z + time;
				int xPix = (int) (xx);
				int yPix = (int) (yy);
				pixels[x + y * width] = ((xPix & 15) * 16) | ((yPix & 15) * 16) << 8;				
			}
		}
	}
}

