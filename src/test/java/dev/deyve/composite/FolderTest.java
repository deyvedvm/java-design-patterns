package dev.deyve.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FolderTest {

    @Test
    void folderSizeShouldBeSumOfChildren() {
        var docs = new Folder("docs");
        docs.add(new File("a.txt", 100));
        docs.add(new File("b.txt", 200));

        assertEquals(300, docs.getSize());
    }

    @Test
    void nestedFoldersShouldAggregateRecursively() {
        var root = new Folder("root");
        var sub = new Folder("sub");
        sub.add(new File("nested.txt", 50));
        root.add(sub);
        root.add(new File("top.txt", 10));

        assertEquals(60, root.getSize());
    }

    @Test
    void emptyFolderShouldHaveZeroSize() {
        assertEquals(0, new Folder("empty").getSize());
    }
}
