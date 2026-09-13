# StyleUI

StyleUI is a modern Java Swing UI library that provides beautiful, animated components with support for multiple style themes. Designed to create professional-looking applications with modern aesthetics.

## 📋 Overview

StyleUI offers a complete set of UI components featuring:

- **Three pre-built style themes**: FLAT, NEUMORPHIC, GLASS
- **Smooth animations** on user interaction
- **Localization support** via external systems
- **Flexible sizing** and scaling capabilities
- **Easy integration** with existing Swing applications

## 🧩 Components

### 🔘 StyledButton

Styled button with hover animations and localization support.

**Features:**

- Background color animation on hover
- Offset animation on press
- Support for all three styles
- Text localization
- Customizable size

**Usage:**

```java
// Create a button with flat style
StyledButton button = new StyledButton(Style.FLAT, "Click Me");

// Create a button with custom size
StyledButton button = new StyledButton(Style.NEUMORPHIC, "Submit", 200, 50);

// Add action listener
button.addActionListener(e -> {
    System.out.println("Button clicked!");
});

// Change style dynamically
button.setStyle(Style.GLASS);

// Localization
button.setLocalizationKey("button.submit");
button.setLocalizationFormat("button.greeting", () -> new Object[]{"User"});
```

**Methods:**

- `setText(String text)` - set button text
- `setStyle(Style style)` - change style
- `addActionListener(ActionListener listener)` - add action listener
- `setLocalizationKey(String key)` - bind to localization key
- `setLocalizationFormat(String key, Supplier<Object[]> arguments)` - formatted localization

---

### 📊 StyledSlider

Styled slider with horizontal and vertical orientation support.

**Features:**

- Horizontal and vertical orientation
- Value range configuration
- Major and minor ticks support
- Drag animations
- Keyboard navigation
- Support for all styles

**Usage:**

```java
// Create a horizontal slider
StyledSlider slider = new StyledSlider(Style.FLAT, 0, 100, 50);

// Create a vertical slider
StyledSlider verticalSlider = new StyledSlider(Style.NEUMORPHIC, 0, 100, 75, SwingConstants.VERTICAL);

// Configure ticks
slider.setMajorTickSpacing(10);
slider.setMinorTickSpacing(5);
slider.setPaintTicks(true);
slider.setPaintLabels(true);

// Add change listener
slider.addChangeListener(e -> {
    System.out.println("Value: " + slider.getValue());
});

// Configure increments
slider.setUnitIncrement(5);
slider.setBlockIncrement(20);
```

**Methods:**

- `setValue(int value)` - set current value
- `getValue()` - get current value
- `setMinimum(int min)` / `setMaximum(int max)` - set range
- `setOrientation(int orientation)` - set orientation (HORIZONTAL/VERTICAL)
- `setMajorTickSpacing(int spacing)` - set major tick spacing
- `setMinorTickSpacing(int spacing)` - set minor tick spacing
- `setPaintTicks(boolean paint)` - show/hide ticks
- `setPaintLabels(boolean paint)` - show/hide labels
- `setSnapToTicks(boolean snap)` - enable/disable snap to ticks
- `setInverted(boolean inverted)` - invert slider direction
- `addChangeListener(ChangeListener listener)` - add change lisener

---

### 📝 StyledTextField

Styled text field with reflection animation support.

**Features:**

- Support for all styles
- Reflection animations for glass style
- Automatic font scaling
- Text localization
- Customizable padding

**Usage:**

```java
// Create a text field
StyledTextField textField = new StyledTextField(Style.FLAT, "Enter text...");

// Create with custom size
StyledTextField textField = new StyledTextField(Style.GLASS, "Username", 250, 40);

// Configure font and alignment
textField.setHorizontalAlignment(JTextField.CENTER);
textField.setFont(new Font("Arial", Font.PLAIN, 16));

// Localization
textField.setLocalizationKey("field.username");
```

**Methods:**

