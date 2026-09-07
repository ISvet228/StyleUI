package StyleUI;

import javax.swing.*;
import java.awt.*;

public class StyledLabel extends AnimatedComponent {
    private Style style;
    private final String text;
    private double reflectionPhase;
    private Timer reflectionTimer;

    public StyledLabel(Style style, String text) {
        this.style = style;
        this.text = text;
        setOpaque(false);
        setPreferredSize(new Dimension(180, 36));
        reflectionTimer = new Timer(16, e -> { if (style == Style.GLASS)
        {reflectionPhase = (reflectionPhase + 0.0035) % 1.0;repaint(); }});
        reflectionTimer.start();
    }
    public void setStyle(Style style) {
        if (style == null || style == this.style) return;
        this.style = style;
        repaint();
    }
    @Override protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        float arc = Math.clamp(Math.min(w, h) * 0.22f, 4, 30);
        g2d.setColor(style == Style.GLASS ? new Color(255, 255, 255, 26) : style.field);
        g2d.fillRoundRect(0, 0, w, h, Math.round(arc), Math.round(arc));
        g2d.setColor(style.accent);
        g2d.drawRoundRect(0, 0, w - 1, h - 1, Math.round(arc), Math.round(arc));
        if (style == Style.GLASS) paintGlassSheen(g2d, w, h, arc, reflectionPhase);
        drawCenteredText(g2d, text, style.text, Math.clamp(h * 0.34f, 9, 40), 0, 0, w, h);
        g2d.dispose();
    }

    @Override
    protected Style getStyle() {
        return null;
    }
}