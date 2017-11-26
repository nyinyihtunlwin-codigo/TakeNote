package projects.nyinyihtunlwin.takenote.models;

/**
 * Created by Dell on 11/23/2017.
 */

public class NoteModel {
    private int id;
    private String content;

    public NoteModel() {
    }

    public NoteModel(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