- `setText(String text)` - set text
- `getText()` - get text
- `setReferenceSize(int width, int height)` - set reference size for scaling

---

### 📋 StyledComboBox

Styled dropdown combo box with item style customization.

**Features:**

- Customizable item style (ItemStyle)
- Hover animations on items
- Glass style support
- Color, font, and padding customization
- Item localization

**Usage:**

```java
// Create a combo box
StyledComboBox<String> comboBox = new StyledComboBox<>(Style.FLAT);

// Add items
comboBox.addItem("Option 1");
comboBox.addItem("Option 2");
comboBox.addItem("Option 3");

// Configure item style
StyledComboBox.ItemStyle itemStyle = comboBox.getItemStyle();
itemStyle.setNormalColor(new Color(50, 51, 54));
itemStyle.setHoverColor(new Color(70, 71, 74));
itemStyle.setSelectedColor(new Color(72, 99, 151));
itemStyle.setTextColor(Color.WHITE);
itemStyle.setArc(16);
itemStyle.setHorizontalPadding(12);
itemStyle.setVerticalPadding(6);

// Add action listener
comboBox.addActionListener(e -> {
    System.out.println("Selected: " + comboBox.getSelectedItem());
});

// Configure glass style
itemStyle.setGlass(true);
itemStyle.setGlassOpacity(0.45f);
itemStyle.setGlassRadius(0.5f);
```

**Methods:**

- `addItem(T item)` - add item
- `removeItem(T item)` - remove item
- `getSelectedItem()` - get selected item
- `setSelectedItem(T item)` - set selected item
- `getItemStyle()` - get item style configuration
- `setStyle(Style style)` - change main style

---

### 🏷️ StyledLabel

Styled label with reflection animation support.

**Features:**

- Support for all styles
- Reflection animations for glass style
- Text localization
- Border visibility configuration
- Automatic scaling

**Usage:**

```java
// Create a label
StyledLabel label = new StyledLabel(Style.FLAT, "Hello, World!");

// Create with custom settings
StyledLabel label = new StyledLabel(Style.GLASS, "Title", 300, 60, true, /*themed*/ true /*borderVisible*/);

// Configure text
label.setText("New Text");
label.setLocalizationKey("label.welcome");

// Configure display
label.setBorderVisible(false);
label.setReflectionEnabled(true);
```

**Methods:**

- `setText(String text)` - set text
- `getText()` - get text
- `setStyle(Style style)` - change style
- `setBorderVisible(boolean visible)` - show/hide border
- `setReflectionEnabled(boolean enabled)` - enable/disable reflection
- `setLocalizationKey(String key)` - bind to localization key

---

### 📜 StyledScrollPane

Styled scroll pane with scrollbar customization.

**Features:**

- Scrollbar customization
- Support for all styles
- Reflection animations for glass style
- Corner radius configuration
- Scrollbar thickness configuration

**Usage:**

```java
// Create a scroll pane
JPanel contentPanel = new JPanel();
StyledScrollPane scrollPane = new StyledScrollPane(contentPanel, Style.FLAT);

// Create with scrollbar settings
StyledScrollPane scrollPane = new StyledScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER, Style.NEUMORPHIC);

// Configure parameters
scrollPane.setArc(20);
scrollPane.setThumbArc(10);
scrollPane.setThumbThickness(12);
scrollPane.setThumbInset(4);

// Configure glass style
scrollPane.setGlass(true);
scrollPane.setGlassOpacity(0.45f);
```

**Methods:**

- `setArc(int arc)` - set corner radius
- `setThumbArc(int arc)` - set thumb corner radius
- `setThumbThickness(int thickness)` - set thumb thickness
- `setThumbInset(int inset)` - set thumb inset
- `setGlass(boolean glass)` - enable glass style
- `setGlassOpacity(float opacity)` - set glass opacity

---

### ⚡ StyledToggle

Styled toggle switch component.

**Features:**

