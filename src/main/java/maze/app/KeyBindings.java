package maze.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public final class KeyBindings {

    public static Action moveRight(MazePanel maze) {
        return new Action() {
            @Override
            public Object getValue(String key) {
                return "moveRight";
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                maze.moveRight();
            }
        };
    }

    public static Action moveDown(MazePanel maze) {
        return new Action() {
            @Override
            public Object getValue(String key) {
                return "moveDown";
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                maze.moveDown();
            }
        };
    }

    public static Action moveLeft(MazePanel maze) {
        return new Action() {
            @Override
            public Object getValue(String key) {
                return "moveLeft";
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                maze.moveLeft();
            }
        };
    }

    public static Action moveUp(MazePanel maze) {
        return new Action() {
            @Override
            public Object getValue(String key) {
                return "moveUp";
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                maze.moveUp();
            }
        };
    }

    private KeyBindings() {
        // no instantiation
    }
}
