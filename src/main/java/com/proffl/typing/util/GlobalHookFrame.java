package com.proffl.typing.util;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;

public class GlobalHookFrame extends JFrame implements NativeKeyListener {
    private JTextField text = new JTextField();

    public GlobalHookFrame() {
        this.text.setText("end");
        this.text.setEnabled(false);
        this.add(text);
    }

    public static boolean isRunning = false;
    public static void main(String[] args) throws AWTException, InterruptedException {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        GlobalHookFrame frame = new GlobalHookFrame();
        frame.setSize(150, 100);
        frame.setVisible(true);
        GlobalScreen.addNativeKeyListener(new GlobalHookFrame());
        Robot robot =  new Robot();
        while (true) {
            if (isRunning) {
                robot.keyPress('2');
                Thread.sleep(100);
                robot.keyRelease('2');
            }
            Thread.sleep(250);
        }
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_G) {
            isRunning =true;
            startHook();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_E) {
            isRunning =false;
            endHook();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_K) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e1) {
                e1.printStackTrace();
            }
            System.exit(0);
        }
    }

    public void startHook() {
        this.text.setText("start");
        this.text.update(this.text.getGraphics());
    }

    public void endHook() {
        this.text.setText("end");
        this.text.update(this.text.getGraphics());
    }


    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
    }
}
