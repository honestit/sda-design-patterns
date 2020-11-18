package gof.prototype;

import java.util.List;

public class Template extends Letter {

    public Letter letter() {
        Letter letter = new Letter();
        letter.setTitle(this.getTitle());
        letter.setContent(this.getContent());
        letter.setDate(this.getDate());
        letter.setReceiver(this.getReceiver());
        letter.setAttachments(List.copyOf(this.getAttachments()));
        return letter;
    }

    public Letter letter(String receiver) {
        Letter letter = letter();
        letter.setReceiver(receiver);
        return letter;
    }
}
