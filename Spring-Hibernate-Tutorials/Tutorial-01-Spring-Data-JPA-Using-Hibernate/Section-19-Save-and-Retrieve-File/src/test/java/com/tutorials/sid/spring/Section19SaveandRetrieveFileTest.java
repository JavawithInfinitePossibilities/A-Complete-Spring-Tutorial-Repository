package com.tutorials.sid.spring;


import com.tutorials.sid.spring.entity.Image;
import com.tutorials.sid.spring.repositories.IMageDBRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Unit test for simple Section19SaveandRetrieveFile.
 */
@SpringBootTest(classes = Section19SaveandRetrieveFile.class)
public class Section19SaveandRetrieveFileTest {

    @Autowired
    private IMageDBRepo iMageDBRepo;

    @Test
    public void testApp() {
    }

    @Test
    public void testImageBLOB() throws IOException {
        File file = new File(this.getClass().getClassLoader().getResource("l-829.jpg").getFile());
        byte[] fileByte = new byte[(int) file.length()];
        Image image = Image.builder().name("l-829.jpg").data(fileByte).build();
        iMageDBRepo.save(image);
    }

    /**
     *
     * @throws IOException If the Image is to large and unable to retrieve from the DB then execute the below query in DB <br/>
     *                     set global max_allowed_packet=32*1024*1024;
     */
    @Disabled
    @Test
    public void testReadImageBLOB() throws IOException {
        Image image = iMageDBRepo.findById(1).get();
        FileOutputStream outputStream = new FileOutputStream(new File("E:\\Test-Image\\download\\" + image.getName()));
        outputStream.write(image.getData());
        outputStream.flush();
        outputStream.close();
    }
}
