package de.vitox;

import static org.lwjgl.opengl.GL11.*;

/**
 * skidded by vitox, modified by vertex
 */
public class RenderUtils {

    public static void drawBorderedCircle(int x, int y, float radius, int outsideC, int insideC) {
        glEnable(GL_BLEND);
        glDisable(GL_TEXTURE_2D);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_LINE_SMOOTH);

        glPushMatrix();
        float scale = 0.1F;
        glScalef(scale, scale, scale);
        x = (int) (x * (1.0F / scale));
        y = (int) (y * (1.0F / scale));
        radius *= 1.0F / scale;
        drawCircle(x, y, radius, insideC);
        drawUnfilledCircle(x, y, radius, 1.0F, outsideC);
        glScalef(1.0F / scale, 1.0F / scale, 1.0F / scale);
        glPopMatrix();
        
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);
        glDisable(GL_LINE_SMOOTH);
    }

    public static void drawUnfilledCircle(int x, int y, float radius, float lineWidth, int color) {
        /* Shift Colors */
        float alpha = (color >> 24 & 0xFF) / 255.0F;
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;

        /* Render Unfilled Circle (using lines) */
        glColor4f(red, green, blue, alpha);
        glLineWidth(lineWidth);
        glEnable(GL_LINE_SMOOTH);
        glBegin(GL_LINE_LOOP);
        for (int i = 0; i <= 360; i++) {
            glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * radius, y + Math.cos(i * Math.PI / 180.0D) * radius);
        }
        glEnd();
        glDisable(GL_LINE_SMOOTH);
    }

    public static void drawCircle(int x, int y, float radius, int color) {
        /* Shift Colors */
        float alpha = (color >> 24 & 0xFF) / 255.0F;
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;

        /* Render Circle */
        glColor4f(red, green, blue, alpha);
        glBegin(GL_POLYGON);
        for (int i = 0; i <= 360; i++) {
            glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * radius, y + Math.cos(i * Math.PI / 180.0D) * radius);
        }
        glEnd();
    }
}
