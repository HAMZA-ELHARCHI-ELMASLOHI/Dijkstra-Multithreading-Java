package project;

public class Node {
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


}