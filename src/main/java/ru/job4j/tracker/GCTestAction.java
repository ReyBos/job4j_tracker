package ru.job4j.tracker;

import java.sql.SQLException;

public class GCTestAction implements UserAction {
    private final Output out;

    public GCTestAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "GC Test";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        for (int i = 0; i < 500000; i++) {
            Item item = new Item("test" + i);
            tracker.add(item);
            System.out.println(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}