package be.bbk.backend;

import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by peterdp on 18/08/2017.
 */
@RestController
public class HeadLineController {

    @RequestMapping("/headlines")
    public List<HeadLine> getHeadLines() {
        return Lists.newArrayList(new HeadLine("Titel 1"), new HeadLine("Titel 2"));
    }
}
