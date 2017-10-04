package be.bbk.domain;

/**
 * Created by peterdp on 18/08/2017.
 */
@lombok.Getter
@lombok.Setter
public class HeadLine {

    private String title;

    public HeadLine(String title) {
        this.title = title;
    }


}