- Selected/unselected state
- Hover and press animations
- Action event listeners
- Text localization
- Support for all styles

**Usage:**

```java
// Create a toggle
StyledToggle toggle = new StyledToggle(Style.FLAT, "Enable Feature");

// Create with custom size
StyledToggle toggle = new StyledToggle(Style.NEUMORPHIC, "Dark Mode", 200, 40);

// Configure state
toggle.setSelected(true);
toggle.setSelected(false);

// Add action listener
toggle.addActionListener(e -> {
    System.out.println("Toggle state: " + toggle.isSelected());
});

// Localization
toggle.setLocalizationKey("toggle.darkmode");
```

**Methods:**

- `setSelected(boolean selected)` - set toggle state
- `isSelected()` - get current state
- `setText(String text)` - set text
- `addActionListener(ActionListener listener)` - add action listener
- `setLocalizationKey(String key)` - bind to localization key

---

### 🔄 StyledToggleButton

Styled toggle button component.

**Features:**

- Extends JToggleButton
- Hover, press, and selection animations
- Scaling support
- Text localization
- Support for all styles

**Usage:**

```java
// Create a toggle button
StyledToggleButton toggleButton = new StyledToggleButton(Style.FLAT, "Toggle Me");

// Create with custom size
StyledToggleButton toggleButton = new StyledToggleButton(Style.GLASS, "ON/OFF", 150, 45);

// Configure state
toggleButton.setSelected(true);

// Add action listener
toggleButton.addActionListener(e -> {
    System.out.println("Toggled: " + toggleButton.isSelected());
});

// Localization
toggleButton.setLocalizationKey("button.toggle");
```

**Methods:**

- `setSelected(boolean selected)` - set toggle state
- `isSelected()` - get current state
- `setText(String text)` - set text
- `setLocalizationKey(String key)` - bind to localization key

---

### ✨ Animated3DText

Animated 3D text component with various animation effects.

**Features:**

- 6 animation types: NONE, PULSE, ROTATE, PULSE\_ROTATE, BOUNCE, FULL
- Speed, depth, and color configuration
- Automatic scaling
- Localization support
- Click event handlers
- Font customization

**Usage:**

```java
// Create animated text
Animated3DText animatedText = new Animated3DText("StyleUI");

// Create with animation type
Animated3DText animatedText = new Animated3DText("Welcome!", Animated3DText.AnimationType.PULSE_ROTATE);

// Create with custom size
Animated3DText animatedText = new Animated3DText("Hello", Animated3DText.AnimationType.ROTATE, 400, 200);

// Configure animation
animatedText.setAnimationType(Animated3DText.AnimationType.BOUNCE);
animatedText.setAnimationSpeed(1.5);
animatedText.setPulseAmount(0.1);
animatedText.setRotationAmount(0.1);
animatedText.setBounceAmount(0.08);

// Configure 3D effect
animatedText.setDepth(12);
animatedText.setTextColor(Color.WHITE);
animatedText.setDepthColor(new Color(120, 180, 255, 80));

// Configure font
animatedText.setFontName("Arial");
animatedText.setFontStyle(Font.BOLD);
animatedText.setBaseFontSize(72f);

// Add click handler
animatedText.addActionListener(e -> {
    System.out.println("3D Text clicked!");
});

// Localization
animatedText.setLocalizationKey("text.welcome");
```

**Methods:**

- `setAnimationType(AnimationType type)` - set animation type
- `setAnimationSpeed(double speed)` - set animation speed
- `setPulseAmount(double amount)` - set pulse amplitude
- `setRotationAmount(double amount)` - set rotation amplitude
- `setBounceAmount(double amount)` - set bounce amplitude
- `setDepth(int depth)` - set 3D depth
- `setTextColor(Color color)` - set text color
- `setDepthColor(Color color)` - set depth color
- `setFontName(String name)` - set font name
- `setFontStyle(int style)` - set font style
- `setBaseFontSize(float size)` - set base font size
- `setAutoScale(boolean autoScale)` - enable/disable auto scaling
- `addActionListener(ActionListener listener)` - add click handler

