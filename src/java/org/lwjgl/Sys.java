package org.lwjgl;

import static org.lwjgl.glfw.GLFW.glfwInit;

import java.awt.Desktop;
import java.net.URI;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.Platform;
import org.lwjgl.opengl.Display;

public class Sys {

    static {
        if (!glfwInit()) throw new IllegalStateException("Unable to initialize glfw");
    }

    public static void initialize() {}

    public static String getVersion() {
        return Version.getVersion();
    }

    public static long getTimerResolution() {
        return 1000;
    }

    public static long getTime() {
        return (long) (GLFW.glfwGetTime() * 1000);
    }

    public static long getNanoTime() {
        return (long) (GLFW.glfwGetTime() * (1000L * 1000L * 1000L));
    }

    public static boolean openURL(String url) {
        if (!Desktop.isDesktopSupported()) return false;

        Desktop desktop = Desktop.getDesktop();
        if (!desktop.isSupported(Desktop.Action.BROWSE)) return false;

        try {
            desktop.browse(new URI(url));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void alert(String title, String message) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            LWJGLUtil.log("Caught exception while setting LAF: " + e);
        }
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static boolean is64Bit() {
        return Platform.getArchitecture().toString().endsWith("64");
    }

    public String getClipboard() {
        return GLFW.glfwGetClipboardString(Display.getWindow());
    }
}
