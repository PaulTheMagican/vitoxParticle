package de.vitox.particle;

import java.util.Random;

import de.vitox.RenderUtils;
import net.minecraft.util.MathHelper;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_NICEST;

public class Particle {

	public int x;
	public int y;
	public int k;
	public ParticleGenerator particleGenerator;
	public boolean reset;
	public float size;
	private Random random = new Random();
	
	public Particle(int x, int y) {
		this.x = x;
		this.y = y;
		this.size = genRandom(0.7F, 0.8F);
	}

	public void draw() {
		//Reset
		if (x == -1){
			x = particleGenerator.width;
			reset = true;
		}
		
		if (y == -1){
			y = particleGenerator.height;
			reset = true;
		}
		
		this.x -= random.nextInt(2);
		this.y -= random.nextInt(2);
		
		int xx = (int) (MathHelper.cos(0.1F * (this.x + this.k)) * 10.0F);
		glPolygonMode(GL_FRONT, GL_FILL);
		glEnable(GL_POLYGON_SMOOTH);
		glHint(GL_POLYGON_SMOOTH_HINT, GL_NICEST);
		RenderUtils.drawBorderedCircle(this.x + xx, this.y, this.size, 0, 0xffFFFFFF);
		glDisable(GL_POLYGON_SMOOTH);
	}


	public float genRandom(float min, float max) {
		return (float) (min + Math.random() * (max - min + 1.0F));
	}
}