---

## 🎯 Core Classes

### Style (Enum)

Defines the three available style themes with a set of colors for each.

**Colors for each style:**

- `panel` - panel background color
- `normal` - normal component color
- `hover` - hover color
- `text` - text color
- `accent` - accent color
- `field` - field input color

**Usage:**

```java
// Get a style
Style style = Style.FLAT;

// Access colors
Color panelColor = style.panel;
Color textColor = style.text;
```

---

### AnimatedComponent

Base abstract class for all animated components.

**Functionality:**

- Animation management via AnimationManager
- Mouse event handling (hover, press)
- Component scaling
- Basic graphics settings (anti-aliasing)

**Protected Methods:**

- `protected Style getStyle()` - get current style (must be implemented by subclass)
- `protected Graphics2D graphics(Graphics g)` - get Graphics2D with settings
- `protected float parentScale()` - get parent scale

---

### AnimationManager

Centralized animation manager for all components.

**Functionality:**

- Registration and removal of animation tasks
- Automatic timer management for animations
- Glass phase management for glass style animations
- Smooth animations at 60 FPS

**Usage:**

```java
// Register an animation task
AnimationManager.register(() -> {
    // Your animation code
    repaint();
});

// Unregister a task
AnimationManager.unregister(task);

// Get glass phase
double phase = AnimationManager.getGlassPhase();
```

---

### LocalizationBridge

Bridge for integration with localization systems.

**Functionality:**

- Binding components to localization keys
- Formatted string support
- Automatic text updates on language change
- Works with external Helpers.NSLocalizedString system

**Usage:**

```java
// Bind component to key
LocalizationBridge.bind(component, "key.name", text -> {
    component.setText(text);
});

// Bind with formatting
LocalizationBridge.bindFormat(component, "key.greeting", () -> new Object[]{"User"}, text -> component.setText(text));

// Unbind component
LocalizationBridge.unbind(component);

// Notify of external text change
LocalizationBridge.externalTextChanged(component, "new text", text -> component.setText(text));

// Get localized string
String localized = LocalizationBridge.localized("key.name");
```

---

## 🚀 Quick Start

### 1. Include the Library

Copy all Java files from the repository to your project:

```
StyleUI/
├── Style.java
├── AnimatedComponent.java
├── AnimationManager.java
├── LocalizationBridge.java
├── StyledButton.java
├── StyledSlider.java
├── StyledTextField.java
├── StyledComboBox.java
├── StyledLabel.java
├── StyledScrollPane.java
├── StyledToggle.java
├── StyledToggleButton.java
└── Animated3DText.java
```

### 2. Create a Simple UI

```java
import StyleUI.*;
import javax.swing.*;
import java.awt.*;

public class StyleUIDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("StyleUI Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new FlowLayout());
            
            // Create components with different styles
            StyledButton flatButton = new StyledButton(Style.FLAT, "FLAT");
            StyledButton neumorphicButton = new StyledButton(Style.NEUMORPHIC, "NEUMORPHIC");
            StyledButton glassButton = new StyledButton(Style.GLASS, "GLASS");
            
            StyledSlider slider = new StyledSlider(Style.FLAT, 0, 100, 50);
            StyledTextField textField = new StyledTextField(Style.FLAT, "Enter text...");
            
            // Add components to frame
            frame.add(flatButton);
            frame.add(neumorphicButton);
            frame.add(glassButton);
            frame.add(slider);
            frame.add(textField);
            
            // Display frame
            frame.setVisible(true);
        });
    }
}
```

### 3. Localization Integration

For localization to work, ensure your project has the `Helpers.NSLocalizedString` class with appropriate methods, or implement your own localization system.

---

## 📦 Dependencies

- **Java 17+** (recommended)

For localization (optional):

- `Helpers.NSLocalizedString` class or similar system
