package project;

import java.util.Comparator;

public class Node implements Comparator {
    int id;
    String data;

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }

    public Node(String data) {
        this.data = data;
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}