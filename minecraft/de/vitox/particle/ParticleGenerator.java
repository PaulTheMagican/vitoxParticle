package de.vitox.particle;

import java.util.ArrayList;
import java.util.Random;

public class ParticleGenerator {

    public static int amount;
    public static int width;
    public static int height;

    public ArrayList<Particle> particles = new ArrayList();
    private Random random = new Random();

    public ParticleGenerator(int amount, int width, int height) {
        this.amount = amount;
        this.width = width;
        this.height = height;
        for (int i = 0; i < amount; i++) {
            this.particles.add(new Particle(this.random.nextInt(width), this.random.nextInt(height)));
        }
    }

    public void drawParticles() {
        for (Particle p : this.particles) {
            p.draw();
        }
    }
}
