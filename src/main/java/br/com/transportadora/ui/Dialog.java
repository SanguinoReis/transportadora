package br.com.transportadora.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import java.util.LinkedList;

public abstract class Dialog extends Window {
    private static final long serialVersionUID = -8953587458458098089L;

    protected final LinkedList<WindowResultListener> windowResultListeners = new LinkedList<>();

    public Dialog() {
        super();
        initDialog();
    }

    public Dialog(String caption) {
        super(caption);
        initDialog();
    }

    private void initDialog() {
        this.setModal(true);
        this.center();
        this.setResizable(false);
    }

    public void show() {
        UI.getCurrent().addWindow(this);
    }

    protected void fireWindowResultEvent(final WindowResultEvent event) {
        this.setEnabled(false);
        windowResultListeners.forEach(l -> l.windowResult(event));
    }

    public void addWindowResultListener(WindowResultListener listener) {
        if (listener != null) {
            windowResultListeners.add(listener);
        }
    }

    public void removeWindowResultListener(WindowResultListener listener) {
        if (listener != null) {
            windowResultListeners.remove(listener);
        }
    }

    public void removeAllWindowResultListeners() {
        windowResultListeners.clear();
    }

    public static interface WindowResultListener {
        public void windowResult(WindowResultEvent event);
    }

    public static abstract class WindowResultEvent extends Event {
        private static final long serialVersionUID = -7781408886057605299L;

        public WindowResultEvent(Component source) {
            super(source);
        }
    }
}
