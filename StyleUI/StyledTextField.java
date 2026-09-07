package StyleUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

public class StyledTextField extends JTextField {
    private Style style;
    private double reflectionPhase;
    private Dimension baseParentSize;
    private final Timer reflectionTimer;

    public StyledTextField(Style style, String text) {
        super(text);
        this.style = style;
        setForeground(style.text);
        setCaretColor(style.text);
        setOpaque(false);
        setHorizontalAlignment(LEFT);
        setBorder(new EmptyBorder(3, 8, 3, 8));
        addComponentListener(new ComponentAdapter() {@Override public void componentResized(ComponentEvent e) { updateFont();repaint(); }});
        reflectionTimer = new Timer(16, e -> {
            if (style == Style.GLASS) {
                reflectionPhase = (reflectionPhase + 0.0035) % 1.0;
                repaint();
            }
        });
        reflectionTimer.start();
        updateFont();
    }

    @Override public void addNotify() {
        super.addNotify();
        if (reflectionTimer != null && !reflectionTimer.isRunning()) reflectionTimer.start();
    }
    @Override public void removeNotify() {
        if (reflectionTimer != null && reflectionTimer.isRunning()) reflectionTimer.stop();
        super.removeNotify();
    }
    public void setStyle(Style style) {
        if (style == null || style == this.style) return;
        this.style = style;
        setForeground(style.text);
        setCaretColor(style.text);
        repaint();
    }
    private float parentScale() {
        Container parent = getParent();
        if (parent == null || parent.getWidth() <= 0 || parent.getHeight() <= 0) return 1f;
        if (baseParentSize == null) baseParentSize = new Dimension(parent.getWidth(), parent.getHeight());
        return Math.max(0.1f, Math.min(parent.getWidth() / (float)baseParentSize.width, parent.getHeight() / (float)baseParentSize.height));
    }
    private void updateFont() { setFont(new Font("SansSerif", Font.PLAIN, Math.round(Math.clamp(getHeight() * 0.34f, 9, 40)))); }
    @Override protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        float arc = Math.clamp(Math.min(w, h) * 0.22f, 4, 30);
        g2d.setColor(style.panel);
        g2d.fillRoundRect(0, 0, w, h, Math.round(arc), Math.round(arc));
        if (style == Style.GLASS) {
            g2d.setColor(new Color(255, 255, 255, 22));
            g2d.fillRoundRect(0, 0, w, h, Math.round(arc), Math.round(arc));
            paintGlassSheen(g2d, w, h, arc, reflectionPhase);
            g2d.setColor(new Color(255, 255, 255, 90));
            g2d.drawRoundRect(0, 0, w - 1, h - 1, Math.round(arc), Math.round(arc));
        } else {
            g2d.setColor(style.field);
            g2d.fillRoundRect(0, 0, w, h, Math.round(arc), Math.round(arc));
            g2d.setColor(style.accent);
            g2d.drawRoundRect(0, 0, w - 1, h - 1, Math.round(arc), Math.round(arc));
        }
        g2d.dispose();
        super.paintComponent(g);
    }
    static void paintGlassSheen(Graphics2D g2d, int w, int h, float arc, double phase) {
        if (w <= 0 || h <= 0) return;
        Graphics2D gc = (Graphics2D)g2d.create();
        gc.clip(new RoundRectangle2D.Float(0, 0, w, h, arc, arc));
        float band = Math.max(w, h) * 0.5f;
        float span = w + h + band * 2;
        float start = (float) (phase * span) - band - h;
        Point2D p1 = new Point2D.Float(start, 0);
        Point2D p2 = new Point2D.Float(start + band, h);
        float[] fractions = {0f, 0.5f, 1f};
        Color[] colors = {
                new Color(255, 255, 255, 0),
                new Color(255, 255, 255, Math.round(255 * 0.45f)),
                new Color(255, 255, 255, 0)};
        gc.setPaint(new LinearGradientPaint(p1, p2, fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE));
        gc.fillRoundRect(0, 0, w, h, Math.round(arc), Math.round(arc));
        gc.dispose();
    }
}